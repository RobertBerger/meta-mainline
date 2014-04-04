# This file was derived from the linux-yocto-custom.bb recipe in
# oe-core.
#
# linux-yocto-custom.bb:
#
#   A yocto-bsp-generated kernel recipe that uses the linux-yocto and
#   oe-core kernel classes to apply a subset of yocto kernel
#   management to git managed kernel repositories.
#
# Warning:
#
#   Building this kernel without providing a defconfig or BSP
#   configuration will result in build or boot errors. This is not a
#   bug.
#
# Notes:
#
#   patches: patches can be merged into to the source git tree itself,
#            added via the SRC_URI, or controlled via a BSP
#            configuration.
#
#   example configuration addition:
#            SRC_URI += "file://smp.cfg"
#   example patch addition:
#            SRC_URI += "file://0001-linux-version-tweak.patch
#   example feature addition:
#            SRC_URI += "file://feature.scc"
#

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

#SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=git;bareclone=1"
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;bareclone=1"

SRC_URI += "file://defconfig"
# I want this here just for reference
# should be the same with defconfig
# SRC_URI += "file://config-3.13.0-rc8-armv7-x9"

# I want to trick the patch checker
#do_patch_prepend() {
#	cp ${WORKDIR}/defconfig ${WORKDIR}/.config
#}

# Yocto should copy ${WORKDIR}/defconfig ${B}/.config automatically
# but for some reason it does not
# So I do it here myself
do_configure_prepend() {
        cp ${WORKDIR}/defconfig ${B}/.config
}

SRC_URI += "file://beagle-xm-ml.scc \
            file://beagle-xm-ml.cfg \
            file://beagle-xm-ml-user-config.cfg \
            file://beagle-xm-ml-user-patches.scc \
           "

KBRANCH = "linux-3.13.y"

LINUX_VERSION ?= "3.13.8"
LINUX_VERSION_EXTENSION ?= "-custom"

# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2014-03-31 17:05:38 (GMT)
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2014-03-31 17:05:38 (GMT)
# commit	536663583285f2dccf5bdb1e997d25268772a4eb (patch)
# tree		6e292c874ad4f1be78020571f0a54ec9a9271104
# parent	82fd05a1b898fca663b2c01a330e7554a91808dd (diff)
# Linux 3.13.8 v3.13.8 linux-3.13.y

SRCREV="536663583285f2dccf5bdb1e997d25268772a4eb"

PR = "r0"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_beagle-xm-ml = "beagle-xm-ml"

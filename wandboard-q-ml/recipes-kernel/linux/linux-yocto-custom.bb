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

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=git;bareclone=1"

SRC_URI += "file://defconfig"
# I want this here just for reference
# should be the same with defconfig
SRC_URI += "file://config-3.13.0-rc8-armv7-x8"

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

SRC_URI += "file://wandboard-q-ml.scc \
            file://wandboard-q-ml.cfg \
            file://wandboard-q-ml-user-config.cfg \
            file://wandboard-q-ml-user-patches.scc \
           "

KBRANCH = "master"

LINUX_VERSION ?= "3.13-rc8"
LINUX_VERSION_EXTENSION ?= "-custom"

# author	Linus Torvalds <torvalds@linux-foundation.org>	2014-01-12 10:04:18 (GMT)
# committer	Linus Torvalds <torvalds@linux-foundation.org>	2014-01-12 10:04:18 (GMT)
# commit	7e22e91102c6b9df7c4ae2168910e19d2bb14cd6 (patch)
# tree	        a0b3677d442ed08ca16943fb471a90f5fd5bc367
# parent	3dc91d4338d698ce77832985f9cb183d8eeaf6be (diff)
# Linux 3.13-rc8 v3.13-rc8

SRCREV="7e22e91102c6b9df7c4ae2168910e19d2bb14cd6"

PR = "r0"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_wandboard-q-ml = "wandboard-q-ml"

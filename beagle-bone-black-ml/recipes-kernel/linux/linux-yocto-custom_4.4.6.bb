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
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;bareclone=1;branch=${KBRANCH}"

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

SRC_URI += "file://beagle-bone-black-ml.scc \
            file://beagle-bone-black-ml.cfg \
            file://beagle-bone-black-ml-user-config.cfg \
            file://beagle-bone-black-ml-user-patches.scc \
           "

KBRANCH = "linux-4.4.y"

LINUX_VERSION ?= "4.4.6"
LINUX_VERSION_EXTENSION ?= "-custom"

# author        Greg Kroah-Hartman <gregkh@linuxfoundation.org> 2016-03-16 15:43:17 (GMT)
# committer     Greg Kroah-Hartman <gregkh@linuxfoundation.org> 2016-03-16 15:43:17 (GMT)
# commit        0d1912303e54ed1b2a371be0bba51c384dd57326 (patch)
# tree          706c149c0f0d6865d14e6b18058826f9dfd49f24
# parent        f3f47e76d14820b150479d78ac8edad33a1e0c19 (diff)
# Linux 4.4.6 v4.4.6 linux-4.4.y

SRCREV ?= "0d1912303e54ed1b2a371be0bba51c384dd57326"
# looks like we need to update SRCREV_machine not to get latest in the branch, but specific SRCREV 
SRCREV_machine = "${SRCREV}"

PR = "r0"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_beagle-bone-black-ml = "beagle-bone-black-ml"

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

SRC_URI += "file://m28evk-ml.scc \
            file://m28evk-ml.cfg \
            file://m28evk-ml-user-config.cfg \
            file://m28evk-ml-user-patches.scc \
           "

KBRANCH = "linux-3.13.y"

LINUX_VERSION ?= "3.13.2"
LINUX_VERSION_EXTENSION ?= "-custom"

# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2014-02-06 19:42:22 (GMT)
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2014-02-06 19:42:22 (GMT)
# commit	fd82174a6967b34e1f478469269f161f7b1e688b (patch)
# tree		d23a7558547cc7d0bc21f761fb540557c24aed82
# parent	31752e89b1e728d672eaafaa7869e7c0673ae9f6 (diff)
# Linux 3.13.2 v3.13.2 linux-3.13.y

SRCREV="fd82174a6967b34e1f478469269f161f7b1e688b"

PR = "r0"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_m28evk-ml = "m28evk-ml"

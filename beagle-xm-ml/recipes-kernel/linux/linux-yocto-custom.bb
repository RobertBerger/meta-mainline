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

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;bareclone=1"

SRC_URI += "file://defconfig"

SRC_URI += "file://beagle-xm-ml.scc \
            file://beagle-xm-ml.cfg \
            file://beagle-xm-ml-user-config.cfg \
            file://beagle-xm-ml-user-patches.scc \
           "

KBRANCH = "linux-3.9.y"

LINUX_VERSION ?= "3.9.7"
LINUX_VERSION_EXTENSION ?= "-custom"

#Author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2013-06-20 19:01:46 (GMT)
#committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2013-06-20 19:01:46 (GMT)
#commit	485f25fcc014f2744754f22de395f745f2c7e492 (patch)
#tree	2ee23d2bacc5202860dfaffa2e65bffdb35520b7
#parent	8e8577e87943a83aa1b84b3d5202f1f4e8f088d0 (diff)
#Linux 3.9.7 v3.9.7

SRCREV="485f25fcc014f2744754f22de395f745f2c7e492"

PR = "r0"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_beagle-xm-ml = "beagle-xm-ml"

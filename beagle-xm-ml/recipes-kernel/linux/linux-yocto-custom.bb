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

LINUX_VERSION ?= "3.9.11"
LINUX_VERSION_EXTENSION ?= "-custom"

#author        Greg Kroah-Hartman <gregkh@linuxfoundation.org> 2013-07-21 00:16:17 (GMT)
#committer     Greg Kroah-Hartman <gregkh@linuxfoundation.org> 2013-07-21 00:16:17 (GMT)
#commit        896f5009ed1fbaec43f360c4ebf022639cd61d5f (patch)
#tree  4b3f5f8244bbf4a787df08c50fb69e7611831338
#parent        0b2bf3e6dae86b256f6ee0fb428166e111278aa8 (diff)
#Linux 3.9.11 v3.9.11 linux-3.9.y

SRCREV="896f5009ed1fbaec43f360c4ebf022639cd61d5f"

PR = "r0"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_beagle-xm-ml = "beagle-xm-ml"

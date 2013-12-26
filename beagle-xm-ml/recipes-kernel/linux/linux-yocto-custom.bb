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

SRC_URI += "file://example_omap2plus_defconfig"

SRC_URI += "file://beagle-xm-ml.scc \
            file://beagle-xm-ml.cfg \
            file://beagle-xm-ml-user-config.cfg \
            file://beagle-xm-ml-user-patches.scc \
           "

KBRANCH = "master"

LINUX_VERSION ?= "3.13-rc5"
LINUX_VERSION_EXTENSION ?= "-custom"

# author	Linus Torvalds <torvalds@linux-foundation.org>	2013-12-22 21:08:32 (GMT)
# committer	Linus Torvalds <torvalds@linux-foundation.org>	2013-12-22 21:08:32 (GMT)
# commit	413541dd66d51f791a0b169d9b9014e4f56be13c (patch)
# tree		6e23a64c6202ed814e7043ca80a38cad3f341f32
# parent	93579aeec2093ff12b55491c655129431b63e3dd (diff)
# Linux 3.13-rc5 v3.13-rc5

SRCREV="413541dd66d51f791a0b169d9b9014e4f56be13c"

PR = "r0"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_beagle-xm-ml = "beagle-xm-ml"

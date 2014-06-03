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

SRC_URI += "file://m28evk-ml.scc \
            file://m28evk-ml.cfg \
            file://m28evk-ml-user-config.cfg \
            file://m28evk-ml-user-patches.scc \
           "

KBRANCH = "linux-3.14.y"

LINUX_VERSION ?= "3.14.0"
LINUX_VERSION_EXTENSION ?= "-custom"

# author	Linus Torvalds <torvalds@linux-foundation.org>	2014-03-31 03:40:15 (GMT)
# committer	Linus Torvalds <torvalds@linux-foundation.org>	2014-03-31 03:40:15 (GMT)
# commit	455c6fdbd219161bd09b1165f11699d6d73de11c (patch)
# tree		dd65155eb5a9410e83c5b0d760c099f9fbb7719c
# parent	fedc1ed0f11be666de066b0c78443254736a942e (diff)
# Linux 3.14 HEAD v3.14 master linux-3.14.y

SRCREV="455c6fdbd219161bd09b1165f11699d6d73de11c"
# looks like we need to update SRCREV_machine not to get latest in the branch, but specific SRCREV 
SRCREV_machine = "${SRCREV}"

PR = "r0"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_m28evk-ml = "m28evk-ml"

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

LINUX_VERSION ?= "3.14.4"
LINUX_VERSION_EXTENSION ?= "-custom"

# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2014-05-13 11:33:14 (GMT)
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2014-05-13 11:33:14 (GMT)
# commit	7261684765e4411dff5ec5ffbad52f5009a2941b (patch)
# tree		a0706071586eca113d218cd26889e4a879207ce3
# parent	dec190e5b9428821cfffe7462fce43a234564711 (diff)
# Linux 3.14.4 v3.14.4 linux-3.14.y

SRCREV="7261684765e4411dff5ec5ffbad52f5009a2941b"
# looks like we need to update SRCREV_machine not to get latest in the branch, but specific SRCREV 
SRCREV_machine = "${SRCREV}"

PR = "r0"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_m28evk-ml = "m28evk-ml"

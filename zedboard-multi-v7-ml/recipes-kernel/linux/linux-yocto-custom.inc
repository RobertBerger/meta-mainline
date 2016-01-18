# This is what should be common to all kernel versions
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

# This version extension should match CONFIG_LOCALVERSION in defconfig
LINUX_VERSION_EXTENSION ?= "-custom-ml-${KTYPE}"
PV = "${LINUX_VERSION}${LINUX_VERSION_EXTENSION}+git${SRCPV}"

# Sources, by default allow for the use of SRCREV pointing to orphaned tags/commits
#SRCBRANCH ?= ""
#SRCBRANCHARG = "${@['nobranch=1', 'branch=${SRCBRANCH}'][d.getVar('SRCBRANCH', True) != '']}"

#SRC_URI += " \
#             git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;branch=${KBRANCH};${SRCBRANCHARG} \
#             file://zedboard-multi-v7-ml-common;type=kmeta;destsuffix=zedboard-multi-v7-ml-common \
#           "

SRC_URI += "\
           git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;branch=${KBRANCH} \
           file://zedboard-multi-v7-ml-common;type=kmeta;destsuffix=zedboard-multi-v7-ml-common \
           "

SRCREV_machine ?= "${SRCREV}"

require recipes-kernel/linux/linux-yocto.inc

DESCRIPTION = "Mainline kernel"

require linux-ml-configs.inc
require linux-ml-machines.inc

# Let's try an in-tree defconfig:
KERNEL_DEFCONFIG_zedboard-multi-v7-ml ?= "multi_v7_defconfig"
KBUILD_DEFCONFIG_zedboard-multi-v7-ml ?= "multi_v7_defconfig"
KCONFIG_MODE="--alldefconfig"

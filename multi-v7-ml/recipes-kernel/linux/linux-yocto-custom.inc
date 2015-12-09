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

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

# SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;bareclone=1;branch=${KBRANCH}"
# Jethro wants it this way:
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;branch=${KBRANCH}"

#SRC_URI += " \
#        file://defconfig \
#        "
SRC_URI += "file://multi-v7-ml.scc \
            file://multi-v7-ml.cfg \
            file://multi-v7-ml-user-config.cfg \
            file://multi-v7-ml-user-patches.scc \
           "

# Let's try an in-tree defconfig:
KERNEL_DEFCONFIG_multi-v7-ml ?= "multi_v7_defconfig"
KBUILD_DEFCONFIG_multi-v7-ml ?= "multi_v7_defconfig"
KCONFIG_MODE="--alldefconfig"

LINUX_VERSION_EXTENSION_append = "-custom"

# looks like we need to update SRCREV_machine not to get latest in the branch, but specific SRCREV 
SRCREV_machine = "${SRCREV}"

#PR = "r0"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_multi-v7-ml = "multi-v7-ml"

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

#SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=git;bareclone=1"
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;bareclone=1;branch=${KBRANCH}"

# To specify an "in-tree" defconfig file, edit the recipe that builds your kernel so that it has the following command form:
#    KBUILD_DEFCONFIG_KMACHINE ?= defconfig_file
# You need to append the variable with KMACHINE and then supply the path to your "in-tree" defconfig file. 
KERNEL_DEFCONFIG_multi-v7-ml ?= "multi_v7_defconfig"

#SRC_URI += "file://defconfig"
# I want this here just for reference

# I want to trick the patch checker
#do_patch_prepend() {
#	cp ${WORKDIR}/defconfig ${WORKDIR}/.config
#}

# Yocto should copy ${WORKDIR}/defconfig ${B}/.config automatically
# but for some reason it does not
# So I do it here myself
#do_configure_prepend() {
#        cp ${WORKDIR}/defconfig ${B}/.config
#}

SRC_URI += "file://multi-v7-ml.scc \
            file://multi-v7-ml.cfg \
            file://multi-v7-ml-user-config.cfg \
            file://multi-v7-ml-user-patches.scc \
           "

LINUX_VERSION_EXTENSION_append = "-custom"

# looks like we need to update SRCREV_machine not to get latest in the branch, but specific SRCREV 
SRCREV_machine = "${SRCREV}"

#PR = "r0"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_multi-v7-ml = "multi-v7-ml"
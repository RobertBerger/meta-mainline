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

SRC_URI += "file://terasic-ml.scc \
            file://terasic-ml.cfg \
            file://terasic-ml-user-config.cfg \
            file://terasic-ml-user-patches.scc \
           "

KBRANCH = "linux-4.1.y"

LINUX_VERSION ?= "4.1.0"
LINUX_VERSION_EXTENSION ?= ""

# author        Linus Torvalds <torvalds@linux-foundation.org>  2015-06-22 05:05:43 (GMT)
# committer     Linus Torvalds <torvalds@linux-foundation.org>  2015-06-22 05:05:43 (GMT)
# commit        b953c0d234bc72e8489d3bf51a276c5c4ec85345 (patch)
# tree          862523724661a2344bbbce7812081bf29950c371
# parent        d2228e4310612a1289c343bcf819831a74ae0366 (diff)
# Linux 4.1 HEAD v4.1 master linux-4.1.y

SRCREV="b953c0d234bc72e8489d3bf51a276c5c4ec85345"
# looks like we need to update SRCREV_machine not to get latest in the branch, but specific SRCREV 
SRCREV_machine = "${SRCREV}"

PR = "r0"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_terasic-ml = "terasic-ml"

# --> dtb symlink for qemu: 

do_deploy_append() {
        if test -n "${KERNEL_DEVICETREE}"; then
                for DTB in ${KERNEL_DEVICETREE}; do
                        if echo ${DTB} | grep -q '/dts/'; then
                                bbwarn "${DTB} contains the full path to the the dts file, but only the dtb name should be used."
                                DTB=`basename ${DTB} | sed 's,\.dts$,.dtb,g'`
                        fi
                        DTB_BASE_NAME=`basename ${DTB} .dtb`
                        DTB_NAME=`echo ${KERNEL_IMAGE_BASE_NAME} | sed "s/${MACHINE}/${DTB_BASE_NAME}/g"`
                        #DTB_SYMLINK_NAME=`echo ${KERNEL_IMAGE_SYMLINK_NAME} | sed "s/${MACHINE}/${DTB_BASE_NAME}/g"`
                        DTB_PATH="${B}/arch/${ARCH}/boot/dts/${DTB}"
                        if [ ! -e "${DTB_PATH}" ]; then
                                DTB_PATH="${B}/arch/${ARCH}/boot/${DTB}"
                        fi
                        install -d ${DEPLOYDIR}
                        install -m 0644 ${DTB_PATH} ${DEPLOYDIR}/${DTB_NAME}.dtb
                        cd ${DEPLOYDIR}
                        # qemu wants the dtb file with this symlink:
                        ln -sf ${DTB_NAME}.dtb ${KERNEL_IMAGETYPE}-${COMPATIBLE_MACHINE}.bin-${COMPATIBLE_MACHINE}.dtb
                        cd -
                done
        fi
}

# <-- dtb symlink for qemu


inherit kernel
require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;bareclone=1;branch=${KBRANCH}"

# SRC_URI += "file://defconfig"

SRC_URI += "file://u-boot-wic.scc \
            file://u-boot-wic.cfg \
           "
# u-boot-wic-user-config.cfg and
# u-boot-wic-user-patches.scc are
# included by u-boot-wic.scc
# removed from SRC_URI to avoid double inclusion
# and like this avoiding applying same patch twice

LINUX_VERSION_EXTENSION ?= "-custom"

PV = "${LINUX_VERSION}+git${SRCPV}"

# Let's try an in-tree defconfig:
KERNEL_DEFCONFIG_am335x-phytec-wega ?= "multi_v7_defconfig"
KBUILD_DEFCONFIG_am335x-phytec-wega ?= "multi_v7_defconfig"
KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE_am335x-phytec-wega = "am335x-phytec-wega"
COMPATIBLE_MACHINE_imx6q-phytec-mira-rdk-nand = "imx6q-phytec-mira-rdk-nand"
COMPATIBLE_MACHINE_beagle-bone-black = "beagle-bone-black"

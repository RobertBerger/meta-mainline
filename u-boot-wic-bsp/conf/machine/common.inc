#@TYPE: Machine
#@NAME: u-boot-wic

#@DESCRIPTION: Machine configuration for u-boot-wic systems


MACHINE_EXTRA_RDEPENDS = " kernel-modules kernel-devicetree"

EXTRA_IMAGEDEPENDS += "u-boot wic-tools"

IMAGE_INSTALL_append = " u-boot-uenv-helper"

DEFAULTTUNE = "armv7a-neon"
include conf/machine/include/arm/arch-armv7a.inc

IMAGE_FSTYPES += "tar.bz2 wic wic.bmap"

SERIAL_CONSOLES="115200;console"

PREFERRED_PROVIDER_virtual/kernel ?= "linux-yocto-custom"

# kernel version
KERNEL_VERSION_PATCHLEVEL="4.9"
KERNEL_SUBLEVEL="34"
PREFERRED_VERSION_linux-yocto-custom = "${KERNEL_VERSION_PATCHLEVEL}.${KERNEL_SUBLEVEL}%"

# use instead of "default" version of linux libc headers this version
# which is an exact fit to the kernel version
LINUXLIBCVERSION ?= "${KERNEL_VERSION_PATCHLEVEL}"

WKS_FILE_am335x-phytec-wega = "am335x-phytec-wega-sd-card.wks"
WKS_FILE_imx6q-phytec-mira-rdk-nand = "imx6q-phytec-mira-rdk-nand-sd-card.wks"
WKS_FILE_beagle-bone-black = "beagle-bone-black.wks"
do_image_wic[depends] += "mtools-native:do_populate_sysroot dosfstools-native:do_populate_sysroot"

KERNEL_IMAGETYPE = "uImage"
KERNEL_DEVICETREE_am335x-phytec-wega = "am335x-wega-rdk.dtb"
KERNEL_DEVICETREE_imx6q-phytec-mira-rdk-nand = "imx6q-phytec-mira-rdk-nand.dtb"
KERNEL_DEVICETREE_beagle-bone-black = "am335x-boneblack.dtb"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT} UIMAGE_TYPE=kernel_noload "

SPL_BINARYNAME_am335x-phytec-wega = "MLO"
SPL_BINARYNAME_imx6q-phytec-mira-rdk-nand = "SPL"
SPL_BINARYNAME_beagle-bone-black = "MLO"
SPL_BINARY = "${SPL_BINARYNAME}"
UBOOT_SUFFIX = "img"
UBOOT_MACHINE_am335x-phytec-wega = "pcm051_rev3_defconfig"
UBOOT_MACHINE_imx6q-phytec-mira-rdk-nand = "pcm058_defconfig"
UBOOT_MACHINE_beagle-bone-black = "am335x_evm_defconfig"
UBOOT_ENTRYPOINT = "0x0"
UBOOT_LOADADDRESS = "0x0"

MACHINE_FEATURES = "usbgadget usbhost vfat alsa"

IMAGE_BOOT_FILES ?= "u-boot.${UBOOT_SUFFIX} ${SPL_BINARYNAME}"
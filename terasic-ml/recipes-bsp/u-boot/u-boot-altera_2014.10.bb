require recipes-bsp/u-boot/u-boot.inc
require u-boot-ti.inc
require u-boot-socfpga-boot-script.inc

SPL_BINARY = ""

# To build u-boot for your machine, provide the following lines in
# your machine config, replacing the assignments as appropriate for
# your machine.
# UBOOT_MACHINE = "am335x_evm_config"
#UBOOT_ENTRYPOINT = "0x80008000"
#UBOOT_LOADADDRESS = "0x80008000"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=c7383a594871c03da76b3707929d2919"

PROVIDES += "u-boot-altera"

PV = "v2014.10"

SRCREV = "65fa9d0ca579016f28fa5ee5c2915642ca917615"
SRC_URI += "git://github.com/altera-opensource/u-boot-socfpga.git;branch=socfpga_v2014.10_arria10_bringup;protocol=git"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"


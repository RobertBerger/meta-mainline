require recipes-bsp/u-boot/u-boot.inc
require u-boot-fsl.inc

DEPENDS += "elftosb-native"

# To build u-boot for your machine, provide the following lines in
# your machine config, replacing the assignments as appropriate for
# your machine.
# UBOOT_MACHINE = "m28evk_config"
# UBOOT_ENTRYPOINT = "0x40008000"
# UBOOT_LOADADDRESS = "0x40008000"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

PROVIDES += "u-boot"

PV = "v2013.07"

SRCREV = "62c175fbb8a0f9a926c88294ea9f7e88eb898f6c"
SRC_URI = "git://git.denx.de/u-boot.git;branch=master;protocol=git"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"


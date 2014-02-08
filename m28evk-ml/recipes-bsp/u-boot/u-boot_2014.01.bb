require u-boot-fsl.inc

DEPENDS += "elftosb-native"

# To build u-boot for your machine, provide the following lines in
# your machine config, replacing the assignments as appropriate for
# your machine.
# UBOOT_MACHINE = "m28evk_config"
# UBOOT_ENTRYPOINT = "0x40008000"
# UBOOT_LOADADDRESS = "0x40008000"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"

PROVIDES += "u-boot"

PV = "v2014.01"

SRCREV = "b44bd2c73c4cfb6e3b9e7f8cf987e8e39aa74a0b"
SRC_URI += "git://git.denx.de/u-boot.git;branch=master;protocol=git"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

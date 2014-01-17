require recipes-bsp/u-boot/u-boot.inc
require u-boot-ti.inc

SPL_BINARY = "MLO"

# To build u-boot for your machine, provide the following lines in
# your machine config, replacing the assignments as appropriate for
# your machine.
# UBOOT_MACHINE = "omap3_beagle_config"
# UBOOT_ENTRYPOINT = "0x80008000"
# UBOOT_LOADADDRESS = "0x80008000"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"

PROVIDES += "u-boot"

PV = "v2013.10"

SRCREV = "183acb700378a8cfc5d50a01a65de93fb2c24586"
SRC_URI = "git://git.denx.de/u-boot.git;branch=master;protocol=git"

# extra scripts and readme 
SRC_URI += "file://mkcard-igepv2.sh;md5=d3c467bfbb481b03dbceed5c125b3697"
SRC_URI += "file://mmc-core-image-minimal-dev-igepv2.sh;md5=6bd8b0c8953a65388cd8aafedd280de1"
SRC_URI += "file://readme-igepv2.txt;md5=76cc7e26ebb1653c4e791d32afc0e10e"
SRC_URI += "file://uEnv-igepv2.txt;md5=6a84a1a4a3b54a3e0dd55224cc7affbb"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

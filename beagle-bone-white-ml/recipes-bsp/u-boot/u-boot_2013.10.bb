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
SRC_URI += "file://mkcard-beagle-bone-white.sh;md5=f87393ca1cffa7c2564ba470e0c1402e"
SRC_URI += "file://mmc-core-image-minimal-dev-beagle-bone-white.sh;md5=88e50a43263dd234fcf5022259c8f322"
SRC_URI += "file://readme-beagle-bone-white.txt;md5=88d4f7e8f600bc4f49726fe7e82ba63f"
SRC_URI += "file://uEnv-beagle-bone-white.txt;md5=b9c66b7c232513d8864a64596956d0b9"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

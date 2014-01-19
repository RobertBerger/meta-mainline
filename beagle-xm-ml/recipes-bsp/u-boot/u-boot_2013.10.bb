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
SRC_URI += "file://mkcard-beagle-xm.sh;md5=3f410089787acb9e89ec143de888046f"
SRC_URI += "file://mmc-core-image-minimal-dev-beagle-xm.sh;md5=ef966283293cc12fc2891723e6e0d8b2"
SRC_URI += "file://mmc-uEnv-beagle-xm.txt;md5=c1944e3f907c704590dd494dda9c6e28"
SRC_URI += "file://readme-beagle-xm.txt;md5=407a4a3f10581221c4e78bbdf7b5e70d"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

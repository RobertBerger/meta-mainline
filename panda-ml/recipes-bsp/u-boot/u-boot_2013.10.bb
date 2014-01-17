require recipes-bsp/u-boot/u-boot.inc
require u-boot-ti.inc

SPL_BINARY = "MLO"

# To build u-boot for your machine, provide the following lines in
# your machine config, replacing the assignments as appropriate for
# your machine.
# UBOOT_MACHINE = "omap4_panda_config"
# UBOOT_ENTRYPOINT = "0x80008000"
# UBOOT_LOADADDRESS = "0x80008000"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"

PROVIDES += "u-boot"

PV = "v2013.10"

SRCREV = "183acb700378a8cfc5d50a01a65de93fb2c24586"
SRC_URI = "git://git.denx.de/u-boot.git;branch=master;protocol=git"

# extra scripts and readme 
SRC_URI += "file://mkcard-panda.sh;md5=d02a03371e4423086a7e08d746dddb9a"
SRC_URI += "file://mmc-core-image-minimal-dev-panda.sh;md5=511f1dfea4d633a43be892a059181859"
SRC_URI += "file://readme-panda.txt;md5=0142cb79bb274d8f32e2bb08b687ac96"
SRC_URI += "file://uEnv-panda.txt;md5=eb741d20d70328c30ba29260fb3f758a"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

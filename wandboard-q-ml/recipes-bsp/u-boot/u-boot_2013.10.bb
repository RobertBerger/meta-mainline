require u-boot-fsl.inc

#DEPENDS += "elftosb-native"

# To build u-boot for your machine, provide the following lines in
# your machine config, replacing the assignments as appropriate for
# your machine.
# UBOOT_MACHINE = "wandboard_quad_config"
# UBOOT_ENTRYPOINT = "0x10008000"
# UBOOT_LOADADDRESS = "0x10008000"
# UBOOT_MAKE_TARGET = "u-boot.imx"
# UBOOT_SUFFIX = "imx"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"

PROVIDES += "u-boot"

PV = "v2013.10"

SRCREV = "183acb700378a8cfc5d50a01a65de93fb2c24586"
SRC_URI = "git://git.denx.de/u-boot.git;branch=master;protocol=git"

# u-boot patches
SRC_URI += "file://0001-enable-uEnv.txt.patch"

# extra scripts and readme 
SRC_URI += "file://mkcard-wandboard.sh;md5=7e6f58ccb8af2ade607d1e99d7b090b1"
SRC_URI += "file://mmc-core-image-minimal-dev-wandboard.sh;md5=c404f593e7685ba678d620ebd037d044"
SRC_URI += "file://mmc-uEnv-wandboard.txt;md5=61d5d1f50ead039a92e160eb45475041"
SRC_URI += "file://readme-wandboard.txt;md5=51f68dde103140a431eba0a0b62b13f1"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

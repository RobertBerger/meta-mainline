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

PV = "v2013.10"

SRCREV = "183acb700378a8cfc5d50a01a65de93fb2c24586"
SRC_URI = "git://git.denx.de/u-boot.git;branch=master;protocol=git"

# extra scripts and readme 
SRC_URI += "file://mkcard-m28evk.sh;md5=473e45d2325bdf6dfc53bcfac8d99963"
SRC_URI += "file://mkcard-new-m28evk.sh;md5=9a0ab0697ede08d94108d6b7fc1ea7f7"
SRC_URI += "file://mmc-core-image-minimal-dev-m28evk.sh;md5=9895d784e416885fe14a26aeafc57d67"
SRC_URI += "file://mmc-Env-m28evk.txt;md5=45dc399eb09fecb13e19f55f9a6fc1d1"
SRC_URI += "file://readme-m28evk.txt;md5=51f68dde103140a431eba0a0b62b13f1"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"


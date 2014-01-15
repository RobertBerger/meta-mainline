require u-boot-fsl.inc

#DEPENDS += "elftosb-native"

# To build u-boot for your machine, provide the following lines in
# your machine config, replacing the assignments as appropriate for
# your machine.
# UBOOT_MACHINE = "wandboard_dl_config"
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
SRC_URI += "file://mkcard-wandboard.sh;md5=4699cff4c14f5bcd27c2f67a46b2f473"
SRC_URI += "file://mmc-core-image-minimal-dev-wandboard.sh;md5=109a04a9d96c4bfaaa35e547adc9b127"
SRC_URI += "file://readme-wandboard.txt;md5=14cb6225a2131e959059725e5e653f48"
SRC_URI += "file://uEnv-wandboard.txt;md5=bc5179551180a4182706c1b7dea38424"

# patches
SRC_URI += "file://0001-enable-uEnv.txt.patch"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

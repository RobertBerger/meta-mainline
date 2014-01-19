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
SRC_URI += "file://mkcard-wandboard.sh;md5=544f762b406a8376bb07fe8809d5cc44"
SRC_URI += "file://mmc-core-image-minimal-dev-wandboard.sh;md5=b99a1ed895c724c56915383778912266"
SRC_URI += "file://mmc-Env-wandboard.txt;md5=bc5179551180a4182706c1b7dea38424"
SRC_URI += "file://readme-wandboard.txt;md5=14cb6225a2131e959059725e5e653f48"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

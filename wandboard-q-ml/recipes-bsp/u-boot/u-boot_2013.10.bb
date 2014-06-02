require u-boot-fsl.inc

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
SRC_URI += "git://git.denx.de/u-boot.git;branch=master;protocol=git"

# u-boot patches
SRC_URI += "file://0001-enable-uEnv.txt_2013.10.patch"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

require recipes-bsp/u-boot/u-boot.inc
require u-boot-fsl.inc

DEPENDS += "dtc-native"

SPL_BINARY = "SPL"

PROVIDES += "u-boot"

SRC_URI += "git://git.denx.de/u-boot.git;branch=master;protocol=git"

# u-boot patches
SRC_URI += "file://0001-enable-uEnv.txt_2016.01.patch"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

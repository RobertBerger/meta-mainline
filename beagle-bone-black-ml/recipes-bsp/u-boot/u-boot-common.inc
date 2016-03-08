require recipes-bsp/u-boot/u-boot.inc
require u-boot-ti.inc

DEPENDS += "dtc-native"

SPL_BINARY = "MLO"

PROVIDES += "u-boot"

SRC_URI += "git://git.denx.de/u-boot.git;branch=master;protocol=git"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

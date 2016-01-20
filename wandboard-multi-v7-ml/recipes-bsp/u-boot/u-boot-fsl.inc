FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot:"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES += "u-boot"
PKG_${PN} = "u-boot"
PKG_${PN}-dev = "u-boot-dev"
PKG_${PN}-dbg = "u-boot-dbg"

# extra scripts and readme
SRC_URI = "file://mkcard-wandboard.sh"
SRC_URI += "file://mmc-core-image-minimal-dev-wandboard.sh"
SRC_URI += "file://mmc-uEnv-wandboard.txt"
SRC_URI += "file://readme-wandboard.txt"

S = "${WORKDIR}/git"

#UBOOT_SUFFIX = "img"

do_deploy_append () {
# deploy scripts for sd card
    install ${WORKDIR}/mkcard-wandboard.sh ${DEPLOYDIR}
    install ${WORKDIR}/mmc-core-image-minimal-dev-wandboard.sh ${DEPLOYDIR}
    install ${WORKDIR}/mmc-uEnv-wandboard.txt ${DEPLOYDIR}
    install ${WORKDIR}/readme-wandboard.txt ${DEPLOYDIR}
}

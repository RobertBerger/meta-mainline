FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot:"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES += "u-boot"
PKG_${PN} = "u-boot"
PKG_${PN}-dev = "u-boot-dev"
PKG_${PN}-dbg = "u-boot-dbg"

# extra scripts and readme
SRC_URI = "file://mkcard-multi-v7.sh"
SRC_URI += "file://mmc-core-image-minimal-dev-multi-v7.sh"
SRC_URI += "file://mmc-uEnv-multi-v7.txt"
SRC_URI += "file://readme-multi-v7.txt"

S = "${WORKDIR}/git"

UBOOT_SUFFIX = "img"

do_deploy_prepend () {
   install ${S}/spl/${SPL_BINARY} ${S}
}

do_deploy_append () {
# deploy scripts for sd card
#    install ${WORKDIR}/mkcard-multi-v7.sh ${DEPLOYDIR}
#    install ${WORKDIR}/mmc-core-image-minimal-dev-multi-v7.sh ${DEPLOYDIR}
#    install ${WORKDIR}/mmc-uEnv-multi-v7.txt ${DEPLOYDIR}
#    install ${WORKDIR}/readme-multi-v7.txt ${DEPLOYDIR}
    cd ${DEPLOYDIR}
    install ${S}/u-boot-dtb.img ${DEPLOYDIR}/u-boot-dtb-${MACHINE}-${PV}-${PR}.img
    rm -f ${DEPLOYDIR}/u-boot-dtb.img
    ln -sf u-boot-dtb-${MACHINE}-${PV}-${PR}.img u-boot-dtb.img
}


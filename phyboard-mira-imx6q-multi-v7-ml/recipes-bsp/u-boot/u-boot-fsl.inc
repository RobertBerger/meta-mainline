FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot:"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES += "u-boot"
PKG_${PN} = "u-boot"
PKG_${PN}-dev = "u-boot-dev"
PKG_${PN}-dbg = "u-boot-dbg"

# extra scripts and readme
SRC_URI = "file://mkcard-mira.sh"
SRC_URI += "file://tftp-nfs-uEnv-mira-cmd.txt"

S = "${WORKDIR}/git"

UBOOT_SUFFIX = "img"

do_deploy_append () {
# deploy scripts for sd card
    install ${WORKDIR}/tftp-nfs-uEnv-mira-cmd.txt ${DEPLOYDIR}
    install ${WORKDIR}/mkcard-mira.sh ${DEPLOYDIR}
}

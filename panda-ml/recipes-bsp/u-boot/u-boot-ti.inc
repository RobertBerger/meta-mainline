FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot:"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES += "u-boot"
PKG_${PN} = "u-boot"
PKG_${PN}-dev = "u-boot-dev"
PKG_${PN}-dbg = "u-boot-dbg"

# extra scripts and readme
SRC_URI = "file://mkcard-panda.sh"
SRC_URI += "file://mmc-core-image-minimal-dev-panda.sh"
SRC_URI += "file://mmc-uEnv-panda.txt"
SRC_URI += "file://readme-panda.txt"

S = "${WORKDIR}/git"

UBOOT_SUFFIX = "img"

# SPL (Second Program Loader) to be loaded over UART
SPL_UART_BINARY ?= ""
SPL_UART_IMAGE ?= "${SPL_UART_BINARY}-${MACHINE}-${PV}-${PR}"
SPL_UART_SYMLINK ?= "${SPL_UART_BINARY}-${MACHINE}"

do_install_append () {
    if [ "x${SPL_UART_BINARY}" != "x" ]
    then
        install ${S}/spl/${SPL_UART_BINARY} ${D}/boot/${SPL_UART_IMAGE}
        ln -sf ${SPL_UART_IMAGE} ${D}/boot/${SPL_UART_BINARY}
    fi
}

do_deploy_append () {
# deploy scripts for sd card
    install ${WORKDIR}/mkcard-panda.sh ${DEPLOYDIR}
    install ${WORKDIR}/mmc-core-image-minimal-dev-panda.sh ${DEPLOYDIR}
    install ${WORKDIR}/mmc-uEnv-panda.txt ${DEPLOYDIR}
    install ${WORKDIR}/readme-panda.txt ${DEPLOYDIR}
    cd ${DEPLOYDIR}
    if [ "x${SPL_UART_BINARY}" != "x" ]
    then
        install ${S}/spl/${SPL_UART_BINARY} ${DEPLOYDIR}/${SPL_UART_IMAGE}
        rm -f ${DEPLOYDIR}/${SPL_UART_BINARY} ${DEPLOYDIR}/${SPL_UART_SYMLINK}
        ln -sf ${SPL_UART_IMAGE} ${DEPLOYDIR}/${SPL_UART_BINARY}
        ln -sf ${SPL_UART_IMAGE} ${DEPLOYDIR}/${SPL_UART_SYMLINK}
    fi
}

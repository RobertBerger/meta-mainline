FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot:"

PACKAGE_ARCH = "${MACHINE_ARCH}"

# extra scripts and readme
SRC_URI = "file://mkcard-terasic.sh"
SRC_URI += "file://mmc-core-image-minimal-dev-terasic.sh"
SRC_URI += "file://mmc-uEnv-terasic.txt"
SRC_URI += "file://readme-terasic.txt"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = 'CROSS_COMPILE=${TARGET_PREFIX} CC="${TARGET_PREFIX}gcc ${TOOLCHAIN_OPTIONS}" V=1'

UBOOT_SUFFIX = "img"

# SPL (Second Program Loader) to be loaded over UART
SPL_UART_BINARY ?= ""
SPL_UART_IMAGE ?= "${SPL_UART_BINARY}-${MACHINE}-${PV}-${PR}"
SPL_UART_SYMLINK ?= "${SPL_UART_BINARY}-${MACHINE}"


# Altera preloader generator
PRELOADER_BINARY = "preloader-mkpimage"
PRELOADER_SUFFIX = "bin"
PRELOADER_IMAGE = "${PRELOADER_BINARY}-${MACHINE}-${PV}-${PR}.${PRELOADER_SUFFIX}"
PRELOADER_SYMLINK = "${PRELOADER_BINARY}-${MACHINE}.${PRELOADER_SUFFIX}"

do_compile_append () {
    /development/tools/altera/15.0/embedded/host_tools/altera/mkpimage/mkpimage \
        --header-version 0 \
        -o ${PRELOADER_IMAGE} \
        ${S}/spl/u-boot-spl.bin ${S}/spl/u-boot-spl.bin ${S}/spl/u-boot-spl.bin ${S}/spl/u-boot-spl.bin
}

do_install_append () {
    if [ "x${SPL_UART_BINARY}" != "x" ]
    then
        install ${S}/spl/${SPL_UART_BINARY} ${D}/boot/${SPL_UART_IMAGE}
        ln -sf ${SPL_UART_IMAGE} ${D}/boot/${SPL_UART_BINARY}
    fi

    install ${S}/${PRELOADER_IMAGE} ${D}/boot/${PRELOADER_IMAGE}
    ln -sf ${PRELOADER_IMAGE} ${D}/boot/${PRELOADER_SYMLINK}

}

do_deploy_append () {
# deploy scripts for sd card
    install ${WORKDIR}/mkcard-terasic.sh ${DEPLOYDIR}
    install ${WORKDIR}/mmc-core-image-minimal-dev-terasic.sh ${DEPLOYDIR}
    install ${WORKDIR}/mmc-uEnv-terasic.txt ${DEPLOYDIR}
    install ${WORKDIR}/readme-terasic.txt ${DEPLOYDIR}
    cd ${DEPLOYDIR}
    if [ "x${SPL_UART_BINARY}" != "x" ]
    then
        install ${S}/spl/${SPL_UART_BINARY} ${DEPLOYDIR}/${SPL_UART_IMAGE}
        rm -f ${DEPLOYDIR}/${SPL_UART_BINARY} ${DEPLOYDIR}/${SPL_UART_SYMLINK}
        ln -sf ${SPL_UART_IMAGE} ${DEPLOYDIR}/${SPL_UART_BINARY}
        ln -sf ${SPL_UART_IMAGE} ${DEPLOYDIR}/${SPL_UART_SYMLINK}
    fi

    install ${S}/${PRELOADER_IMAGE} ${DEPLOYDIR}/${PRELOADER_IMAGE}
    ln -sf ${PRELOADER_IMAGE} ${DEPLOYDIR}/${PRELOADER_SYMLINK}

}

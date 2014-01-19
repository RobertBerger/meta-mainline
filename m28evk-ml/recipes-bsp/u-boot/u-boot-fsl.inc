require recipes-bsp/u-boot/u-boot.inc

FILESEXTRAPATHS_prepend := "${THISDIR}/u-boot:"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES += "u-boot"
PKG_${PN} = "u-boot"
PKG_${PN}-dev = "u-boot-dev"
PKG_${PN}-dbg = "u-boot-dbg"

S = "${WORKDIR}/git"

do_compile_append () {
   # create bitstream for sd card
   ${S}/tools/mxsboot sd ${S}/${PN}.sb ${S}/${PN}.sd
}

SD_BITSTREAM_BINARY ?= "${PN}"
SD_BITSTREAM_IMAGE ?= "${SD_BITSTREAM_BINARY}-${MACHINE}-${EXTENDPKGV}.sd"
SD_BITSTREAM_SYMLINK ?= "${SD_BITSTREAM_BINARY}-${MACHINE}.sd"

do_install_append () {
   # install bistream for sd card
   install ${S}/${SD_BITSTREAM_BINARY} ${D}/boot/${SD_BISTREAM_IMAGE}
   ln -sf ${SD_BITSTREAM_IMAGE} ${D}/boot/${SD_BITSTREAM_BINARY}

}

do_deploy_append () {
   # deploy scripts for sd card
   install ${WORKDIR}/mkcard-m28evk.sh ${DEPLOYDIR}
   install ${WORKDIR}/mkcard-new-m28evk.sh ${DEPLOYDIR}
   install ${WORKDIR}/mmc-core-image-minimal-dev-m28evk.sh ${DEPLOYDIR}
   install ${WORKDIR}/mmc-uEnv-m28evk.txt ${DEPLOYDIR}
   install ${WORKDIR}/readme-m28evk.txt ${DEPLOYDIR}
   # deploy bitstream for sd card
   install ${S}/${SD_BITSTREAM_BINARY}.sd ${DEPLOYDIR}/${SD_BITSTREAM_IMAGE}
   rm -f ${DEPLOYDIR}/${SD_BITSTREAM_BINARY}.sd  ${DEPLOYDIR}/${SD_BITSTREAM_SYMLINK}
   ln -sf ${SD_BITSTREAM_IMAGE} ${DEPLOYDIR}/${SD_BITSTREAM_BINARY}.sd
   ln -sf ${SD_BITSTREAM_IMAGE} ${DEPLOYDIR}/${SD_BITSTREAM_SYMLINK}
}

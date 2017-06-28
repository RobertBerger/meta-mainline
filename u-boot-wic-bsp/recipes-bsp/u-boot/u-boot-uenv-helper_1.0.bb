FILESEXTRAPATHS_prepend := "${THISDIR}/${MACHINE}:"
SUMMARY = "u-boot uEnv.txt helper"
SECTION = "bsp"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# pace different uEnv.txt files in different subdirs with MACHINE name
SRC_URI += " \
    file://uEnv.txt \
"

DEPENDS_imx6q-phytec-mira-rdk-nand = "u-boot"

S = "${WORKDIR}"

do_install() {
	# place in rootfs
        install -d ${D}/${rootdir}
        install -m 0444 ${WORKDIR}/uEnv.txt ${D}/${rootdir}/uEnv.txt
}

do_install_append_imx6q-phytec-mira-rdk-nand() {
        # place in rootfs
        install -d ${D}/${rootdir}
        install -m 0666 ${DEPLOY_DIR_IMAGE}/u-boot.img ${D}/${rootdir}/u-boot.img 
}

FILES_${PN} += "/uEnv.txt"

FILES_${PN}_imx6q-phytec-mira-rdk-nand += "/uEnv.txt \
                                           /u-boot.img \
                                           "
## Copy script to the deploy area with u-boot, uImage, and rootfs
do_deploy () {
   install -d ${DEPLOY_DIR_IMAGE}
   install -m 0755 ${WORKDIR}/uEnv.txt ${DEPLOY_DIR_IMAGE}
}
addtask deploy after do_install

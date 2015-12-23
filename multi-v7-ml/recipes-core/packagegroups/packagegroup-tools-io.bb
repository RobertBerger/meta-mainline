DESCRIPTION = "Tools i/o Package Group"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    packagegroup-tools-io"

RDEPENDS_packagegroup-tools-io = "\
    i2c-tools \
    iotop \
    libuio \
    devmem2 \
    evtest \
    libsoc \
    spitools \
    "

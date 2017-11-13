DESCRIPTION = "zedboard Package Group"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    packagegroup-zedboard"

RDEPENDS_packagegroup-zedboard = "\
    force-usb-power \
    xilinx-dma \
    "

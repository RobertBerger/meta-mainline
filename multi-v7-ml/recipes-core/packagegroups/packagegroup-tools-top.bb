DESCRIPTION = "Tools Top Package Group"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    packagegroup-tools-top"

RDEPENDS_packagegroup-tools-top = "\
    htop \
    iotop \
    latencytop \
    powertop \
    powerdebug \
    tiptop \
    atop \
    iftop \
    "

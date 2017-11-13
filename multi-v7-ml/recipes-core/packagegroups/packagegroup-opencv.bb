DESCRIPTION = "opencv Package Group"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    packagegroup-opencv"

RDEPENDS_packagegroup-opencv = "\
    v4l-utils \
    yavta \
    opencv \
    "

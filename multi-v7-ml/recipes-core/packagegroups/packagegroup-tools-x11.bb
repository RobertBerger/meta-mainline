DESCRIPTION = "Tools x11 Package Group"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    packagegroup-tools-x11"

RDEPENDS_packagegroup-tools-x11 = "\
    xeyes \
    "

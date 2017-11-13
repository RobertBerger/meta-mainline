DESCRIPTION = "Tools Real-Time Package Group"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    packagegroup-tools-rt"

RDEPENDS_packagegroup-tools-rt = "\
    hwlatdetect \
    rt-tests \
    "

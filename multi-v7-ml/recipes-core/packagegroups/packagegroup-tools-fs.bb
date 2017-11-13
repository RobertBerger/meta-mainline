DESCRIPTION = "Tools Filesystems Package Group"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    packagegroup-tools-fs"

RDEPENDS_packagegroup-tools-fs = "\
    mtd-utils \
    mtd-utils-jffs2 \
    mtd-utils-ubifs \
    mtd-utils-misc \
    "

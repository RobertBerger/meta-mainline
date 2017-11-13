DESCRIPTION = "Tools Commandline Package Group"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    packagegroup-tools-cmdline"

RDEPENDS_packagegroup-tools-cmdline = "\
    pv \
    tree \
    vim \
    timelimit \
    lsof \
    psmisc \
    "

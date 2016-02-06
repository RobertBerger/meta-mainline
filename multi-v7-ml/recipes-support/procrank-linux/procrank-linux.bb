DESCRIPTION = "procrank-linux"
HOMEPAGE = "https://github.com/csimmonds/procrank_linux"
SECTION = "recipes-support"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRCREV = "1d48fd7579bce60b785ba2a78fff560c93293c4e"
PV = "0.1+git${SRCPV}"

SRC_URI = "git://github.com/RobertBerger/procrank_linux"

S = "${WORKDIR}/git"

do_install () {
    oe_runmake DESTDIR=${D} install
}


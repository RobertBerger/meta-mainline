FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = "http://git.yoctoproject.org/cgit/cgit.cgi/${BPN}/snapshot/${BPN}-${PV}.tar.gz \
           file://opkg-configure.service \
           file://opkg.conf \
"

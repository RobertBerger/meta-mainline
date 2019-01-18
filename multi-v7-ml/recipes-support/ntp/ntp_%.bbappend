SRC_URI += "file://my-ntpd \
"
do_install_append() {
    install -m 755 ${WORKDIR}/my-ntpd ${D}${sysconfdir}/init.d/ntpd
}

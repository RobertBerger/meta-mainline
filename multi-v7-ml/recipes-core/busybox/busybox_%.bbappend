# This recipe modifies the default settings of busybox
#
# busybox-ntpd package is generated that contains the needed init script.
# Moreover, this adds busybox-ntpd to INITSCRIPT_PACKAGES

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://ntpclient.cfg"
SRC_URI += "file://ntp.conf"
SRC_URI += "file://ntpd.busybox"

PACKAGES =+ "${PN}-ntpd"

INITSCRIPT_PACKAGES += "${PN}-ntpd"
INITSCRIPT_NAME_${PN}-ntpd = "ntpd.busybox"

FILES_${PN}-ntpd = "${sysconfdir}/init.d/ntpd.busybox ${sysconfdir}/ntp.conf"

CONFFILES_${PN}-ntpd = "${sysconfdir}/ntp.conf"

RRECOMMENDS_${PN} += "${PN}-ntpd"

do_install_append() {
	install -d ${D}${sysconfdir}
	install -m 0644 ${WORKDIR}/ntp.conf ${D}${sysconfdir}/

	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/ntpd.busybox ${D}${sysconfdir}/init.d/
}

# we need the resolveconf package in order
# to add some nameservers with static IPs
RDEPENDS_${PN} = "resolvconf"

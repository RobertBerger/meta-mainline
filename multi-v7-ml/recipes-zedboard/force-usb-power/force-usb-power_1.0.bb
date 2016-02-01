DESCRIPTION = "force usb power"
SRC_URI = "file://force-usb-power"

inherit update-rc.d

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

INITSCRIPT_NAME = "force-usb-power"
INITSCRIPT_PARAMS = "start 32 2 3 4 5 . stop 32 0 1 6 ."

do_install() {
       install -d ${D}${sysconfdir}/init.d
       install -m 0755 ${WORKDIR}/force-usb-power ${D}${sysconfdir}/init.d/force-usb-power
}

FILES_${PN} = "${sysconfdir}/init.d/force-usb-power"


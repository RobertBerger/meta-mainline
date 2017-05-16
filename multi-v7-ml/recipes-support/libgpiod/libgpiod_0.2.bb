SUMMARY = "C library and tools for interacting with the linux GPIO character device"
HOMEPAGE = "https://github.com/brgl/libgpiod"

LICENSE = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://COPYING;md5=2caced0b25dfefd4c601d92bd15116de"

SRCREV = "7ab5e53b69cce313ba87033a442cabd417f5d895"
#SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/brgl/libgpiod;protocol=https;branch=v0.2.x"
# Note: this only works with PR_server running!
# PV is expanded to something like 0.0+gitAUTOINC+ecf1f0bc87"
# The PR_server? replaces AUTOINC with a number in the package name
# simple-hello-world-git-dev_0.0+git4+ecf1f0bc87-r0.0_armv7a-vfp-neon.ipk
PV = "0.0+git${SRCPV}"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

# enable tools
PACKAGECONFIG ?= "tools"

PACKAGECONFIG[tests] = "--enable-tests,--disable-tests,kmod udev"
PACKAGECONFIG[tools] = "--enable-tools,--disable-tools,"

PACKAGES += " ${PN}-tools"

FILES_${PN} = "${libdir}/*"
FILES_${PN}-tools = "${bindir}/*"

# Recipe created by recipetool - hacked by Robert Berger - ReliableEmbeddedSystems
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   vpnclient/ReadMeFirst_License.txt
#   vpnclient/lib/License.txt
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://ReadMeFirst_License.txt;md5=64703177fdf8b6436fe8bcddd122308d \
                    file://lib/License.txt;md5=e8ae0fe60be3cd8cd07330928de5add9"

SRC_URI = "git://github.com/RobertBerger/softether-vpnclient-linux-arm_eabi-32bit.git;protocol=git;branch=v4.28-9669-beta-2018.09.11-res"

# Modify these as desired
PV = "4.28.9969.2018.09.11+git${SRCPV}"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

# NOTE: no Makefile found, unable to determine what needs to be done

do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# Specify compilation commands here
	oe_runmake
}


do_install () {
	# Specify install commands here
	install -d ${D}/${bindir}
        install -m 0555 ${S}/vpnclient   ${D}/${bindir}/vpnclient
        install -m 0555 ${S}/vpncmd      ${D}/${bindir}/vpncmd
        install -m 0444 ${S}/hamcore.se2 ${D}/${bindir}/hamcore.se2
}

# to igore:
# do_package_qa: QA Issue: ELF binary ... has relocations in .text
# we ignore it here, because stuff is partially prebuilt
INSANE_SKIP_${PN}_append = " textrel"

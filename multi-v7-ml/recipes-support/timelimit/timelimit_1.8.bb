# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)
#
# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://Makefile;beginline=1;endline=25;md5=961bf5dca32e6cc9b2a3cbe84b3157fd \
                    file://config.h;beginline=4;endline=29;md5=cbb1c217b91c5f961cdfcd8d8afe01a7 \
                    file://timelimit.c;beginline=1;endline=25;md5=b00aa6c4b65c817bc55bb2e3cb1bccc0 \
                   "
# No information for SRC_URI yet (only an external source tree was specified)
SRC_URI = "file://timelimit-${PV}.tar.gz"

# NOTE: this is a Makefile-only piece of software, so we cannot generate much of the
# recipe automatically - you will need to examine the Makefile yourself and ensure
# that the appropriate arguments are passed in.

do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# You will almost certainly need to add additional arguments here
	oe_runmake
}

do_install () {
	# This is a guess; additional arguments may be required
	oe_runmake install 'DESTDIR=${D}'
}


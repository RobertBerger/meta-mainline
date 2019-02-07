# Copyright (C) 2019 Robert Berger <Robert.Berger@ReliableEmbeddedSystems.com>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Kernel analysis utility for live systems, netdump, diskdump, kdump, LKCD or mcore dumpfiles"
DESCRIPTION = "The core analysis suite is a self-contained tool that can be used to\
investigate either live systems, kernel core dumps created from the\
netdump, diskdump and kdump packages from Red Hat Linux, the mcore kernel patch\
offered by Mission Critical Linux, or the LKCD kernel patch."

HOMEPAGE = "http://people.redhat.com/anderson"
SECTION = "devel"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI += "file://crash-small;subdir=${BP}"

DEPENDS = "xz zlib readline coreutils-native"

inherit bin_package

INSANE_SKIP_${PN} += "already-stripped"

do_install() {
    install -d ${D}${bindir}
    install -m 0777 crash-small ${D}${bindir}
}

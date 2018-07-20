# Copyright (C) 2018 Robert Berger  <robert.berger@ReliableEmbeddedSystems.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "iio generic-buffer"
LICENSE = "GPL-2.0"
SECTION = "examples"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://CMakeLists.txt \
           file://iio_utils.c \
           file://iio_utils.h \
           file://iio-generic-buffer.c"

S = "${WORKDIR}"

inherit cmake

EXTRA_OECMAKE = ""


DESCRIPTION = "Tools i/o Package Group"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    packagegroup-tools-io"

RDEPENDS_packagegroup-tools-io = "\
    i2c-tools \
    iotop \
    libuio \
    devmem2 \
    evtest \
    libsoc \
    spitools \
    zlog \
    libgpiod \
    libiio \
    lsiio \
    iio-event-monitor \
    iio-generic-buffer \
    lmsensors \
    lmsensors-config \
    "

DESCRIPTION = "Tools iot Package Group"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    ${PN}"

RDEPENDS_${PN} = "\
    mraa \
    upm \
    mosquitto \
    paho-mqtt-c \
    rabbitmq-c \
    python3-pip \
    mysql-python \
    python-pyzmq \
    "

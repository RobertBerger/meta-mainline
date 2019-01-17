# those should end up in the nativesdk


RDEPENDS_${PN} += " \
    nativesdk-agent-proxy \
    nativesdk-dtc \
    nativesdk-e2fsprogs \
    nativesdk-elfutils \
    nativesdk-git \
    nativesdk-lzop \
    nativesdk-make \
    nativesdk-mtd-utils \
    nativesdk-squashfs-tools \
    nativesdk-u-boot-tools \
    nativesdk-wget \
    nativesdk-xz \
"
#
#RDEPENDS_${PN} += " \
#    nativesdk-elftosb \
#    nativesdk-mxsldr \
#    nativesdk-u-boot-mkimage \
#    nativesdk-imx-usb-loader \
#    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'nativesdk-wayland', '', d)} \
#"


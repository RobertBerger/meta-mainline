# those should end up in the nativesdk

RDEPENDS_${PN} += " \
    nativesdk-u-boot-mkimage \
"

#
#RDEPENDS_${PN} += " \
#    nativesdk-elftosb \
#    nativesdk-mxsldr \
#    nativesdk-u-boot-mkimage \
#    nativesdk-imx-usb-loader \
#    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'nativesdk-wayland', '', d)} \
#"


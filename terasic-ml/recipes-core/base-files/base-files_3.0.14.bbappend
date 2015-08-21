FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

do_install_append (){
    install -m 0755 -d ${D}/mnt/ramdisk
}


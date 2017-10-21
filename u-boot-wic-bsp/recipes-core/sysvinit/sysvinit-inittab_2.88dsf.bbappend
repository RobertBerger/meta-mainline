# use runlevel 3 instead of 5 and
# replace funny /bin/getty script with /sbin/getty
do_install_append() {
        sed -i 's/^id:5:initdefault/id:3:initdefault/' ${D}${sysconfdir}/inittab
        sed -i 's/bin\/start_getty/sbin\/getty/' ${D}${sysconfdir}/inittab
}

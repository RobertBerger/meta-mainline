# limit console labels to 5 chars
do_install() {
    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/inittab ${D}${sysconfdir}/inittab
	
    tmp="${SERIAL_CONSOLES}"
    for i in $tmp
    do
	j=`echo ${i} | sed s/\;/\ /g`
	label=`echo ${i} | sed -e 's/^.*;tty//' -e 's/;.*//'`
	# console labels must not be more than 5 chars - cook up something, leave in last 4 chars
	case "$label" in
		console*)
			label="$(echo ${label} | cut -c1,5-)"
		;;
	esac
	echo "$label:12345:respawn:${base_sbindir}/getty ${j}" >> ${D}${sysconfdir}/inittab
    done

    if [ "${USE_VT}" = "1" ]; then
        cat <<EOF >>${D}${sysconfdir}/inittab
# ${base_sbindir}/getty invocations for the runlevels.
#
# The "id" field MUST be the same as the last
# characters of the device (after "tty").
#
# Format:
#  <id>:<runlevels>:<action>:<process>
#

EOF

        for n in ${SYSVINIT_ENABLED_GETTYS}
        do
            echo "$n:2345:respawn:${base_sbindir}/getty 38400 tty$n" >> ${D}${sysconfdir}/inittab
        done
        echo "" >> ${D}${sysconfdir}/inittab
    fi
}

# use runlevel 3 instead of 5
do_install_append() {
	sed -i 's/^id:5:initdefault/id:3:initdefault/' ${D}${sysconfdir}/inittab
}

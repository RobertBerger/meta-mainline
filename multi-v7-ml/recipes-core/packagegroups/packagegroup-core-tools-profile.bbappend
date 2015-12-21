# add oprofile, which got lost in jethro

RRECOMMENDS_${PN}_append = "\
    kernel-module-oprofile \
    "

PROFILETOOLS_append = "\
    oprofile \
    "

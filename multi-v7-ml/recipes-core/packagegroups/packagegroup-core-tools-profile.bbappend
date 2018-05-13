# add oprofile, which got lost in jethro

PROFILETOOLS_append = "\
    bootchart2 \
    ltrace \
    "

# sumo removed oprofile
# oprofile

#RRECOMMENDS_${PN}_append = "
#    kernel-module-oprofile
#    "

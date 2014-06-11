# find defconfig path
FILESEXTRAPATHS := "${THISDIR}/${PN}"

# Kernel configs
SRC_URI_append_beagleboard = " \
	file://beagle_qemu.cfg \
	"

SRC_URI_append_vexpress-a9-ml = " \
	file://vexpress_a9.cfg  \
	"

SRC_URI_append_qemux86 = " \
	file://qemux86.cfg  \
	"

SRC_URI_append_qemux86-64 = " \
	file://qemux86_64.cfg  \
	"

KMACHINE_vexpress-a9-ml = "beagleboard"
SRCREV_machine_vexpress-a9-ml ?= "${AUTOREV}"
COMPATIBLE_MACHINE_vexpress-a9-ml = "vexpress-a9-ml"

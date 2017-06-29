# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.9.y"

LINUX_VERSION ?= "4.9.34"
LINUX_VERSION_EXTENSION ?= "-custom"

SRCREV="493ecd5cd73ed41e319fe39816c6d3638ef080ff"

PATCHPATH="${THISDIR}/linux-yocto-custom/${KERNEL_VERSION_PATCHLEVEL}.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "file://u-boot-wic-user-patches.scc"

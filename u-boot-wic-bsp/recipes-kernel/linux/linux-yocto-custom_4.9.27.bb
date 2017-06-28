# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.9.y"

LINUX_VERSION ?= "4.9.27"
LINUX_VERSION_EXTENSION ?= "-custom"

SRCREV="89f3b8d5f264d5dab9818c6667c71e3cc55b13f5"

PATCHPATH="${THISDIR}/linux-yocto-custom/${KERNEL_VERSION_PATCHLEVEL}.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "file://u-boot-wic-user-patches.scc"

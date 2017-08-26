# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.9.y"

LINUX_VERSION ?= "4.9.44"
LINUX_VERSION_EXTENSION ?= "-custom"

SRCREV="a97a16f18c4895e41951a44d27af8af0b8f1d897"

PATCHPATH="${THISDIR}/linux-yocto-custom/${KERNEL_VERSION_PATCHLEVEL}.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "file://u-boot-wic-user-patches.scc"

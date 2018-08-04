# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.14.y"

LINUX_VERSION ?= "4.14.47"
LINUX_VERSION_EXTENSION ?= "-custom"

SRCREV ?= "57a3ca7835962109d94533465a75e8c716b26845"

PATCHPATH="${THISDIR}/linux-yocto-custom/${KERNEL_VERSION_PATCHLEVEL}.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "file://u-boot-wic-user-patches.scc"

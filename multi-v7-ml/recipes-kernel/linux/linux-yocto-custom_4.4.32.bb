# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.4.y"

LINUX_VERSION = "4.4.32"

# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2016-11-15 06:47:35 (GMT)
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2016-11-15 06:47:35 (GMT)
# commit	4dab3e4df9944782cb3c229bd37f5ea8b5f52bac (patch)
# tree		53b25f19516b7de766a61e4ecebb8312604491c1
# parent	ae94da4c53b77058241fd3551f55cd40327be37d (diff)
# Linux 4.4.32 v4.4.32 linux-4.4.y

SRCREV ?= "4dab3e4df9944782cb3c229bd37f5ea8b5f52bac"

PATCHPATH="${THISDIR}/patch/4.4.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "\
           file://multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://${PATCHPATH}/patches;type=kmeta;destsuffix=patches \
                "

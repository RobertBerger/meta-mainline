# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.1.y"

LINUX_VERSION = "4.1.13"

# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2015-11-09 22:34:10 (GMT)
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2015-11-09 22:34:10 (GMT)
# commit	1f2ce4a2e7aea3a2123b17aff62a80553df31e21 (patch)
# tree		646f196eebdcf8353ca9ce30b4fd3880302d1ced
# parent	50eda1546d87542d21eb5a69caf4f046a4bb416e (diff)
# Linux 4.1.13 v4.1.13 linux-4.1.y

SRCREV ?= "1f2ce4a2e7aea3a2123b17aff62a80553df31e21"

FILESEXTRAPATHS_prepend := "${THISDIR}/patch/4.1.x:"

SRC_URI += "\
           file://zedboard-multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://patches;type=kmeta;destsuffix=patches \
                "

# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.4.y"

LINUX_VERSION = "4.4.1"

# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2016-01-31 19:29:37 (GMT)
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2016-01-31 19:29:37 (GMT)
# commit	f1ab5eafa3625b41c74326a1994a820ff805d5b2 (patch)
# tree		2e6b1d1c4db95041fe2590d11a45cdb567e00360
# parent	9497f702ab82314dffa457823be91783ca5a4531 (diff)
# Linux 4.4.1 v4.4.1 linux-4.4.y

SRCREV ?= "f1ab5eafa3625b41c74326a1994a820ff805d5b2"

PATCHPATH="${THISDIR}/patch/4.4.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "\
           file://multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://${PATCHPATH}/patches;type=kmeta;destsuffix=patches \
                "


# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.9.y"

LINUX_VERSION = "4.9.80"

# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2018-02-03 17:05:43 +0100
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2018-02-03 17:05:43 +0100
# commit	331b057d4f3ccf2290e6e651b5728db81e9249c6 (patch)
# tree		d5514d74c8479d70360cda1c6e5814511cf522ed
# parent	1333c3e996eb799286ee2ef2c01752da45bf926f (diff)
# download	linux-stable-331b057d4f3ccf2290e6e651b5728db81e9249c6.tar.gz
# Linux 4.9.80 v4.9.80 linux-4.9.y

SRCREV ?= "331b057d4f3ccf2290e6e651b5728db81e9249c6"

PATCHPATH="${THISDIR}/patch/4.9.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "\
           file://multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://${PATCHPATH}/patches;type=kmeta;destsuffix=patches \
                "

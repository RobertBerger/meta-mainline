# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.4.y"

LINUX_VERSION = "4.4.23"

# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2016-09-30 08:20:43 (GMT)
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2016-09-30 08:20:43 (GMT)
# commit	d19e48fe5da7b83d02ed4aec3567f08ae02a168c (patch)
# tree		48237ea47087f8087251a9f4eb16bad29273bdb2
# parent	7b251d3404dfd0384274b7493722f65a1ceaa724 (diff)
# Linux 4.4.23 v4.4.23 linux-4.4.y

SRCREV ?= "d19e48fe5da7b83d02ed4aec3567f08ae02a168c"

PATCHPATH="${THISDIR}/patch/4.4.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "\
           file://multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://${PATCHPATH}/patches;type=kmeta;destsuffix=patches \
                "


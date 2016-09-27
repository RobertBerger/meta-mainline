# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.4.y"

LINUX_VERSION = "4.4.22"

# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2016-09-24 08:08:14 (GMT)
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2016-09-24 08:08:14 (GMT)
# commit	8d5e93bb8c9c48ee5948f6b1aff0e895381f09e6 (patch)
# tree		1a11bffa518af9d27a0df5f262474b3d3499f2e9
# parent	7e30e5bb42de8039d78dd8c4c69039e155d536d1 (diff)
# Linux 4.4.22 v4.4.22 linux-4.4.y

SRCREV ?= "8d5e93bb8c9c48ee5948f6b1aff0e895381f09e6"

PATCHPATH="${THISDIR}/patch/4.4.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "\
           file://multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://${PATCHPATH}/patches;type=kmeta;destsuffix=patches \
                "


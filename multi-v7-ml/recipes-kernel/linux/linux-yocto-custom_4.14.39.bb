# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.14.y"

LINUX_VERSION = "4.14.39"

# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2018-05-01 12:58:27 -0700
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2018-05-01 12:58:27 -0700
# commit	7d6240f0fb85430ae4f490824fdf8d0a078dfcd2 (patch)
# tree		2f72fc408f40adcc9e98f4dbcc4554abe563ccf5
# parent	7fddff51f245b01d1dab2a6461d706170ff5b519 (diff)
# download	linux-stable-7d6240f0fb85430ae4f490824fdf8d0a078dfcd2.tar.gz
# Linux 4.14.39 v4.14.39

SRCREV ?= "7d6240f0fb85430ae4f490824fdf8d0a078dfcd2"

PATCHPATH="${THISDIR}/patch/4.14.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "\
           file://multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://${PATCHPATH}/patches;type=kmeta;destsuffix=patches \
                "

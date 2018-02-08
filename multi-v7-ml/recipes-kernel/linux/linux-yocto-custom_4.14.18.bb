# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.14.y"

LINUX_VERSION = "4.14.18"

# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2018-02-07 11:12:26 -0800
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2018-02-07 11:12:26 -0800
# commit	81d0cc85caabe062991ea45ddada814835d47fb0 (patch)
# tree		eb22485657e869c64961603c00541a1c40c2b5f5
# parent	8d1ed7d4e1ce6d4d08676f5b2bb1a4e83b3ad5f7 (diff)
# download	linux-stable-81d0cc85caabe062991ea45ddada814835d47fb0.tar.gz
# Linux 4.14.18 v4.14.18 linux-4.14.y

SRCREV ?= "81d0cc85caabe062991ea45ddada814835d47fb0"

PATCHPATH="${THISDIR}/patch/4.14.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "\
           file://multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://${PATCHPATH}/patches;type=kmeta;destsuffix=patches \
                "

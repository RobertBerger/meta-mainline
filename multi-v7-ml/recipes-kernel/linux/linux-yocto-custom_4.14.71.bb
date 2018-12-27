# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.14.y"

LINUX_VERSION = "4.14.71"

# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2018-09-19 22:43:49 +0200
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2018-09-19 22:43:49 +0200
# commit	1244bbb3e92135d247e2dddfa6fe5e3e171a9635 (patch)
# tree		5017c60a70286e33c74b2d3745361f99df3bb5de
# parent	06274364edb4407b386a996a7ff46c3ca3459b70 (diff)
# download	linux-1244bbb3e92135d247e2dddfa6fe5e3e171a9635.tar.gz
# Linux 4.14.71	v4.14.71

SRCREV ?= "1244bbb3e92135d247e2dddfa6fe5e3e171a9635"

PATCHPATH="${THISDIR}/patch/4.14.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "\
           file://multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://${PATCHPATH}/patches;type=kmeta;destsuffix=patches \
                "

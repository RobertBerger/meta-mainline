# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.14.y"

LINUX_VERSION = "4.14.47"

# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2018-05-30 22:32:31 +0200
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2018-05-30 22:32:31 +0200
# commit	57a3ca7835962109d94533465a75e8c716b26845 (patch)
# tree		790eca6aa5f097aef341098b86262afc9f373d0c
# parent	3e496be2038a100fc53627238fe120dc4c948719 (diff)
# download	linux-stable-57a3ca7835962109d94533465a75e8c716b26845.tar.gz
# Linux 4.14.47 v4.14.47 linux-4.14.y

SRCREV ?= "57a3ca7835962109d94533465a75e8c716b26845"

PATCHPATH="${THISDIR}/patch/4.14.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "\
           file://multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://${PATCHPATH}/patches;type=kmeta;destsuffix=patches \
                "

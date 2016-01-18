# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.1.y"

LINUX_VERSION = "4.1.15"

# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2015-12-15 05:24:51 (GMT)
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2015-12-15 05:24:51 (GMT)
# commit	07cc49f66973f49a391c91bf4b158fa0f2562ca8 (patch)
# tree		52ad3436062e687c262acf4cf5cf48fbd120da8b
# parent	296bf2e45cb117a0face3e0e5c94d371d8781e0e (diff)
# Linux 4.1.15 v4.1.15 linux-4.1.y

SRCREV ?= "07cc49f66973f49a391c91bf4b158fa0f2562ca8"

FILESEXTRAPATHS_prepend := "${THISDIR}/patch/4.1.x:"

SRC_URI += "\
           file://zedboard-multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://patches;type=kmeta;destsuffix=patches \
                "

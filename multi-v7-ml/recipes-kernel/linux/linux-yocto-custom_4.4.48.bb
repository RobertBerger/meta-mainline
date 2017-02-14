# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.4.y"

LINUX_VERSION = "4.4.48"

# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2017-02-09 07:02:59 (GMT)
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2017-02-09 07:02:59 (GMT)
# commit	6a1bd90632464c129ad5f9ca7c54917a6dd7cb4b (patch)
# tree		ac0fd6c52b0f68d8316f739e9f9c2daf8352eda6
# parent	87ebcc534d47dd924327daa651c36f876db76f72 (diff)
# Linux 4.4.48 v4.4.48 linux-4.4.y

SRCREV ?= "6a1bd90632464c129ad5f9ca7c54917a6dd7cb4b"

PATCHPATH="${THISDIR}/patch/4.4.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "\
           file://multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://${PATCHPATH}/patches;type=kmeta;destsuffix=patches \
                "

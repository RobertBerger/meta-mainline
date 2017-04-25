# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.9.y"

LINUX_VERSION = "4.9.24"

# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2017-04-21 09:31:39 +0200
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2017-04-21 09:31:39 +0200
# commit	2f5e58ec793f56f9ac1c6736b4638a4b81d6f099 (patch)
# tree		d5a2f971f6bc0ff20bbe09a708d20e3396dd7aaa
# parent	35b9d61ea910c1ebd4652b32cc7d713f6689b4f4 (diff)
# Linux 4.9.24 v4.9.24 linux-4.9.y

SRCREV ?= "2f5e58ec793f56f9ac1c6736b4638a4b81d6f099"

PATCHPATH="${THISDIR}/patch/4.9.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "\
           file://multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://${PATCHPATH}/patches;type=kmeta;destsuffix=patches \
                "

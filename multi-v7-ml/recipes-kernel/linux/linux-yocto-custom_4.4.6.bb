# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.4.y"

LINUX_VERSION = "4.4.6"


# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2016-03-16 15:43:17 (GMT)
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2016-03-16 15:43:17 (GMT)
# commit	0d1912303e54ed1b2a371be0bba51c384dd57326 (patch)
# tree		706c149c0f0d6865d14e6b18058826f9dfd49f24
# parent	f3f47e76d14820b150479d78ac8edad33a1e0c19 (diff)
# Linux 4.4.6 v4.4.6 linux-4.4.y

SRCREV ?= "0d1912303e54ed1b2a371be0bba51c384dd57326"

PATCHPATH="${THISDIR}/patch/4.4.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "\
           file://multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://${PATCHPATH}/patches;type=kmeta;destsuffix=patches \
                "


# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.9.y"

LINUX_VERSION = "4.9.44"

# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2017-08-16 13:44:13 -0700
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2017-08-16 13:44:13 -0700
# commit	a97a16f18c4895e41951a44d27af8af0b8f1d897 (patch)
# tree		4ef05033ff6c25ab1e1eae9b9df8d1da15f68841
# parent	eea1ec08f8a5f8ab57b66f47d2673089c9ebea69 (diff)
# download	linux-stable-a97a16f18c4895e41951a44d27af8af0b8f1d897.tar.gz
# Linux 4.9.44 v4.9.44 linux-4.9.y

SRCREV ?= "a97a16f18c4895e41951a44d27af8af0b8f1d897"

PATCHPATH="${THISDIR}/patch/4.9.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "\
           file://multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://${PATCHPATH}/patches;type=kmeta;destsuffix=patches \
                "

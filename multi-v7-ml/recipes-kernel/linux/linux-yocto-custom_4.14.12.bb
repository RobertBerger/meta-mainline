# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.14.y"

LINUX_VERSION = "4.14.12"

# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2018-01-05 15:48:59 +0100
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2018-01-05 15:48:59 +0100
# commit	8d577afdee3540808302d9dc7a0a7be96c91178f (patch)
# tree		cd310c3a190a1e792ffe26e239548c01a0e1fe5a
# parent	566fb9906ee25a697f4b694dd624398712adf00b (diff)
# download	linux-stable-8d577afdee3540808302d9dc7a0a7be96c91178f.tar.gz
# Linux 4.14.12 v4.14.12 linux-4.14.y

SRCREV ?= "8d577afdee3540808302d9dc7a0a7be96c91178f"

PATCHPATH="${THISDIR}/patch/4.14.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "\
           file://multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://${PATCHPATH}/patches;type=kmeta;destsuffix=patches \
                "

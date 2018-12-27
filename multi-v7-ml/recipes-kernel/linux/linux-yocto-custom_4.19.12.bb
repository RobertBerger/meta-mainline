# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.19.y"

LINUX_VERSION = "4.19.12"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2018-12-21 14:15:25 +0100
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2018-12-21 14:15:25 +0100
# commit	2a7cb228d29c3882c1414c10a44c5f3f59bfa44d (patch)
# tree		293d147b1b71cb97091c2448c963917b28ebf206
# parent	b4c7c826709b7d882ec9b264d5032e887e6bd720 (diff)
# download	linux-2a7cb228d29c3882c1414c10a44c5f3f59bfa44d.tar.gz
# Linux 4.19.12 v4.19.12 linux-4.19.y

SRCREV ?= "2a7cb228d29c3882c1414c10a44c5f3f59bfa44d"

PATCHPATH="${THISDIR}/patch/4.19.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "\
           file://multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://${PATCHPATH}/patches;type=kmeta;destsuffix=patches \
                "

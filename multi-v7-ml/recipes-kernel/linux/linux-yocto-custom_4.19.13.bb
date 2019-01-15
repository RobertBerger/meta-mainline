# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.19.y"

LINUX_VERSION = "4.19.13"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

# author        Greg Kroah-Hartman <gregkh@linuxfoundation.org> 2018-12-29 13:37:59 +0100
# committer     Greg Kroah-Hartman <gregkh@linuxfoundation.org> 2018-12-29 13:37:59 +0100
# commit        c04c050f5bf98845bfe22164b8a1503d696a6e26 (patch)
# tree          89318fa970dc27c17524fec161c6e53301057e86
# parent        7f3ebea19795eb38438cd3709fabf2afd53cf447 (diff)
# download      linux-c04c050f5bf98845bfe22164b8a1503d696a6e26.tar.gz
# Linux 4.19.13 v4.19.13 linux-4.19.y

SRCREV ?= "c04c050f5bf98845bfe22164b8a1503d696a6e26"

PATCHPATH="${THISDIR}/patch/4.19.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "\
           file://multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://${PATCHPATH}/patches;type=kmeta;destsuffix=patches \
                "

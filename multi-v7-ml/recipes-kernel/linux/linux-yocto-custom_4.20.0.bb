# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.20.y"

LINUX_VERSION = "4.20.0"

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

# author	Linus Torvalds <torvalds@linux-foundation.org>	2018-12-23 15:55:59 -0800
# committer	Linus Torvalds <torvalds@linux-foundation.org>	2018-12-23 15:55:59 -0800
# commit	8fe28cb58bcb235034b64cbbb7550a8a43fd88be (patch)
# tree		dcc1d8d3390639bc88323070d368024579f2154e
# parent	3c730b1041aefa2a92b96fcba9db237d28585922 (diff)
# download	linux-8fe28cb58bcb235034b64cbbb7550a8a43fd88be.tar.gz
# Linux 4.20 HEAD v4.20 master linux-4.20.y

SRCREV ?= "8fe28cb58bcb235034b64cbbb7550a8a43fd88be"

PATCHPATH="${THISDIR}/patch/4.20.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "\
           file://multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://${PATCHPATH}/patches;type=kmeta;destsuffix=patches \
                "

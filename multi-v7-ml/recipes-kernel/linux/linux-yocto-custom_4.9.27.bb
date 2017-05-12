# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.9.y"

LINUX_VERSION = "4.9.27"

# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2017-05-08 07:48:32 +0200
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2017-05-08 07:48:32 +0200
# commit	89f3b8d5f264d5dab9818c6667c71e3cc55b13f5 (patch)
# tree		ec69583e1b877de0ac3bc4287586dbc9531af414
# parent	a0d50c80a29e13a56f9830d0b4bc6e333fc09da2 (diff)
# download	linux-stable-89f3b8d5f264d5dab9818c6667c71e3cc55b13f5.tar.gz
# Linux 4.9.27 v4.9.27 linux-4.9.y

SRCREV ?= "89f3b8d5f264d5dab9818c6667c71e3cc55b13f5"

PATCHPATH="${THISDIR}/patch/4.9.x"

FILESEXTRAPATHS_prepend := "${PATCHPATH}:"

SRC_URI += "\
           file://multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://${PATCHPATH}/patches;type=kmeta;destsuffix=patches \
                "

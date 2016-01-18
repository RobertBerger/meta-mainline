# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-4.4.y"

LINUX_VERSION = "4.4"

# author	Linus Torvalds <torvalds@linux-foundation.org>	2016-01-10 23:01:32 (GMT)
# committer	Linus Torvalds <torvalds@linux-foundation.org>	2016-01-10 23:01:32 (GMT)
# commit	afd2ff9b7e1b367172f18ba7f693dfb62bdcb2dc (patch)
# tree		0cba53f59f487c0de2b1a0d9fb1b11ae27de96ec
# parent	eac6f76ac72c0a7e6f6d4f1640be751a526b5de2 (diff)
# Linux 4.4 HEAD v4.4 master linux-4.4.y

SRCREV ?= "afd2ff9b7e1b367172f18ba7f693dfb62bdcb2dc"

FILESEXTRAPATHS_prepend := "${THISDIR}/patch/4.4.x:"

SRC_URI += "\
           file://zedboard-multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://patches;type=kmeta;destsuffix=patches \
                "


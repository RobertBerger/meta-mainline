# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "master"

LINUX_VERSION = "4.4-rc5"

# author        Linus Torvalds <torvalds@linux-foundation.org>  2015-12-14 01:42:58 (GMT)
# committer     Linus Torvalds <torvalds@linux-foundation.org>  2015-12-14 01:42:58 (GMT)
# commit        9f9499ae8e6415cefc4fe0a96ad0e27864353c89 (patch)
# tree          79c89eb2e0d05f5be3140571cd79ba44606b165d
# parent        dfd01f026058a59a513f8a365b439a0681b803af (diff)
# Linux 4.4-rc5 HEAD v4.4-rc5 master

SRCREV ?= "9f9499ae8e6415cefc4fe0a96ad0e27864353c89"

FILESEXTRAPATHS_prepend := "${THISDIR}/patch/4.4.x:"

SRC_URI += "\
           file://multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://patches;type=kmeta;destsuffix=patches \
                "


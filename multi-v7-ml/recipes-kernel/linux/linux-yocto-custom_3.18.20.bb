# linux-yocto-custom_x.x.x.bb 
# attempt to have only kernel version related stuff in here

require recipes-kernel/linux/linux-yocto-custom.inc

KBRANCH = "linux-3.18.y"

LINUX_VERSION = "3.18.20"

# author        Sasha Levin <sasha.levin@oracle.com>    2015-08-07 19:08:04 (GMT)
# committer     Sasha Levin <sasha.levin@oracle.com>    2015-08-07 19:08:04 (GMT)
# commit        e9fd6ddcabf8695329f2462d3ece5a8442f2a8cf (patch)
# tree          37975237a92e235cebf9ebf0d79cee97630a4725
# parent        df0e5109cfea25f842bf99f567aac20ac9ef78fe (diff)
# Linux 3.18.20 v3.18.20

SRCREV ?= "e9fd6ddcabf8695329f2462d3ece5a8442f2a8cf"

FILESEXTRAPATHS_prepend := "${THISDIR}/patch/3.18.20-${KTYPE}:"

SRC_URI += "\
           file://multi-v7-ml-user-patches.scc \
           "
SRC_URI_append += " \
                file://patches;type=kmeta;destsuffix=patches \
                "

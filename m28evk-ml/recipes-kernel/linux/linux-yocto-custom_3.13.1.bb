# This file was derived from the linux-yocto-custom.bb recipe in
# oe-core.
#
# linux-yocto-custom.bb:
#
#   A yocto-bsp-generated kernel recipe that uses the linux-yocto and
#   oe-core kernel classes to apply a subset of yocto kernel
#   management to git managed kernel repositories.
#
# Warning:
#
#   Building this kernel without providing a defconfig or BSP
#   configuration will result in build or boot errors. This is not a
#   bug.
#
# Notes:
#
#   patches: patches can be merged into to the source git tree itself,
#            added via the SRC_URI, or controlled via a BSP
#            configuration.
#
#   example configuration addition:
#            SRC_URI += "file://smp.cfg"
#   example patch addition:
#            SRC_URI += "file://0001-linux-version-tweak.patch
#   example feature addition:
#            SRC_URI += "file://feature.scc"
#

inherit kernel
require recipes-kernel/linux/linux-yocto.inc

#SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=git;bareclone=1"
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;bareclone=1"

SRC_URI += "file://defconfig"

SRC_URI += "file://m28evk-ml.scc \
            file://m28evk-ml.cfg \
            file://m28evk-ml-user-config.cfg \
            file://m28evk-ml-user-patches.scc \
           "

KBRANCH = "linux-3.13.y"

LINUX_VERSION ?= "3.13.1"
LINUX_VERSION_EXTENSION ?= "-custom"

# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2014-01-29 13:06:37 (GMT)
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2014-01-29 13:06:37 (GMT)
# commit	07ecf16297bbec8d94012f2dd9d615f98093fbbe (patch)
# tree		3809c0d23e6859fe88c2548af5866e377e69e69c
# parent	e4e80e0bec9e03b6e323857e9bb2820f5bbe6287 (diff)
# Linux 3.13.1 v3.13.1 linux-3.13.y

SRCREV="07ecf16297bbec8d94012f2dd9d615f98093fbbe"

PR = "r0"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_m28evk-ml = "m28evk-ml"

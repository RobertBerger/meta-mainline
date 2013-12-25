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

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;bareclone=1"

SRC_URI += "file://defconfig"

SRC_URI += "file://beagle-xm-ml.scc \
            file://beagle-xm-ml.cfg \
            file://beagle-xm-ml-user-config.cfg \
            file://beagle-xm-ml-user-patches.scc \
           "

KBRANCH = "linux-3.12.y"

LINUX_VERSION ?= "3.12.5"
LINUX_VERSION_EXTENSION ?= "-custom"


# author	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2013-12-12 06:38:07 (GMT)
# committer	Greg Kroah-Hartman <gregkh@linuxfoundation.org>	2013-12-12 06:38:07 (GMT)
# commit	156c7581a8b9b7d9665c63f96e312093736c832e (patch)
# tree		f31d955511e4b344b29925c11e954540b7046244
# parent	012228e9c4841140fc6a3e5da6196b6550890f83 (diff)
# Linux 3.12.5 v3.12.5 linux-3.12.y

SRCREV="156c7581a8b9b7d9665c63f96e312093736c832e"

PR = "r0"
PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_beagle-xm-ml = "beagle-xm-ml"

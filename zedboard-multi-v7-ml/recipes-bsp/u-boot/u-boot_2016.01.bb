require u-boot-common.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"

PV = "v2016.01"

SRCREV = "fa85e826c16b9ce1ad302a57e9c4b24db0d8b930"

FILESEXTRAPATHS_prepend := "${THISDIR}/patch/2016.01:"

SRC_URI += "\
           file://zedboard/0001-QSPI-uEnv.txt-from-SD-card.patch \
           "

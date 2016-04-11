require u-boot-common.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"

PV = "v2016.03"

SRCREV = "df61a74e6845ec9bdcdd48d2aff5e9c2c6debeaa"

# u-boot patches
SRC_URI += "file://0001-am335x_evm-uEnv.txt-bootz-n-fixes.patch"

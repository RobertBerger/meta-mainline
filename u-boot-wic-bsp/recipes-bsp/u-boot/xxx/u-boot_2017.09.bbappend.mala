FILESEXTRAPATHS_prepend := "${THISDIR}/${PV}/${MACHINE}:"

# patches
# appends and += do not play well;)
SRC_URI_append_am335x-phytec-wega = " \
    file://0001-read-env-from-ext4.patch \
"

# this would be the hack for lava
# try to solve this on the lava end
# sample see 2017.06 dir beagle bone black
#SRC_URI_append_beagle-bone-black = " \
#        file://0001-read-env-from-ext4.patch \
#        file://0002-default-AUTOBOOT_PROMPT-for-LAVA.patch \
#        file://0003-SYS_PROMPT-LAVA-compatible.patch \
#"

SRC_URI_append_beagle-bone-black = " \
    file://0001-read-env-from-ext4.patch \
"

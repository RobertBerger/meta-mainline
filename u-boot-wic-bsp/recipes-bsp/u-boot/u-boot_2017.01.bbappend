FILESEXTRAPATHS_prepend := "${THISDIR}/${MACHINE}:"

# patches
SRC_URI_am335x-phytec-wega += " \
    file://0001-read-env-from-ext4.patch \
"

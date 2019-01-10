# U-Boot version specific patches for all machines:

FILESEXTRAPATHS_prepend := "${THISDIR}/${PV}:"

# In case you want to create something with mkimage this restores
# backwards compatibility, which was broken in U-Boot 2018.11

SRC_URI_append = "\
     file://0001-New-item-at-list-end-for-backwards-compatibility.patch \
"

# This include file sets up the ml config fragments, these
# fragments build on top of the base config infrastructure provided in
# the linux-yocto/kernel-yocto recipes and classes in core layer of OE.

FILESEXTRAPATHS_prepend := "${THISDIR}/config:"

SRC_URI_append += " \
                file://zedboard-multi-v7-ml-base;type=kmeta;destsuffix=zedboard-multi-v7-ml-base \
                "


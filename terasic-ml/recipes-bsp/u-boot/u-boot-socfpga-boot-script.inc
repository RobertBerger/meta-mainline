###########################################################
# Additional boot script recepie
###########################################################
# Source for script
SRC_URI += "file://aux-boot-script.txt"

# Destination to be used by Build system
UBOOT_ENV = "u-boot"
UBOOT_ENV_SUFFIX = "scr"
###########################################################

###########################################################
# Additional tasks to be performed
###########################################################
do_compile_append () {
    ${S}/tools/mkimage \
    -A arm -O linux -T script -C none -a 0 -e 0 -n "SocKit AUX Boot script" \
    -d ${WORKDIR}/aux-boot-script.txt \
    ${WORKDIR}/${UBOOT_ENV}.${UBOOT_ENV_SUFFIX}

#    /development/tools/altera/15.0/embedded/host_tools/altera/mkpimage/mkpimage --header-version 0 -o preloader-mkpimage.bin ${S}/spl/u-boot-spl.bin ${S}/spl/u-boot-spl.bin ${S}/spl/u-boot-spl.bin ${S}/spl/u-boot-spl.bin
}


#! /bin/sh

export LC_ALL=C

if [ $# -ne 6 ]; then
        echo "Usage: $0 <boot_part> <kernel_file> <fdt> <rootfs_part> <rootfs_file.tar.bz2> <kernel_modules_file.tar.gz>"
        exit 1;
fi

# Here the right number of arguments have been passed

# Let's see if the boot_part exists
BOOT_PART=$1

if [ -d ${BOOT_PART} ]; then
    echo "${BOOT_PART} exists"
    echo "press <ENTER> to go on"
    read r
else
    echo "${BOOT_PART} does not exist"
    echo "is this partition mounted?"
    exit
fi

# cp MLO, u-boot and uEnv.txt

MLO="MLO-panda-ml"

if [ -f ${MLO} ]; then
    echo "${MLO} exists - I'll cp it to ${BOOT_PART}/MLO"
    echo "press <ENTER> to go on"
    read r
else
    echo "${MLO} does not exist"
    exit
fi

echo "+ cp ${MLO} ${BOOT_PART}/MLO"
cp ${MLO} ${BOOT_PART}/MLO

U_BOOT="u-boot-panda-ml.img"

if [ -f ${U_BOOT} ]; then
    echo "${U_BOOT} exists - I'll cp it to ${BOOT_PART}/u-boot.img"
    echo "press <ENTER> to go on"
    read r
else
    echo "${U_BOOT} does not exist"
    exit
fi

echo "+ cp ${U_BOOT} ${BOOT_PART}/u-boot.img"
cp ${U_BOOT} ${BOOT_PART}/u-boot.img

# uEnv.txt
echo "+ cp uEnv-panda.txt ${BOOT_PART}/uEnv.txt"
cp uEnv-panda.txt ${BOOT_PART}/uEnv.txt

# Let's see if the boot_part exists
ROOTFS_PART=$4

if [ -d ${ROOTFS_PART} ]; then
    echo "${ROOTFS_PART} exists"
    echo "press <ENTER> to go on"
    read r
else
    echo "${ROOTFS_PART} does not exist"
    echo "is this partition mounted?"
    exit
fi

# we need to pass the name of the rootfs file
ROOTFS_FILE=$5

if [ -f ${ROOTFS_FILE} ]; then
    echo "${ROOTFS_FILE} exists - I'll unpack it to ${ROOTFS_PART}"
    echo "needs to be .tar.bz2!"
    echo "press <ENTER> to go on"
    read r
else
    echo "${ROOTFS_FILE} does not exist"
    exit
fi

echo "+ sudo tar xjvf ${ROOTFS_FILE} -C ${ROOTFS_PART}"
sudo tar xjvf ${ROOTFS_FILE} -C ${ROOTFS_PART}

# we need to pass the name of the rootfs file
KERNEL_MODULES_FILE=$6

if [ -f ${KERNEL_MODULES_FILE} ]; then
    echo "${KERNEL_MODULES_FILE} exists - I'll unpack it to ${ROOTFS_PART}"
    echo "needs to be .tar.gz!"
    echo "press <ENTER> to go on"
    read r
else
    echo "${KERNEL_MODULES_FILE} does not exist"
    exit
fi

echo "+ sudo tar xvf ${KERNEL_MODULES_FILE} -C ${ROOTFS_PART}"
sudo tar xvf ${KERNEL_MODULES_FILE} -C ${ROOTFS_PART}

# we need to pass the name of the kernel file
KERNEL=$2

if [ -f ${KERNEL} ]; then
    echo "${KERNEL} exists - I'll cp it to ${ROOTFS_PART}/boot"
    echo "press <ENTER> to go on"
    read r
else
    echo "${KERNEL} does not exist"
    exit
fi

echo "+ cp ${KERNEL} ${ROOTFS_PART}/boot"
sudo cp ${KERNEL} ${ROOTFS_PART}/boot

# we need to pass the name of the fdt file
FDT=$3

if [ -f ${FDT} ]; then
    echo "${FDT} exists - I'll cp it to ${ROOTFS_PART}/boot"
    echo "press <ENTER> to go on"
    read r
else
    echo "${FDT} does not exist"
    exit
fi

echo "+ cp ${FDT} ${ROOTFS_PART}/boot"
sudo cp ${FDT} ${ROOTFS_PART}/boot

echo "+sync"
sync

echo "+ ls -la ${BOOT_PART}"
ls -la ${BOOT_PART}

echo "+ ls -la ${ROOTFS_PART}"
ls -la ${ROOTFS_PART}

echo "issue this command to umount the paritions:"
echo "umount ${BOOT_PART} ${ROOTFS_PART}"

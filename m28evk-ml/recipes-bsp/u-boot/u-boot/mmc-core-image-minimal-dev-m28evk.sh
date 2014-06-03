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

# we need to pass the name of the kernel file
KERNEL=$2

if [ -f ${KERNEL} ]; then
    echo "${KERNEL} exists - I'll cp it to ${BOOT_PART}"
    echo "press <ENTER> to go on"
    read r
else
    echo "${KERNEL} does not exist"
    exit
fi

echo "+ cp ${KERNEL} ${BOOT_PART}"
cp ${KERNEL} ${BOOT_PART}

# we need to pass the name of the fdt file
FDT=$3

if [ -f ${FDT} ]; then
    echo "${FDT} exists - I'll cp it to ${BOOT_PART}"
    echo "press <ENTER> to go on"
    read r
else
    echo "${FDT} does not exist"
    exit
fi

echo "+ cp ${FDT} ${BOOT_PART}"
cp ${FDT} ${BOOT_PART}

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

# uEnv.txt (where should this be?)
echo "+ cp mmc-uEnv-m28evk.txt ${BOOT_PART}/uEnv.txt"
cp mmc-uEnv-m28evk.txt ${BOOT_PART}/uEnv.txt

echo "+sync"
sync

echo "+ ls -la ${BOOT_PART}"
ls -la ${BOOT_PART}

echo "+ ls -la ${ROOTFS_PART}"
ls -la ${ROOTFS_PART}

echo "issue this command to umount the paritions:"
echo "umount ${BOOT_PART} ${ROOTFS_PART}"

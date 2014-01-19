#! /bin/sh
# mkcard.sh v0.5
# History: 
#         2013-08-27 Marek reviewed and removed seek in dd
#         2013-08-18 m28evk from tftp/nfs (just boot partition necessary)
#                    adjusted sfdisk command 
#                    for Freescale boards we need to dd the boot partition
#         2012-01-12 adjusted for Beagle-XM training (3 partitions)
#         2011-03-21 used sudo fdisk and sudo umount -f
# (c) Copyright 2012 Robert Berger <robert.berger@reliableembeddedsystems.com>
# (c) Copyright 2009 Graeme Gregory <dp@xora.org.uk>
# Licensed under terms of GPLv2
#
# Parts of the procudure base on the work of Denys Dmytriyenko
# http://wiki.omap.com/index.php/MMC_Boot_Format

export LC_ALL=C

if [ $# -ne 2 ]; then
        echo "+ Usage: $0 <drive> <full path to u-boot.sd>"
        exit 1;
fi

DRIVE=$1

# we need to pass as a second argoment u-boot.sd with it's full patch
U_BOOT_SD=$2

if [ -f ${U_BOOT_SD} ]; then
    echo "+ ${U_BOOT_SD} exists - I'll dd it to ${DRIVE}"
    echo "+ press <ENTER> to go on"
    read r
else
    echo "+ ${U_BOOT_SD} does not exist"
    exit
fi

# Erase microSD/SD card:
echo "+ sudo dd if=/dev/zero of=$DRIVE bs=1024 count=1024"
sudo dd if=/dev/zero of=$DRIVE bs=1024 count=1024

# Install Bootloader:
echo "+ sudo dd if=${U_BOOT_SD} of=${DRIVE} bs=512 seek=2"
sudo dd if=${U_BOOT_SD} of=${DRIVE} bs=512 seek=2

echo "+ sync"
sync

echo "+ # 0xE --> \"Win95 FAT16 (LBA)\""
echo "+ {"
echo "+ echo 1,48,0xE,*"
echo "+ echo ,,,-"
echo "+ } | sudo sfdisk --in-order --Linux --unit M ${DRIVE}"

# 0xE --> "Win95 FAT16 (LBA)"
{
echo 1,48,0xE,*
echo ,,,-
} | sudo sfdisk --in-order --Linux --unit M ${DRIVE}

echo "+ sync"
sync

if [ -b ${DRIVE}1 ]; then
        echo "+ sudo umount -f ${DRIVE}1"
        sudo umount -f ${DRIVE}1
        echo "+ sudo mkfs.vfat -F 16 -n "boot" ${DRIVE}1"
        sudo mkfs.vfat -F 16 -n "boot" ${DRIVE}1
else
        if [ -b ${DRIVE}p1 ]; then
		echo "+ sudo umount -f ${DRIVE}p1"
                sudo umount -f ${DRIVE}p1
                echo "+ sudo mkfs.vfat -F 16 -n "boot" ${DRIVE}p1"
                sudo mkfs.vfat -F 16 -n "boot" ${DRIVE}p1
        else
                echo "+ Cant find boot partition in /dev"
        fi
fi

if [ -b ${DRIVE}2 ]; then
	echo "+ sudo umount -f ${DRIVE}2"
        sudo umount -f ${DRIVE}2
        echo "+ sudo mkfs.ext3 -L "rootfs" ${DRIVE}2"
        sudo mkfs.ext3 -L "rootfs" ${DRIVE}2
else
        if [ -b ${DRIVE}p2 ]; then
		echo "+ sudo umount -f ${DRIVE}p2"
                sudo umount -f ${DRIVE}p2
                echo "+ sudo mkfs.ext3 -L "rootfs" ${DRIVE}p2"
                sudo mkfs.ext3 -L "rootfs" ${DRIVE}p2
        else
                echo "+ Cant find rootfs partition in /dev"
        fi
fi

# currently we would not even need the second partition
# .in any case we'll not create a third one

#if [ -b ${DRIVE}3 ]; then
#        sudo umount -f ${DRIVE}3
#        sudo mke2fs -j -L "eldk-rootfs" ${DRIVE}3
#else
#        if [ -b ${DRIVE}p3 ]; then
#                sudo umount -f ${DRIVE}p3
#                sudo mke2fs -j -L "eldk-rootfs" ${DRIVE}p3
#        else
#                echo "Cant find rootfs partition in /dev"
#        fi
#fi



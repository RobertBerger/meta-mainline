#! /bin/sh
# mkcard.sh v0.5
# History: 
#         2013-08-18 beagle-xm from tftp/nfs (just boot partition necessary)
#                    adjusted sfdisk command - hoping no more complaints from kernel
#         2012-01-12 adjusted for Beagle-XM training (3 partitions)
#         2011-03-21 used sudo fdisk and sudo umount -f
# (c) Copyright 2012 Robert Berger <robert.berger@reliableembeddedsystems.com>
# (c) Copyright 2009 Graeme Gregory <dp@xora.org.uk>
# Licensed under terms of GPLv2
#
# Parts of the procudure base on the work of Denys Dmytriyenko
# http://wiki.omap.com/index.php/MMC_Boot_Format

export LC_ALL=C

if [ $# -ne 1 ]; then
        echo "Usage: $0 <drive>"
        exit 1;
fi

DRIVE=$1

sudo dd if=/dev/zero of=$DRIVE bs=1024 count=1024

# --> this is just here for fun

SIZE=`sudo fdisk -l $DRIVE | grep Disk | grep bytes | awk '{print $5}'`

echo DISK SIZE - $SIZE bytes

CYLINDERS=`echo $SIZE/255/63/512 | bc`

echo CYLINDERS - $CYLINDERS

# <-- this is just here for fun

# 0xE --> "Win95 FAT16 (LBA)"

{
echo 1,48,0xE,*
echo ,,,-
} | sudo sfdisk --in-order --Linux --unit M ${DRIVE}

# what I used so far:
# sudo sfdisk -D -H 255 -S 63 -C $CYLINDERS $DRIVE

sleep 1

if [ -b ${DRIVE}1 ]; then
        sudo umount -f ${DRIVE}1
        sudo mkfs.vfat -F 16 -n "boot" ${DRIVE}1
else
        if [ -b ${DRIVE}p1 ]; then
                sudo umount -f ${DRIVE}p1
                sudo mkfs.vfat -F 16 -n "boot" ${DRIVE}p1
        else
                echo "Cant find boot partition in /dev"
        fi
fi

if [ -b ${DRIVE}2 ]; then
        sudo umount -f ${DRIVE}2
        sudo mkfs.ext3 -L "rootfs" ${DRIVE}2
else
        if [ -b ${DRIVE}p3 ]; then
                sudo umount -f ${DRIVE}p2
                sudo mkfs.ext4 -L "rootfs" ${DRIVE}p2
        else
                echo "Cant find rootfs partition in /dev"
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
echo "+ sync"
sync 

echo "+ sudo fdisk -l ${DRIVE}"
sudo fdisk -l ${DRIVE}

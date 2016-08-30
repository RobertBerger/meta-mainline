#! /bin/sh
# mkcard.sh v0.6
# History: 
#         2016-06-21 mira support
#         2014-01-13 wandboard support
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

if [ $# -ne 3 ]; then
        echo "+ Usage: $0 <drive> <full path to SPL> <full path to u-boot.img>"
        exit 1;
fi

DRIVE=$1

# we need to pass as a second argoment SPL with it's full patch
SPL=$2

if [ -f ${SPL} ]; then
    echo "+ ${SPL} exists - I'll dd it to ${DRIVE}"
    echo "+ press <ENTER> to go on"
    read r
else
    echo "+ ${SPL} does not exist"
    exit
fi

# Erase microSD/SD card:
set -x
sudo dd if=/dev/zero of=${DRIVE} bs=1M count=16
set +x

# Install SPL:
set -x
sudo dd if=${SPL} of=${DRIVE} seek=1 bs=1k
set +x

echo "+ sync"
sync

# we need to pass as a third argoment u-boot.img with it's full patch
#U_BOOT=$3

#if [ -f ${U_BOOT} ]; then
#    echo "+ ${U_BOOT} exists - I'll dd it to ${DRIVE}"
#    echo "+ press <ENTER> to go on"
#    read r
#else
#    echo "+ ${U_BOOT} does not exist"
#    exit
#fi

# Install u-boot.img:
#set -x
#sudo dd if=${U_BOOT} of=${DRIVE} seek=69 bs=1k
#set +x
#
#echo "+ sync"
#sync


# partitioning/formatting

echo "+ {"
echo "+ 1,,L,*"
echo "+ } | sudo sfdisk --in-order --Linux --unit M ${DRIVE}"
#echo "+ } | sudo sfdisk --unit M ${DRIVE}"

{
echo 1,,L,*
} | sudo sfdisk --in-order --Linux --unit M ${DRIVE}

#} | sudo sfdisk --unit M ${DRIVE}

echo "+ sync"
sync

echo "+ press <ENTER> to go on"
read r

if [ -b ${DRIVE}1 ]; then
        echo "+ sudo umount -f ${DRIVE}1"
        sudo umount -f ${DRIVE}1
        echo "+ sudo mkfs.ext4 -L "mira-rootfs" ${DRIVE}1"
        sudo mkfs.ext4 -L "mira-rootfs" ${DRIVE}1
else
        if [ -b ${DRIVE}p1 ]; then
                echo "+ sudo umount -f ${DRIVE}p1"
                sudo umount -f ${DRIVE}p1
                echo "+ sudo mkfs.ext4 -L "mira-rootfs" ${DRIVE}p1"
                sudo mkfs.ext4 -L "mira-rootfs" ${DRIVE}p1
        else
                echo "+ Cant find rootfs partition in /dev"
        fi
fi

echo "+ sync"
sync


echo "+ sudo fdisk -l ${DRIVE}"
sudo fdisk -l ${DRIVE}


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

# we need to pass as a third argoment u-boot.img with it's full patch
U_BOOT=$3

if [ -f ${U_BOOT} ]; then
    sudo mkdir /tmp/mnttmp
    if [ -b ${DRIVE}1 ]; then
      echo "+ ${U_BOOT} exists - I'll cp it to ${DRIVE}1"
      sudo mount ${DRIVE}1 /tmp/mnttmp
    fi
    if [ -b ${DRIVE}p1 ]; then
      echo "+ ${U_BOOT} exists - I'll cp it to ${DRIVE}p1"
      sudo mount ${DRIVE}p1 /tmp/mnttmp      
    fi
    echo "+ press <ENTER> to go on"
    read r
else
    echo "+ ${U_BOOT} does not exist"
    exit
fi

# Install u-boot.img:
set -x
sudo cp ${U_BOOT} /tmp/mnttmp
sudo ls /tmp/mnttmp
sudo umount /tmp/mnttmp 
sudo rm -rf /tmp/mnttmp
set +x

echo "+ sync"
sync

echo "+ sudo fdisk -l ${DRIVE}"
sudo fdisk -l ${DRIVE}



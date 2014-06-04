== Unmount your SD card ==

e.g.:
umount /media/*

== partition/format card ==

e.g.:
./mkcard-beagle-bone-white.sh /dev/sdb 

=== check if this worked ===

e.g..:
sudo fdisk -l /dev/sdb

== populate card ==

unplug/plug card to mount it or mount it

./mmc-core-image-minimal-dev-beagle-bone-white.sh <boot_part> <kernel_file> <fdt> <rootfs_part> <rootfs_file.tar.bz2> <kernel_modules_file.tar.gz>

e.g.:
./mmc-core-image-minimal-dev-beagle-bone-white.sh /media/boot uImage-beagle-bone-white-ml.bin uImage-am335x-bone.dtb /media/rootfs core-image-minimal-dev-beagle-bone-white-ml.tar.bz2 modules-beagle-bone-white-ml.tgz

== unmout SD card ==

e.g.:
umount /media/boot /media/rootfs

== try it ==
plug the card and boot!

now we could try over tftp and nfs:

you need to create a nfs export of the rootfs
e.g.
/opt/poky/1.6/core-image-sato-sdk-beagle-bone-white-ml

and a tftp export
e.g.
/tftboot/beagle-bone-white

mine looks like this:


student@bb-white-dev:/tftpboot/beagle-bone-white$ ls -lah
total 3.7M
drwxrwxr-x 2 student student 4.0K Jun  2 23:06 .
drwxrwxrwx 4 root    nogroup 4.0K Jun  2 22:56 ..
-rw-rw-r-- 1 student student 1.8K Jun  2 23:06 tftp-nfs-uEnv-beagle-bone-white.txt
lrwxrwxrwx 1 student student   73 Jun  2 23:04 uImage -> uImage--3.14.4+git0+7261684765-r0-beagle-bone-white-ml-20140601185103.bin
-rw-r--r-- 1 student student  30K Jun  2 23:01 uImage--3.14.4+git0+7261684765-r0-am335x-bone-20140601185103.dtb
-rw-r--r-- 1 student student 3.7M Jun  2 23:02 uImage--3.14.4+git0+7261684765-r0-beagle-bone-white-ml-20140601185103.bin
lrwxrwxrwx 1 student student   64 Jun  2 23:05 uImage-am335x-bone.dtb -> uImage--3.14.4+git0+7261684765-r0-am335x-bone-20140601185103.dtb

also you will need to adjust a few things in tftp-nfs-uEnv-beagle-bone-white.txt:

e.g.

ipaddr=192.168.2.240
serverip=192.168.2.226
gatewayip=192.168.2.1
netmask=255.255.255.0
usbethaddr=0:0:1:2:3:f0

and:

nfsroot=/opt/poky/1.6/core-image-sato-sdk-beagle-bone-white-ml

now we need to replace uEnv.txt with the new one

e.g.
mount /mnt/boot
cp /mnt/boot/uEnv.txt /mnt/beag1/mmc-uEnv-beagle-bone-white.txt
cp tftp-nfs-uEnv-beagle-bone-white.txt /mnt/boot/uEnv.txt
umount /mnt/boot

plug the SD card into the board and give it a try

assuming the board is accessible via network you could scp the stuff as well



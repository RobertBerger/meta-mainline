== Unmount your SD card ==

e.g.:
umount /media/*

== partition/format card ==

e.g.:
./mkcard-panda.sh /dev/sdb 

=== check if this worked ===

e.g..:
sudo fdisk -l /dev/sdb

== populate card ==

unplug/plug card to mount it or mount it

./mmc-core-image-minimal-dev-panda.sh <boot_part> <kernel_file> <fdt> <rootfs_part> <rootfs_file.tar.bz2> <kernel_modules_file.tar.gz>

e.g.:
./mmc-core-image-minimal-dev-panda.sh /media/boot uImage-panda-ml.bin uImage-omap4-panda.dtb /media/rootfs core-image-minimal-dev-panda-ml.tar.bz2 modules-panda-ml.tgz

== unmout SD card ==

e.g.:
umount /media/boot /media/rootfs

== try it ==
plug the card and boot!

now we could try over tftp and nfs:

you need to create a nfs export of the rootfs
e.g.
/opt/poky/1.6/core-image-sato-sdk-panda-ml

and a tftp export
e.g.
/tftboot/panda

mine looks like this:

student4@bh4:/tftpboot/panda$ ls -lah
total 4.5M
drwxrwxr-x 2 student4 student4 4.0K Jun  5 12:06 .
drwxrwxrwx 7 root     nogroup  4.0K Jun  5 12:04 ..
lrwxrwxrwx 1 student4 student4   61 Jun  5 12:06 uImage -> uImage--3.14.4+git0+7261684765-r0-panda-ml-20140605002206.bin
-rw-r--r-- 1 student4 student4  53K Jun  5 12:06 uImage--3.14.4+git0+7261684765-r0-omap4-panda-20140605002206.dtb
-rw-r--r-- 1 student4 student4 4.5M Jun  5 12:05 uImage--3.14.4+git0+7261684765-r0-panda-ml-20140605002206.bin
lrwxrwxrwx 1 student4 student4   64 Jun  5 12:06 uImage-omap4-panda.dtb -> uImage--3.14.4+git0+7261684765-r0-omap4-panda-20140605002206.dtb

also you will need to adjust a few things in tftp-nfs-uEnv-panda.txt:

e.g.

ipaddr=192.168.2.240
serverip=192.168.2.226
gatewayip=192.168.2.1
netmask=255.255.255.0
usbethaddr=0:0:1:2:3:f0

and:

nfsroot=/opt/poky/1.6/core-image-sato-sdk-panda-ml

now we need to replace uEnv.txt with the new one

e.g.
mount /mnt/boot
cp /mnt/boot/uEnv.txt /mnt/boot/mmc-uEnv-panda.txt
cp tftp-nfs-uEnv-panda.txt /mnt/boot/uEnv.txt
umount /mnt/boot

plug the SD card into the board and give it a try

assuming the board is accessible via network you could scp the stuff as well



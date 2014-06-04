== Unmount your SD card ==

e.g.:
umount /media/*

== partition/format card ==

e.g.:
./mkcard-igepv2.sh /dev/sdb 

=== check if this worked ===

e.g..:
sudo fdisk -l /dev/sdb

== populate card ==

unplug/plug card to mount it or mount it

./mmc-core-image-minimal-dev-igepv2.sh <boot_part> <kernel_file> <fdt> <rootfs_part> <rootfs_file.tar.bz2> <kernel_modules_file.tar.gz>

e.g.:
./mmc-core-image-minimal-dev-igepv2.sh /media/boot uImage-igepv2-ml.bin uImage-omap3-igep0020.dtb /media/rootfs core-image-minimal-dev-igepv2-ml.tar.bz2 modules-igepv2-ml.tgz

== unmout SD card ==

e.g.:
umount /media/boot /media/rootfs

== try it ==
plug the card and boot!

now we could try over tftp and nfs:

you need to create a nfs export of the rootfs
e.g.
/opt/poky/1.6/core-image-sato-sdk-igepv2-ml

and a tftp export
e.g.
/tftboot/igepv2

mine looks like this:

student4@bh4:/tftpboot/igepv2$ ls -lah
total 4.4M
drwxrwxr-x 2 student4 student4 4.0K Jun  4 19:27 .
drwxrwxrwx 4 root     nogroup  4.0K Jun  4 19:08 ..
lrwxrwxrwx 1 student4 student4   62 Jun  4 19:25 uImage -> uImage--3.14.4+git0+7261684765-r0-igepv2-ml-20140602132457.bin
-rw-r--r-- 1 student4 student4 4.3M Jun  4 19:25 uImage--3.14.4+git0+7261684765-r0-igepv2-ml-20140602132457.bin
-rw-r--r-- 1 student4 student4  62K Jun  4 19:25 uImage--3.14.4+git0+7261684765-r0-omap3-igep0020-20140602132457.dtb
lrwxrwxrwx 1 student4 student4   67 Jun  4 19:27 uImage-omap3-igep0020.dtb -> uImage--3.14.4+git0+7261684765-r0-omap3-igep0020-20140602132457.dtb

also you will need to adjust a few things in tftp-nfs-uEnv-igepv2.txt:

e.g.

ipaddr=192.168.2.240
serverip=192.168.2.226
gatewayip=192.168.2.1
netmask=255.255.255.0
usbethaddr=0:0:1:2:3:f0

and:

nfsroot=/opt/poky/1.6/core-image-sato-sdk-igepv2-ml

now we need to replace uEnv.txt with the new one

e.g.
mount /mnt/boot
cp /mnt/boot/uEnv.txt /mnt/boot/mmc-uEnv-igepv2.txt
cp tftp-nfs-uEnv-igepv2.txt /mnt/boot/uEnv.txt
umount /mnt/boot

plug the SD card into the board and give it a try

assuming the board is accessible via network you could scp the stuff as well

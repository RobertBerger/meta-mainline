== Unmount your SD card ==

e.g.:
umount /media/*

== partition/format card ==

e.g.:
./mkcard-wandboard.sh /dev/sdb u-boot-wandboard-q-ml.imx

=== check if this worked ===

e.g..:
sudo fdisk -l /dev/sdb

== populate card ==

unplug/plug card to mount it or mount it

./mmc-core-image-minimal-dev-wandboard.sh <boot_part> <kernel_file> <fdt> <rootfs_part> <rootfs_file.tar.bz2> <kernel_modules_file.tar.gz>

e.g.:
./mmc-core-image-minimal-dev-wandboard.sh /media/boot uImage-wandboard-q-ml.bin uImage-imx6q-wandboard.dtb /media/rootfs core-image-minimal-dev-wandboard-q-ml.tar.bz2 modules-wandboard-q-ml.tgz

== unmout SD card ==

e.g.:
umount /media/boot /media/rootfs

== try it ==
plug the card and boot!

now we could try over tftp and nfs:

you need to create a nfs export of the rootfs
e.g.
/opt/poky/1.6/core-image-sato-sdk-wandboard-q-ml

and a tftp export
e.g.
/tftboot/wandboard-q

mine looks like this:

student4@bh4:/tftpboot/wandboard-q$ ls -lah
total 4.5M
drwxrwxr-x 2 student4 student4 4.0K Jun  5 10:37 .
drwxrwxrwx 6 root     nogroup  4.0K Jun  5 10:36 ..
lrwxrwxrwx 1 student4 student4   67 Jun  5 10:37 uImage -> uImage--3.14.4+git0+7261684765-r0-wandboard-q-ml-20140604222707.bin
-rw-r--r-- 1 student4 student4  27K Jun  5 10:37 uImage--3.14.4+git0+7261684765-r0-imx6q-wandboard-20140604222707.dtb
-rw-r--r-- 1 student4 student4 4.5M Jun  5 10:36 uImage--3.14.4+git0+7261684765-r0-wandboard-q-ml-20140604222707.bin
lrwxrwxrwx 1 student4 student4   68 Jun  5 10:37 uImage-imx6q-wandboard.dtb -> uImage--3.14.4+git0+7261684765-r0-imx6q-wandboard-20140604222707.dtb

also you will need to adjust a few things in tftp-nfs-uEnv-wandboard.txt:

e.g.

ipaddr=192.168.2.240
serverip=192.168.2.226
gatewayip=192.168.2.1
netmask=255.255.255.0
usbethaddr=0:0:1:2:3:f0

and:

nfsroot=/opt/poky/1.6/core-image-sato-sdk-wandboard-q-ml

now we need to replace uEnv.txt with the new one

e.g.
mount /mnt/boot
cp /mnt/boot/uEnv.txt /mnt/boot/mmc-uEnv-wandboard.txt
cp tftp-nfs-uEnv-wandboard.txt /mnt/boot/uEnv.txt
umount /mnt/boot

plug the SD card into the board and give it a try

assuming the board is accessible via network you could scp the stuff as well



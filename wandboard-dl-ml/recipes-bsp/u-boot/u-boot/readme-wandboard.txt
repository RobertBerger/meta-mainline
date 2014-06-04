== Unmount your SD card ==

e.g.:
umount /media/*

== partition/format card ==

e.g.:
./mkcard-wandboard.sh /dev/sdb u-boot-wandboard-dl-ml.imx

=== check if this worked ===

e.g..:
sudo fdisk -l /dev/sdb

== populate card ==

unplug/plug card to mount it or mount it

./mmc-core-image-minimal-dev-wandboard.sh <boot_part> <kernel_file> <fdt> <rootfs_part> <rootfs_file.tar.bz2> <kernel_modules_file.tar.gz>

e.g.:
./mmc-core-image-minimal-dev-wandboard.sh /media/boot uImage-wandboard-dl-ml.bin uImage-imx6dl-wandboard.dtb /media/rootfs core-image-minimal-dev-wandboard-dl-ml.tar.bz2 modules-wandboard-dl-ml.tgz

== unmout SD card ==

e.g.:
umount /media/boot /media/rootfs

== try it ==
plug the card and boot!

now we could try over tftp and nfs:

you need to create a nfs export of the rootfs
e.g.
/opt/poky/1.6/core-image-sato-sdk-wandboard-dl-ml

and a tftp export
e.g.
/tftboot/wandboard-dl

mine looks like this:

student4@bh4:/tftpboot/wandboard-dl$ ls -lah
total 4.4M
drwxrwxr-x 2 student4 student4 4.0K Jun  4 22:55 .
drwxrwxrwx 5 root     nogroup  4.0K Jun  4 22:52 ..
lrwxrwxrwx 1 student4 student4   68 Jun  4 22:55 uImage -> uImage--3.14.4+git0+7261684765-r0-wandboard-dl-ml-20140602192118.bin
-rw-r--r-- 1 student4 student4  26K Jun  4 22:54 uImage--3.14.4+git0+7261684765-r0-imx6dl-wandboard-20140602192118.dtb
-rw-r--r-- 1 student4 student4 4.3M Jun  4 22:53 uImage--3.14.4+git0+7261684765-r0-wandboard-dl-ml-20140602192118.bin
lrwxrwxrwx 1 student4 student4   69 Jun  4 22:54 uImage-imx6dl-wandboard.dtb -> uImage--3.14.4+git0+7261684765-r0-imx6dl-wandboard-20140602192118.dtb

also you will need to adjust a few things in tftp-nfs-uEnv-wandboard.txt:

e.g.

ipaddr=192.168.2.240
serverip=192.168.2.226
gatewayip=192.168.2.1
netmask=255.255.255.0
usbethaddr=0:0:1:2:3:f0

and:

nfsroot=/opt/poky/1.6/core-image-sato-sdk-wandboard-dl-ml

now we need to replace uEnv.txt with the new one

e.g.
mount /mnt/boot
cp /mnt/boot/uEnv.txt /mnt/boot/mmc-uEnv-wandboard.txt
cp tftp-nfs-uEnv-wandboard.txt /mnt/boot/uEnv.txt
umount /mnt/boot

plug the SD card into the board and give it a try

assuming the board is accessible via network you could scp the stuff as well



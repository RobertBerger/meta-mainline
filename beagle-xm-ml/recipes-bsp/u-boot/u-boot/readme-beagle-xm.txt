== Unmount your SD card ==

e.g.:
umount /media/*

== partition/format card ==

e.g.:
./mkcard-beagle-xm.sh /dev/sdb 

=== check if this worked ===

e.g..:
sudo fdisk -l /dev/sdb

== populate card ==

unplug/plug card to mount it or mount it 
or (if you have entries in fstab)
mount /mnt/beag1
mount /mnt/beag2

./mmc-core-image-minimal-dev-beagle-xm.sh <boot_part> <kernel_file> <fdt> <rootfs_part> <rootfs_file.tar.bz2> <kernel_modules_file.tar.gz>

e.g.:
./mmc-core-image-minimal-dev-beagle-xm.sh /media/boot uImage-beagle-xm-ml.bin uImage-omap3-beagle-xm-c.dtb /media/rootfs core-image-minimal-dev-beagle-xm-ml.tar.bz2 modules-beagle-xm-ml.tgz

or:
./mmc-core-image-minimal-dev-beagle-xm.sh /mnt/beag1 uImage-beagle-xm-ml.bin uImage-omap3-beagle-xm-c.dtb /mnt/beag2 core-image-minimal-dev-beagle-xm-ml.tar.bz2 modules-beagle-xm-ml.tgz

== unmout SD card ==

e.g.:
umount /media/boot /media/rootfs

or:
umount /mnt/beag1 /mnt/beag2

== try it ==
plug the card and boot!


now we could try over tftp and nfs:

you need to create a nfs export of the rootfs 
e.g.
/opt/poky/1.5.1/core-image-sato-sdk-beagle-xm-ml

and a tftp export
e.g.
/tftboot/beagle-xm

mine looks like this:

student@armv7a:/tftpboot/beagle-xm$ ls -lah
total 3.9M
drwxrwxr-x 2 student student 4.0K Feb 18 12:03 .
drwxrwxrwx 4 root    nogroup 4.0K Feb 18 11:59 ..
lrwxrwxrwx 1 student student   65 Feb 18 12:03 uImage -> uImage--3.13.2+git0+fd82174a69-r0-beagle-xm-ml-20140211155923.bin
-rw-r--r-- 1 student student 3.8M Feb 18 12:02 uImage--3.13.2+git0+fd82174a69-r0-beagle-xm-ml-20140211155923.bin
-rw-r--r-- 1 student student  18K Feb 18 12:02 uImage--3.13.2+git0+fd82174a69-r0-omap3-beagle-xm-ab-20140211155923.dtb
-rw-r--r-- 1 student student  18K Feb 18 12:02 uImage--3.13.2+git0+fd82174a69-r0-omap3-beagle-xm-c-20140211155923.dtb
lrwxrwxrwx 1 student student   70 Feb 18 12:03 uImage-omap3-beagle-xm.dtb -> uImage--3.13.2+git0+fd82174a69-r0-omap3-beagle-xm-c-20140211155923.dtb

also you will need to adjust a few things in tftp-nfs-uEnv-beagle-xm.txt:

e.g.

ipaddr=192.168.2.54
serverip=192.168.2.75
gatewayip=192.168.2.1
netmask=255.255.255.0
usbethaddr=0:0:1:2:3:54

and:

nfsroot=/opt/poky/1.5.1/core-image-sato-sdk-beagle-xm-ml


now we need to replace uEnv.txt with the new one

e.g.
mount /mnt/beag1
cp /mnt/beag1/uEnv.txt /mnt/beag1/mmc-uEnv-beagle-xm.txt
cp tftp-nfs-uEnv-beagle-xm.txt /mnt/beag1/uEnv.txt
umount /mnt/beag1

plug the SD card into the board and give it a try



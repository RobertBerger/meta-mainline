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

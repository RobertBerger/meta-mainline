== Unmount your SD card ==

e.g.:
umount /media/*

== partition/format card ==

e.g.:
./mkcard-wandboard.sh /dev/sdb u-boot-m28evk.sd

=== check if this worked ===

e.g..:
sudo fdisk -l /dev/sdb

== populate card ==

unplug/plug card to mount it or mount it

./mmc-core-image-minimal-dev-m28evk.sh <boot_part> <kernel_file> <fdt> <rootfs_part> <rootfs_file.tar.bz2> <kernel_modules_file.tar.gz>

e.g.:
./mmc-core-image-minimal-dev-m28evk.sh /media/boot uImage-m28evk-ml.bin uImage-imx28-m28evk.dtb /media/rootfs core-image-minimal-dev-m28evk-ml.tar.bz2 modules-m28evk-ml.tgz

== unmout SD card ==

e.g.:
umount /media/boot /media/rootfs

== try it ==
plug the card and boot!

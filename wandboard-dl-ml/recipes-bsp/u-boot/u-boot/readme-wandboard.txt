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

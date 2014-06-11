bitbake qemu-helper-native
bitbake meta-ide-support

something like this worked:
~/yocto-autobuilder/yocto-slave/custom-daisy-vexpress-a9-sato-sdk-new/build/meta-mainline/vexpress-a9-ml/scripts/runqemu core-image-minimal vexpressa9

genius@8fa4efeb5e9d:~/yocto-autobuilder/yocto-slave/custom-daisy-vexpress-a9-sato-sdk-new/build/build/tmp/deploy/images/vexpress-a9-ml> ~/yocto-autobuilder/yocto-slave/custom-daisy-vexpress-a9-sato-sdk-new/build/meta-mainline/vexpress-a9-ml/scripts/runqemu core-image-minimal vexpressa9
Assuming core-image-minimal really means /home/genius/yocto-autobuilder/yocto-slave/custom-daisy-vexpress-a9-sato-sdk-new/build/build/tmp/deploy/images/core-image-minimal-vexpressa9.tar.bz2

Continuing with the following parameters:
KERNEL: [/home/genius/yocto-autobuilder/yocto-slave/custom-daisy-vexpress-a9-sato-sdk-new/build/build/tmp/deploy/images/vexpressa9/zImage-vexpressa9.bin]
ROOTFS: [/home/genius/yocto-autobuilder/yocto-slave/custom-daisy-vexpress-a9-sato-sdk-new/build/build/tmp/deploy/images/vexpressa9/core-image-minimal-vexpressa9.tar.bz2]
FSTYPE: [tar.bz2]
Setting up tap interface under sudo
Acquiring lockfile for tap0...
No need to create image.
WARNING: distccd not present, no distcc support loaded.
Running qemu-system-arm...
/home/genius/yocto-autobuilder/yocto-slave/custom-daisy-vexpress-a9-sato-sdk-new/build/build/tmp/sysroots/x86_64-linux/usr/bin/qemu-system-arm -kernel /home/genius/yocto-autobuilder/yocto-slave/custom-daisy-vexpress-a9-sato-sdk-new/build/build/tmp/deploy/images/vexpressa9/zImage-vexpressa9.bin -net nic,vlan=0 -net tap,vlan=0,ifname=tap0,script=no,downscript=no -M vexpress-a9 -cpu cortex-a9 -sd /home/genius/yocto-autobuilder/yocto-slave/custom-daisy-vexpress-a9-sato-sdk-new/build/build/tmp/deploy/images/vexpressa9/core-image-minimal-vexpressa9.ext3 -no-reboot -m 1024 --append "root=/dev/mmcblk0 rw mem=1024M raid=noautodetect console=tty0 console=ttyAMA0,38400n8 rootwait vmalloc=256MB devtmpfs.mount=0 "
Set 'tap0' nonpersistent
Releasing lockfile of preconfigured tap device 'tap0'


--------

cd ~/test/yocto-autobuilder/yocto-worker/custom-dizzy-qemux86-core-image-minimal/build 

source oe-init-build-env

../scripts/runqemu qemux86 tmp/deploy/images/qemux86/core-image-minimal-qemux86.ext3 nographic

...

Starting syslogd/klogd: done

Poky (Yocto Project Reference Distro) 1.7 qemux86 /dev/ttyS0

qemux86 login: root
root@qemux86:~# cat /proc/cmdline 
vga=0 uvesafb.mode_option=640x480-32 root=/dev/hda rw mem=256M ip=192.168.7.2::192.168.7.1:255.255.255.0 oprofile.timer=1  console=ttyS0
root@qemux86:~# cat /proc/version
Linux version 3.14.19-yocto-standard (genius@3937966be1b5) (gcc version 4.9.1 (GCC) ) #1 SMP PREEMPT Sat Nov 22 19:28:12 UTC 2014
root@qemux86:~# 


--------

ssh -X server

ssh -X genius@

xterm &

cd ~/test/yocto-autobuilder/yocto-worker/custom-dizzy-qemux86-core-image-minimal/build

source oe-init-build-env

bitbake -v -c testimage core-image-minimal

--------

from xterm:

this does not seem to work:

../scripts/runqemu qemux86 tmp/deploy/images/qemux86/core-image-minimal-qemux86.ext3

Continuing with the following parameters:
KERNEL: [/home/genius/test/yocto-autobuilder/yocto-worker/custom-dizzy-qemux86-core-image-minimal/build/build/tmp/deploy/images/qemux86/bzImage-qemux86.bin]
ROOTFS: [/home/genius/test/yocto-autobuilder/yocto-worker/custom-dizzy-qemux86-core-image-minimal/build/build/tmp/deploy/images/qemux86/core-image-minimal-qemux86-20141123123837.rootfs.ext3]
FSTYPE: [ext3]
Acquiring lockfile for tap0...
Using preconfigured tap device 'tap0'
If this is not intended, touch /tmp/qemu-tap-locks/tap0.skip to make runqemu skip tap0.
Running qemu-system-i386...
/home/genius/test/yocto-autobuilder/yocto-worker/custom-dizzy-qemux86-core-image-minimal/build/build/tmp/sysroots/x86_64-linux/usr/bin/qemu-system-i386 -kernel /home/genius/test/yocto-autobuilder/yocto-worker/custom-dizzy-qemux86-core-image-minimal/build/build/tmp/deploy/images/qemux86/bzImage-qemux86.bin -net nic,vlan=0 -net tap,vlan=0,ifname=tap0,script=no,downscript=no -cpu qemu32 -hda /home/genius/test/yocto-autobuilder/yocto-worker/custom-dizzy-qemux86-core-image-minimal/build/build/tmp/deploy/images/qemux86/core-image-minimal-qemux86-20141123123837.rootfs.ext3 -show-cursor -usb -usbdevice wacom-tablet -vga vmware -no-reboot -m 256 --append "vga=0 uvesafb.mode_option=640x480-32 root=/dev/hda rw mem=256M ip=192.168.7.2::192.168.7.1:255.255.255.0 oprofile.timer=1 "

----------

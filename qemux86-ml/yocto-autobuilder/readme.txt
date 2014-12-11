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

run testimage on a preppred autobuilder from cmdline:

DISPLAY=:1 bitbake core-image-minimal -c testimage

Loading cache: 100% |#####################################################################################################################################| ETA:  00:00:00
Loaded 1287 entries from dependency cache.
NOTE: Resolving any missing task queue dependencies

Build Configuration:
BB_VERSION        = "1.24.0"
BUILD_SYS         = "x86_64-linux"
NATIVELSBSTRING   = "Ubuntu-14.04"
TARGET_SYS        = "i586-poky-linux"
MACHINE           = "qemux86"
DISTRO            = "poky"
DISTRO_VERSION    = "1.7"
TUNE_FEATURES     = "m32 i586"
TARGET_FPU        = ""
meta              
meta-yocto        
meta-yocto-bsp    = "dizzy:ecf1e3d1b1c9ea676b385b1df99621dd148af88b"

NOTE: Preparing runqueue
NOTE: Executing SetScene Tasks
NOTE: Executing RunQueue Tasks
core-image-minimal - Ran 1 test in 0.078s
core-image-minimal - OK - All required tests passed
NOTE: Tasks Summary: Attempted 304 tasks of which 303 didn't need to be rerun and all succeeded.

------------

with more debug:

DISPLAY=:1 bitbake core-image-minimal -vvv -c testimage    
Loading cache: 100% |#####################################################################################################################################| ETA:  00:00:00
Loaded 1287 entries from dependency cache.
NOTE: Resolving any missing task queue dependencies
NOTE: selecting pigz-native to satisfy gzip-native due to PREFERRED_PROVIDERS
NOTE: selecting pseudo-native to satisfy virtual/fakeroot-native due to PREFERRED_PROVIDERS
NOTE: selecting linux-yocto to satisfy virtual/kernel due to PREFERRED_PROVIDERS
NOTE: selecting opkg-native to satisfy opkg-native due to PREFERRED_PROVIDERS
NOTE: selecting opkg-utils-native to satisfy virtual/update-alternatives-native due to PREFERRED_PROVIDERS
NOTE: selecting glibc to satisfy runtime libsegfault due to PREFERRED_PROVIDER_virtual/libc = glibc
NOTE: selecting glibc to satisfy runtime glibc-dev due to PREFERRED_PROVIDER_virtual/libc = glibc
NOTE: selecting glibc to satisfy runtime glibc due to PREFERRED_PROVIDER_virtual/libc = glibc
NOTE: selecting linux-yocto to satisfy runtime kernel-base due to PREFERRED_PROVIDER_virtual/kernel = linux-yocto
NOTE: selecting gcc-cross-initial-i586 to satisfy virtual/i586-poky-linux-gcc-initial due to PREFERRED_PROVIDERS
NOTE: selecting linux-libc-headers to satisfy linux-libc-headers due to PREFERRED_PROVIDERS
NOTE: selecting glibc-initial to satisfy virtual/i586-poky-linux-libc-initial due to PREFERRED_PROVIDERS
NOTE: selecting gcc-cross-i586 to satisfy virtual/i586-poky-linux-gcc due to PREFERRED_PROVIDERS
NOTE: selecting gcc-runtime to satisfy virtual/i586-poky-linux-compilerlibs due to PREFERRED_PROVIDERS
NOTE: selecting glibc to satisfy virtual/libc due to PREFERRED_PROVIDERS
NOTE: selecting opkg-utils to satisfy virtual/update-alternatives due to PREFERRED_PROVIDERS
NOTE: selecting binutils-cross-i586 to satisfy virtual/i586-poky-linux-binutils due to PREFERRED_PROVIDERS
NOTE: selecting nativesdk-glibc to satisfy virtual/nativesdk-libc due to PREFERRED_PROVIDERS
NOTE: selecting libgcc to satisfy runtime libgcc due to PREFERRED_PROVIDER_libgcc = libgcc
NOTE: selecting libgcc to satisfy runtime libgcc-dev due to PREFERRED_PROVIDER_libgcc = libgcc
NOTE: selecting libgcc to satisfy runtime libgcov-dev due to PREFERRED_PROVIDER_libgcc = libgcc
NOTE: selecting gcc-runtime to satisfy runtime libstdc++ due to PREFERRED_PROVIDER_virtual/i586-poky-linux-compilerlibs = gcc-runtime
NOTE: selecting gcc-runtime to satisfy runtime libstdc++-dev due to PREFERRED_PROVIDER_virtual/i586-poky-linux-compilerlibs = gcc-runtime
NOTE: selecting glibc to satisfy runtime glibc-dbg due to PREFERRED_PROVIDER_virtual/libc = glibc
NOTE: selecting glibc to satisfy runtime glibc-utils due to PREFERRED_PROVIDER_virtual/libc = glibc
NOTE: selecting glibc to satisfy runtime glibc-thread-db due to PREFERRED_PROVIDER_virtual/libc = glibc
NOTE: selecting glibc-locale to satisfy runtime glibc-localedata-i18n due to PREFERRED_PROVIDER_virtual/libc-locale = glibc-locale
NOTE: selecting glibc-locale to satisfy runtime glibc-gconv-ibm850 due to PREFERRED_PROVIDER_virtual/libc-locale = glibc-locale
NOTE: selecting glibc-locale to satisfy runtime glibc-gconv-cp1252 due to PREFERRED_PROVIDER_virtual/libc-locale = glibc-locale
NOTE: selecting glibc-locale to satisfy runtime glibc-gconv-iso8859-1 due to PREFERRED_PROVIDER_virtual/libc-locale = glibc-locale
NOTE: selecting glibc-locale to satisfy runtime glibc-gconv-iso8859-15 due to PREFERRED_PROVIDER_virtual/libc-locale = glibc-locale
NOTE: selecting udev to satisfy runtime udev due to PREFERRED_PROVIDER_udev = udev
NOTE: selecting opkg-utils to satisfy runtime update-alternatives-opkg due to PREFERRED_PROVIDER_virtual/update-alternatives = opkg-utils
NOTE: selecting nativesdk-opkg to satisfy runtime nativesdk-opkg due to PREFERRED_PROVIDER_nativesdk-opkg = nativesdk-opkg
NOTE: selecting linux-libc-headers to satisfy runtime linux-libc-headers-dev due to PREFERRED_PROVIDER_linux-libc-headers = linux-libc-headers
NOTE: selecting opkg-utils to satisfy runtime opkg-utils-dev due to PREFERRED_PROVIDER_virtual/update-alternatives = opkg-utils
NOTE: selecting opkg-utils to satisfy runtime opkg-utils due to PREFERRED_PROVIDER_virtual/update-alternatives = opkg-utils
NOTE: selecting nativesdk-glibc to satisfy runtime nativesdk-libsegfault due to PREFERRED_PROVIDER_virtual/nativesdk-libc = nativesdk-glibc
NOTE: selecting nativesdk-glibc to satisfy runtime nativesdk-glibc due to PREFERRED_PROVIDER_virtual/nativesdk-libc = nativesdk-glibc
NOTE: selecting nativesdk-glibc to satisfy runtime nativesdk-glibc-dev due to PREFERRED_PROVIDER_virtual/nativesdk-libc = nativesdk-glibc
NOTE: selecting glibc to satisfy virtual/i586-poky-linux-libc-for-gcc due to PREFERRED_PROVIDERS
NOTE: selecting gcc-cross-i586 to satisfy virtual/i586-poky-linux-g++ due to PREFERRED_PROVIDERS
NOTE: selecting libgcc to satisfy libgcc due to PREFERRED_PROVIDERS                                                                                               [43/528]
NOTE: selecting gettext to satisfy virtual/gettext due to PREFERRED_PROVIDERS
NOTE: selecting nativesdk-libgcc to satisfy nativesdk-libgcc due to PREFERRED_PROVIDERS
NOTE: selecting binutils-crosssdk-x86_64 to satisfy virtual/x86_64-pokysdk-linux-binutils-crosssdk due to PREFERRED_PROVIDERS
NOTE: selecting nativesdk-glibc to satisfy virtual/nativesdk-x86_64-pokysdk-linux-libc-for-gcc due to PREFERRED_PROVIDERS
NOTE: selecting nativesdk-glibc-initial to satisfy virtual/nativesdk-x86_64-pokysdk-linux-libc-initial due to PREFERRED_PROVIDERS
NOTE: selecting nativesdk-linux-libc-headers to satisfy nativesdk-linux-libc-headers due to PREFERRED_PROVIDERS
NOTE: selecting glibc-locale to satisfy runtime glibc-charmaps due to PREFERRED_PROVIDER_virtual/libc-locale = glibc-locale
NOTE: selecting glibc-locale to satisfy runtime glibc-localedatas due to PREFERRED_PROVIDER_virtual/libc-locale = glibc-locale
NOTE: selecting glibc-locale to satisfy runtime glibc-gconvs due to PREFERRED_PROVIDER_virtual/libc-locale = glibc-locale
NOTE: selecting udev to satisfy runtime udev-dev due to PREFERRED_PROVIDER_udev = udev
NOTE: selecting make to satisfy runtime make due to PREFERRED_PROVIDER_make = make
NOTE: selecting udev to satisfy runtime udev-cache due to PREFERRED_PROVIDER_udev = udev
NOTE: selecting linux-yocto to satisfy runtime kernel-module-uvesafb due to PREFERRED_PROVIDER_virtual/kernel = linux-yocto
NOTE: selecting nativesdk-opkg to satisfy runtime nativesdk-opkg-dev due to PREFERRED_PROVIDER_nativesdk-opkg = nativesdk-opkg
NOTE: selecting gettext to satisfy runtime gettext-dev due to PREFERRED_PROVIDER_virtual/gettext = gettext
NOTE: selecting gettext to satisfy runtime gettext due to PREFERRED_PROVIDER_virtual/gettext = gettext
NOTE: selecting nativesdk-libgcc to satisfy runtime nativesdk-libgcc due to PREFERRED_PROVIDER_nativesdk-libgcc = nativesdk-libgcc
NOTE: selecting nativesdk-linux-libc-headers to satisfy runtime nativesdk-linux-libc-headers-dev due to PREFERRED_PROVIDER_nativesdk-linux-libc-headers = nativesdk-linux-
libc-headers
NOTE: selecting glibc-locale to satisfy runtime glibc-gconv-utf-16 due to PREFERRED_PROVIDER_virtual/libc-locale = glibc-locale
NOTE: selecting glibc-locale to satisfy runtime glibc-charmap-utf-8 due to PREFERRED_PROVIDER_virtual/libc-locale = glibc-locale
NOTE: selecting glibc-locale to satisfy runtime glibc-gconv-cp1255 due to PREFERRED_PROVIDER_virtual/libc-locale = glibc-locale
NOTE: selecting glibc-locale to satisfy runtime glibc-charmap-cp1255 due to PREFERRED_PROVIDER_virtual/libc-locale = glibc-locale
NOTE: selecting glibc-locale to satisfy runtime glibc-gconv-utf-32 due to PREFERRED_PROVIDER_virtual/libc-locale = glibc-locale
NOTE: selecting glibc-locale to satisfy runtime glibc-gconv-utf-7 due to PREFERRED_PROVIDER_virtual/libc-locale = glibc-locale
NOTE: selecting glibc-locale to satisfy runtime glibc-gconv-euc-jp due to PREFERRED_PROVIDER_virtual/libc-locale = glibc-locale
NOTE: selecting glibc-locale to satisfy runtime glibc-charmap-invariant due to PREFERRED_PROVIDER_virtual/libc-locale = glibc-locale
NOTE: selecting glibc-locale to satisfy runtime glibc-localedata-translit-cjk-variants due to PREFERRED_PROVIDER_virtual/libc-locale = glibc-locale
NOTE: selecting db to satisfy runtime db-dev due to PREFERRED_PROVIDER_virtual/db = db
NOTE: selecting db to satisfy runtime db due to PREFERRED_PROVIDER_virtual/db = db
NOTE: selecting glibc to satisfy virtual/libiconv due to PREFERRED_PROVIDERS
NOTE: selecting db to satisfy virtual/db due to PREFERRED_PROVIDERS
NOTE: selecting nativesdk-glibc to satisfy virtual/nativesdk-libiconv due to PREFERRED_PROVIDERS
NOTE: selecting nativesdk-glibc to satisfy virtual/nativesdk-libintl due to PREFERRED_PROVIDERS
NOTE: selecting dbus-glib to satisfy dbus-glib due to PREFERRED_PROVIDERS
NOTE: selecting glibc to satisfy virtual/libintl due to PREFERRED_PROVIDERS
NOTE: selecting make to satisfy runtime make-dev due to PREFERRED_PROVIDER_make = make
NOTE: selecting glibc-locale to satisfy runtime locale-base-ru-ru due to PREFERRED_PROVIDER_virtual/libc-locale = glibc-locale
NOTE: selecting dbus-glib to satisfy runtime dbus-glib-dev due to PREFERRED_PROVIDER_dbus-glib = dbus-glib
NOTE: selecting dbus-glib to satisfy runtime dbus-glib due to PREFERRED_PROVIDER_dbus-glib = dbus-glib
NOTE: selecting glibc-locale to satisfy runtime glibc-gconv-ebcdic-us due to PREFERRED_PROVIDER_virtual/libc-locale = glibc-locale
NOTE: selecting glibc-locale to satisfy runtime glibc-gconv-ibm1141 due to PREFERRED_PROVIDER_virtual/libc-locale = glibc-locale
NOTE: selecting libx11 to satisfy virtual/libx11 due to PREFERRED_PROVIDERS
NOTE: selecting dbus-glib-native to satisfy dbus-glib-native due to PREFERRED_PROVIDERS
NOTE: selecting libx11 to satisfy runtime libx11-dev due to PREFERRED_PROVIDER_virtual/libx11 = libx11
NOTE: selecting libx11 to satisfy runtime libx11 due to PREFERRED_PROVIDER_virtual/libx11 = libx11

Build Configuration:
BB_VERSION        = "1.24.0"
BUILD_SYS         = "x86_64-linux"
NATIVELSBSTRING   = "Ubuntu-14.04"
TARGET_SYS        = "i586-poky-linux"
MACHINE           = "qemux86"
DISTRO            = "poky"
DISTRO_VERSION    = "1.7"
TUNE_FEATURES     = "m32 i586"
TARGET_FPU        = ""
meta              
meta-yocto        
meta-yocto-bsp    = "dizzy:ecf1e3d1b1c9ea676b385b1df99621dd148af88b"

NOTE: Preparing runqueue
NOTE: Marking Active Tasks
NOTE: Pruned 8939 inactive tasks, 304 left
NOTE: Assign Weightings
NOTE: Compute totals (have 1 endpoint(s))
NOTE: Executing SetScene Tasks
NOTE: Executing RunQueue Tasks
NOTE: Created listening socket for qemu serial console on: 127.0.0.1:39742
NOTE: rootfs file: /home/genius/test/yocto-autobuilder/yocto-worker/custom-dizzy-qemux86-core-image-minimal/build/build/tmp/work/qemux86-poky-linux/core-image-minimal/1.0
-r0/testimage/core-image-minimal-qemux86-testimage.ext3
NOTE: Qemu log file: /home/genius/test/yocto-autobuilder/yocto-worker/custom-dizzy-qemux86-core-image-minimal/build/build/tmp/work/qemux86-poky-linux/core-image-minimal/1
.0-r0/testimage/qemu_boot_log.20141211073628
NOTE: SSH log file: /home/genius/test/yocto-autobuilder/yocto-worker/custom-dizzy-qemux86-core-image-minimal/build/build/tmp/work/qemux86-poky-linux/core-image-minimal/1.
0-r0/testimage/ssh_target_log.20141211073628
NOTE: runqemu started, pid is 5126
NOTE: waiting at most 60 seconds for qemu pid
NOTE: qemu started - qemu procces pid is 5211
NOTE: Target IP: 192.168.7.2
NOTE: Server IP: 192.168.7.1
NOTE: Waiting at most 1500 seconds for login banner
NOTE: Connection from 127.0.0.1:36883
NOTE: Reached login banner
core-image-minimal - Ran 1 test in 0.055s
core-image-minimal - OK - All required tests passed
NOTE: Sending SIGTERM to runqemu
NOTE: Tasks Summary: Attempted 304 tasks of which 303 didn't need to be rerun and all succeeded.

-------------

trying to figure out how qemurun is being called:

diff --git a/meta/lib/oeqa/utils/qemurunner.py b/meta/lib/oeqa/utils/qemurunner.py
index f1a7e24..bee6557 100644
--- a/meta/lib/oeqa/utils/qemurunner.py
+++ b/meta/lib/oeqa/utils/qemurunner.py
@@ -91,6 +91,7 @@ class QemuRunner:
             self.qemuparams = self.qemuparams[:-1] + " " + qemuparams + " " + '\"'
 
         launch_cmd = 'runqemu %s %s %s' % (self.machine, self.rootfs, self.qemuparams)
+       bb.note('runqemu %s %s %s' % (self.machine, self.rootfs, self.qemuparams))
         self.runqemu = subprocess.Popen(launch_cmd,shell=True,stdout=subprocess.PIPE,stderr=subprocess.STDOUT,preexec_fn=os.setpgrp)
 
         bb.note("runqemu started, pid is %s" % self.runqemu.pid)

which gives:

...
NOTE: Preparing runqueue
NOTE: Marking Active Tasks
NOTE: Pruned 8939 inactive tasks, 304 left
NOTE: Assign Weightings
NOTE: Compute totals (have 1 endpoint(s))
NOTE: Executing SetScene Tasks
NOTE: Executing RunQueue Tasks
NOTE: Created listening socket for qemu serial console on: 127.0.0.1:40865
NOTE: rootfs file: /home/genius/test/yocto-autobuilder/yocto-worker/custom-dizzy-qemux86-core-image-minimal/build/build/tmp/work/qemux86-poky-linux/core-image-minimal/1.0-r0/testimage/core-image-minimal-qemux86-testimage.ext3
NOTE: Qemu log file: /home/genius/test/yocto-autobuilder/yocto-worker/custom-dizzy-qemux86-core-image-minimal/build/build/tmp/work/qemux86-poky-linux/core-image-minimal/1.0-r0/testimage/qemu_boot_log.20141211102158
NOTE: SSH log file: /home/genius/test/yocto-autobuilder/yocto-worker/custom-dizzy-qemux86-core-image-minimal/build/build/tmp/work/qemux86-poky-linux/core-image-minimal/1.0-r0/testimage/ssh_target_log.20141211102158
NOTE: runqemu qemux86 /home/genius/test/yocto-autobuilder/yocto-worker/custom-dizzy-qemux86-core-image-minimal/build/build/tmp/work/qemux86-poky-linux/core-image-minimal/1.0-r0/testimage/core-image-minimal-qemux86-testimage.ext3 bootparams="console=tty1 console=ttyS0,115200n8" qemuparams="-serial tcp:127.0.0.1:40865"
NOTE: runqemu started, pid is 14163
NOTE: waiting at most 60 seconds for qemu pid
NOTE: qemu started - qemu procces pid is 14248
NOTE: Target IP: 192.168.7.2
NOTE: Server IP: 192.168.7.1
NOTE: Waiting at most 1500 seconds for login banner
NOTE: Connection from 127.0.0.1:46287
NOTE: Reached login banner
core-image-minimal - Ran 1 test in 0.061s
core-image-minimal - OK - All required tests passed
NOTE: Sending SIGTERM to runqemu
NOTE: Tasks Summary: Attempted 304 tasks of which 303 didn't need to be rerun and all succeeded.
...

--------

like this over an ssh -X session or directly on the same machine:

runqemu qemux86 /home/genius/test/yocto-autobuilder/yocto-worker/custom-dizzy-qemux86-core-image-minimal/build/build/tmp/work/qemux86-poky-linux/core-image-minimal/1.0-r0/testimage/core-image-minimal-qemux86-testimage.ext3 bootparams="console=tty1 console=ttyS0,115200n8" qemuparams="-serial stdio"

--------


something like this worked:

cd ~/yocto-autobuilder/yocto-slave/custom-daisy-vexpressa9-sato-sdk-new/build

source oe-init-build-env

with video console:
~/yocto-autobuilder/yocto-slave/custom-daisy-vexpressa9-sato-sdk-new/build/meta-mainline/vexpressa9/scripts/runqemu core-image-minimal vexpressa9

without video console:
~/yocto-autobuilder/yocto-slave/custom-daisy-vexpressa9-sato-sdk-new/build/meta-mainline/vexpressa9/scripts/runqemu core-image-minimal vexpressa9 nographic

with video console - sato sdk:
~/yocto-autobuilder/yocto-slave/custom-daisy-vexpressa9-sato-sdk-new/build/meta-mainline/vexpressa9/scripts/runqemu core-image-sato-sdk vexpressa9

without video console - sato sdk:
~/yocto-autobuilder/yocto-slave/custom-daisy-vexpressa9-sato-sdk-new/build/meta-mainline/vexpressa9/scripts/runqemu core-image-sato-sdk vexpressa9 nographic

----------

Assuming core-image-minimal really means /home/genius/yocto-autobuilder/yocto-slave/custom-daisy-vexpressa9-sato-sdk-new/build/build/tmp/deploy/images/core-image-minimal-vexpressa9.tar.bz2

Continuing with the following parameters:
KERNEL: [/home/genius/yocto-autobuilder/yocto-slave/custom-daisy-vexpressa9-sato-sdk-new/build/build/tmp/deploy/images/vexpressa9/zImage-vexpressa9.bin]
ROOTFS: [/home/genius/yocto-autobuilder/yocto-slave/custom-daisy-vexpressa9-sato-sdk-new/build/build/tmp/deploy/images/vexpressa9/core-image-minimal-vexpressa9.tar.bz2]
FSTYPE: [tar.bz2]
Setting up tap interface under sudo
Acquiring lockfile for tap0...
No need to create image.
WARNING: distccd not present, no distcc support loaded.
Running qemu-system-arm...
/home/genius/yocto-autobuilder/yocto-slave/custom-daisy-vexpressa9-sato-sdk-new/build/build/tmp/sysroots/x86_64-linux/usr/bin/qemu-system-arm -kernel /home/genius/yocto-autobuilder/yocto-slave/custom-daisy-vexpressa9-sato-sdk-new/build/build/tmp/deploy/images/vexpressa9/zImage-vexpressa9.bin -net nic,vlan=0 -net tap,vlan=0,ifname=tap0,script=no,downscript=no -M vexpress-a9 -cpu cortex-a9 -sd /home/genius/yocto-autobuilder/yocto-slave/custom-daisy-vexpressa9-sato-sdk-new/build/build/tmp/deploy/images/vexpressa9/core-image-minimal-vexpressa9.ext3 -no-reboot -m 1024 --append "root=/dev/mmcblk0 rw mem=1024M raid=noautodetect console=tty0 console=ttyAMA0,38400n8 rootwait vmalloc=256MB devtmpfs.mount=0 "
Set 'tap0' nonpersistent
Releasing lockfile of preconfigured tap device 'tap0'

----------

attempt with u-boot:

/home/genius/yocto-autobuilder/yocto-slave/custom-daisy-vexpressa9-sato-sdk-new/build/build/tmp/sysroots/x86_64-linux/usr/bin/qemu-system-arm -M vexpress-a9 -cpu cortex-a9 -m 1024 -kernel u-boot -nographic

Note that u-boot is the .elf file and not u-boot.bin

----------

see also:

http://www.elinux.org/Virtual_Development_Board
http://wiki.gumstix.org/index.php?title=Overo_qemu_script
http://wiki.gumstix.org/index.php?title=Gumstix_Emulation_for_QEMU
http://wiki.qemu.org/Documentation/Debugging
http://wiki.osdev.org/Kernel_Debugging
http://www.ece.cmu.edu/~ee349/f-2012/lab2/qemu.pdf
http://www.ece.cmu.edu/~ee349/f-2012/lab2/
http://wiki.qemu.org/Debugging_with_Valgrind
http://www.hellion.org.uk/blog/posts/grub-on-uboot-on-qemu/
http://emreboy.wordpress.com/2012/12/15/how-to-cross-compile-u-boot-and-work-it-on-qemu/
----------

/home/genius/yocto-autobuil
der/yocto-slave/custom-daisy-vexpressa9-sato-sdk-new/build/build/tmp/sysroots/x86_64-linux/usr/bin/qemu-system-arm -cpu help                                              
Available CPUs:
  arm1026
  arm1136
  arm1136-r2
  arm1176
  arm11mpcore
  arm926
  arm946
  cortex-a15
  cortex-a8
  cortex-a9
  cortex-m3
  pxa250
  pxa255
  pxa260
  pxa261
  pxa262
  pxa270-a0
  pxa270-a1
  pxa270
  pxa270-b0
  pxa270-b1
  pxa270-c0
  pxa270-c5
  sa1100
  sa1110
  ti925t

/home/genius/yocto-autobuilder/yocto-slave/custom-daisy-vexpressa9-sato-sdk-new/build/build/tmp/sysroots/x86_64-linux/usr/bin/qemu-system-arm -machine help
Supported machines are:
none                 empty machine
collie               Collie PDA (SA-1110)
nuri                 Samsung NURI board (Exynos4210)
smdkc210             Samsung SMDKC210 board (Exynos4210)
connex               Gumstix Connex (PXA255)
verdex               Gumstix Verdex (PXA270)
highbank             Calxeda Highbank (ECX-1000)
midway               Calxeda Midway (ECX-2000)
integratorcp         ARM Integrator/CP (ARM926EJ-S) (default)
kzm                  ARM KZM Emulation Baseboard (ARM1136)
mainstone            Mainstone II (PXA27x)
musicpal             Marvell 88w8618 / MusicPal (ARM926EJ-S)
n800                 Nokia N800 tablet aka. RX-34 (OMAP2420)
n810                 Nokia N810 tablet aka. RX-44 (OMAP2420)
sx1                  Siemens SX1 (OMAP310) V2
sx1-v1               Siemens SX1 (OMAP310) V1
cheetah              Palm Tungsten|E aka. Cheetah PDA (OMAP310)
realview-eb          ARM RealView Emulation Baseboard (ARM926EJ-S)
realview-eb-mpcore   ARM RealView Emulation Baseboard (ARM11MPCore)
realview-pb-a8       ARM RealView Platform Baseboard for Cortex-A8
realview-pbx-a9      ARM RealView Platform Baseboard Explore for Cortex-A9
akita                Akita PDA (PXA270)
spitz                Spitz PDA (PXA270)
borzoi               Borzoi PDA (PXA270)
terrier              Terrier PDA (PXA270)
lm3s811evb           Stellaris LM3S811EVB
lm3s6965evb          Stellaris LM3S6965EVB
tosa                 Tosa PDA (PXA255)
versatilepb          ARM Versatile/PB (ARM926EJ-S)
versatileab          ARM Versatile/AB (ARM926EJ-S)
vexpress-a9          ARM Versatile Express for Cortex-A9
vexpress-a15         ARM Versatile Express for Cortex-A15
xilinx-zynq-a9       Xilinx Zynq Platform Baseboard for Cortex-A9
z2                   Zipit Z2 (PXA27x)

------------------

http://iamhahar.blogspot.gr/2013/08/emulate-vexpress-a15-board-on-qemu.html

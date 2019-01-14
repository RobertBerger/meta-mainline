OE/Yocto Project/BitBake prerequisites
======================================

Install the required prerequisites as defined in the Yocto Project manual for your build host:

https://www.yoctoproject.org/docs/latest/mega-manual/mega-manual.html#required-packages-for-the-build-host

variables
=========

export BSP_BRANCH="thud-training-v4.19.x"

export POKY_BRANCH="2018-11-28-thud-2.6+"

poky
====

git clone git://github.com/RobertBerger/poky.git -b ${POKY_BRANCH}

u-boot-wic-bsp
==============

cd poky

git clone git://github.com/RobertBerger/meta-mainline.git -b ${BSP_BRANCH}

supported BOARDS
================

ls meta-mainline/u-boot-wic-bsp/conf/machine/
am335x-phytec-wega.conf  beagle-bone-black.conf  common.inc  imx6q-phytec-mira-rdk-nand.conf

so we have those choices:

* am335x-phytec-wega

* beagle-bone-black

* imx6q-phytec-mira-rdk-nand

more might be added.

initial config
==============

for beagle-bone-black:

export BOARD="beagle-bone-black"

export TEMPLATECONF="meta-mainline/u-boot-wic-bsp/template-${BOARD}"

source oe-init-build-env ${BOARD}

cp ../meta-mainline/u-boot-wic-bsp/template-common/site.conf.sample conf/site.conf

You might need to adjust the site.conf or better the site.conf.sample once it works for you.

Most likely you want to point DL_DIR and SSTATE_DIR to some dir which is non-volatile 
and where you have write permissions. If you don't know what they are, just comment them out.

#DL_DIR = "/tmp/yocto-autobuilder/downloads"
#SSTATE_DIR ?= "/tmp/yocto-autobuilder/sstate/"

If you don't know what are mirros you most likely dont' have any set up so comment this out:

#INHERIT += "own-mirrors"
#SOURCE_MIRROR_URL = "http://mirror/source_mirror_thud"
#SSTATE_MIRRORS ?= "file://.* http://mirror/sstate_mirror_thud/PATH;downloadfilename=PATH"

If you want instead of the default sysvinit systemd as your init manager 
you need to activate those lines in your conf/local.conf:

#DISTRO_FEATURES_append = " systemd"
#VIRTUAL-RUNTIME_init_manager = "systemd"
#DISTRO_FEATURES_BACKFILL_CONSIDERED = "sysvinit"
#VIRTUAL-RUNTIME_initscripts = ""

build
=====

bitbake core-image-minimal

The result of the build can be found under

tmp/deploy/images/${BOARD}

flash
=====

I usually use the CLI for Etcher to flash the image, but with the GUI it should work as well.

If you don't already have it, download 

https://www.balena.io/etcher/

And install it somewhere.

I would do the following in order to flash my image:

cd tmp/deploy/images/${BOARD}

sudo /opt/etcher/Etcher-cli-1.2.0-linux-x64/etcher core-image-minimal-${BOARD}.wic

first boot
==========

The system should start up and boot from SD card.
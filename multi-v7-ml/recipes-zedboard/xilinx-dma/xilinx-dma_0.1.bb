DESCRIPTION = "xilinx-dma (not yet mainline)"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit module

PR = "r0"
PV = "0.1"

SRC_URI = "file://Makefile \
           file://vdmatest.c \
           file://xilinx_dma.c \
           file://dmaengine.h \
           file://axidmatest.c \
           file://xilinx_cdma.c \
           file://amba_xilinx_dma.h \
           file://cdmatest.c \
           file://xilinx_dpdma.c \
           file://zynqmp_dma.c \
          "

S = "${WORKDIR}"

# automatically load the kernel module we build here
KERNEL_MODULE_AUTOLOAD += " hello"


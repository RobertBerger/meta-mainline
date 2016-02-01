obj-m := xilinx_dma.o
obj-m += axidmatest.o
obj-m += vdmatest.o
obj-m += xilinx_cdma.o
obj-m += cdmatest.o
obj-m += xilinx_dpdma.o
obj-m += zynqmp_dma.o

SRC := $(shell pwd)

all:
	$(MAKE) -C $(KERNEL_SRC) M=$(SRC)

modules_install:
	$(MAKE) -C $(KERNEL_SRC) M=$(SRC) modules_install

clean:
	rm -f *.o *~ core .depend .*.cmd *.ko *.mod.c
	rm -f Module.markers Module.symvers modules.order
	rm -rf .tmp_versions Modules.symvers

#obj-$(CONFIG_XILINX_AXIDMA) += xilinx_dma.o
#obj-$(CONFIG_XILINX_DMATEST) += axidmatest.o
#obj-$(CONFIG_XILINX_VDMATEST) += vdmatest.o
#obj-$(CONFIG_XILINX_AXICDMA) += xilinx_cdma.o
#obj-$(CONFIG_XILINX_CDMATEST) += cdmatest.o
#obj-$(CONFIG_XILINX_DPDMA) += xilinx_dpdma.o
#obj-$(CONFIG_XILINX_VDMA) += xilinx_vdma.o
#obj-$(CONFIG_XILINX_ZYNQMP_DMA) += zynqmp_dma.o

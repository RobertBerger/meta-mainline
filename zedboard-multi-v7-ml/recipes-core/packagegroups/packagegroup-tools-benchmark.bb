DESCRIPTION = "Tools Benchmark Package Group"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = "\
    packagegroup-tools-benchmark"

RDEPENDS_packagegroup-tools-benchmark = "\
    cpuburn-neon \
    iozone3 \
    iperf \
    iperf3 \
    libhugetlbfs \
    memtester \
    nbench-byte \
    tinymembench \
    stress \
    "

# add those if you need them:
#    analyze-suspend 
#    bonnie++ 
#    dbench 
#    fio 
#    glmark2 
#    lmbench 
#    tiobench 

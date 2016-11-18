DESCRIPTION = "Tools Benchmark Package Group"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690 \
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
    phoronix-test-suite \
    "

# add those if you need them:
#    analyze-suspend 
#    bonnie++ 
#    dbench 
#    fio 
#    glmark2 
#    lmbench 
#    tiobench 

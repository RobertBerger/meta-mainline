DESCRIPTION = "Tools Benchmark Package Group"

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
#    phoronix-test-suite
# removed phoronix for now for sumo due to php

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

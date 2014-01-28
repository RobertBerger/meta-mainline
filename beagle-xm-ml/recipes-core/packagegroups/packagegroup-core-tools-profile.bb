#
# Copyright (C) 2008 OpenedHand Ltd.
#

SUMMARY = "Profiling tools"
LICENSE = "MIT"

PR = "r3"

inherit packagegroup

PACKAGE_ARCH = "${MACHINE_ARCH}"

# For backwards compatibility after rename
RPROVIDES_${PN} = "task-core-tools-profile"
RREPLACES_${PN} = "task-core-tools-profile"
RCONFLICTS_${PN} = "task-core-tools-profile"

PROFILE_TOOLS_X = "${@base_contains('DISTRO_FEATURES', 'x11', 'sysprof', '', d)}"

RRECOMMENDS_${PN} = "\
    trace-cmd \
    kernel-module-oprofile \
    blktrace \
    ${PROFILE_TOOLS_X} \
    "

PROFILETOOLS = "\
    oprofile \
    oprofileui-server \
    powertop \
    latencytop \
    "

# systemtap needs elfutils which is not fully buildable on uclibc
# hence we exclude it from uclibc based builds
SYSTEMTAP = "systemtap"
SYSTEMTAP_libc-uclibc = ""
SYSTEMTAP_mips = ""
SYSTEMTAP_mips64 = ""
SYSTEMTAP_aarch64 = ""

# lttng-ust uses sched_getcpu() which is not there on uclibc
# for some of the architectures it can be patched to call the
# syscall directly but for x86_64 __NR_getcpu is a vsyscall
# which means we can not use syscall() to call it. So we ignore
# it for x86_64/uclibc

LTTNGUST = "lttng-ust"
LTTNGUST_libc-uclibc = ""
LTTNGUST_aarch64 = ""

LTTNGTOOLS = "lttng-tools"
LTTNGTOOLS_aarch64 = ""

LTTNGMODULES = "lttng-modules"
LTTNGMODULES_aarch64 = ""

BABELTRACE = "babeltrace"
BABELTRACE_aarch64 = ""

# valgrind does not work on mips

VALGRIND = "valgrind"
VALGRIND_libc-uclibc = ""
VALGRIND_mips = ""
VALGRIND_mips64 = ""
VALGRIND_arm = ""
VALGRIND_aarch64 = ""

#    exmap-console
#    exmap-server

RDEPENDS_${PN} = "\
    ${PROFILETOOLS} \
    ${LTTNGUST} \
    ${LTTNGTOOLS} \
    ${LTTNGMODULES} \
    ${BABELTRACE} \
    ${SYSTEMTAP} \
    ${VALGRIND} \
    "

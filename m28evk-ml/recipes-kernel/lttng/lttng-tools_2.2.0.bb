SECTION = "devel"
SUMMARY = "Linux Trace Toolkit Control"
DESCRIPTION = "The Linux trace toolkit is a suite of tools designed \
to extract program execution details from the Linux operating system \
and interpret them."

LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=01d7fc4496aacf37d90df90b90b0cac1 \
                    file://gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://lgpl-2.1.txt;md5=0f0d71500e6a57fd24d825f33242b9ca"

DEPENDS = "liburcu popt lttng-ust"

SRCREV = "eff0b2c38d24092c41bbb51926ac4e3b8c6acb83"
PV = "v2.2.0"

SRC_URI = "git://git.lttng.org/lttng-tools.git;protocol=git"

S = "${WORKDIR}/git"

inherit autotools

export KERNELDIR="${STAGING_KERNEL_DIR}"

FILES_${PN} += "${libdir}/lttng/libexec/*"
FILES_${PN}-dbg += "${libdir}/lttng/libexec/.debug"

# Since files are installed into ${libdir}/lttng/libexec we match 
# the libexec insane test so skip it.
INSANE_SKIP_${PN} = "libexec"
INSANE_SKIP_${PN}-dbg = "libexec"

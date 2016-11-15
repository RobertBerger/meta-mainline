# This patch is needed, at this time, to fix builds with linux-libc-headers
# from the 4.8 Linux kernel or newer, which is not the case for most external
# toolchains. As the external toolchain is available at parse time, we can
# check the version and only apply it when appropriate.
# The same problem exists for an 'internal toolchain' with LINUXLIBCVERSION set
# to < 4.8 e.g. to 4.4
# Here we remove the ppp-fix-building-with-linux-4.8.patch when it's not needed
# unfortunately the default LINUXLIBCVERSION is 4.8%, so we need to remove %
# before we can do numerical comparisons
KERNEL_48_PATCH = "file://ppp-fix-building-with-linux-4.8.patch"
SRC_URI_remove := "${@'${KERNEL_48_PATCH}' if [int(i) for i in ('${LINUXLIBCVERSION}'.replace('%', '') or '0.0').split('.')] < [4, 8] else ''}"

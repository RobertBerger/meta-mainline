set -e

# don't use builtin 'echo' from /bin/sh
export ECHO="$(which echo)"

PATCHPATH="patches"

# It is essential to apply the patches in the right order !
PATCHSET="arm drivers imx_next omap_next omap_dt_dss imx omap_usb omap_video omap_clock dts bone imx_video_staging omap3_beagle_xm_rework omap_sprz319_erratum_v2.1 fixes vivante saucy"

OUTPUT_FILE="proposed_igepv2-ml-user-patches.scc"

rm -f ${OUTPUT_FILE}

for patchset in ${PATCHSET} ; do
   for patch in $(ls -1 ${PATCHPATH}/$patchset/*.patch | sort -n) ; do
           $ECHO -e "$patch"
           $ECHO -e "patch $patch" >> ${OUTPUT_FILE}
#           read r
   done
done

echo
echo
echo ">>>>>> update your igepv2-ml-user-patches.scc file <<<<<<"

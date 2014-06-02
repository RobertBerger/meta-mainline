set -e

# don't use builtin 'echo' from /bin/sh
export ECHO="$(which echo)"

PATCHPATH="patches"

# It is essential to apply the patches in the right order !
PATCHSET="drivers imx_next omap_dt_dss clock usb dts imx_drm imx_drm_dts omap_sprz319_erratum_v2.1 omap3_beagle_xm_rework fixes vivante saucy"

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

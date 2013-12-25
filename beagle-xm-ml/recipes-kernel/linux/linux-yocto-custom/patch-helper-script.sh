set -e

# don't use builtin 'echo' from /bin/sh
export ECHO="$(which echo)"

PATCHPATH="patches"

# It is essential to apply the patches in the right order !
PATCHSET="omap-next-dt dma-devel general-fixes dtc-fixes dtc-overlays of-fixes pdev-fixes mmc-fixes dts-fixes i2c-fixes pinctrl-fixes capemgr reset capes lcdc-fixes net deassert-hard-reset cape-import audio drm cpufreq"

OUTPUT_FILE="proposed_beagle-xm-ml-user-patches.scc"

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
echo ">>>>>> update your beagle-xm-ml-user-patches.scc file <<<<<<"

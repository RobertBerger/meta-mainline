set -e

# don't use builtin 'echo' from /bin/sh
export ECHO="$(which echo)"

PATCHPATH="patches"

# It is essential to apply the patches in the right order !
PATCHSET="pinmux dts capes dtb_makefile static-capes sgx"
#disabled by default
#rt

OUTPUT_FILE="proposed_beagle-bone-black-ml-user-patches.scc"

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
echo ">>>>>> update your beagle-bone-black-ml-user-patches.scc file <<<<<<"

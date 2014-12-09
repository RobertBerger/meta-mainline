#! /bin/bash

HERE=$(pwd)

set -x
cd /home/genius/test/meta-mainline
git checkout master
git status
set +x

FOLDERS_TO_PROCESS="beagle-bone-black-ml/ beagle-bone-white-ml/ beagle-xm-ml/ igepv2-ml/ m28evk-ml/ panda-ml/ socrates-ml/ vexpressa9/ wandboard-dl-ml/ wandboard-q-ml/"

for FOLDER in ${FOLDERS_TO_PROCESS}
do
set -x
  git clean -f -d ${FOLDER}
set +x
done

set -x
git status
set +x

cd ${HERE}

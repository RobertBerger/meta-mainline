HERE=$(pwd)

echo "+  git checkout master"
git checkout master

for BRANCH in master dora-armv7-multiplatform-v3.13.x dora-armv7-multiplatform-v3.13.x-min dora-linux-dev-v3.13.x dora-training-v3.13.x
do
  echo "+ ----->"
  echo "+ cd ../../meta-mainline-top/meta-mainline-test/"
  cd ../../meta-mainline-top/meta-mainline-test/
  echo "+  git checkout ${BRANCH}"
  git checkout ${BRANCH}
  echo "+ cd ${HERE}"
  cd ${HERE}
  echo "+ cd .."
  cd ..
  echo "+ git checkout ${BRANCH}"
  git checkout ${BRANCH}
  echo "+ git pull ../meta-mainline-top/meta-mainline-test"
  git pull ../meta-mainline-top/meta-mainline-test
  echo "+ git log --name-status HEAD^..HEAD"
  git log --name-status HEAD^..HEAD
  echo "+ git checkout master"
  git checkout master
  echo "+ cd ${HERE}"
  cd ${HERE}
  echo "+ <-----"
done

echo "+ git status"
git status

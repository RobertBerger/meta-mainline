HERE=$(pwd)

echo "+  git checkout master"
git checkout master

echo "+ cd ../../meta-mainline-top/meta-mainline-test/"
cd ../../meta-mainline-top/meta-mainline-test/
echo "+  git checkout master"
git checkout master

echo "+ cd ${HERE}"

#for BRANCH in master dora-armv7-multiplatform-v3.13.x dora-armv7-multiplatform-v3.13.x-min dora-linux-dev-v3.13.x dora-training-v3.13.x dora-training-v3.14.x daisy-training-v3.14.x daisy-training-v3.15.x daisy-training-v3.16.x dizzy-training-v3.14.x dizzy-training-v3.19.x fido-training-v3.19.x fido-training-v4.1.x jethro-training-v4.1.x jethro-training-v4.4.x fido-training-v4.1.x jethro-training-v4.1.x jethro-training-v4.4.x morty-training-v4.4.x pyro-training-v4.4.x pyro-training-v4.9.x
#for BRANCH in master rocko-training-v4.9.x rocko-training-v4.14.x sumo-training-v4.14.x sumo-training-v4.14.x-next thud-training-v4.14.x
#for BRANCH in master sumo-training-v4.14.x sumo-training-v4.14.x-next thud-training-v4.14.x thud-training-v4.19.x thud-training-v4.19.x-next
#for BRANCH in master sumo-training-v4.14.x sumo-training-v4.14.x-next thud-training-v4.14.x thud-training-v4.19.x thud-training-v4.19.x-next
for BRANCH in master thud-training-v4.14.x thud-training-v4.19.x thud-training-v4.19.x-next warrior-training-v4.19.x
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
  echo "+ press <ENTER> to go on"
  read r
  echo "+ <-----"
done

echo "+  git checkout master"
git checkout master

echo "+ cd ../../meta-mainline-top/meta-mainline-test/"
cd ../../meta-mainline-top/meta-mainline-test/
echo "+  git checkout master"
git checkout master
echo "+ git status"
git status

echo "+ cd ${HERE}"
cd ${HERE}
echo "+  git checkout master"
git checkout master
echo "+ git status"
git status

sync

cd $HOME

echo "+ cd ${HERE}"
cd ${HERE}

cd $(pwd)

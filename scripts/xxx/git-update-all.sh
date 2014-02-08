#!/bin/bash
# Update all local branches, checking out each branch in succession.
# Eventually returns to the original branch. Use "-n" for dry-run.
git_update_all() {
  local run br
  br=$(git name-rev --name-only HEAD 2>/dev/null)
  [ "$1" = "-n" ] && shift && run=echo

  for x in $( git branch | cut -c3- ) ; do
     $run git checkout $x && $run git pull --ff-only || return 2
  done

  [ ${#br} -gt 0 ] && $run git checkout "$br"
}

cd ..
echo "+ dry run"
git_update_all "$@" -n
echo "press <ENTER to really execute it"
#git_update_all "$@"
cd scripts

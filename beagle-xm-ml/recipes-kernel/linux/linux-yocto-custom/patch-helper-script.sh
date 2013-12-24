find . -name \*.patch | sort -n > intermediate_file
cat intermediate_file | sed 's/^..//' > intermediate_file_1
rm -f intermediate_file
awk '{print "patch " $0}' intermediate_file_1 > proposed_beagle-xm-ml-user-patches.scc
rm -f intermediate_file_1
echo "update your beagle-xm-ml-user-patches.scc from proposed_beagle-xm-ml-user-patches.scc"

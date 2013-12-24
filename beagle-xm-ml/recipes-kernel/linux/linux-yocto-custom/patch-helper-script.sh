find . -name \*.patch | sort -n > intermediate_file
cat intermediate_file | sed 's/^..//' > intermediate_file_1
rm -f intermediate_file  
awk '{print "file://" $0}' intermediate_file_1 > intermediate_file_2
awk '{print $0" \\"}' intermediate_file_2 > add_to_linux_recipe.txt
rm -f intermediate_file_1  
rm -f intermediate_file_2
echo "update your linux-yocto-custom.bb with add_to_linux_recipe.txt"  

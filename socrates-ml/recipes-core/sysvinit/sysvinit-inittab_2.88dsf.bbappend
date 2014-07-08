# want runlevel 3 and not 5
# .avoid "overlaying" entire recipes from other layers in your configuration 
# (i.e. copying the entire recipe into your layer and modifying it). 
# Use .bbappend files to override the parts of the recipe you need to modify.
do_install_append() {
       sed -i 's/^id:5:initdefault/id:3:initdefault/' ${D}${sysconfdir}/inittab
}

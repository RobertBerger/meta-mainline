=== u-boot ennvironment search order ===
1) u-boot environment stored on eMMC (blob) if available
2) uEnv.txt on ext4 partition if SD card is inserted
   - press button while applying power to the board or
   - erase default u-boot environment in eMMC (blob)
3) default uEnv.txt with fatload - not tested

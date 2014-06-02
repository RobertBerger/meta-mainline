default:

root@wandboard-dl-ml:~# lsmod
Module                  Size  Used by
smsc95xx               17837  0 
usbnet                 24935  1 smsc95xx

we want to have this compiled into the kernel

diff --git a/wandboard-dl-ml/recipes-kernel/linux/linux-yocto-custom/defconfig b/wandboard-dl-ml/recipes-kernel/linux/linux-yocto-custom/defconfig
index 1dec8e2..099a5a4 100644
--- a/wandboard-dl-ml/recipes-kernel/linux/linux-yocto-custom/defconfig
+++ b/wandboard-dl-ml/recipes-kernel/linux/linux-yocto-custom/defconfig
@@ -1908,7 +1908,7 @@ CONFIG_USB_KAWETH=m
 CONFIG_USB_PEGASUS=m
 CONFIG_USB_RTL8150=m
 CONFIG_USB_RTL8152=m
-CONFIG_USB_USBNET=m
+CONFIG_USB_USBNET=y
 CONFIG_USB_NET_AX8817X=m
 CONFIG_USB_NET_AX88179_178A=m
 CONFIG_USB_NET_CDCETHER=m
@@ -1919,7 +1919,7 @@ CONFIG_USB_NET_CDC_MBIM=m
 CONFIG_USB_NET_DM9601=m
 CONFIG_USB_NET_SR9700=m
 CONFIG_USB_NET_SMSC75XX=m
-CONFIG_USB_NET_SMSC95XX=m
+CONFIG_USB_NET_SMSC95XX=y
 CONFIG_USB_NET_GL620A=m
 CONFIG_USB_NET_NET1080=m
 CONFIG_USB_NET_PLUSB=m


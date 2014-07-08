+                elif "soc" in artifact:
+                    artifact_name, deploy_image_dir = self.getDeployNames(artifact, buildername)
+                    command=command+"mkdir -p " + DEST + "/" + MACHINE_PUBLISH_DIR + "/" + artifact_name + ";"
+                    command=command+"cp -R --no-dereference --preserve=links " + \
+                                    deploy_image_dir + \
+                                    "/*soc* " + DEST + "/" + MACHINE_PUBLISH_DIR + "/" + artifact_name + ";"
+                    command=command+"cp -R --no-dereference --preserve=links " + \
+                                    deploy_image_dir + \
+                                    "/../*.md5sum " + DEST + "/" + MACHINE_PUBLISH_DIR + "/" + artifact_name + "/../ ;"

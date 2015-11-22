#include <jni.h>
#include "VirusScanner.h"
#include <stdio.h>

extern int scan_file(const char* filePath);

JNIEXPORT void JNICALL
Java_VirusScanner_scanFile
  (JNIEnv *env, jobject jo, jstring filePath)
{
  const char *filePathNativeStr = (*env)->GetStringUTFChars(env, filePath, 0);
  printf("Hello world from C!\n");
  printf("%s\n", filePathNativeStr);

  scan_file(filePathNativeStr);
  return;
 }

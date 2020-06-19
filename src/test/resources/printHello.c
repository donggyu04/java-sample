#include "com_training_jni_HelloJNI.h"
#include <stdio.h>

JNIEXPORT void JNICALL Java_com_training_jni_HelloJNI_printHello(JNIEnv *env, jobject thisObject) {
   printf("Hello, I am made in C language.\n");
   return;
}

// gcc -fPIC -I$JAVA_HOME/include -I$JAVA_HOME/include/darwin -c printHello.c
// gcc -fPIC -I$JAVA_HOME/include -I$JAVA_HOME/include/darwin -shared -o libhello.so printHello.o

//
// Created by robin young on 2018/1/11.
//
#include <jni.h>
#ifndef ANDROID_MP3ENCODER_JNI_MP3ENCODER_H
#define ANDROID_MP3ENCODER_JNI_MP3ENCODER_H
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_yb_android_mp3encoder_Mp3Encoder
 * Method:    init
 * Signature: (Ljava/lang/String;IIILjava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_com_yb_android_mp3encoder_Mp3Encoder_init
        (JNIEnv *, jobject, jstring, jint, jint, jint, jstring);

/*
 * Class:     com_yb_android_mp3encoder_Mp3Encoder
 * Method:    encode
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_yb_android_mp3encoder_Mp3Encoder_encode
        (JNIEnv *, jobject);

/*
 * Class:     com_yb_android_mp3encoder_Mp3Encoder
 * Method:    destroy
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_yb_android_mp3encoder_Mp3Encoder_destroy
        (JNIEnv *, jobject);

#ifdef __cplusplus
}
#endif
#endif //ANDROID_MP3ENCODER_JNI_MP3ENCODER_H

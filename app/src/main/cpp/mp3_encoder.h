//
// Created by robin young on 2018/1/11.
//

#ifndef ANDROID_MP3ENCODER_MP3_ENCODER_H
#define ANDROID_MP3ENCODER_MP3_ENCODER_H

#include "lame.h"

class Mp3Encoder {
private:
    FILE *pcmFile;
    FILE *mp3File;
    lame_t lameClient;

public:
    Mp3Encoder();

    ~Mp3Encoder();

    int Init(const char *pcmFilePath, const char *mp3FilePath, int sampleRate, int channels,
             int bitRate);

    void Encode();

    void Destory();
};

#endif //ANDROID_MP3ENCODER_MP3_ENCODER_H

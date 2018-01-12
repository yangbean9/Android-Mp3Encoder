package com.yb.android.mp3encoder;

/**
 * Created by robin on 2018/1/12.
 */

public class Mp3Encoder {

    public native int init(String pcmPath, int audioChannels, int bitRate, int sampleRate, String mp3Path);

    public native void encode();

    public native void destroy();
}

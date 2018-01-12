package com.yb.android.mp3encoder;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;


public class MainActivity extends Activity {

    private static final String TAG = "Mp3Encoder";
    private static final String PCM_FILE_NAME = "vocal.pcm";
    private static final String MP3_FILE_NAME = "vocal.mp3";


    static {
        System.loadLibrary("mp3encoder-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.mp3_encoder_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        encoderMP3();
                    }
                }).start();
            }
        });
    }

    private void encoderMP3() {
        File destFile = new File(getFilesDir(), PCM_FILE_NAME);
        FileUtil.copyFileFromAssets(this, PCM_FILE_NAME, destFile);
        if (destFile.exists()) {
            Log.i(TAG, "copy success");
            Mp3Encoder encoder = new Mp3Encoder();
            String pcmPath = destFile.getAbsolutePath();
            int audioChannels = 2;
            int bitRate = 128 * 1024;
            int sampleRate = 44100;
            String mp3Path = getFilesDir() + File.separator + MP3_FILE_NAME;
            int ret = encoder.init(pcmPath, audioChannels, bitRate, sampleRate, mp3Path);
            if (ret >= 0) {
                encoder.encode();
                Log.i(TAG, "Encode Mp3 Success");
                encoder.destroy();
            } else {
                Log.i(TAG, "Encoder Initialized Failed...");
            }
        }
    }
}

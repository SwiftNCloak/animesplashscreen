package com.mj_bonifacio.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int currImg = 0;

    Intent slide;

    int[] ImageArray = {R.drawable.mha_splashscreen0,
                        R.drawable.mha_splashscreen1,
                        R.drawable.mha_splashscreen2,
                        R.drawable.mha_splashscreen3,
                        R.drawable.mha_splashscreen4,
                        R.drawable.mha_splashscreen5,
                        R.drawable.mha_splashscreen6,
                        R.drawable.mha_splashscreen7,
                        R.drawable.mha_splashscreen8,
                        R.drawable.mha_splashscreen9,
                        R.drawable.mha_splashscreen10,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slide = new Intent(".SplashActivity");
        slide.putExtra("currImg", currImg);

        slide.putExtra("ImageArray", ImageArray);

        Thread tmr = new Thread(){
            public void run(){
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                } finally {
                    startActivity(slide);
                    finish();
                }
            }
        };
        tmr.start();

    }
}
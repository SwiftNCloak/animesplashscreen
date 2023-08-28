package com.mj_bonifacio.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.mj_bonifacio.myapplication.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {
    private ActivitySplashBinding binding;

    Intent Slide;
    int currImg = 0;
    View container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        int currentIndex = intent.getIntExtra("currImg", 0);
        int[] images = intent.getIntArrayExtra("ImageArray");

        // detect if we're on the last slide
        if (images.length == currImg + 1) {
            finish();
        }

        // instantiate a new Slide
        // and inject our variables to it
        Slide = new Intent(".SplashActivity");
        Slide.putExtra("currImg", currentIndex+1);
        Slide.putExtra("ImageArray", images);

        container = findViewById(R.id.SplashActivity);
        container.setBackgroundResource(images[currentIndex]);

        Thread tmr = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    startActivity(Slide);
                    finish();
                }
            }
        };
        tmr.start();
    }
}
package com.example.bopit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // disable the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // disable the action bar with title
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        ImageView logo = findViewById(R.id.v_splash_logo);

        final Animation logoAnimation = new ScaleAnimation(10f, 1f, 10f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        logoAnimation.setDuration(2000);
        logo.startAnimation(logoAnimation);
    }
}
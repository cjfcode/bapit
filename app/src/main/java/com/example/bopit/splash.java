package com.example.bopit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
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
        ImageView flashEffect = findViewById(R.id.v_flash_effect);
        ImageView splashBackground = findViewById(R.id.v_splash_bg);

        // animation for the logo zoom out
        final Animation logoAnimation = new ScaleAnimation(10f, 1f, 10f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        logoAnimation.setDuration(2000);
        logo.startAnimation(logoAnimation);

        // animation for flash effect in
        final Animation flashEffectAnimationIn = new AlphaAnimation(0.0f, 1.0f);
        flashEffectAnimationIn.setDuration(500);

        // animation for flash effect out
        final Animation flashEffectAnimationOut = new AlphaAnimation(1.0f, 0.0f);
        flashEffectAnimationOut.setDuration(500);

        logoAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                flashEffect.startAnimation(flashEffectAnimationIn);
                flashEffect.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        flashEffectAnimationIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                flashEffectAnimationOut.setStartOffset(1000);
                splashBackground.setVisibility(View.VISIBLE);
                flashEffect.startAnimation(flashEffectAnimationOut);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        flashEffectAnimationOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                flashEffect.setVisibility(View.GONE);
                Intent titleScreen = new Intent(splash.this, main.class);
                titleScreen.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(titleScreen);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
package com.example.bopit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class agreement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);

        // disable the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // disable the action bar with title
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        TextView agreement = findViewById(R.id.v_agreement_text);

        // fade in animation for the agreement screen
        final Animation introTextAnimationIn = new AlphaAnimation(0.0f, 1.0f);
        introTextAnimationIn.setDuration(2000);
        introTextAnimationIn.setStartOffset(3000);

        // fade out animation for the agreement screen
        final Animation introTextAnimationOut = new AlphaAnimation(1.0f, 0.0f);
        introTextAnimationOut.setDuration(2000);
        introTextAnimationOut.setStartOffset(5000);

        introTextAnimationIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                agreement.startAnimation(introTextAnimationOut);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        introTextAnimationOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                // disable the text so it doesn't reappear before loading the new activity
                agreement.setVisibility(View.GONE);

                // delay starting the new activity until 2 seconds after the text fades out
                new Handler().postDelayed(() -> {
                    Intent splashScreen = new Intent(agreement.this, splash.class);
                    startActivity(splashScreen);
                }, 2000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        agreement.startAnimation(introTextAnimationIn);
    }
}
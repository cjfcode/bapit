/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                                                   *
 * Bap-it                                                            *
 * Version: Beta                                                     *
 * Author: cjfcode and SentientTowel                                 *
 * Date: 06/26/18                                                    *
 * Desc: Free software version of the toy Bop It for Android         *
 *                                                                   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

package com.example.bopit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class main extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout code_mainLayout = findViewById (R.id.v_main_layout);
        ImageView code_mainTitle = findViewById (R.id.v_main_title);
        TextView code_mainStartBtn = findViewById(R.id.v_main_btn_start);

        // animation for the text
        final Animation textAnimation = new AlphaAnimation(0.0f, 1.0f);
        textAnimation.setRepeatCount(Animation.INFINITE);
        textAnimation.setRepeatMode(Animation.REVERSE);
        textAnimation.setDuration(1000);
        code_mainStartBtn.startAnimation(textAnimation);

        code_mainStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gameScreen = new Intent(main.this, game.class);
                startActivity(gameScreen);
            }
        });
    }
}

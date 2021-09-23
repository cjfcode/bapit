/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                                                   *
 * Bap-it                                                             *
 * Version: Beta                                                     *
 * Author: cjfcode and SentientTowel                                 *
 * Date: 06/26/18                                                    *
 * Desc: Free software version of the toy Bop It for Android         *
 *                                                                   *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

package com.example.bopit;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class main extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout code_mainLayout = findViewById (R.id.v_main_layout);
        ImageView code_mainTitle = findViewById (R.id.v_main_title);
        Button code_mainStartBtn = findViewById(R.id.v_main_btn_start);

        /* code within the function below is used to control the actions of the start button */
        code_mainStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gameScreen = new Intent(main.this, game.class);
                startActivity(gameScreen);
            }
        });
    }
}

package com.foslipy.languagetutorial;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


public class Splash extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        final Animation splash = AnimationUtils.loadAnimation(this, R.anim.splash);

        new CountDownTimer(3000, 500) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                Intent login = new Intent(Splash.this, Login.class);
                startActivity(login);
                finish();
            }
        }.start();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

}




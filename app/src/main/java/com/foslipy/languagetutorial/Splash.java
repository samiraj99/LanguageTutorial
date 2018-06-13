package com.foslipy.languagetutorial;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class Splash extends AppCompatActivity {

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

       }

       @Override
       protected void onStart() {
           super.onStart();
           new CountDownTimer(3000, 500) {
               @Override
               public void onTick(long l) {

               }

               @Override
               public void onFinish() {
                   Intent login = new Intent(Splash.this,Login.class);
                   startActivity(login);
                   finish();
               }
           }.start();
       }

   }




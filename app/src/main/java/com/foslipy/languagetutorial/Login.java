package com.foslipy.languagetutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    Button SignIn,SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SignIn=findViewById(R.id.BT_Sign_In);
        SignUp=findViewById(R.id.BT_Sign_up);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Regist = new Intent(Login.this,Registration.class);
                startActivity(Regist);
            }
        });

    }
}

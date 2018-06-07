package com.foslipy.languagetutorial;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {


    Button SignIn,SignUp;
    EditText Email,Pass;
    ProgressDialog dialog;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SignIn=findViewById(R.id.BT_Sign_In);
        SignUp=findViewById(R.id.BT_Sign_up);
        Email=findViewById(R.id.Login_ET_Email);
        Pass=findViewById(R.id.Login_ET_Pass);
        dialog=new ProgressDialog(this);
//
//        if(firebaseAuth.getCurrentUser()!=null)
//        {
//            finish();
//        }

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String St_Email=Email.getText().toString().trim();
                String St_Pass=Pass.getText().toString().trim();

                if(TextUtils.isEmpty(St_Email))
                {
                    Toast.makeText(Login.this, "Enter Email ...", Toast.LENGTH_SHORT).show();
                    return;
                }else if(TextUtils.isEmpty(St_Pass))
                {
                    Toast.makeText(Login.this, "Enter Password...", Toast.LENGTH_SHORT).show();
                    return;
                }
                dialog.setMessage("Log In ....!");
                dialog.show();

                firebaseAuth.signInWithEmailAndPassword(St_Email,St_Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(Login.this, "success", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }else {
                            Toast.makeText(Login.this, "Log in Failed ...! ", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }
                });
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Regist = new Intent(Login.this,Registration.class);
                startActivity(Regist);
            }
        });

    }
}

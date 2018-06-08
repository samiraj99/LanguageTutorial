package com.foslipy.languagetutorial;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {

    Button SignIn;
    EditText FirstName,LastName,Email,Occupation,Pass;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    ProgressDialog dialog;
    String St_Email;
    String St_Pass;
    String St_FirstName;
    String St_LastName;
    String St_Occupation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        SignIn=findViewById(R.id.BT_Sign_In);
        FirstName=findViewById(R.id.ET_First_name);
        LastName=findViewById(R.id.ET_Last_name);
        Email=findViewById(R.id.Reg_ET_Email);
        Pass=findViewById(R.id.ET_Pass);
        Occupation=findViewById(R.id.ET_Occupation);
        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        dialog=new ProgressDialog(this);

        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 St_Email=Email.getText().toString().trim();
                 St_Pass=Pass.getText().toString().trim();
                 St_FirstName=FirstName.getText().toString().trim();
                 St_LastName=LastName.getText().toString().trim();
                 St_Occupation=Occupation.getText().toString().trim();

                if(TextUtils.isEmpty(St_Email))
                {
                    Toast.makeText(Registration.this, "Enter Email ...!", Toast.LENGTH_SHORT).show();
                    return;
                }else if(TextUtils.isEmpty(St_Pass))
                {
                    Toast.makeText(Registration.this, "Enter Password ...!", Toast.LENGTH_SHORT).show();
                    return;
                }
                dialog.setMessage("Signing up ...!");
                dialog.show();
                firebaseAuth.createUserWithEmailAndPassword(St_Email,St_Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if(task.isSuccessful())
                        {
                            Regist();
                           // Toast.makeText(Registration.this, "Success", Toast.LENGTH_SHORT).show();
                           // dialog.dismiss();
                            //finish();
                        }else {
                            //Toast.makeText(Registration.this, "Failed", Toast.LENGTH_SHORT).show();
                            //dialog.dismiss();
                        }

                    }
                });


            }
        });

    }
    void Regist()
    {
        RegistrationData data=new RegistrationData(St_FirstName,St_LastName,St_Occupation,St_Email);
        databaseReference.child(firebaseAuth.getUid()).child("Info").setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    dialog.dismiss();
                    Toast.makeText(Registration.this, "Registration Successful ..!", Toast.LENGTH_SHORT).show();
                    finish();
                    Intent home=new Intent(Registration.this,Home.class);
                    startActivity(home);
                }else
                {
                    Toast.makeText(Registration.this, "Registration Failed ...!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent log=new Intent(Registration.this,Login.class);
        startActivity(log);
        super.onBackPressed();
    }
}

package com.foslipy.languagetutorial;

import android.app.ProgressDialog;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        SignIn=findViewById(R.id.BT_Sign_In);
        FirstName=findViewById(R.id.ET_First_name);
        LastName=findViewById(R.id.ET_Last_name);
        Email=findViewById(R.id.ET_Email);
        Pass=findViewById(R.id.ET_Pass);
        Occupation=findViewById(R.id.ET_Occupation);
        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        dialog=new ProgressDialog(this);
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String St_Email=Email.getText().toString().trim();
                String St_Pass=Pass.getText().toString().trim();
                String St_FirstName=FirstName.getText().toString().trim();
                String St_LastName=LastName.getText().toString().trim();
                String St_Occupation=Occupation.getText().toString().trim();

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
                    }
                });
                RegistrationData data=new RegistrationData(St_FirstName,St_LastName,St_Occupation,St_Email);
                databaseReference.child(firebaseAuth.getUid()).child("Info").setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            dialog.dismiss();
                            Toast.makeText(Registration.this, "Registration Successful ..!", Toast.LENGTH_SHORT).show();
                        }else
                        {
                            Toast.makeText(Registration.this, "Signing Failed ...!", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    }
                });


            }
        });

    }
}

package com.foslipy.languagetutorial;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfile extends AppCompatActivity {

    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    String User_First_Name,User_Last_Name,User_Email,User_Occupation;
    EditText First_Name,Last_Name,Email,Occupation;
    Button Update;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        First_Name=findViewById(R.id.EditProfile_First_name);
        Last_Name=findViewById(R.id.EditProfile_last_name);
        Email=findViewById(R.id.EditProfile_Email);
        Occupation=findViewById(R.id.EditProfile_Occupation);
        Update=findViewById(R.id.EditProfile_update_button);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        firebaseAuth=FirebaseAuth.getInstance();
        dialog=new ProgressDialog(this);

        User_First_Name=getIntent().getExtras().getString("First_Name");
        User_Last_Name=getIntent().getExtras().getString("Last_Name");
        User_Email=getIntent().getExtras().getString("Email");
        User_Occupation=getIntent().getExtras().getString("Occupation");

        First_Name.setText(User_First_Name);
        Last_Name.setText(User_Last_Name);
        Email.setText(User_Email);
        Occupation.setText(User_Occupation);

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User_First_Name=First_Name.getText().toString();
                User_Last_Name=Last_Name.getText().toString();
                User_Email=Email.getText().toString();
                User_Occupation=Occupation.getText().toString();

                if(TextUtils.isEmpty(User_First_Name))
                {
                    Toast.makeText(EditProfile.this, "Enter Email ...!", Toast.LENGTH_SHORT).show();
                    return;
                }else if(TextUtils.isEmpty(User_Last_Name))
                {
                    Toast.makeText(EditProfile.this, "Enter Email ...!", Toast.LENGTH_SHORT).show();
                    return;
                }else if(TextUtils.isEmpty(User_Email))
                {
                    Toast.makeText(EditProfile.this, "Enter Email ...!", Toast.LENGTH_SHORT).show();
                    return;
                }else if(TextUtils.isEmpty(User_Occupation))
                {
                    Toast.makeText(EditProfile.this, "Enter Email ...!", Toast.LENGTH_SHORT).show();
                    return;
                }
                dialog.setMessage("Updating...!");
                dialog.show();
                RegistrationData edit = new RegistrationData(User_First_Name,User_Last_Name,User_Occupation,User_Email);
                databaseReference.child(firebaseAuth.getUid()).child("Info").setValue(edit).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful())
                        {
                            dialog.dismiss();
                            finish();
                        }else
                            {
                            Toast.makeText(EditProfile.this, "Profile Has been Updated ", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }
        });

    }
}

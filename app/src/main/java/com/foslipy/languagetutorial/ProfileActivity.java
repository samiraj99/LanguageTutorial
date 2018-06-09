package com.foslipy.languagetutorial;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

DatabaseReference databaseReference;
TextView Image_first_name,First_name,Last_name,Email,Occupation;
FirebaseUser user;
String uid;
ProgressDialog dialog;
Button Edit;
String User_first_name,User_last_name,User_email,User_occupation;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        user= FirebaseAuth.getInstance().getCurrentUser();
        uid=user.getUid();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        Image_first_name=findViewById(R.id.Profile_Image_first_name);
        First_name=findViewById(R.id.Profile_first_name);
        Last_name=findViewById(R.id.Profile_last_name);
        Email=findViewById(R.id.Profile_email);
        Occupation=findViewById(R.id.Profile_occupation);
        Edit=findViewById(R.id.Profile_button_edit);
        dialog=new ProgressDialog(this);

        dialog.setMessage("Loading..!");
        dialog.show();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 User_first_name=dataSnapshot.child(uid).child("Info").child("FirstName").getValue(String.class);
                 User_last_name=dataSnapshot.child(uid).child("Info").child("LastName").getValue(String.class);
                 User_email=dataSnapshot.child(uid).child("Info").child("Email").getValue(String.class);
                 User_occupation=dataSnapshot.child(uid).child("Info").child("Occupation").getValue(String.class);

                Image_first_name.setText(User_first_name);
                First_name.setText(User_first_name);
                Last_name.setText(User_last_name);
                Email.setText(User_email);
                Occupation.setText(User_occupation);

                if (User_email.length()>1)
                {
                    dialog.dismiss();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent edit = new Intent(ProfileActivity.this,EditProfile.class);
                edit.putExtra("First_Name",User_first_name);
                edit.putExtra("Last_Name",User_last_name);
                edit.putExtra("Email",User_email);
                edit.putExtra("Occupation",User_occupation);
                startActivity(edit);
            }
        });

    }
}

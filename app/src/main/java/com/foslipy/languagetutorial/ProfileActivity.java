package com.foslipy.languagetutorial;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        dialog=new ProgressDialog(this);

        dialog.setMessage("Loading..!");
        dialog.show();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String User_first_name=dataSnapshot.child(uid).child("Info").child("FirstName").getValue(String.class);
                String User_last_name=dataSnapshot.child(uid).child("Info").child("LastName").getValue(String.class);
                String User_email=dataSnapshot.child(uid).child("Info").child("Email").getValue(String.class);
                String User_occupation=dataSnapshot.child(uid).child("Info").child("Occupation").getValue(String.class);

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
    }
}

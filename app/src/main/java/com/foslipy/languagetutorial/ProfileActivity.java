package com.foslipy.languagetutorial;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

DatabaseReference databaseReference;
TextInputEditText First_name,Last_name,Occupation;
TextView Image_first_name,Email;
FirebaseUser user;
String uid;
ProgressDialog dialog;
TextView Btn_Edit,Btn_Done;
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
        Email=findViewById(R.id.Profile_image_email);
        Occupation=findViewById(R.id.Profile_occupation);
        Btn_Done=findViewById(R.id.Profile_button_done);
        Btn_Edit=findViewById(R.id.Profile_button_edit);

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

        Btn_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                First_name.setEnabled(true);
                Last_name.setEnabled(true);
                Occupation.setEnabled(true);
                Btn_Done.setVisibility(View.VISIBLE);
                Btn_Edit.setVisibility(View.INVISIBLE);
            }
        });

        Btn_Done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User_first_name=First_name.getText().toString();
                User_last_name=Last_name.getText().toString();
                User_occupation=Occupation.getText().toString();

                if(TextUtils.isEmpty(User_first_name))
                {
                    First_name.setError("Fields can't be Empty");
                }else if(TextUtils.isEmpty(User_last_name))
                {
                    Last_name.setError("Fields can't be Empty");
                }else if(TextUtils.isEmpty(User_occupation))
                {
                    Last_name.setError("Fields can't be Empty");
                }else {
                    RegistrationData data = new RegistrationData(User_first_name, User_last_name, User_occupation, User_email);
                    databaseReference.child(uid).child("Info").setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful())
                            {

                                First_name.setEnabled(false);
                                Last_name.setEnabled(false);
                                Occupation.setEnabled(false);
                                Btn_Done.setVisibility(View.INVISIBLE);
                                Btn_Edit.setVisibility(View.VISIBLE);
                                First_name.setFocusable(false);
                                Last_name.setFocusable(false);
                                Occupation.setFocusable(false);
                                Toast.makeText(ProfileActivity.this, "Profile has been updated", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ProfileActivity.this, "Check Internet Connection", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });
    }
}

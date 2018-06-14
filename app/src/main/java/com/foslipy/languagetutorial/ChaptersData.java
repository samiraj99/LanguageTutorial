package com.foslipy.languagetutorial;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ChaptersData extends AppCompatActivity {

    DatabaseReference databaseReference;
    TextView SectionName,SectionData,SectionExample,text_example;
    String Level,Chapter_no,Section_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters_data);
        Level=getIntent().getExtras().getString("Level");
        Chapter_no=getIntent().getExtras().getString("Chapter_no");
        Section_no=getIntent().getExtras().getString("Section_no");
        databaseReference= FirebaseDatabase.getInstance().getReference();
        SectionName=findViewById(R.id.SectionName);
        SectionData=findViewById(R.id.SectionData);
        SectionExample=findViewById(R.id.SectionExample);
        text_example=findViewById(R.id.text_view_example);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override



            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              String section_name=  dataSnapshot.child("Languages").child("Java").child(Level).child(Chapter_no).child("Sections").child(Section_no).child("SectionName").getValue(String.class);
              String section_data=  dataSnapshot.child("Languages").child("Java").child(Level).child(Chapter_no).child("Sections").child(Section_no).child("SectionData").getValue(String.class);
              String section_example=dataSnapshot.child("Languages").child("Java").child(Level).child(Chapter_no).child("Sections").child(Section_no).child("SectionExample").getValue(String.class);

              SectionName.setText(section_name);
              SectionData.setText(section_data);
              SectionExample.setText(section_example);

                if (section_example == null)
              {
                  text_example.setVisibility(View.INVISIBLE);
                  SectionExample.setVisibility(View.INVISIBLE);
              }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}

package com.foslipy.languagetutorial;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class ChaptersData extends AppCompatActivity {

    DatabaseReference databaseReference;
    TextView SectionName,SectionData;
    String Level,Chapter_no,Section_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters_data);
        Level=getIntent().getExtras().getString("Level");
        Chapter_no=getIntent().getExtras().getString("Chapter_no");
        Section_no=getIntent().getExtras().getString("Section_no");
        databaseReference= FirebaseDatabase.getInstance().getReference();
        SectionName=findViewById(R.id.ChapterName);
        SectionData=findViewById(R.id.ChapterData);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              String chapter_name=  dataSnapshot.child("Languages").child("JAVA").child(Level).child(Chapter_no).child(Section_no).child("SectionName").getValue(String.class);
              String chapter_data=  dataSnapshot.child("Languages").child("JAVA").child(Level).child(Chapter_no).child(Section_no).child("SectionData").getValue(String.class);
              SectionName.setText(chapter_name);
              SectionData.setText(chapter_data);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}

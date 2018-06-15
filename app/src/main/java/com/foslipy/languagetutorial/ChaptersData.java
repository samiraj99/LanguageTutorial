package com.foslipy.languagetutorial;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ChaptersData extends AppCompatActivity {

    DatabaseReference databaseReference;
    TextView SectionName, SectionData, SectionExample, text_example;
    String Level, Chapter_no,Chapter_name,Section_no,Section_name,Section_data,Section_example;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters_data);
        Level = getIntent().getExtras().getString("Level");
        Chapter_no = getIntent().getExtras().getString("Chapter_no");
        Chapter_name=getIntent().getExtras().getString("chpter_name");
        Section_no = getIntent().getExtras().getString("Section_no");
        databaseReference = FirebaseDatabase.getInstance().getReference();
        SectionName = findViewById(R.id.SectionName);
        SectionData = findViewById(R.id.SectionData);
        SectionExample = findViewById(R.id.SectionExample);
        text_example = findViewById(R.id.text_view_example);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Section_name = dataSnapshot.child("Languages").child("Java").child(Level).child(Chapter_no).child("Sections").child(Section_no).child("SectionName").getValue(String.class);
                Section_data = dataSnapshot.child("Languages").child("Java").child(Level).child(Chapter_no).child("Sections").child(Section_no).child("SectionData").getValue(String.class);
                Section_example = dataSnapshot.child("Languages").child("Java").child(Level).child(Chapter_no).child("Sections").child(Section_no).child("SectionExample").getValue(String.class);

                SectionName.setText(Section_name);
                SectionData.setText(Section_data);
                SectionExample.setText(Section_example);

                if (Section_example == null) {
                    text_example.setVisibility(View.INVISIBLE);
                    SectionExample.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        db = new DatabaseHelper(this);
        db.addContent(Level,Chapter_no,Chapter_name,Section_no,Section_name,Section_data,Section_example);
        Toast.makeText(this,"Values Saved",Toast.LENGTH_LONG).show();



    }
}

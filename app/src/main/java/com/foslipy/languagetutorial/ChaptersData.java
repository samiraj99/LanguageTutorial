package com.foslipy.languagetutorial;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.DragAndDropPermissions;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ChaptersData extends AppCompatActivity {

    DatabaseReference databaseReference;
    TextView SectionName, SectionData, SectionExample, text_example, temptv;
    String Level, Chapter_no, Chapter_name, Section_no, Section_name, Section_data, Section_example;
    Context ctx = this;
    DatabaseHelper offlineDB;
    ConnectionDetector connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapters_data);
        Level = getIntent().getExtras().getString("Level");
        Chapter_no = getIntent().getExtras().getString("Chapter_no");
        Chapter_name = getIntent().getExtras().getString("chapter_name");
        Section_no = getIntent().getExtras().getString("Section_no");
        databaseReference = FirebaseDatabase.getInstance().getReference();
        SectionName = findViewById(R.id.SectionName);
        SectionData = findViewById(R.id.SectionData);
        SectionExample = findViewById(R.id.SectionExample);
        text_example = findViewById(R.id.text_view_example);
        connection = new ConnectionDetector(this);
        offlineDB = new DatabaseHelper(ctx);

        if (connection.isConnected()) {
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



                        Cursor cr1 = offlineDB.getData(Level, Chapter_no, Chapter_name, Section_no);
                        if(cr1.getCount()==0)
                        {
                            offlineDB.putData(Level, Chapter_no, Chapter_name, Section_no, Section_name, Section_data, Section_example);
                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        if(!connection.isConnected()){

            Cursor cr = offlineDB.getData(Level, Chapter_no, Chapter_name, Section_no);
            if (cr.moveToFirst()) {
                do {
                    String name, data, example;
                    name = cr.getString(0);
                    data = cr.getString(1);
                    example = cr.getString(2);
                    SectionName.setText(name);
                    SectionData.setText(data);
                    SectionExample.setText(example);
                    if (example == null) {
                        text_example.setVisibility(View.INVISIBLE);
                        SectionExample.setVisibility(View.INVISIBLE);
                    }

                } while (cr.moveToNext());
            }else {
                ShowwMessage("No Data Found","");
            }
        }
    }

    public void ShowwMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}

package com.foslipy.languagetutorial;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SectionList extends AppCompatActivity {

    ListView list;
    ArrayList<String> SectionNames = new ArrayList<>();
    String Level, Chapter_no, Chapter_name;
    DatabaseHelper offlineDB;
    ConnectionDetector cd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_list);
        list = findViewById(R.id.List_view);
        Level = getIntent().getExtras().getString("Level");
        Chapter_no = getIntent().getExtras().getString("Chapter_no");
        Chapter_name = getIntent().getExtras().getString("chapter_name");

        TextView pageTitle = findViewById(R.id.pageTitle);
        pageTitle.setText(Chapter_name);

        cd = new ConnectionDetector(this);

        if (cd.isConnected()) {

            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Languages").child("Java").child(Level).child(Chapter_no).child("Sections");
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Section section = snapshot.getValue(Section.class);
                        if (section != null) {
                            SectionNames.add(section.SectionName);
                        }
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SectionNames);
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent ChData = new Intent(SectionList.this, ChaptersData.class);
                    int no = i + 1;
                    ChData.putExtra("Level", Level);
                    ChData.putExtra("Chapter_no", Chapter_no);
                    ChData.putExtra("chapter_name", Chapter_name);
                    ChData.putExtra("Section_no", "Section" + no);
                    startActivity(ChData);
                }
            });

        }
        if (!cd.isConnected()) {
            ArrayList<String> SectionNames2 = new ArrayList<>();
            offlineDB = new DatabaseHelper(this);
            Cursor sectnames = offlineDB.getSectioNames(Level, Chapter_name);
            if (sectnames.moveToFirst()) {
                do {
                    String sect;
                    sect = sectnames.getString(0);
                    SectionNames2.add(sect);
                } while (sectnames.moveToNext());

            } else {
                ShowwMessage("No Data Found","Please conect to the Internet");
            }
            ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, SectionNames2);
            list.setAdapter(adapter2);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent ChData = new Intent(SectionList.this, ChaptersData.class);
                    int no = i + 1;
                    ChData.putExtra("Level", Level);
                    ChData.putExtra("Chapter_no", Chapter_no);
                    ChData.putExtra("chapter_name", Chapter_name);
                    ChData.putExtra("Section_no", "Section" + no);
                    startActivity(ChData);
                }
            });
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

package com.foslipy.languagetutorial;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BeginnersLevelFragment extends Fragment {
    View view;
    CardView CH1, CH2, CH3, CH4, CH5, CH6, CH7, CH8, CH9, CH10;
    TextView chapter1name, chapter2name, chapter3name, chapter4name, chapter5name, chapter6name, chapter7name, chapter8name, chapter9name, chapter10name;
    String Level = "Beginners";
    DatabaseHelper offlineDb;
    ConnectionDetector connection;
    ArrayList<String> chapNames;
    ArrayList<String> chapNo;
    DatabaseReference db;
    String Language;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.beginners_fragment_layout, container, false);

        Language = Helper.language;


        CH1 = view.findViewById(R.id.CardView_Beginners_chapter_1);
        CH2 = view.findViewById(R.id.CardView_Beginners_chapter_2);
        CH3 = view.findViewById(R.id.CardView_Beginners_chapter_3);
        CH4 = view.findViewById(R.id.CardView_Beginners_chapter_4);
        CH5 = view.findViewById(R.id.CardView_Beginners_chapter_5);
        CH6 = view.findViewById(R.id.CardView_Beginners_chapter_6);
        CH7 = view.findViewById(R.id.CardView_Beginners_chapter_7);
        CH8 = view.findViewById(R.id.CardView_Beginners_chapter_8);
        CH9 = view.findViewById(R.id.CardView_Beginners_chapter_9);
        CH10 = view.findViewById(R.id.CardView_Beginners_chapter_10);

        chapter1name = view.findViewById(R.id.chapter1);
        chapter2name = view.findViewById(R.id.chapter2);
        chapter3name = view.findViewById(R.id.chapter3);
        chapter4name = view.findViewById(R.id.chapter4);
        chapter5name = view.findViewById(R.id.chapter5);
        chapter6name = view.findViewById(R.id.chapter6);
        chapter7name = view.findViewById(R.id.chapter7);
        chapter8name = view.findViewById(R.id.chapter8);
        chapter9name = view.findViewById(R.id.chapter9);
        chapter10name = view.findViewById(R.id.chapter10);

        offlineDb = new DatabaseHelper(getActivity());
        connection = new ConnectionDetector(getActivity());
        chapNames = new ArrayList<>();
        chapNo = new ArrayList<>();


        if (connection.isConnected()) {

            db = FirebaseDatabase.getInstance().getReference();
            db.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String chapter_name = dataSnapshot.child("Languages").child(Language).child(Level).child("Chapter1").child("ChapterName").getValue(String.class);
                    chapter1name.setText(chapter_name);
                    chapter_name = dataSnapshot.child("Languages").child(Language).child(Level).child("Chapter2").child("ChapterName").getValue(String.class);
                    chapter2name.setText(chapter_name);
                    chapter_name = dataSnapshot.child("Languages").child(Language).child(Level).child("Chapter3").child("ChapterName").getValue(String.class);
                    chapter3name.setText(chapter_name);
                    chapter_name = dataSnapshot.child("Languages").child(Language).child(Level).child("Chapter4").child("ChapterName").getValue(String.class);
                    chapter4name.setText(chapter_name);
                    chapter_name = dataSnapshot.child("Languages").child(Language).child(Level).child("Chapter5").child("ChapterName").getValue(String.class);
                    chapter5name.setText(chapter_name);
                    chapter_name = dataSnapshot.child("Languages").child(Language).child(Level).child("Chapter6").child("ChapterName").getValue(String.class);
                    chapter6name.setText(chapter_name);
                    chapter_name = dataSnapshot.child("Languages").child(Language).child(Level).child("Chapter7").child("ChapterName").getValue(String.class);
                    chapter7name.setText(chapter_name);
                    chapter_name = dataSnapshot.child("Languages").child(Language).child(Level).child("Chapter8").child("ChapterName").getValue(String.class);
                    chapter8name.setText(chapter_name);
                    chapter_name = dataSnapshot.child("Languages").child(Language).child(Level).child("Chapter9").child("ChapterName").getValue(String.class);
                    chapter9name.setText(chapter_name);
                    chapter_name = dataSnapshot.child("Languages").child(Language).child(Level).child("Chapter10").child("ChapterName").getValue(String.class);
                    chapter10name.setText(chapter_name);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }
        if (!connection.isConnected()) {
            Toast.makeText(getActivity(), "Your are Offline", Toast.LENGTH_LONG).show();
            Cursor chapnames = offlineDb.getChapterNames(Language, Level);
            if (chapnames.moveToFirst()) {
                do {
                    String sect;
                    String cp;
                    cp = chapnames.getString(0);
                    sect = chapnames.getString(1);
                    chapNames.add(sect);
                    chapNo.add(cp);
                } while (chapnames.moveToNext());
                chapter1name.setText(chapNames.get(0));
            }
        }

        CH1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                SecList.putExtra("Level", Level);
                SecList.putExtra("Language", Language);
                SecList.putExtra("Chapter_no", "Chapter1");
                SecList.putExtra("chapter_name", chapter1name.getText().toString());
                startActivity(SecList);
            }
        });

        CH2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                SecList.putExtra("Level", Level);
                SecList.putExtra("Language", Language);
                SecList.putExtra("Chapter_no", "Chapter2");
                SecList.putExtra("chapter_name", chapter2name.getText().toString());
                startActivity(SecList);
            }
        });

        CH3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                SecList.putExtra("Level", Level);
                SecList.putExtra("Language", Language);
                SecList.putExtra("Chapter_no", "Chapter3");
                SecList.putExtra("chapter_name", chapter3name.getText().toString());
                startActivity(SecList);
            }
        });

        CH4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                SecList.putExtra("Level", Level);
                SecList.putExtra("Language", Language);
                SecList.putExtra("Chapter_no", "Chapter4");
                SecList.putExtra("chapter_name", chapter4name.getText().toString());
                startActivity(SecList);
            }
        });

        CH5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                SecList.putExtra("Level", Level);
                SecList.putExtra("Language", Language);
                SecList.putExtra("Chapter_no", "Chapter5");
                SecList.putExtra("Chapter_name", chapter5name.getText().toString());
                startActivity(SecList);
            }
        });

        CH6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                SecList.putExtra("Level", Level);
                SecList.putExtra("Language", Language);
                SecList.putExtra("Chapter_no", "Chapter6");
                SecList.putExtra("Chapter_name", chapter6name.getText().toString());
                startActivity(SecList);
            }
        });

        CH7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                SecList.putExtra("Level", Level);
                SecList.putExtra("Language", Language);
                SecList.putExtra("Chapter_no", "Chapter7");
                SecList.putExtra("Chapter_name", chapter7name.getText().toString());
                startActivity(SecList);
            }
        });
        CH8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                SecList.putExtra("Level", Level);
                SecList.putExtra("Language", Language);
                SecList.putExtra("Chapter_no", "Chapter8");
                SecList.putExtra("Chapter_name", chapter8name.getText().toString());
                startActivity(SecList);
            }
        });
        CH9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                SecList.putExtra("Level", Level);
                SecList.putExtra("Language", Language);
                SecList.putExtra("Chapter_no", "Chapter9");
                SecList.putExtra("Chapter_name", chapter9name.getText().toString());
                startActivity(SecList);
            }
        });
        CH10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                SecList.putExtra("Level", Level);
                SecList.putExtra("Language", Language);
                SecList.putExtra("Chapter_no", "Chapter10");
                SecList.putExtra("Chapter_name", chapter10name.getText().toString());
                startActivity(SecList);
            }
        });

        FloatingActionButton fab_button_quiz;
        fab_button_quiz = view.findViewById(R.id.Float_button_quiz);
        fab_button_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quizlist = new Intent(getActivity(), QuizList.class);
                quizlist.putExtra("Level", Level);
                startActivity(quizlist);
            }
        });

        return view;
    }

}

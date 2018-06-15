package com.foslipy.languagetutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BeginnersLevelFragment extends Fragment {
    View view;
    CardView CH1, CH2, CH3, CH4, CH5, CH6, CH7, CH8, CH9, CH10;
    DatabaseReference db;
    TextView chapter1name, chapter2name, chapter3name, chapter4name;
    String Level = "Beginners";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.beginners_fragment_layout, container, false);

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

        db = FirebaseDatabase.getInstance().getReference();
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String chapter_name = dataSnapshot.child("Languages").child("Java").child("Beginners").child("Chapter1").child("ChapterName").getValue(String.class);
                chapter1name.setText(chapter_name);
                chapter_name = dataSnapshot.child("Languages").child("Java").child("Beginners").child("Chapter2").child("ChapterName").getValue(String.class);
                chapter2name.setText(chapter_name);
                chapter_name = dataSnapshot.child("Languages").child("Java").child("Beginners").child("Chapter3").child("ChapterName").getValue(String.class);
                chapter3name.setText(chapter_name);
                chapter_name =dataSnapshot.child("Languages").child("Java").child("Beginners").child("Chapter4").child("ChapterName").getValue(String.class);
                chapter4name.setText(chapter_name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        CH1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                String chname=chapter1name.getText().toString();
                SecList.putExtra("Level", Level);
                SecList.putExtra("Chapter_no", "Chapter1");
                SecList.putExtra("chapter_name",chname);
                startActivity(SecList);
            }
        });

        CH2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), ChaptersData.class);
                String chmane=chapter1name.getText().toString();
                SecList.putExtra("Level", Level);
                SecList.putExtra("Chapter_no", "Chapter2");
                SecList.putExtra("chapter_name",chmane);
                startActivity(SecList);
            }
        });

        CH3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                String chmane=chapter1name.getText().toString();
                SecList.putExtra("Level", Level);
                SecList.putExtra("Chapter_no", "Chapter1");
                SecList.putExtra("chapter_name",chmane);
                startActivity(SecList);
            }
        });

        CH4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                String chmane=chapter1name.getText().toString();
                SecList.putExtra("Level", Level);
                SecList.putExtra("Chapter_no", "Chapter1");
                SecList.putExtra("chapter_name",chmane);
                startActivity(SecList);
            }
        });

        CH5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                SecList.putExtra("Level", Level);
                SecList.putExtra("Chapter_no", "Chapter1");
                startActivity(SecList);
            }
        });

        CH6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                SecList.putExtra("Level", Level);
                SecList.putExtra("Chapter_no", "Chapter1");
                startActivity(SecList);
            }
        });

        CH7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                SecList.putExtra("Level", Level);
                SecList.putExtra("Chapter_no", "Chapter1");
                startActivity(SecList);
            }
        });
        CH8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                SecList.putExtra("Level", Level);
                SecList.putExtra("Chapter_no", "Chapter1");
                startActivity(SecList);
            }
        });
        CH9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                SecList.putExtra("Level", Level);
                SecList.putExtra("Chapter_no", "Chapter1");
                startActivity(SecList);
            }
        });
        CH10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                SecList.putExtra("Level", Level);
                SecList.putExtra("Chapter_no", "Chapter1");
                startActivity(SecList);
            }
        });

        return view;
    }

}

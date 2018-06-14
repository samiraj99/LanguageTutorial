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

public class ExpertLevelFragment extends Fragment {
    View view;
    CardView CH1, CH2, CH3, CH4, CH5, CH6, CH7, CH8, CH9, CH10;
    String Level = "Experts";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.expert_fragment_layout, container, false);


        CH1 = view.findViewById(R.id.CardView_Expert_chapter_1);
        CH2 = view.findViewById(R.id.CardView_Expert_chapter_2);
        CH3 = view.findViewById(R.id.CardView_Expert_chapter_3);
        CH4 = view.findViewById(R.id.CardView_Expert_chapter_4);
        CH5 = view.findViewById(R.id.CardView_Expert_chapter_5);
        CH6 = view.findViewById(R.id.CardView_Expert_chapter_6);
        CH7 = view.findViewById(R.id.CardView_Expert_chapter_7);
        CH8 = view.findViewById(R.id.CardView_Expert_chapter_8);
        CH9 = view.findViewById(R.id.CardView_Expert_chapter_9);
        CH10 = view.findViewById(R.id.CardView_Expert_chapter_10);


        CH1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                SecList.putExtra("Level", Level);
                SecList.putExtra("Chapter_no", "Chapter1");
                startActivity(SecList);
            }
        });

        CH2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), ChaptersData.class);
                SecList.putExtra("Level", Level);
                SecList.putExtra("Chapter_no", "Chapter2");
                startActivity(SecList);
            }
        });

        CH3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                SecList.putExtra("Level", Level);
                SecList.putExtra("Chapter_no", "Chapter1");
                startActivity(SecList);
            }
        });

        CH4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SecList = new Intent(getActivity(), SectionList.class);
                SecList.putExtra("Level", Level);
                SecList.putExtra("Chapter_no", "Chapter1");
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

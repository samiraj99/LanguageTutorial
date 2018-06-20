package com.foslipy.languagetutorial;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class QuizList extends AppCompatActivity {

    ListView listView;
    ArrayList<String> QuizNames=new ArrayList<>();
    String Level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_list);

        Level=getIntent().getExtras().getString("Level");

        listView=findViewById(R.id.List_view_quiz);

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("Languages").child("Java").child(Level);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){

                    Quiz quiz=snapshot.getValue(Quiz.class);
                    if (quiz != null) {
                        QuizNames.add(quiz.ChapterName);
                    }
                }

                AddArrayListView();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent QuizPage = new Intent(QuizList.this,QuizActivity.class);
                int no=i+1;
                QuizPage.putExtra("Level",Level);
                QuizPage.putExtra("ChapterNo","Chapter"+no);
                QuizPage.putExtra("QuizNo",no);
                startActivity(QuizPage);
            }
        });

    }

    private void AddArrayListView() {

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, QuizNames);
        listView.setAdapter(adapter);
    }
}

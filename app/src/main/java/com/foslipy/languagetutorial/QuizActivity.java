package com.foslipy.languagetutorial;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Console;
import java.util.ArrayList;
import java.util.Objects;

public class QuizActivity extends AppCompatActivity {

    String Level,Chapter_No,Answer;
    ArrayList<String> QuestionNames=new ArrayList<>();
    ArrayList<String> QuestionAnswer=new ArrayList<>();
    ArrayList<String> Option1=new ArrayList<>();
    ArrayList<String> Option2=new ArrayList<>();
    ArrayList<String> Option3=new ArrayList<>();
    ArrayList<String> Option4=new ArrayList<>();
    int count=0;
    TextView QuestionName;
    RadioGroup radioGroup;
    RadioButton radioButton;
    RadioButton Radio_btn_Option1,Radio_btn_Option2,Radio_btn_Option3,Radio_btn_Option4;
    Button Next;
    int Limit=0,Marks=0,QuizNo;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        databaseReference=FirebaseDatabase.getInstance().getReference();
        firebaseAuth=FirebaseAuth.getInstance();
        QuestionName=findViewById(R.id.QuestionName);
        Radio_btn_Option1=findViewById(R.id.Radio_button_Option1);
        Radio_btn_Option2=findViewById(R.id.Radio_button_Option2);
        Radio_btn_Option3=findViewById(R.id.Radio_button_Option3);
        Radio_btn_Option4=findViewById(R.id.Radio_button_Option4);
        Next=findViewById(R.id.Button_next);
        Level=getIntent().getExtras().getString("Level");
        Chapter_No=getIntent().getExtras().getString("ChapterNo");
        QuizNo=getIntent().getExtras().getInt("QuizNo");
        radioGroup=findViewById(R.id.Radio_group);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Languages").child("Java").child(Level).child(Chapter_No).child("Quiz");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot:dataSnapshot.getChildren()){

                    Quiz quiz=snapshot.getValue(Quiz.class);
                    if (quiz != null) {
                        QuestionNames.add(quiz.QuestionName);
                        Option1.add(quiz.Option1);
                        Option2.add(quiz.Option2);
                        Option3.add(quiz.Option3);
                        Option4.add(quiz.Option4);
                        QuestionAnswer.add(quiz.QuestionAnswer);
                        Limit++;
                    }


                }
                AddData();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


      Next.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              if(radioGroup.getCheckedRadioButtonId() == -1)
              {
                  Toast.makeText(QuizActivity.this, "Select Option ..!", Toast.LENGTH_SHORT).show();
                  return;
              }

              if (count==Limit-2)
              {
                  Next.setText("Finish");
              }
              if (count < Limit-1) {
                  count++;
                  CheckAnswer();
                  AddData();
              }
              else
              {

                  if((Marks*100)/Limit>=50)
                  {
                      databaseReference.child("Users").child(firebaseAuth.getUid()).child("Progress").child(Helper.language).child(Level).child("Quizzes").child("Quiz"+QuizNo).setValue("IsCompleted");
                  }
                  Intent result = new Intent(QuizActivity.this,QuizResult.class);
                  result.putExtra("TotalQuestions",Limit);
                  result.putExtra("CorrectAns",Marks);
                  startActivity(result);
                  finish();

              }
          }
      });

    }

    private void CheckAnswer() {

        int selectId=radioGroup.getCheckedRadioButtonId();
        radioButton=findViewById(selectId);
        if (Objects.equals(Answer, radioButton.getText().toString()))
        {
            Marks++;
        }
        radioGroup.clearCheck();
    }

    private void AddData() {
        QuestionName.setText(QuestionNames.get(count));
        Radio_btn_Option1.setText(Option1.get(count));
        Radio_btn_Option2.setText(Option2.get(count));
        Radio_btn_Option3.setText(Option3.get(count));
        Radio_btn_Option4.setText(Option4.get(count));
        Answer=QuestionAnswer.get(count);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder=new AlertDialog.Builder(QuizActivity.this);
        builder.setTitle("Alert");
        builder.setMessage("You can't go back. \n Data will be lost.");
        builder.setIcon(R.drawable.icons8_error_64);
        builder.setCancelable(false);

        builder.setPositiveButton(
                "Cancel",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        builder.setNegativeButton(
                "Exit",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
        builder.create();
        builder.show();

    }
}


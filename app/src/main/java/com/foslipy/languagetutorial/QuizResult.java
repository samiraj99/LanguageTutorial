package com.foslipy.languagetutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class QuizResult extends AppCompatActivity {

    TextView Total,Marks;
    int total;
    int marks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        Total=findViewById(R.id.Total_que);
        Marks=findViewById(R.id.Correct_ans);

        total=getIntent().getExtras().getInt("TotalQuestions");
        marks=getIntent().getExtras().getInt("CorrectAns");

        Toast.makeText(this, ""+total, Toast.LENGTH_SHORT).show();
        Total.setText(""+total);
        Marks.setText(""+marks);

    }
}

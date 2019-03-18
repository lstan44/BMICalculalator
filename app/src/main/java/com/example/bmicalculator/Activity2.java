package com.example.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Intent intent = getIntent();
        String t = intent.getStringExtra("title");
        String bmiText = intent.getStringExtra("bmi");
        String comment = intent.getStringExtra("comment");

        TextView reportTitle = findViewById(R.id.reportTitle);
       TextView reportBmi = findViewById(R.id.reportBmi);
        TextView reportComment = findViewById(R.id.reportComment);
        reportTitle.setText(t);
        reportBmi.setText(bmiText);
        reportComment.setText(comment);
    }
}

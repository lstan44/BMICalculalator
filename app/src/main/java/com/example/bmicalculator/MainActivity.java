package com.example.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button calculate;
    private EditText name, height, weight;
    private String Name;
    private double Height, Weight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate = (Button)findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openActivity2();
                }
            });

    }

    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        name = findViewById(R.id.name);
        Name = name.getText().toString();

        weight = findViewById(R.id.weight);
        Weight = (Double.parseDouble(weight.getText().toString()))/2.205;

        height = findViewById(R.id.height);
        Height = (Double.parseDouble(height.getText().toString()))/39.37;

        double bmi = calculateBMI(Height, Weight);
        String title = "Health Report for "+ Name;
        String bmiText = "Your BMI is:\n"+bmi;

        intent.putExtra("bmi",bmiText);
        intent.putExtra("title",title);


        String healthLevel = "";

        if (bmi <=18.5)
            healthLevel="You are considered underweight.";
        else if (bmi>18.5 && bmi<=24.9)
            healthLevel="You are healthy.";
        else if (bmi>=25 && bmi <=29.9)
            healthLevel="You are considered overweight.";
        else
            healthLevel = "You are considered obese.";

        intent.putExtra("comment", healthLevel);

        startActivity(intent);

    }

    public double calculateBMI(double h, double w){
        return w/(h*h);
    }
}

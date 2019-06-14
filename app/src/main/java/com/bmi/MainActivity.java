package com.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonListener();
    }

    public void buttonListener()
    {
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code that 'ill run when button is pressed.
                //txt->string->double
                final EditText heightTxt= (EditText) findViewById(R.id.heightInput);
                String heightStr= heightTxt.getText().toString();
                double height = Double.parseDouble(heightStr);

                final  EditText weightTxt= (EditText) findViewById(R.id.weightInput);
                String weightStr= weightTxt.getText().toString();
                double weight= Double.parseDouble(weightStr);

                //equation to calculate BMI
                double BMI= (weight)/(height*height);
                DecimalFormat df= new DecimalFormat("#.#");
                double BMI_trimmed= Double.parseDouble(df.format(BMI));
                //display BMI value
                final  EditText BMIResult= (EditText) findViewById(R.id.BMIResult);
                BMIResult.setText(Double.toString(BMI_trimmed));
                //check category of the calculated BMI
                String BMI_cat;
                if(BMI<15)
                    BMI_cat="Very severly underweight";
                else if(BMI<16)
                    BMI_cat="Severly underweight";
                else if(BMI<18.5)
                    BMI_cat="Underweight";
                else if(BMI<25)
                    BMI_cat="Normal";
                else if(BMI<30)
                    BMI_cat="Overweight";
                else if(BMI<35)
                    BMI_cat="Obese Class 1 - Moderately Obese";
                else if(BMI<40)
                    BMI_cat="Obese Class 2 - Severely Obese";
                else
                    BMI_cat="Obese Class 3 - Very Severely Obese";

                final TextView BMICategory= (TextView) findViewById(R.id.BMICategory);
                BMICategory.setText(BMI_cat);

            }
        });
    }
}

package com.example.interest_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateResult(View trigger){
        TextView baseET =(TextView)findViewById(R.id.baseET);
        TextView interestET =(TextView)findViewById(R.id.interestET);
        TextView compoundsET =(TextView)findViewById(R.id.compoundsET);
        TextView result = (TextView)findViewById(R.id.result);

        double base  = Double.parseDouble(baseET.getText().toString());
        System.out.println("Base: " + base);
        int compound  = Integer.parseInt(compoundsET.getText().toString());
        System.out.println("Compound: " + compound);
        double interest  = Double.parseDouble(interestET.getText().toString());
        System.out.println("Interest: " + interest);
        double fractional_interest = 0;
        double total = (double)base;
        double modifier = 0;

        if(compound == 0){
            result.setText("Cannot divide by 0. Please enter another number for Compound.");
        }
        else{
            if(base < 0){
                result.setText("Cannot compute with a negative base. Please enter another number for Base");
            }
            else{
                if(interest < 0){
                    result.setText("Cannot compute with negative interest. Please enter another number for Interest");
                }
                else{
                    for(int i = 0; i < compound; i++){
                        // calculate fractional interest
                        fractional_interest = (interest / compound) / 100;

                        // calculate modifier
                        modifier = total * fractional_interest;

                        // calculate total
                        total += modifier;
                    }

                    String string = "Amount at one year is $" + df.format(total);
                    result.setText(string);
                }
            }
        }
    }

    public void compound1(View trigger){
        TextView compoundsET =(TextView)findViewById(R.id.compoundsET);
        compoundsET.setText("1");
    }

    public void compound4(View trigger){
        TextView compoundsET =(TextView)findViewById(R.id.compoundsET);
        compoundsET.setText("4");
    }

    public void compound12(View trigger){
        TextView compoundsET =(TextView)findViewById(R.id.compoundsET);
        compoundsET.setText("12");
    }

    public void compound365(View trigger){
        TextView compoundsET =(TextView)findViewById(R.id.compoundsET);
        compoundsET.setText("365");
    }
}
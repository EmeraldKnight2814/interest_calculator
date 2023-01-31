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

        int base  = Integer.parseInt(baseET.getText().toString());
        int compound  = Integer.parseInt(compoundsET.getText().toString());
        int interest  = Integer.parseInt(interestET.getText().toString());
        double fractional_interest = 0;
        double total = (double)base;
        double modifier = 0;

        for(int i = 0; i < compound; i++){
            // calculate fractional interest
            fractional_interest = (interest / compound) / 10;

            // calculate modifier
            modifier = total * fractional_interest;

            // calculate total
            total += modifier;
        }

        String string = "Amount at one year is $" + df.format(total);
        result.setText(string);
    }
}
package com.example.tipcalculator_counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText check;
    EditText numPeople;
    EditText customTip;

    TextView finalTotal;
    TextView finalDividedTotal;

    double tip = 0.0;
    double total;
    double dividedTotal;

    RadioButton tenPer;
    RadioButton fifteenPer;
    RadioButton twentyPer;
    RadioButton customPer;
    Button calcTip;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reset = findViewById(R.id.resetButton);
        check = findViewById(R.id.checkAmount);
        //numPeople = findViewById(R.id.divideNum);
        customTip = findViewById(R.id.customTip);
        finalTotal = findViewById(R.id.finalTotal);
        finalDividedTotal = findViewById(R.id.finalDividedTotal);
        tenPer = findViewById(R.id.tenPer);
        fifteenPer = findViewById(R.id.fifteenPer);
        twentyPer = findViewById(R.id.twentyPer);
        customPer = findViewById(R.id.customPer);
        calcTip = findViewById(R.id.calcButton);

        calcTip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                int subTotal = Integer.parseInt(check.getText().toString());
                int divideNum = Integer.parseInt(numPeople.getText().toString());

                if (twentyPer.isChecked()) {
                    tip = .2;
                }
                else if(fifteenPer.isChecked()) {
                    tip = .15;
                }
                else if(tenPer.isChecked()) {
                    tip = .1;
                }
                else if(customPer.isChecked()) {
                    double custom = Double.parseDouble(customTip.getText().toString());
                    tip = custom / 100.0;
                }


                total = (subTotal * tip) + subTotal;
                dividedTotal = total/divideNum;


                finalTotal.setText("$" + total);
                finalDividedTotal.setText("$" + dividedTotal);


            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                tenPer.setChecked(false);
                fifteenPer.setChecked(false);
                twentyPer.setChecked(false);
                customPer.setChecked(false);

                check.getText().clear();
                numPeople.getText().clear();

            }
        });
    }
}

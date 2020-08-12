package com.example.tips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    EditText et_bill;

    TextView tv_tip , people,  tv_tip_output, tv_total_output , waiter_total;

    Button button_tip_minus, button_tip_plus, button_people_minus, button_people_plus ,button_calculate;

    int tip_perce = 0;
    int num_of_people =1;

    double bill_amount = 100.00;

    double tip_total = 0.0;

    double total = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_bill = findViewById(R.id.et_bill);
        tv_tip = findViewById(R.id.tv_tip);
        people = findViewById(R.id.people);
        tv_tip_output = findViewById(R.id.tv_tip_output);
        tv_total_output = findViewById(R.id.tv_total_output);

        button_calculate = findViewById(R.id.button_calculate);
        button_people_minus = findViewById(R.id.button_people_minus);
        button_people_plus = findViewById(R.id.button_people_plus);
        button_tip_minus = findViewById(R.id.button_tip_minus);
        button_tip_plus = findViewById(R.id.button_tip_plus);

        waiter_total = findViewById(R.id.waiter_total);


        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_amount = et_bill.getText().toString();

                if(!input_amount.equals("")){
                    bill_amount = Double.valueOf(input_amount);
                    bill_amount = bill_amount * 100;
                    bill_amount = Math.round(bill_amount);
                    bill_amount = bill_amount / 100 ;


                   // et_bill.setText(String.format(Locale.CANADA, "%.2f" , et_bill));
                    et_bill.setText(et_bill.getText().toString());
                     tip_total =  (bill_amount * tip_perce ) / 100;

                    tip_total = tip_total * 100;
                    tip_total = Math.round(tip_total);
                    tip_total = tip_total / 100 ;

                    if(num_of_people == 1) {
                        //   tv_tip_output.setText(String.format(Locale.CANADA, "%.2f" , tip_total));
                        tv_tip_output.setText(String.valueOf(tip_total));
                        total = bill_amount + tip_total;

                        //    tv_total_output.setText(String.format(Locale.CANADA, "%.2f" , total));
                        tv_total_output.setText(String.valueOf(total));
                    }
                    else{

                        total = bill_amount + tip_total ;

                        total = total / num_of_people;

                        tv_total_output.setText(String.format("%.2f", total) + " per person");

                        tip_total = tip_total / num_of_people;
                        tv_tip_output.setText(String.format("%.2f",tip_total) + " per person");

                    }
                    double waiter_total_sum =  total * num_of_people;

                    waiter_total.setText(String.format("%.2f",waiter_total_sum));

                }
            }
        });
        button_people_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(num_of_people > 1){
                    num_of_people --;
                    people.setText(String.valueOf(num_of_people));
                }
            }
        });
        button_people_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num_of_people ++;

               people.setText(String.valueOf(num_of_people));
            }
        });
        button_tip_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tip_perce > 0){
                    tip_perce --;
                    tv_tip.setText(tip_perce+"%");
                }
            }
        });
        button_tip_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tip_perce ++;
                tv_tip.setText(tip_perce+"%");
            }
        });

    }
}

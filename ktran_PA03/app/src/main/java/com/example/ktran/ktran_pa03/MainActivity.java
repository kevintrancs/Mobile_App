package com.example.ktran.ktran_pa03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void calulcate_tip(View v){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);


        EditText init_bill = (EditText) findViewById(R.id.init_amt);
        EditText init_tip = (EditText) findViewById(R.id.init_tip);

        double bill = Double.parseDouble(init_bill.getText().toString());
        double tip = Double.parseDouble(init_tip.getText().toString());


        TipCalculator tc = new TipCalculator(bill, tip);

        TextView final_tip_amt = (TextView)findViewById(R.id.tip_amt);
        TextView final_bill_amt = (TextView)findViewById(R.id.ttl_amt);


        final_tip_amt.setText(getText(R.string.tip_amount) + " " + df.format(tc.calculateTip()));
        final_bill_amt.setText(getText(R.string.total_amount) + " " + df.format(tc.calculateTotalBill()));

    }
}

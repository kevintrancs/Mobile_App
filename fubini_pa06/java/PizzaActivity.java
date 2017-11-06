package com.example.ktran.pa06;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class PizzaActivity extends AppCompatActivity {

    double total_cost = 6.88;
    TextView textView1;
    NumberFormat formatter = new DecimalFormat("#0.00");
    private static final String STATE_LIST = "Data";
    public static final String PIZZA = "PIZZA";
    Pizza p = new Pizza();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);
        textView1 =(TextView) findViewById(R.id.total_cost);

        if (savedInstanceState != null) {
            p = (Pizza)savedInstanceState.getSerializable(STATE_LIST);

            RadioButton rb = (RadioButton) findViewById(R.id.thicc_crust);
            rb.setChecked(p.isThicc_crust());
            RadioButton rbb = (RadioButton) findViewById(R.id.thicc_crust);
            rbb.setChecked(p.isThin_crust());

            CheckBox c = (CheckBox) findViewById(R.id.pepperoni);
            c.setChecked(p.isPineapples());
            TextView pep = (TextView) findViewById(R.id.pepperoni_cost);
            if(p.isPineapples())
                pep.setText("2.00");

            CheckBox cc= (CheckBox) findViewById(R.id.fish);
            cc.setChecked(p.isFish());
            TextView fesh = (TextView) findViewById(R.id.fish_cost);
            if(p.isFish())
                fesh.setText("2.00");

            CheckBox ccc = (CheckBox) findViewById(R.id.shrooms);
            ccc.setChecked(p.isMushrroms());
            TextView shrom = (TextView) findViewById(R.id.shroom_cost);
            if(p.isMushrroms())
                shrom.setText("2.00");

            Switch s = (Switch) findViewById(R.id.glutten);
            s.setChecked(p.isGluten_free());
            TextView swit = (TextView) findViewById(R.id.glutten_cost);
            if(p.isGluten_free())
                swit.setText("2.00");

            SeekBar seekbar = (SeekBar) findViewById(R.id.cheese_bar);
            seekbar.setProgress(p.getS_bnar());
            TextView sb = (TextView) findViewById(R.id.cheese_cost);
            if(p.getS_bnar() == 100)
                sb.setText("1.00");

            TextView total = (TextView) findViewById(R.id.total_cost);
            total.setText(Double.toString(p.getCost()));

        }

        SeekBar seekbar = (SeekBar) findViewById(R.id.cheese_bar);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                TextView tv = (TextView) findViewById(R.id.cheese_cost);
                if(i == 100) {
                    tv.setText("1.00");
                    total_cost += 1.00;
                    p.setS_bnar(100);
                }
                if(i == 0){
                    tv.setText("0.00");
                    if(total_cost > 6.88)
                        total_cost -= 1.00;
                }
                p.setS_bnar(0);
                updateTotal();

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.addPizza:
                Intent intent = new Intent();
                intent.putExtra(PIZZA, p);
                setResult(Activity.RESULT_OK, intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi  = getMenuInflater();
        mi.inflate(R.menu.add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(STATE_LIST, p);
    }


    public void updateTotal(){
        textView1.setText(formatter.format(total_cost));
        p.setCost(total_cost);
    }

    public void switchButtonClicked(View view) {

        TextView tv = (TextView) findViewById(R.id.glutten_cost);
        Switch switchButton = (Switch) view;
        // we can find out it it is "checked" or not
        if (switchButton.isChecked()) {
             tv.setText("2.00");
            total_cost += 2.00;
        }
        else {
            tv.setText("0.00");
            if(total_cost > 6.88)
                total_cost -= 2.00;
        }

        p.setGluten_free(true);
        updateTotal();
    }

    public void radiobuttonClicked(View view) {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.classStandingRadioGroup);
        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        switch(radioButtonID){
            case R.id.thicc_crust:
                RadioButton rb = (RadioButton) findViewById(R.id.thicc_crust);
                if(rb.isChecked()){
                    p.setThicc_crust(true);
                    p.setThin_crust(false);
                }
                else{
                    p.setThin_crust(true);
                    p.setThicc_crust(false);
                }
                break;
            case R.id.thin_crust:
                RadioButton rbb = (RadioButton) findViewById(R.id.thicc_crust);
                if(rbb.isChecked()){
                    p.setThicc_crust(false);
                    p.setThin_crust(true);
                }
                else{
                    p.setThin_crust(false);
                    p.setThicc_crust(true);
                }
                break;
            default:
                break;
        }
    }
    public void checkboxClicked(View view) {
        // which checkbox is view referring to
        int checkboxID = view.getId();
        CheckBox checkBox = (CheckBox)view;
        // use if statements or a switch to do this
        switch(checkboxID) {
            case R.id.shrooms:
                TextView tv = (TextView) findViewById(R.id.shroom_cost);
                if(checkBox.isChecked()){
                    tv.setText("2.00");
                    total_cost += 2.00;
                    p.setMushrroms(true);
                }
                else{
                    tv.setText("0.00");
                    if(total_cost > 6.88)
                        total_cost -= 2.00;
                    p.setMushrroms(false);
                }
                break;
            case R.id.pepperoni:
                TextView tvv = (TextView) findViewById(R.id.pepperoni_cost);
                if(checkBox.isChecked()){
                    tvv.setText("2.00");
                    total_cost += 2.00;
                    p.setPineapples(true);
                }
                else{
                    tvv.setText("0.00");
                    if(total_cost > 6.88)
                        total_cost -= 2.00;
                    p.setPineapples(false);
                }
                break;
            case R.id.fish:
                TextView tvvv = (TextView) findViewById(R.id.fish_cost);
                if(checkBox.isChecked()){
                    tvvv.setText("2.00");
                    total_cost += 2.00;
                    p.setFish(true);
                }
                else{
                    tvvv.setText("0.00");
                    if(total_cost > 6.88)
                        total_cost -= 2.00;
                    p.setFish(false);
                }
                break;
        }
        updateTotal();
    }


}

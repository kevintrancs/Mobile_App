package com.example.ktran.pa06;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;


/**
 * Class: FoodMenuActivity
 * Handles the clicking of the food items.
 *
 * Methods: onOptionsItemSelected, onClickBtn, onActivityResult
 */
public class FoodMenuActivity extends AppCompatActivity {
    public static final String FOOD = "food";
    public static final int CREATE_PIZZA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);
    }

    /**
     * Checks the items we have selected in the menu. This menu returns back to main activity on same instance
     * @param item
     * @return
     */
    @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch(item.getItemId()) {
                case android.R.id.home:
                    this.finish();
                    return true;
                default:
                    return super.onOptionsItemSelected(item);
            }
    }

    /**
     *
     *  On the 4 buttons clicked, returns the intent.
     *  For pizza creates a new activity that will return the pizza to return back to main.
     * @param v
     */
    public void onClickBtn(View v) {
        Intent returnIntent = new Intent();
        FoodItem fv;
        switch(v.getId()){
            case R.id.pizza:
                fv = new FoodItem(); // cause we had too
                Intent intent = new Intent(this,
                        PizzaActivity.class);
                startActivityForResult(intent, CREATE_PIZZA);
                break;
            case R.id.raw_egg:
                fv = new Egg();
                returnIntent.putExtra(FOOD, fv);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
                break;
            case R.id.water:
                fv = new Water();
                returnIntent.putExtra(FOOD, fv);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
                break;
            case R.id.salad:
                fv = new Salad();
                returnIntent.putExtra(FOOD, fv);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
                break;
            default:
                fv = new FoodItem();
                break;
        }
    }

    /**
     *
     * Returns the pizza intent specifically.
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CREATE_PIZZA) {
            if(resultCode == Activity.RESULT_OK){
                Intent returnIntent = new Intent();
                returnIntent.putExtra(FOOD, data.getSerializableExtra(PizzaActivity.PIZZA));
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        }
    }

}

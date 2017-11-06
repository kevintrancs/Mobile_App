/**
 *  Food Menu Taker
 *  PA06
 *
 * @author Kevin Tran and Brandon Kelly
 * @version v1.0
 *
 * We sat down and worked on the project at the same time.
 * So the work was 50/50 because we split our ideas, or combined them into
 * one thing.
 *
 */


package com.example.ktran.pa06;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Class: MainActivity
 * Handles the showing our list.
 *
 * Methods: onSaveInstanceState, onCreateOptionsMenu,onOptionsItemSelected, startFoodCartActivity, helpItem
 * deleteItem, onActivityResult
 */
public class MainActivity extends AppCompatActivity {

    /**
     *  Save info in a buddle to retain the data
     *
     * @param savedInstanceState
     */
    ArrayList<FoodItem>  fi_array = new ArrayList<>();
    ArrayAdapter<FoodItem> array_adapter;
    ListView lv;
    private static final String STATE_LIST = "Data";
    private static final int CREATE_FOOD = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            fi_array = (ArrayList<FoodItem>) savedInstanceState.getSerializable(STATE_LIST);

        }
        lv = new ListView(this);
        array_adapter = new ArrayAdapter<FoodItem>(
                this,
                android.R.layout.simple_list_item_activated_1,
                fi_array
        );
        lv.setAdapter(array_adapter);


        /**
         *
         * LONG_CLICK if the user wants to delete a specific item.
         *
         */
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                final int p = pos;
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setTitle("Delete A Note");
                builder1.setMessage("Are you sure you want to delete this note?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                fi_array.remove(p);
                                for(int i = 0; i<fi_array.size(); i++){
                                    fi_array.get(i).setOrder_num(i);
                                }
                                array_adapter.notifyDataSetChanged();
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();
                return true;
            }
        });
        setContentView(lv);
    }

    /**
     * Keeps the array in serial.
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(STATE_LIST, fi_array);
    }

    /**
     * Creates our menu bar
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi  = getMenuInflater();
        mi.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Mind for the option we picked.
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();
        switch(menuId) {
            case R.id.addItem:
                startFoodCartActivity();
                return true;
            case R.id.deleteItem:
                deleteItem();
                return true;
            case R.id.helpitem:
                helpItem();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Starts new activity for Foodmenu
     */
    private void startFoodCartActivity() {
        // explicit intent
        Intent intent = new Intent(this,
                FoodMenuActivity.class);
        startActivityForResult(intent, CREATE_FOOD);
    }

    /**
     * When the help is clicked, helper method
     */
    private void helpItem() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
        builder1.setTitle("How to");
        builder1.setMessage("How to use the app: Click to + to add, then customize, then delete xD.");
        builder1.setCancelable(true);

        builder1.setNeutralButton(
                "Gotcha Fam",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert = builder1.create();
        alert.show();
    }

    /**
     * Deletes all the items in our list.
     */
    private void deleteItem() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
        builder1.setTitle("Delete All");
        builder1.setMessage("Are you sure you want to delete all items?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        fi_array.removeAll(fi_array);
                        array_adapter.notifyDataSetChanged();
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder1.create();
        alert.show();
    }

    /**
     * When we return from another activity we put in our items.
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CREATE_FOOD) {
            if(resultCode == Activity.RESULT_OK){
                FoodItem f = (FoodItem) data.getSerializableExtra(FoodMenuActivity.FOOD);
                f.setOrder_num(fi_array.size());
                fi_array.add(f);
                array_adapter.notifyDataSetChanged();
            }
        }
    }
}

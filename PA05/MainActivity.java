
/**
 * Note Taker
 *  PA05
 *
 * @author Kevin Tran
 * @version v1.0
 */


package com.example.ktran.pa05;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

/**
 * Class Name: MainActivity
 *
 *
 * Methods:
 *  checkUnique: Checks if the name is unique
 *  onActivityResult: returns the values from NoteActivity
 *  onClick:
 *
 */
public class MainActivity extends AppCompatActivity {

    private ArrayList<Note> items = new ArrayList<>();
    private ArrayAdapter<Note> itemsAdapter;
    private ListView lvItems;
    final int CREATE_NOTE = 1;
    final int EDIT_NOTE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemsAdapter = new ArrayAdapter<Note>(this, android.R.layout.simple_list_item_1, this.items);
        lvItems = new ListView(this);
        lvItems.setAdapter(itemsAdapter);

        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(1);

        Button new_note_btn = new Button(this);
        new_note_btn.setText("Add New Note");

        GridLayout.LayoutParams buttonLayoutParams =
                new GridLayout.LayoutParams();
        buttonLayoutParams.width =
                GridLayout.LayoutParams.MATCH_PARENT;

        new_note_btn.setLayoutParams(buttonLayoutParams);

        GridLayout.LayoutParams lvLayoutParams =
                new GridLayout.LayoutParams();
        lvLayoutParams.width =
                GridLayout.LayoutParams.MATCH_PARENT;
        lvItems.setLayoutParams(lvLayoutParams);
        gridLayout.addView(new_note_btn);
        gridLayout.addView(lvItems);

        ButtonClickListener listener =
                new ButtonClickListener();
        itemsAdapter.notifyDataSetChanged();

        new_note_btn.setOnClickListener(listener);
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View arg1, int i, long arg3)
            {
                Note icecream = (Note) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                intent.putExtra("content", icecream.getContent());
                intent.putExtra("title", icecream.getTitle());
                intent.putExtra("type", icecream.getType());
                intent.putExtra("position", i);

                startActivityForResult(intent, EDIT_NOTE);

            }
        });

        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
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
                               items.remove(p);
                                itemsAdapter.notifyDataSetChanged();

                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                builder1.setNeutralButton(
                        "EXTRA CREDIT",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent = new Intent(Intent.ACTION_SEND);
                                intent.setType("text/plain");
                                intent.putExtra(Intent.EXTRA_TEXT, items.get(p).getContent());
                                startActivity(intent);
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();
                return true;
            }
        });
        setContentView(gridLayout);
    }

    /**
     * Class_name: ButtonClickListener
     * method_name: onClick
     *  Creates new intent to Note
     *  Returns  data
     *
     * @param View:  view
     */

    private class ButtonClickListener
            implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, NoteActivity.class);

            intent.putExtra("content", "");
            intent.putExtra("title", "");
            intent.putExtra("type", "");
            intent.putExtra("position", -1);

            startActivityForResult(intent, CREATE_NOTE);
        }
    }

    /**
     * method_name: onActivityResult
     *  Gets data from NoteActivity from intent and gets strings
     *  Returns data and processes it into our note
     *
     * @param int requestCode, int resultCode, Intent data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CREATE_NOTE) {
            if(resultCode == Activity.RESULT_OK){
                String title = data.getStringExtra("title");
                String type = data.getStringExtra("type");
                String content = data.getStringExtra("content");
                Note n = new Note(title, type, content);

                if(checkUnique(title)) {
                    this.items.add(n);
                    itemsAdapter.notifyDataSetChanged();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Sorry, this is already on your to-do list.",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }

        if(requestCode == EDIT_NOTE){
            if(resultCode == Activity.RESULT_OK){
                String title = data.getStringExtra("title");
                String type = data.getStringExtra("type");
                String content = data.getStringExtra("content");
                int pos = data.getIntExtra("position", 0);
                Note n = new Note(title, type, content);

                if(checkUnique(title)) {
                    items.set(pos, n);
                    itemsAdapter.notifyDataSetChanged();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Sorry, this is already on your to-do list.",
                            Toast.LENGTH_SHORT).show();
                }
            }

        }
    }


    /**
     * method_name: checkUnique
     *  Checks if the String is not in it already
     *  Returns true if not
     *
     * @param String s
     */
    public boolean checkUnique(String s){
        for(Note n : items){
            if(n.getTitle().equals(s))
                return false;
        }
        return true;
    }
}

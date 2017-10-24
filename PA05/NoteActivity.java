package com.example.ktran.pa05;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Spinner;

public class NoteActivity extends AppCompatActivity {

    String list[] = {"School", "Personal", "Business"};
    EditText title;
    EditText content;
    Spinner choice;
    Button done_btn;
    int pos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        if(intent != null){

            title = new EditText(this);
            content = new EditText(this);
            choice = new Spinner(this);
            ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_1, list);
            choice.setAdapter(adapter);

            if(intent.getIntExtra("position", -1) != -1)
                pos = intent.getIntExtra("position", 0);

            title.setText(intent.getStringExtra("title"));
            content.setText(intent.getStringExtra("content"));

            if(intent.getStringExtra("type").equals(list[0]))
                choice.setSelection(0);
            if(intent.getStringExtra("type").equals(list[1]))
                choice.setSelection(1);
            if(intent.getStringExtra("type").equals(list[2]))
                choice.setSelection(2);
        }

        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(2);
        gridLayout.setRowCount(4);

        title.setHint("Enter a title");
        title.setTag(1);

        content.setHint("Content");
        content.setTag(3);


        choice.setTag(2);

        done_btn= new Button(this);
        done_btn.setText("Done!");


        // start, size, weight
        // row: row index starts, row span,
        // row weight
        GridLayout.Spec rowSpec = GridLayout.spec(0);
        GridLayout.Spec columnSpec =GridLayout.spec(0,1,2);
        GridLayout.LayoutParams title_params = new GridLayout.LayoutParams(rowSpec, columnSpec);
        title.setLayoutParams(title_params);
        gridLayout.addView(title);

        // start, size, weight
        // row: row index starts, row span,
        // row weight
        GridLayout.Spec rowSpec2 = GridLayout.spec(0);
        GridLayout.Spec columnSpec2 =GridLayout.spec(1,1,1);
        GridLayout.LayoutParams spinner_params = new GridLayout.LayoutParams(rowSpec2, columnSpec2);
        choice.setLayoutParams(spinner_params);
        gridLayout.addView(choice);

        // start, size, weight
        // row: row index starts, row span,
        // row weight
        GridLayout.Spec rowSpec3 = GridLayout.spec(1);
        GridLayout.Spec columnSpec3 =GridLayout.spec(0, 2);
        GridLayout.LayoutParams content_params = new GridLayout.LayoutParams(rowSpec3, columnSpec3);
        content.setLayoutParams(content_params);
        gridLayout.addView(content);


        GridLayout.Spec rowSpec4 = GridLayout.spec(3);
        GridLayout.Spec columnSpec4 =GridLayout.spec(0,2);
        GridLayout.LayoutParams button_params = new GridLayout.LayoutParams(rowSpec4, columnSpec4);
        done_btn.setWidth(780);

        done_btn.setLayoutParams(button_params);
        gridLayout.addView(done_btn);

        setContentView(gridLayout);


        done_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent returnIntent = new Intent();

                String s = choice.getSelectedItem().toString();
                returnIntent.putExtra("title", title.getText().toString());
                returnIntent.putExtra("type", s);
                returnIntent.putExtra("content", content.getText().toString());
                returnIntent.putExtra("position", pos);
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }

}

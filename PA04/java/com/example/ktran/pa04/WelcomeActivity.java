/**
 * Tic Tac Toe
 *  PA04
 *
 * @author Kevin Tran
 * @version v1.0
 */

package com.example.ktran.pa04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Class Name: WelcomeActivity
 *
 *
 * Methods:
 *  onClick: Creates intents if they values are not empty. Goes to GameActivity.
 */

public class WelcomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

    }

    /**
     * method_name: onClick
     *  On Play click button creates a new intent.
     *  No return value
     *
     * @param View:  v
     */


    public void onClick(View view){

        Intent intent = new Intent(this,
                GameActivity.class);

        EditText player1 = (EditText)findViewById(R.id.p1_name);
        String player1_name = player1.getText().toString();

        EditText player2 = (EditText)findViewById(R.id.p2_name);
        String player2_name = player2.getText().toString();

        if(!player1_name.equals(player2_name)){
            intent.putExtra("player1_name", player1_name);
            intent.putExtra("player2_name", player2_name);
            startActivity(intent);
        }
        else
            Toast.makeText(this, "Please enter some names", Toast.LENGTH_SHORT).show();

    }
}

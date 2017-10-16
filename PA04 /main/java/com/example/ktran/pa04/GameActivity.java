package com.example.ktran.pa04;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class GameActivity extends AppCompatActivity {
    int turn = 0;
    String player_1;
    String player_2;
    Board tic = new Board(3);
    boolean active = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        Intent intent = getIntent();
        if (intent != null) {
            player_1 = intent.getStringExtra("player1_name");
            player_2 = intent.getStringExtra("player2_name");
        }

        ImageView i = (ImageView) findViewById(R.id.player_icon);
        i.setImageResource(R.drawable.kiss);
        TextView t = (TextView) findViewById(R.id.player_name);
        t.setText(player_1 + "'s turn.");

    }

    public void onClickSquare(View view) {
        if(!active) {
            ImageView default_image = (ImageView) findViewById(R.id.player_icon);
            TextView t = (TextView) findViewById(R.id.player_name);

            char sym = ' ';
            if (turn % 2 == 0)
                sym = 'x';
            else
                sym = 'o';

            int row = 0;
            int col = 0;
            ImageButton pick = (ImageButton) view;

            switch (pick.getId()) {
                case R.id.r0c0:
                    row = 0;
                    col = 0;
                    break;

                case R.id.r0c1:
                    row = 0;
                    col = 1;
                    break;

                case R.id.r0c2:
                    row = 0;
                    col = 2;
                    break;

                case R.id.r1c0:
                    row = 1;
                    col = 0;
                    break;

                case R.id.r1c1:
                    row = 1;
                    col = 1;
                    break;

                case R.id.r1c2:
                    row = 1;
                    col = 2;
                    break;

                case R.id.r2c0:
                    row = 2;
                    col = 0;
                    break;

                case R.id.r2c1:
                    row = 2;
                    col = 1;
                    break;

                case R.id.r2c2:
                    row = 2;
                    col = 2;
                    break;

                default:
                    Log.d("Error", "Some error");
                    break;
            }

            try {
                if (tic.makeMove(new Coordinates(row, col), sym)) {
                    turn++;
                    if (sym == 'x') {
                        pick.setImageResource(R.drawable.kiss);
                        t.setText(player_2 + "'s turn.");
                    }
                        default_image.setImageResource(R.drawable.tongue);
                    if (sym == 'o') {
                        pick.setImageResource(R.drawable.tongue);
                        t.setText(player_1 + "'s turn.");
                        default_image.setImageResource(R.drawable.kiss);
                    }
                }

                else{
                    Toast.makeText(this, "Invalid Move", Toast.LENGTH_SHORT).show();

                }
            } catch (Exception e) {
                Toast.makeText(this, "Invalid Move", Toast.LENGTH_SHORT).show();
            }



            active = tic.isWinner(sym);

            if (active) {
                TextView tview = (TextView) findViewById(R.id.player_name);
                if (tic.getScratch() == 3 * 3)
                    tview.setText("Draw game");
                else {
                    if (sym == 'x')
                        tview.setText(player_1 + " you have won!");
                    if (sym == 'o')
                        tview.setText(player_2 + " you have won!");
                }

            Button a = (Button) findViewById(R.id.again);
                a.setVisibility(View.VISIBLE);

            }
        }

    }

    public void onQuit(View view){
        Intent intent = new Intent(this,
                WelcomeActivity.class);

        startActivity(intent);
    }

    public void onAgain(View view){
        Intent intent = new Intent(this,
                GameActivity.class);

            intent.putExtra("player1_name", player_1);
            intent.putExtra("player2_name", player_2);
            startActivity(intent);
    }

}
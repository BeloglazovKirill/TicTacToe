package com.beloglazov.example.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        newGame();
    }

    private void newGame() {
        game = new Game();
        Button buttonRestart = (Button) findViewById(R.id.buttonRestart);
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartGame();
            }
        });
        final Button[][] buttons = new Button[3][3];
        buttons[0][0] = (Button) findViewById(R.id.button0);
        buttons[0][1] = (Button) findViewById(R.id.button1);
        buttons[0][2] = (Button) findViewById(R.id.button2);
        buttons[1][0] = (Button) findViewById(R.id.button3);
        buttons[1][1] = (Button) findViewById(R.id.button4);
        buttons[1][2] = (Button) findViewById(R.id.button5);
        buttons[2][0] = (Button) findViewById(R.id.button6);
        buttons[2][1] = (Button) findViewById(R.id.button7);
        buttons[2][2] = (Button) findViewById(R.id.button8);
        final TextView tvWhoGoes = (TextView) findViewById(R.id.textViewWhoGoes);
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                final int I = i;
                final int J = j;
                buttons[I][J].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int id = game.step(I, J);
                        if (id != 0) {
                            buttons[I][J].setText(id);
                            tvWhoGoes.setText(game.whoGoes());
                            switch (game.isEnd()) {
                                case NOEND:
                                    break;
                                case WONX:
                                    Toast.makeText(getApplicationContext(), R.string.playerXwon, Toast.LENGTH_LONG).show();
                                    tvWhoGoes.setText(R.string.playerXwon);
                                    break;
                                case WONO:
                                    Toast.makeText(getApplicationContext(), R.string.playerYwon, Toast.LENGTH_LONG).show();
                                    tvWhoGoes.setText(R.string.playerYwon);
                                    break;
                                case DRAW:
                                    Toast.makeText(getApplicationContext(), R.string.draw, Toast.LENGTH_LONG).show();
                                    tvWhoGoes.setText(R.string.draw);
                                    break;
                            }
                        }
                    }
                });
            }
    }

    private void restartGame() {
        game = new Game();
        ((Button) findViewById(R.id.button0)).setText("");
        ((Button) findViewById(R.id.button1)).setText("");
        ((Button) findViewById(R.id.button2)).setText("");
        ((Button) findViewById(R.id.button3)).setText("");
        ((Button) findViewById(R.id.button4)).setText("");
        ((Button) findViewById(R.id.button5)).setText("");
        ((Button) findViewById(R.id.button6)).setText("");
        ((Button) findViewById(R.id.button7)).setText("");
        ((Button) findViewById(R.id.button8)).setText("");
        ((TextView) findViewById(R.id.textViewWhoGoes)).setText(game.whoGoes());
    }

}

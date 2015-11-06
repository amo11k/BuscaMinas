package com.example.alu53381650f.buscaminas;

import android.app.ActionBar;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Bomb[][] buttons = new Bomb[NUMERO_ROWS][NUMERO_COLS];
    GridLayout tablero;
    static Clock clock;
    TextView clockView;
    TextView scoreLabel;
    int score = 1;
    static final int NUMERO_ROWS = 20;
    static final int NUMERO_COLS = 9;
    private int contador_bombas;
    private int row, col;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tablero = (GridLayout) findViewById(R.id.tablero);
        scoreLabel = (TextView) findViewById(R.id.textScore);
        /*clockView = (TextView) findViewById(R.id.textCLock);
        clock = new Clock(clockView);
        clock.run();*/

        for (int i = 0; i < NUMERO_ROWS; i++) {
            for (int j = 0; j < NUMERO_COLS; j++) {
                buttons[i][j] = new Bomb(getApplicationContext(), false, 0, 0);
                buttons[i][j].setRow(i);
                buttons[i][j].setCol(j);
                buttons[i][j].setImageDrawable(getResources().getDrawable(R.drawable.free));
                buttons[i][j].setLayoutParams(new GridLayout.LayoutParams());
                buttons[i][j].setPadding(0, 0, 0, 0);
                tablero.addView(buttons[i][j], new GridLayout.LayoutParams(tablero.spec(i), tablero.spec(j)));
            }
        }
        while (contador_bombas <= 45) {
            int i = (int) (Math.random() * 20);
            int j = (int) (Math.random() * 9);
            buttons[i][j].setBomb();
            contador_bombas++;
        }

        for (int i = 0; i < NUMERO_ROWS; i++) {
            for (int j = 0; j < NUMERO_COLS; j++) {
                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bomb b = (Bomb) v;
                        if (b.getState()) {
                            ((Bomb) v).setImageDrawable(getResources().getDrawable(R.drawable.mine_wrong));
                        } else {
                            scoreLabel.setText(String.valueOf(score));
                            score++;
                            comprobar((Bomb) v, buttons);
                            /*row = b.getRow();
                            col = b.getCol();
                            ((Bomb) v).setImageDrawable(getResources().getDrawable(R.drawable.c0));*/

                        }
                    }
                });
            }
        }

    }

    public void comprobar(Bomb b, Bomb[][] bombs) {
        int x, y;
        int proxibombs = 0;
        x = b.getRow();
        y = b.getCol();
        System.out.print(y + " " + x);
        //Esq IzSp
        if (bombs[x - 1][y - 1].getState()) {
            proxibombs++;
        } else {
            bombs[x - 1][y - 1].setImageDrawable(getResources().getDrawable(R.drawable.c0));
        }
        //Mid Sup
        if (bombs[x][y - 1].getState()) {
            proxibombs++;
        } else {
            bombs[x][y - 1].setImageDrawable(getResources().getDrawable(R.drawable.c0));
        }
        //ESq DrcSup
        if (bombs[x + 1][y - 1].getState()) {
            proxibombs++;
        } else {
            bombs[x + 1][y - 1].setImageDrawable(getResources().getDrawable(R.drawable.c0));
        }
        //MID IZq
        if (bombs[x - 1][y].getState()) {
            proxibombs++;
        } else {
            bombs[x - 1][y].setImageDrawable(getResources().getDrawable(R.drawable.c0));
        }
        // MID DRCH
        if (bombs[x + 1][y].getState()) {
            proxibombs++;
        } else {
            bombs[x + 1][y].setImageDrawable(getResources().getDrawable(R.drawable.c0));
        }
        //MID BOTTOM
        if (bombs[x][y + 1].getState()) {
            proxibombs++;
        } else {
            bombs[x][y + 1].setImageDrawable(getResources().getDrawable(R.drawable.c0));
        }
        //ESQ IZQ INF
        if (bombs[x - 1][y + 1].getState()) {
            proxibombs++;
        } else {
            bombs[x - 1][y + 1].setImageDrawable(getResources().getDrawable(R.drawable.c0));
        }
        if (bombs[x + 1][y + 1].getState()) {
            proxibombs++;
        } else {
            bombs[x + 1][y + 1].setImageDrawable(getResources().getDrawable(R.drawable.c0));
        }

        System.out.println("  " + b.getState() + "   " + proxibombs);
        switch (proxibombs)

        {
            case 0:
                b.setImageDrawable(getResources().getDrawable(R.drawable.c0));
                break;
            case 1:
                b.setImageDrawable(getResources().getDrawable(R.drawable.c1));
                break;
            case 2:
                b.setImageDrawable(getResources().getDrawable(R.drawable.c2));
                break;
            case 3:
                b.setImageDrawable(getResources().getDrawable(R.drawable.c3));
                break;
            case 4:
                b.setImageDrawable(getResources().getDrawable(R.drawable.c4));
                break;
            case 5:
                b.setImageDrawable(getResources().getDrawable(R.drawable.c5));
                break;
            case 6:
                b.setImageDrawable(getResources().getDrawable(R.drawable.c6));
                break;
            case 7:
                b.setImageDrawable(getResources().getDrawable(R.drawable.c7));
                break;
            case 8:
                b.setImageDrawable(getResources().getDrawable(R.drawable.c8));
                break;
            default:
        }
    }
}

/*timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                clock = (TextView) findViewById(R.id.textCLock);
                int seconds = 1;
                clock.setText(String.valueOf(seconds));
                seconds++;
            }
        }, 0, 1000);*/

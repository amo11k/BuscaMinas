package com.example.alu53381650f.buscaminas;

import android.app.ActionBar;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {
    ImageButton[][] buttons = new ImageButton[NUMERO_ROWS][NUMERO_COLS];

    GridLayout tablero;
    static final int NUMERO_ROWS = 20;
    static final int NUMERO_COLS = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tablero = (GridLayout) findViewById(R.id.tablero);

        for (int i = 0; i < NUMERO_ROWS; i++) {
            for (int j = 0; j < NUMERO_COLS; j++) {
                buttons[i][j] = new ImageButton(getApplicationContext());
                buttons[i][j].setImageDrawable(getResources().getDrawable(R.drawable.free));
                buttons[i][j].setLayoutParams(new GridLayout.LayoutParams());
                buttons[i][j].setPadding(0,0,0,0);
                tablero.addView(buttons[i][j], new GridLayout.LayoutParams(tablero.spec(i), tablero.spec(j)));
            }
        }

        for (int i = 0; i < NUMERO_ROWS; i++) {
            for (int j = 0; j < NUMERO_COLS; j++) {
                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((ImageButton) v).setImageDrawable(getResources().getDrawable(R.drawable.flag));
                    }
                });
            }
        }

    }
}

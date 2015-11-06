package com.example.alu53381650f.buscaminas;

import android.content.Context;
import android.widget.ImageButton;

/**
 * Created by alu53381650f on 06/11/15.
 */
public class Bomb extends ImageButton {
    public boolean bomb;
    public int row, col;

    public Bomb(Context context, boolean bomb, int row, int col) {
        super(context);
        this.bomb = bomb;
        this.row = row;
        this.col = col;

    }

    public boolean getState() {
        return bomb;
    }

    public void setBomb() {
        this.bomb = true;
    }

    public void setRow(int x) {
        this.row=x;
    }

    public int getRow(){
        return row;
    }

    public void setCol(int x){
        this.col=x;
    }

    public int getCol(){
        return col;
    }
}

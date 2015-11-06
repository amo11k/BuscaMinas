package com.example.alu53381650f.buscaminas;

import android.widget.TextView;

import java.util.Timer;

/**
 * Created by alu53381650f on 06/11/15.
 */
public class Clock implements Runnable {
    private Timer timer;
    private TextView textView;

    public Clock(TextView textView) {
        this.textView = textView;
    }

    @Override
    public void run() {
        while (true) {
            int seconds = 01, minutes = 00;
            textView.setText(String.valueOf(minutes) + ":" + String.valueOf(seconds));
            seconds++;
            if (seconds >= 60) {
                minutes++;
                seconds = 0;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.print("Error Run");
            }
        }
    }
}

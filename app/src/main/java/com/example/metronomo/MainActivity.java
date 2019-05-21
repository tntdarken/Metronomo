package com.example.metronomo;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private Metronomo met;
    private SeekBar seek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.seek = findViewById(R.id.id_seekbar);
        this.met = new Metronomo(findViewById(android.R.id.content));
        this.seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                met.stop();
                met.start(progress == 0 ? 1: progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void start(View v){
        // esta é uma forma de fazer a contagem sem usar métodos do sistema.
        new Thread(new Runnable() {
            public void run() {
                long calendar = Calendar.getInstance().getTimeInMillis();
                Boolean x = true;
                int y = 0;
                while(x && y < 15){
                    if(Calendar.getInstance().getTimeInMillis()-calendar > 1000){
                        Log.d("a", String.valueOf(y));
                        calendar = Calendar.getInstance().getTimeInMillis();
                        y++;
                    }
                }
            }
        }).start();
    }

    public void stop(View v){
        met.stop();
    }
}

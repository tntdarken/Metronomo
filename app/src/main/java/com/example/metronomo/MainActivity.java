package com.example.metronomo;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private Metronomo met;
    private SeekBar seek;
    private Integer val;
    private Thread tread;
    private Metronomo_alt metronomo;
    private TextView txBpm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.seek = findViewById(R.id.id_seekbar);
        this.txBpm = findViewById(R.id.bpm);
        this.val = 0;
        this.metronomo = new Metronomo_alt(findViewById(android.R.id.content));
        this.seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){


            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("progress", String.valueOf(progress));
                if(val != progress){
                    val = progress;
                    metronomo.stop();

                    Integer teste = (val * 1000)/60;

                    txBpm.setText(val.toString());

                    metronomo.start(teste);
                }
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
        metronomo.start(500);
    }

    public void stop(View v){
        metronomo.stop();

    }
}

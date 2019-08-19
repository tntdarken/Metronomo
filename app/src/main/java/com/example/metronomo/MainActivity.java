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
        this.txBpm.setText(String.valueOf(this.seek.getMin()));
        this.val = 0;
        this.metronomo = new Metronomo_alt(findViewById(android.R.id.content));
        this.seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            int progress;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                this.progress = progress;
                txBpm.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(val != progress){
                    val = progress;

                    if(metronomo.getStatus()){
                        metronomo.stop();
                        metronomo.start(60000/val);
                    }

                }

            }
        });
    }


    public void start(View v){
        // esta é uma forma de fazer a contagem sem usar métodos do sistema.
        if(!metronomo.getStatus()) {
            metronomo.start(60000 / Integer.parseInt(this.txBpm.getText().toString()));
        }
    }

    public void stop(View v){
        metronomo.stop();

    }
}

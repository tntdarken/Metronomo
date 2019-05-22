package com.example.metronomo;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;

import java.util.Calendar;

public class Metronomo_alt implements Runnable {
        private Thread worker;
        private Integer running;
        private View v;
        private Integer bpm;

        public Metronomo_alt(View v) {
            this.v = v;
        }

        public void start(Integer bp) {
            running = 2;
            bpm = bp;
            worker = new Thread(this);
            worker.start();
        }

        public void stop() {
            running = 0;
        }

        public void run() {
//            final Vibrator vibrator = (Vibrator) v.getContext().getSystemService(Context.VIBRATOR_SERVICE);
            final MediaPlayer mp = MediaPlayer.create(v.getContext(), R.raw.blip_blip_long);

            long calendar = Calendar.getInstance().getTimeInMillis();
            int y = 1;
            mp.seekTo(30);
            mp.start();
//            int bpm = 250;
            while(y < running){

                // trecho para picar o som caso o som seja continuo
//                    if(Calendar.getInstance().getTimeInMillis()-calendar > bpm/2) {
//                        mp.setVolume(1, 1);
//                    }else{
//                        mp.setVolume(0,0);
//                    }

                // trecho que bota o som caso ele seja picado. Lembrando, ele deve ter um longo periodo de pausa
                if(Calendar.getInstance().getTimeInMillis()-calendar > bpm){
//                    vibrator.vibrate(20);
                    Log.d("a", String.valueOf(y));
                    calendar = Calendar.getInstance().getTimeInMillis();
                    mp.seekTo(0);
                }
            }
        }
    }

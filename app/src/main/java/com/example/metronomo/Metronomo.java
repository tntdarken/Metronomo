package com.example.metronomo;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;

public class Metronomo {
    private CountDownTimer count;
    private View view;

    public Metronomo(View v){
        this.view = v;
    }

    public void start(int i){
        final Vibrator vibrator = (Vibrator) this.view.getContext()
                .getSystemService(Context.VIBRATOR_SERVICE);

        this.count = new CountDownTimer(Long.MAX_VALUE, i*100) {
            @Override
            public void onTick(long millisUntilFinished) {
//                Vibrator vibrator = (Vibrator) getBaseContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(40);
            }

            @Override
            public void onFinish() {

            }
        };

        this.count.start();

    }

    public void stop(){
        if(this.count instanceof CountDownTimer){
            this.count.cancel();
        }
    };
}

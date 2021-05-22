package com.shabsudemy.androidadvancedsection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

public class TimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                Log.i("left time",String.valueOf(millisUntilFinished/1000));

            }

            @Override
            public void onFinish() {
                Log.i("CounterTimer Status","Counter timer completed");
            }
        }.start();


        Handler handler = new Handler();
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Log.i("handler Runnable timer","running every sec");
                handler.postDelayed(this,1000);
            }
        };

        handler.post(run);
    }

}
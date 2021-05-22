package com.shabsudemy.androidadvancedsection;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EggTimerActivity extends AppCompatActivity {

    SeekBar timerSeekBar;
    Button goButton;
    TextView timeDurationText;
    CountDownTimer cT;
    Boolean isCounterActive=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg_timer);

        timerSeekBar = (SeekBar) findViewById(R.id.timerSeekBar);
        goButton = (Button) findViewById(R.id.timerController);
        timeDurationText = (TextView) findViewById(R.id.timeDurationText);

        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(30);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setTimerDurationText(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void setTimerDurationText(int secondsLeft) {
        int minutes = (int) secondsLeft / 60;
        String secondsString = "";
        int seconds = secondsLeft - minutes * 60;
        int secondDigitsCount = String.valueOf(seconds).length();
        if (secondDigitsCount == 1) {
            secondsString = "0" + seconds;
        } else {
            secondsString = String.valueOf(seconds);
        }

        timeDurationText.setText(String.valueOf(minutes) + ":" + secondsString);
    }

    public void controlTimer(View view) {

        if (isCounterActive == false) {
            isCounterActive = true;
            timerSeekBar.setEnabled(false);
            goButton.setText("STOP");

            cT = new CountDownTimer((timerSeekBar.getProgress() * 1000) + 100, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    setTimerDurationText(((int) millisUntilFinished / 1000));
                }

                @Override
                public void onFinish() {
                   resetTimer();

                }
            };
            cT.start();
        }else{
            cT.cancel();
            resetTimer();
        }


    }

    public  void  resetTimer(){
        setTimerDurationText(0);
        timerSeekBar.setProgress(30);
        isCounterActive = false;
        timerSeekBar.setEnabled(true);
        timeDurationText.setText("00:30");
        goButton.setText("GO");
    }
}
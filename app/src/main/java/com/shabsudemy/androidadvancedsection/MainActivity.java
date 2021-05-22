package com.shabsudemy.androidadvancedsection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button listViewNavButton,timeTableListView,timerButton,eggTimer,brainTrainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewNavButton = (Button) findViewById(R.id.listViewNavButton);
        timeTableListView = (Button) findViewById(R.id.TimeTableListViewButton);
        timerButton = (Button) findViewById(R.id.timerButton);
        eggTimer = (Button) findViewById(R.id.eggTimerButton);
        brainTrainer = (Button) findViewById(R.id.brainTrainerButton);


        listViewNavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListViewActivity.class);
                startActivity(intent);
            }
        });

        timeTableListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TimeTableListView.class);
                startActivity(intent);
            }
        });

        timerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TimerActivity.class);
                startActivity(intent);
            }
        });

        eggTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,EggTimerActivity.class);
                startActivity(intent);
            }
        });


        brainTrainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BrainTrainerActivity.class);
                startActivity(intent);
            }
        });




    }
}
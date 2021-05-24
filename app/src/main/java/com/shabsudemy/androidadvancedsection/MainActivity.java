package com.shabsudemy.androidadvancedsection;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        System.out.println("key pressed");
        switch (v.getId()) {
            case R.id.listViewNavButton:
                Intent intentListView = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intentListView);
                break;
            case R.id.TimeTableListViewButton:
                Intent TimeTableListViewButton = new Intent(MainActivity.this, TimeTableListView.class);
                startActivity(TimeTableListViewButton);
                break;
            case R.id.timerButton:
                Intent timerButton = new Intent(MainActivity.this, TimerActivity.class);
                startActivity(timerButton);
                break;
            case R.id.eggTimerButton:
                Intent eggTimerButton = new Intent(MainActivity.this, EggTimerActivity.class);
                startActivity(eggTimerButton);
                break;
            case R.id.brainTrainerButton:
                Intent brainTrainerButton = new Intent(MainActivity.this, BrainTrainerActivity.class);
                startActivity(brainTrainerButton);
                break;

            case R.id.webContentDownloadActivityButton:
                Intent webContentDownloadActivityButton = new Intent(MainActivity.this, WebContentDownloadActivity.class);
                startActivity(webContentDownloadActivityButton);
                break;

            case R.id.imagetDownloadActivityButton:
                Intent imagetDownloadActivityButton = new Intent(MainActivity.this, ImageDownloadActivity.class);
                startActivity(imagetDownloadActivityButton);
                break;

            default:
                System.out.println("default key pressed");
                break;
        }

    }
}
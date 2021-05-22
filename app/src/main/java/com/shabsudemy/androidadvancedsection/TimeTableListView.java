package com.shabsudemy.androidadvancedsection;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class TimeTableListView extends AppCompatActivity {

    SeekBar timeTableSeekBar;
    ListView timeTableListView;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table_list_view);

        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();

        timeTableListView = (ListView) findViewById(R.id.timeTableListView);
        timeTableSeekBar = (SeekBar) findViewById(R.id.timeTableSeekBar);

        timeTableSeekBar.setMax(20);
        timeTableSeekBar.setProgress(10);

        int timesTable = 10;
        generateTimesTable(timesTable);

        timeTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timeTable;
                if (progress < 1) {
                    timeTable = min;
                    timeTableSeekBar.setProgress(min);
                } else {
                    timeTable = progress;
                }

                generateTimesTable(timeTable);
                Log.i("seekbar value", String.valueOf(timeTable));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void generateTimesTable(int timesTable) {
        ArrayList<String> timesTableContent = new ArrayList<String>();

        for (int i = 1; i <= 10; i++) {
            String temp=String.valueOf(i)+"*"+String.valueOf(timesTable)+"="+Integer.toString((i * timesTable));
            timesTableContent.add(temp);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, timesTableContent);
        timeTableListView.setAdapter(arrayAdapter);
    }
}
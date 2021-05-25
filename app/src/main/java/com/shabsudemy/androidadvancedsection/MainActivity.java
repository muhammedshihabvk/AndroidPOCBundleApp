package com.shabsudemy.androidadvancedsection;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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

            case R.id.mapActivity:
                Intent mapActivity = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(mapActivity);
                break;

            case R.id.sharedPreferenceActivity:
                Intent sharedPreferenceActivity = new Intent(MainActivity.this, SharedPreferencePOCAcivity.class);
                startActivity(sharedPreferenceActivity);
                break;

            case R.id.noteAppActivity:
                Intent noteAppActivity = new Intent(MainActivity.this, NoteAppAcivity.class);
                startActivity(noteAppActivity);
                break;

            case R.id.databaseActivity:
                Intent databaseActivity = new Intent(MainActivity.this, DatabaseActivity.class);
                startActivity(databaseActivity);
                break;
            case R.id.webviewActivity:
                Intent webviewActivity = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(webviewActivity);

            default:
                System.out.println("default key pressed");
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.default_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuSearch:
                Log.i("menu", "search menue selected");
                showDialogue();
                break;
            case R.id.menuSettings:
                Log.i("menu", "settings menue selected");
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showDialogue() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setIcon(android.R.drawable.sym_def_app_icon);
        alertDialogBuilder.setTitle("Are you sure");
        alertDialogBuilder.setMessage("Do you want to do this?");
//        alertDialogBuilder.setOnDismissListener(new DialogInterface.OnDismissListener() {
//            @Override
//            public void onDismiss(DialogInterface dialog) {
//                showDialogue();
//            }
//        });
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "its done", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "its not done", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialogBuilder.show();
    }
}
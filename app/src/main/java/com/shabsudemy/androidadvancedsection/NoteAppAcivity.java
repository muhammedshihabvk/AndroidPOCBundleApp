package com.shabsudemy.androidadvancedsection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;

public class NoteAppAcivity extends AppCompatActivity {

    ListView mainNoteListView;
    static ArrayList<String> myNotes = new ArrayList<String>();
    static ArrayAdapter arrayAdapter;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_app_acivity);

        mainNoteListView = (ListView) findViewById(R.id.noteAppListView);

        sharedPreferences = getApplicationContext().getSharedPreferences("com.shabsudemy.androidadvancedsection", Context.MODE_PRIVATE);
        HashSet<String> set = (HashSet<String>) sharedPreferences.getStringSet("noteSet",null);

        if(set ==null){
            myNotes.add("sample notes");
        }else{
            myNotes = new ArrayList<>(set);
        }

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, myNotes);

        mainNoteListView.setAdapter(arrayAdapter);

        mainNoteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), NoteAppViewActivity.class);
                intent.putExtra("noteId", position);
                startActivity(intent);
            }
        });

        mainNoteListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                int itemDelete = position;
                Log.i("longPress", "Long pressed" + String.valueOf(position));
                new AlertDialog.Builder(NoteAppAcivity.this)
                        .setIcon(android.R.drawable.ic_delete)
                        .setTitle("are you sure?")
                        .setMessage("Do you want to delete this note").setNegativeButton("No", null)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                myNotes.remove(itemDelete);
                                HashSet<String> set = new HashSet<String>(NoteAppAcivity.myNotes);
                                sharedPreferences.edit().putStringSet("noteSet",set).apply();
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }).show();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.default_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.addNote:
                Intent intent = new Intent(this, NoteAppViewActivity.class);
                startActivity(intent);
                break;
            default:
                Toast.makeText(this, "No option integrated in this screen", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
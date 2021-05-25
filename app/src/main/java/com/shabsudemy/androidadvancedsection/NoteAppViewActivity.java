package com.shabsudemy.androidadvancedsection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashSet;

public class NoteAppViewActivity extends AppCompatActivity {

    EditText noteEditTextView;
    int noteId=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_app_view);

        noteEditTextView = (EditText) findViewById(R.id.noteTextView);

        Intent intent = getIntent();
        noteId = intent.getIntExtra("noteId", -1);

        if (noteId != -1) {
            noteEditTextView.setText(NoteAppAcivity.myNotes.get(noteId));
        }else{
            NoteAppAcivity.myNotes.add("");
            noteId = NoteAppAcivity.myNotes.size()-1;
            NoteAppAcivity.arrayAdapter.notifyDataSetChanged();
        }

        noteEditTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("noteId",String.valueOf(noteId));
                NoteAppAcivity.myNotes.set(noteId, s.toString());
                NoteAppAcivity.arrayAdapter.notifyDataSetChanged();

                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.shabsudemy.androidadvancedsection", Context.MODE_PRIVATE);
                HashSet<String> set = new HashSet<String>(NoteAppAcivity.myNotes);
                sharedPreferences.edit().putStringSet("noteSet",set).apply();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


}
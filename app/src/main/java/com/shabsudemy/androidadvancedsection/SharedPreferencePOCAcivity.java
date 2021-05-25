package com.shabsudemy.androidadvancedsection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SyncRequest;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPreferencePOCAcivity extends AppCompatActivity {

    TextView savedTextView;
    Button saveButton;
    EditText textField;
    SharedPreferences sharedPreferences;
    final String DEFAULT_KEY="defaultKey";


    public void saveToSharedPreference(String key,String value){
        sharedPreferences.edit().putString(key,value).apply();
    }

    public String getFromSharedPreference(String key){
        return sharedPreferences.getString(key,"no value saved");
    }

    private void hideKeyboard(){
        InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(textField.getWindowToken(), 0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference_pocacivity);

        sharedPreferences = this.getSharedPreferences("com.shabsudemy.androidadvancedsection", Context.MODE_PRIVATE);
        savedTextView = (TextView) findViewById(R.id.savedTextView);
        saveButton = (Button) findViewById(R.id.saveButton);
        textField = (EditText) findViewById(R.id.editTextSave);

        savedTextView.setText(getFromSharedPreference(DEFAULT_KEY));

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                String text = textField.getText().toString();
                saveToSharedPreference(DEFAULT_KEY,text);
                savedTextView.setText(text);
            }
        });

    }
}
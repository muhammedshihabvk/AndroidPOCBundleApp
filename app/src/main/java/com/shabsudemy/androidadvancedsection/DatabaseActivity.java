package com.shabsudemy.androidadvancedsection;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DatabaseActivity extends AppCompatActivity {

    ArrayList<String> dbData = new ArrayList<String>();
    ListView dbDataListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        dbDataListView = (ListView)findViewById(R.id.databaseListView);

        try {
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("User", MODE_PRIVATE, null);

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR,age INT(3),place VARCHAR)");
//            myDatabase.execSQL("DELETE FROM users");  //clear table data
            myDatabase.execSQL("INSERT INTO users (name,age,place) VALUES ('shihab',25,'thozhiyoor')");
            myDatabase.execSQL("INSERT INTO users (name,age,place) VALUES ('jabir',20,'thrissur')");

            Cursor cursor = myDatabase.rawQuery("SELECT * FROM users", null);
            int nameIndex = cursor.getColumnIndex("name");
            int ageIndex = cursor.getColumnIndex("age");
            int placeIndex = cursor.getColumnIndex("place");

            cursor.moveToFirst();

            while (cursor!= null) {
                dbData.add(cursor.getString(nameIndex)+"--"+String.valueOf(cursor.getInt(ageIndex))+"--"+cursor.getString(placeIndex));
                cursor.moveToNext();
            }

        } catch (Exception e) {

        }


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,dbData);
        dbDataListView.setAdapter(arrayAdapter);

    }
}
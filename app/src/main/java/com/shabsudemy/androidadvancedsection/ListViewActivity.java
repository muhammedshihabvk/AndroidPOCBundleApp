package com.shabsudemy.androidadvancedsection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity implements  AdapterView.OnItemClickListener{

    ListView listView;
    List<String> nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = (ListView) findViewById(R.id.myListView);

        nameList = new ArrayList<String>();
        nameList.add("shihab");
        nameList.add("jabir");
        nameList.add("shuaib");
        nameList.add("john");
        nameList.add("fathima");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1,nameList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("listview",nameList.get(1));
                Toast.makeText(ListViewActivity.this, nameList.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i("listview",nameList.get(1));
        Toast.makeText(ListViewActivity.this, nameList.get(position), Toast.LENGTH_SHORT).show();
    }
}
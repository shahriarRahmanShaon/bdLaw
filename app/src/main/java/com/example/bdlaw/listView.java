package com.example.bdlaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listView extends AppCompatActivity {
private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = (ListView)findViewById(R.id.listView);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");
        arrayList.add("Mr. Rayhan");



        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(listView.this, PhoneAuthentication.class));
            }
        });


    }
}
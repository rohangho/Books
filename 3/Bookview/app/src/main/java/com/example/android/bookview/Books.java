package com.example.android.bookview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Books extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        ArrayList<custom> words = new ArrayList<custom>();
        words.add(new custom("hi", "by"));
        words.add(new custom("a","c"));

        adapter item = new adapter(this, words);
        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(item);


    }
}

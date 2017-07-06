package com.example.android.bookview;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.bookview.R.drawable.a;

public class Books extends AppCompatActivity {


    private static final String USGS_REQUEST_URL ="https://www.googleapis.com/books/v1/volumes?q=";
    private adapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        ListView listView = (ListView) findViewById(R.id.list);
        mAdapter = new adapter(this, new ArrayList<custom>());
        listView.setAdapter(mAdapter);
        bookAsyncTask task = new bookAsyncTask();

        //To enter the keyword you want to search
        String a=getIntent().getStringExtra("TEXT");
        task.execute(USGS_REQUEST_URL+a);

    }

    private class bookAsyncTask extends AsyncTask<String, Void, List<custom>> {
        @Override
        protected List<custom> doInBackground(String... urls) {
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }
            List<custom> result = QueryUtils.fetchData(urls[0]);
            return result;
        }
        @Override
        protected void onPostExecute(List<custom> data) {
            mAdapter.clear();
            if (data != null && !data.isEmpty()) {
                mAdapter.addAll(data);
            }
        }
    }
}



package com.example.android.bookview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String url="https://www.googleapis.com/books/v1/volumes?q=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button search=(Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,Books.class);
                startActivity(intent);
            }
        });

    }
    public void upjdateurl(){
        EditText name = (EditText) findViewById(R.id.keyword);
        String name1 = name.getText().toString();
        if(0<name1.length())
        {url=url+name1;}
    }
}

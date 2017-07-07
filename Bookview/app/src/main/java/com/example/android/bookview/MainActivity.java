package com.example.android.bookview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.bookview.R.drawable.a;
import static com.example.android.bookview.R.id.search;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView=(TextView)findViewById(R.id.keyword);
        Button search=(Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,Books.class);
                intent.putExtra("TEXT",textView.getText().toString());
                startActivity(intent);
            }
        });
    }

}

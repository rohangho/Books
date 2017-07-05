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

public class MainActivity extends AppCompatActivity {


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

}

package com.example.wastemaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CleaningActivity2 extends AppCompatActivity {

    //create reference
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaning2);

        button1 = findViewById(R.id.btact_id1);
        button2 = findViewById(R.id.btact_id4);

        //button worksrports
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(getApplicationContext(),WorkReport.class);
                startActivity(a);
            }
        });

        //button cleaning officer
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),CreateBin.class);
                startActivity(i);
            }
        });
    }
}
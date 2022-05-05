package com.example.wastemaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CleaningActivity2 extends AppCompatActivity {

    //create reference
    Button button1;
    Button btact_id2;
    Button btact_id3;
    Button btact_id4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaning2);

        button1 = findViewById(R.id.btact_id1);
        btact_id2 = findViewById(R.id.btact_id2);
        btact_id3 = findViewById(R.id.btact_id3);
        btact_id4 = findViewById(R.id.btact_id4);

        //button worksrports
        btact_id4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(getApplicationContext(),W_Reports.class);
                startActivity(a);
            }
        });

        //button cleaning officer
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(getApplicationContext(),CreateBin.class);
                startActivity(b);
            }
        });
    }
}
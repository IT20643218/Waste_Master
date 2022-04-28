package com.example.wastemaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {

    //create reference
    Button button01,button02,button03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button01 = findViewById(R.id.bt_id1);
        button02 = findViewById(R.id.btact_id1);
        button03 = findViewById(R.id.bt_id3);

        //button cleaning officer
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),CleaningActivity2.class);
                startActivity(i);
            }
        });
        //button route management
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(getApplicationContext(),RouteManagement.class);
                startActivity(a);
            }
        });
        //manage garbage
        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(getApplicationContext(),ManageGarbage.class);
                startActivity(b);
            }
        });

    }
}
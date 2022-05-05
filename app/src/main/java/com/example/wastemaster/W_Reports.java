package com.example.wastemaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wastemaster.Database.DBHandler;

public class W_Reports extends AppCompatActivity {

    EditText date,workreport1,workreport2,workreport3,workreport4;
    Button btnnewadd,btnupdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wreports);

        date = findViewById(R.id.date);
        workreport1 = findViewById(R.id.workreport1);
        workreport2 = findViewById(R.id.workreport2);
        workreport3 = findViewById(R.id.workreport3);
        workreport4 = findViewById(R.id.workreport4);
        btnnewadd = findViewById(R.id.btnnewadd);
        btnupdate = findViewById(R.id.btnupdate);

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(getApplicationContext(),Edit_Work_R.class);
                startActivity(b);
            }
        });

        btnnewadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler dbHandler = new DBHandler(getApplicationContext());
                long newRowId  = dbHandler.addwork(date.getText().toString(),workreport1.getText().toString(),workreport2.getText().toString()
                        ,workreport3.getText().toString(),workreport4.getText().toString());

                Toast.makeText(W_Reports.this, "Successfully Added , Work Date"+date, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(),Edit_Work_R.class);
                startActivity(i);
            }
        });
    }
}
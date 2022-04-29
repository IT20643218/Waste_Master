package com.example.wastemaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddBin extends AppCompatActivity {

    private EditText city, lordtype,cleaningperiod;
    private Button add;
    //private DbHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bin);

        city =findViewById(R.id.edit_bin);
        lordtype = findViewById(R.id.edit_Des);
        cleaningperiod = findViewById(R.id.edit_period);
        add = findViewById(R.id.buttonAdd);
    }
}
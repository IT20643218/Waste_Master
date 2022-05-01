package com.example.wastemaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class EditBin extends AppCompatActivity {
    private EditText city,lord_type,cleaning_period,location;
    private Button edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_bin);

        city = findViewById(R.id.edit_bin1);
        lord_type = findViewById(R.id.edit_Des1);
        cleaning_period = findViewById(R.id.edit_period);

        edit = findViewById(R.id.buttonedit);
    }
}
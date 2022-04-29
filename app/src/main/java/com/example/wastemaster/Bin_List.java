package com.example.wastemaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Bin_List extends AppCompatActivity {

    private Button add;
    private ListView listView;
    private TextView count;
    Context context;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bin_list);

        add = findViewById(R.id.add);
        listView = findViewById(R.id.binlist);
        count = findViewById(R.id.bincount);
        context = this;

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,AddBin.class));
            }
        });
    }
}
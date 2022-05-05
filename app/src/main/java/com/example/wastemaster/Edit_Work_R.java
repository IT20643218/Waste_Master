package com.example.wastemaster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.wastemaster.Database.DBHandler;

import java.util.List;

public class Edit_Work_R extends AppCompatActivity {
    EditText edit_date,editNameone,editNametwo,editNametree,editNamefour;
    Button editbin,deletebin,search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_work_r);

        edit_date = findViewById(R.id.edit_date);
        editNameone = findViewById(R.id.editNameone);
        editNametwo = findViewById(R.id.editNametwo);
        editNametree = findViewById(R.id.editNametree);
        editNamefour = findViewById(R.id.editNamefour);

        editbin = findViewById(R.id.editbin);
        deletebin = findViewById(R.id.deletebin);
        search = findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler dbHandler = new DBHandler(getApplicationContext());
                List work = dbHandler.readAllinfo(edit_date.getText().toString());

                if (work.isEmpty()){
                    Toast.makeText(Edit_Work_R.this, "No any work", Toast.LENGTH_SHORT).show();
                    edit_date.setText(null);
                }else{
                    Toast.makeText(Edit_Work_R.this, "Work Found! User:"+work.get(0).toString(), Toast.LENGTH_SHORT).show();
                    edit_date.setText(work.get(0).toString());
                    editNameone.setText(work.get(1).toString());
                    editNametwo.setText(work.get(2).toString());
                    editNametree.setText(work.get(3).toString());
                    editNamefour.setText(work.get(5).toString());
                }

            }
        });
        editbin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler dbHandler = new DBHandler(getApplicationContext());
                Boolean status = dbHandler.updatework(edit_date.getText().toString(),editNameone.getText().toString(),
                        editNametwo.getText().toString(),editNametree.getText().toString(),editNamefour.getText().toString());

                if(status){
                    Toast.makeText(Edit_Work_R.this, "Work Updated !", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Edit_Work_R.this, "Work Failed !", Toast.LENGTH_SHORT).show();
                }
            }
        });

        deletebin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler dbHandler = new DBHandler(getApplicationContext());
                dbHandler.deleteWork(edit_date.getText().toString());

                Toast.makeText(Edit_Work_R.this, "User Delete !", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
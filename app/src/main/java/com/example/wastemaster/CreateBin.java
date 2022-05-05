package com.example.wastemaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wastemaster.Database.DBHandler;

public class CreateBin extends AppCompatActivity {

    private Button select_btn,submit;

    //Create reference for data insert
    private EditText city, lord_type,cleaning_period,location;
    private DBHandler dbHandler;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bin);

        select_btn = findViewById(R.id.btn_select);

        select_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:6.927079"));
                Intent chooser = Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);
            }
        });

        //create reference for insert data
        city = findViewById(R.id.tx_name);
        lord_type = findViewById(R.id.tx2_name);
        cleaning_period = findViewById(R.id.tx3_name);
        location = findViewById(R.id.location);
        submit = findViewById(R.id.btn_sub);
        context = this;
        dbHandler = new DBHandler(context);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userCity = city.getText().toString();
                String userLord_type = lord_type.getText().toString();
                String userCleaning_period = cleaning_period.getText().toString();
                String userLocation = location.getText().toString();
                long started = System.currentTimeMillis();

                BinModal binModal = new BinModal(userCity,userLord_type,userCleaning_period,userLocation,started,0);
                dbHandler.createBin(binModal);

                Intent b = new Intent(getApplicationContext(),Bin_List.class);
                startActivity(b);
            }
        });

    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, "Successfully  Bin Created", Toast.LENGTH_LONG);
        toast.show();
    }
}
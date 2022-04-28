package com.example.wastemaster;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class WorkReport extends AppCompatActivity {

    ListView listView;

    String title[] = {"Malabe","Dehiwal","Bellanwila","Maharagama",
    "Nugegoda"};

    String description[]={"Category:Plastic,Food Waste,Glass","Category:Glass,Food Waste","Category:Food Waste","Category:Plastic",
            "Category:Glass"};

    int image[] ={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_report);

        listView = findViewById(R.id.listview);
        CustomeAdapter adapter = new CustomeAdapter(this,title,image,description);
        listView.setAdapter(adapter);
    }
}
class CustomeAdapter extends ArrayAdapter<String>{

    Context context;
    int[] images;
    String[] title;
    String[] des;

    CustomeAdapter(Context context,String[] title,int[] images,String[] des){
        super(context,R.layout.singal_row,R.id.textView,title);
        this.context = context;
        this.images = images;
        this.title = title;
        this.des = des;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = inflater.inflate(R.layout.singal_row,parent,false);

        ImageView imageView = row.findViewById(R.id.imageView7);
        TextView titleview = row.findViewById(R.id.textView);
        TextView descriptionview = row.findViewById(R.id.textView2);

        imageView.setImageResource(images[position]);
        titleview.setText(title[position]);
        descriptionview.setText(des[position]);

        return row;

    }
}

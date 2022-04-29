package com.example.wastemaster;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final int VERSION =1;
    private static final String DB_NAME = "waste_master";
    private static final String TABLE_NAME = "create_bin";

    //Column name
    private static final String ID = "id";
    private static final String CITY = "city";
    private static final String LORD_TYPE = "lord_type";
    private static final String CLEANING_PERIOD = "cleaning_period";


    public DBHandler(@Nullable Context context) {
        super(context, DB_NAME, null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TABLE_CREATE_QUERY = "CREATE TABLE "+TABLE_NAME+" " +
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +CITY + " TEXT,"
                +LORD_TYPE + " TEXT,"
                +CLEANING_PERIOD+ " TEXT," +
                ");";

        /* TABLE waste_master (id INTEGER PRIMARY KEY AUTOINCREMENT, city TEXT, lord_type TEXT,
                cleaning_period TEXT);*/

        db.execSQL(TABLE_CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+ TABLE_NAME;

        // Drop older table if existed
        db.execSQL(DROP_TABLE_QUERY);

        // Create tables again
        onCreate(db);
    }
}

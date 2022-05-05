package com.example.wastemaster.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.example.wastemaster.BinModal;

import java.util.ArrayList;
import java.util.List;


public class DBHandler extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "work.db";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + WorkProfile.Work.TABLE_NAME + " (" +
                    WorkProfile.Work._ID + " INTEGER PRIMARY KEY," +
                    WorkProfile.Work.COLUMN_1 + " TEXT," +
                    WorkProfile.Work.COLUMN_2 + " TEXT,"+
                    WorkProfile.Work.COLUMN_3 + " TEXT,"+
                    WorkProfile.Work.COLUMN_4 + " TEXT,"+
                    WorkProfile.Work.COLUMN_5 + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + WorkProfile.Work.TABLE_NAME;

    //insert data
    public long addwork (String date,String numberofcomplaint,String totalcollectioncountaners,String totalfeildcountainers,String pendingcustomercomplaint){
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(WorkProfile.Work.COLUMN_1, date);
        values.put(WorkProfile.Work.COLUMN_2, numberofcomplaint);
        values.put(WorkProfile.Work.COLUMN_3, totalcollectioncountaners);
        values.put(WorkProfile.Work.COLUMN_4, totalfeildcountainers);
        values.put(WorkProfile.Work.COLUMN_5, pendingcustomercomplaint);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(WorkProfile.Work.TABLE_NAME, null, values);
        return newRowId;
    }

    //update data
    public boolean updatework (String date, String numberofcomplaint, String totalcollectioncountaners, String totalfeildcountainers, String pendingcustomercomplaint){
        SQLiteDatabase db = getWritableDatabase();

        // New value for one column
        ContentValues values = new ContentValues();
        values.put(WorkProfile.Work.COLUMN_2, numberofcomplaint);
        values.put(WorkProfile.Work.COLUMN_3, totalcollectioncountaners);
        values.put(WorkProfile.Work.COLUMN_4, totalfeildcountainers);
        values.put(WorkProfile.Work.COLUMN_5, pendingcustomercomplaint);

        // Which row to update, based on the title
        String selection = WorkProfile.Work.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { "date" };

        int count = db.update(
                WorkProfile.Work.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        if (count >= 1 ){
            return true;
        }
        else{
            return false;
        }
    }

    public void deleteWork (String date){
        SQLiteDatabase db = getWritableDatabase();

        // Define 'where' part of query.
        String selection = WorkProfile.Work.COLUMN_1 + " LIKE ?";
        // Specify arguments in placeholder order.
        String[] selectionArgs = { "date" };
        // Issue SQL statement.
        int deletedRows = db.delete(WorkProfile.Work.TABLE_NAME, selection, selectionArgs);
    }

    public List readAllinfo (){
        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                WorkProfile.Work.COLUMN_1,
                WorkProfile.Work.COLUMN_2,
                WorkProfile.Work.COLUMN_3,
                WorkProfile.Work.COLUMN_4,
                WorkProfile.Work.COLUMN_5
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = WorkProfile.Work.COLUMN_1 + " = ?";
        String[] selectionArgs = { "date" };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                WorkProfile.Work.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                WorkProfile.Work.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List date = new ArrayList<>();
        while(cursor.moveToNext()) {
            String dates = cursor.getString(cursor.getColumnIndexOrThrow(WorkProfile.Work.COLUMN_1));
            date.add(dates);
        }
        cursor.close();
        return date;
    }

    //Search function
    public List readAllinfo (String date) {
        SQLiteDatabase db = getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                WorkProfile.Work.COLUMN_1,
                WorkProfile.Work.COLUMN_2,
                WorkProfile.Work.COLUMN_3,
                WorkProfile.Work.COLUMN_4,
                WorkProfile.Work.COLUMN_5
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = WorkProfile.Work.COLUMN_1 + "LIKE ?";
        String[] selectionArgs = {"date"};

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                WorkProfile.Work.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                WorkProfile.Work.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List dateinfo = new ArrayList<>();
        while (cursor.moveToNext()) {
            String dates = cursor.getString(cursor.getColumnIndexOrThrow(WorkProfile.Work.COLUMN_1));
            String numberofcomplaint = cursor.getString(cursor.getColumnIndexOrThrow(WorkProfile.Work.COLUMN_2));
            String totalcollectioncountaners = cursor.getString(cursor.getColumnIndexOrThrow(WorkProfile.Work.COLUMN_3));
            String totalfeildcountainers = cursor.getString(cursor.getColumnIndexOrThrow(WorkProfile.Work.COLUMN_5));
            String pendingcustomercomplaint = cursor.getString(cursor.getColumnIndexOrThrow(WorkProfile.Work.COLUMN_5));
            dateinfo.add(dates);//0
            dateinfo.add(numberofcomplaint);//1
            dateinfo.add(totalcollectioncountaners);//2
            dateinfo.add(totalfeildcountainers);//3
            dateinfo.add(pendingcustomercomplaint);//4


        }
        cursor.close();
        return dateinfo;
    }

    public void createBin(BinModal binModal) {
    }
}
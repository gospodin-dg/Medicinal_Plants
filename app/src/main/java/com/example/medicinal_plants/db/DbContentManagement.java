package com.example.medicinal_plants.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DbContentManagement {
    private Context context;
    private DbHelper myDbHelper;
    private SQLiteDatabase db;

    public DbContentManagement(Context context){
        this.context = context;
        myDbHelper = new DbHelper(context);
    }

    public void openDB(){
        db = myDbHelper.getWritableDatabase();
    }

    public void insertInDB(String name, String desc){
        ContentValues cv = new ContentValues();
        cv.put(Constants.NAME, name);
        cv.put(Constants.DESCRIPTION, name);
        db.insert(Constants.TABLE_MED_PLANTS, null, cv);
    }

    public List<String> readFromDB(){
        List<String> med_plants = new ArrayList<>();
        Cursor cursor = db.query(Constants.TABLE_MED_PLANTS, null, null, null, null, null, null);
        while (cursor.moveToNext()){
            @SuppressLint("Range")
            String name_plants = cursor.getString(cursor.getColumnIndex(Constants.NAME));
            med_plants.add(name_plants);
        }
        cursor.close();
        return med_plants;
    }

    public void closeDB(){
        myDbHelper.close();
    }

}

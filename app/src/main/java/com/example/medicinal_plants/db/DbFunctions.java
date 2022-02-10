package com.example.medicinal_plants.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DbFunctions {
    private Context context;
    private DbHelper myDbHelper;
    private SQLiteDatabase db;

    public DbFunctions(Context context){
        this.context = context;
        myDbHelper = new DbHelper(context);
    }

    public void openDB(){
        db = myDbHelper.getWritableDatabase();
    }

    public void insertInDB(String name, String desc, String ills, String photo){
        ContentValues cv = new ContentValues();
        cv.put(Constants.NAME, name);
        cv.put(Constants.DESCRIPTION, desc);
        cv.put(Constants.ILLS, ills);
        cv.put(Constants.PHOTO, photo);
        db.insert(Constants.TABLE_MEDPLANTS, null, cv);
    }

    public ArrayList<MedPlant> readAllFromDB(){
        ArrayList<MedPlant> med_plants = new ArrayList<MedPlant>();
        Cursor cursor = db.query(Constants.TABLE_MEDPLANTS, null, null, null, null, null, null);
        while (cursor.moveToNext()){

            MedPlant medPlant = new MedPlant();
            @SuppressLint("Range")
            String name_plants = cursor.getString(cursor.getColumnIndex(Constants.NAME));
            medPlant.setName(name_plants);
            @SuppressLint("Range")
            String des_plants = cursor.getString(cursor.getColumnIndex(Constants.DESCRIPTION));
            medPlant.setDesc(des_plants);
            @SuppressLint("Range")
            String ill_plants = cursor.getString(cursor.getColumnIndex(Constants.ILLS));
            medPlant.setIll(ill_plants);
            @SuppressLint("Range")
            String photo_plants = cursor.getString(cursor.getColumnIndex(Constants.PHOTO));
            medPlant.setPhoto(photo_plants);

            med_plants.add(medPlant);
        }
        cursor.close();
        return med_plants;
    }



    public void closeDB(){
        myDbHelper.close();
    }

}

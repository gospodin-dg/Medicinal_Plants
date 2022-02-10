package com.example.medicinal_plants.db;

public class Constants {

    public static final String DB_NAME = "Medicinal_plants.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_MEDPLANTS = "medicinal_plants";
    public static final String TABLE_ILLS = "ills";

    public static final String _ID = "_id";
    public static final String  PHOTO = "med_plant_photo";
    public static final String NAME = "name";
    public static final String  DESCRIPTION = "desc";
    public static final String  ILLS = "ills";
    public static final String  MED_PLANTS = "med_plants";

    public static final String  FOREIGN_KEY = "foreign_key";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_MEDPLANTS + " (" +
            _ID + " INTEGER PRIMARY KEY," +
            NAME + " TEXT," +
            DESCRIPTION + " TEXT," +
            ILLS + " TEXT," +
            PHOTO + " TEXT)";


    public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_MEDPLANTS;

}

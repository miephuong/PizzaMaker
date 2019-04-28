package com.example.pizzamaker.UserRegistration;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDatabase extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "User.db";


    public UserDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_USER_TABLE = "create table " + UserContract.UserEntry.TABLE_NAME + " ("
                + UserContract.UserEntry.ID + " INTERGER PRIMARY KEY AUTOINCREMENT,"
                + UserContract.UserEntry.COL_USER_NAME + " TEXT NOT NULL,"
                + UserContract.UserEntry.COL_USER_MAIL + " TEXT,"
                + UserContract.UserEntry.COL_USER_PHONE + " INTERGER,"
                + UserContract.UserEntry.COL_USER_CITY + " TEXT);";
        db.execSQL(SQL_CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + UserContract.UserEntry.TABLE_NAME + ";");
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public boolean insertData(String user_name, String user_email, String user_phone, String user_city){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.UserEntry.COL_USER_NAME, user_name);
        contentValues.put(UserContract.UserEntry.COL_USER_MAIL, user_email);
        contentValues.put(UserContract.UserEntry.COL_USER_PHONE, user_phone);
        contentValues.put(UserContract.UserEntry.COL_USER_CITY, user_city);


        long result = db.insert(UserContract.UserEntry.TABLE_NAME, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }



}

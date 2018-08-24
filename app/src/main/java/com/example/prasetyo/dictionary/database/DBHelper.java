package com.example.prasetyo.dictionary.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
    private static String DATABASE_NAME = "dbKamus";

    private static final int DATABASE_VERSION = 1;

    public static String CREATE_TABLE_INDONESIA = "create table "+DatabaseContract.TABLE_INDONESIA+
            " ("+ DatabaseContract.KamusColumns._ID+" integer primary key autoincrement, " +
            DatabaseContract.KamusColumns.INDONESIA+" text not null, " +
            DatabaseContract.KamusColumns.INGGRIS+" text not null);";

    public static String CREATE_TABLE_INGGRIS = "create table "+DatabaseContract.TABLE_INGGRIS+
            " ("+ DatabaseContract.KamusColumns._ID+" integer primary key autoincrement, " +
            DatabaseContract.KamusColumns.INGGRIS+" text not null, " +
            DatabaseContract.KamusColumns.INDONESIA+" text not null);";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_INDONESIA);
        db.execSQL(CREATE_TABLE_INGGRIS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ DatabaseContract.TABLE_INDONESIA);
        db.execSQL("DROP TABLE IF EXISTS "+ DatabaseContract.TABLE_INGGRIS);
        onCreate(db);
    }
}

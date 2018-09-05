package com.example.prasetyo.dictionary.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.example.prasetyo.dictionary.model.Kamus;

import java.util.ArrayList;

public class KamusHelper {
    private Context context;
    private DBHelper dataBaseHelper;

    private SQLiteDatabase database;

    public KamusHelper(Context context) {
        this.context = context;
    }

    public KamusHelper open() throws SQLException {
        dataBaseHelper = new DBHelper(context);
        database = dataBaseHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dataBaseHelper.close();
    }

    public ArrayList<Kamus> getDataByIndonesia(String keyword) {
        String result = "";
        Cursor cursor = database.query(DatabaseContract.TABLE_INDONESIA, null, DatabaseContract.KamusColumns.INDONESIA + " LIKE ?", new String[]{keyword}, null, null, DatabaseContract.KamusColumns._ID + " ASC", null);
        cursor.moveToFirst();
        ArrayList<Kamus> arrayList = new ArrayList<>();
        Kamus Kamus;
        if (cursor.getCount() > 0) {
            do {
                Kamus = new Kamus();
                Kamus.setId(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.KamusColumns._ID)));
                Kamus.setIndonesia(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.KamusColumns.INDONESIA)));
                Kamus.setInggris(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.KamusColumns.INGGRIS)));

                arrayList.add(Kamus);
                cursor.moveToNext();

            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

    public ArrayList<Kamus> getDataByInggris(String keyword) {
        String result = "";
        Cursor cursor = database.query(DatabaseContract.TABLE_INGGRIS, null, DatabaseContract.KamusColumns.INDONESIA + " LIKE ?", new String[]{keyword}, null, null, DatabaseContract.KamusColumns._ID + " ASC", null);
        cursor.moveToFirst();
        ArrayList<Kamus> arrayList = new ArrayList<>();
        Kamus Kamus;
        if (cursor.getCount() > 0) {
            do {
                Kamus = new Kamus();
                Kamus.setId(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.KamusColumns._ID)));
                Kamus.setIndonesia(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.KamusColumns.INDONESIA)));
                Kamus.setInggris(cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.KamusColumns.INGGRIS)));

                arrayList.add(Kamus);
                cursor.moveToNext();

            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

    public void beginTransaction() {
        database.beginTransaction();
    }

    public void setTransactionSuccess() {
        database.setTransactionSuccessful();
    }

    public void endTransaction() {
        database.endTransaction();
    }

    public void insertTransactionIndonesia(Kamus Kamus) {
        String sql = "INSERT INTO " + DatabaseContract.TABLE_INDONESIA + " (" + DatabaseContract.KamusColumns.INDONESIA + ", " + DatabaseContract.KamusColumns.INGGRIS
                + ") VALUES (?, ?)";
        SQLiteStatement stmt = database.compileStatement(sql);
        stmt.bindString(1, Kamus.getIndonesia());
        stmt.bindString(2, Kamus.getInggris());
        stmt.execute();
        stmt.clearBindings();

    }

    public void insertTransactionInggris(Kamus Kamus) {
        String sql = "INSERT INTO " + DatabaseContract.TABLE_INGGRIS + " (" + DatabaseContract.KamusColumns.INDONESIA + ", " + DatabaseContract.KamusColumns.INGGRIS
                + ") VALUES (?, ?)";
        SQLiteStatement stmt = database.compileStatement(sql);
        stmt.bindString(2, Kamus.getIndonesia());
        stmt.bindString(1, Kamus.getInggris());
        stmt.execute();
        stmt.clearBindings();

    }
}

package com.example.prasetyo.dictionary.util;

import android.provider.BaseColumns;

public class DatabaseContract {
    static String TABLE_INDONESIA = "table_indonesia";
    static String TABLE_INGGRIS = "table_inggris";

    static final class MahasiswaColumns implements BaseColumns {

        // Mahasiswa nama
        static String INDONESIA = "indonesia";
        // Mahasiswa nim
        static String INGGRIS = "inggris";

    }
}

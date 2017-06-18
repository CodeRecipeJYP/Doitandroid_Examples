package com.asuscomm.yangyinetwork.doitandroid_examples.logic.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jaeyoung on 2017. 6. 18..
 */

public class MySqliteOpenHeloper extends SQLiteOpenHelper {
    private static final String DB_NAME = "name";
    private static final int DB_VERSION = 0;

    public MySqliteOpenHeloper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String q = "CREATE TABLE test (" +
                "name TEXT" +
                ", age INTEGER" +
                ")";
        db.execSQL(q);

        q = "INSERT (" +
                "name" +
                ",age" +
                ") INTO test VALUES(" +
                "WooJu" +
                ",25)";
        db.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

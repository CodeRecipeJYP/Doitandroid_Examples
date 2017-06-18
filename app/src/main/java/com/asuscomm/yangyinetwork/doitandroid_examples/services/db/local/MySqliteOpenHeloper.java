package com.asuscomm.yangyinetwork.doitandroid_examples.services.db.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by jaeyoung on 2017. 6. 18..
 */

public class MySqliteOpenHeloper extends SQLiteOpenHelper {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();
    private static final String DB_NAME = "test_db2";
    private static final int DB_VERSION = 1;

    public MySqliteOpenHeloper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate: ");
        String q = "CREATE TABLE chat (" +
                "name TEXT" +
                ", ismine INTEGER" +
                ", content TEXT" +
                ")";
        db.execSQL(q);
//
//        q = "INSERT TABLE test(" +
//                "name" +
//                ",age" +
//                ") VALUES(" +
//                "WooJu" +
//                ",25)";
//        db.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

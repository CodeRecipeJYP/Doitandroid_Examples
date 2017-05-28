package com.asuscomm.yangyinetwork.doitandroid_examples;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by jaeyoung on 2017. 5. 28..
 */

public class DBHelper extends SQLiteOpenHelper {
    String TAG = "JYP/DBHelper";
    String TABLE_NAME;

    public DBHelper(Context context, String name, int version) {
        super(context, name, null, version);
        TABLE_NAME = name;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate() called with: db = [" + db + "]");

        Log.d(TAG, "onCreate: dropping table.");
        String DROP_SQL = "drop table if exists " + TABLE_NAME;
        db.execSQL(DROP_SQL);

        Log.d(TAG, "onCreate: creating table.");
        String CREATE_SQL = "create table " +TABLE_NAME + "("
                            + " _id integer PRIMARY KEY autoincrement, "
                            + " name text, "
                            + " age integer, "
                            + " phone text)";

        db.execSQL(CREATE_SQL);

        Log.d(TAG, "onCreate: inserting records.");
        String[] INSERT_SQL = {
                "insert into " + TABLE_NAME + "(name, age, phone) values ('John', 20, '010-7788-1234' );",
                "insert into " + TABLE_NAME + "(name, age, phone) values ('Brown', 40, '010-7788-1234' );",
                "insert into " + TABLE_NAME + "(name, age, phone) values ('Yang', 34, '010-7788-1234' );"
        };
        for (int i = 0; i < INSERT_SQL.length; i++) {
            db.execSQL(INSERT_SQL[i]);
        }
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        Log.d(TAG, "onOpen() called with: TABLE_NAME = [" + TABLE_NAME+ "]");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG, "onUpgrade: Upgrading database from version " + oldVersion + " to " +newVersion + ".");
    }
}

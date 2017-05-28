package com.asuscomm.yangyinetwork.doitandroid_examples;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String TAG = "JYP/MainActivity";
    SQLiteDatabase db;
    EditText databaseNameInput,tableNameInput;
    Button createDatabaseBtn, createTableBtn;
    String databaseName, tableName;
    TextView statusTv;
    boolean databaseCreated=false, tableCreated =false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseNameInput = (EditText) findViewById(R.id.databaseNameInput);
        tableNameInput = (EditText) findViewById(R.id.tableNameInput);

        createDatabaseBtn = (Button) findViewById(R.id.createDatabaseBtn);
        createDatabaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseName = databaseNameInput.getText().toString();
                createDatabase(databaseName);
            }
        });

        createTableBtn = (Button) findViewById(R.id.createTableBtn);
        createTableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tableName = tableNameInput.getText().toString();
                createTable(tableName);
                int count = insertRecord(tableName);
                Log.d(TAG, "onClick: "+count+" records inserted.");
            }
        });

        statusTv = (TextView) findViewById(R.id.statusTv);
    }

    private void createDatabase(String name) {
        Log.d(TAG, "createDatabase() called with: name = [" + name + "]");

        try {
            db = openOrCreateDatabase(name, MODE_WORLD_WRITEABLE, null);
            databaseCreated = true;
            Log.d(TAG, "createDatabase: database is created.");
        } catch(Exception ex) {
            ex.printStackTrace();
            Log.d(TAG, "createDatabase: database is not created.");
        }
    }

    private void createTable(String name) {
        Log.d(TAG, "createTable() called with: name = [" + name + "]");

        db.execSQL("create table " + name + "("
                                + " _id integer PRIMARY KEY autoincrement, "
                                + " name text, "
                                + " age integer, "
                                + " phone text);");

        tableCreated = true;
    }

    private int insertRecord(String name) {
        Log.d(TAG, "insertRecord() called with: name = [" + name + "]");

        int count = 3;
        db.execSQL( "insert into " + name + "(name, age, phone) values ( 'John', 20, '010-7788-1234');");

        return count;
    }

}

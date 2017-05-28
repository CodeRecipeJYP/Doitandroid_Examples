package com.asuscomm.yangyinetwork.doitandroid_examples;

import android.database.Cursor;
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
    String TABLE_NAME;
    Button btn1, btn2;
    EditText input1, input2;
    TextView tvStatus;
    DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: btn1");
                boolean isOpen = openDatabase();
                if(isOpen) {
                    executeRawQuery();
                    executeRawQueryParam();
                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: btn2");
            }
        });

        input1 = (EditText) findViewById(R.id.input1);
        input2 = (EditText) findViewById(R.id.input2);
        tvStatus = (TextView) findViewById(R.id.tvStatus);
    }

    private boolean openDatabase() {

        TABLE_NAME = input1.getText().toString();
        dbHelper = new DBHelper(MainActivity.this, TABLE_NAME, 1);
        db = dbHelper.getWritableDatabase();

        return true;
    }

    private void executeRawQuery() {
        Log.d(TAG, "executeRawQuery: executeRawQuery called");

        Cursor c1 = db.rawQuery("select count(*) as Total from " +TABLE_NAME, null);
        println("executeRawQuery: "+c1.getCount());
        c1.moveToNext();
        c1.getInt(0);
        println("record count : "+c1.getInt(0));
        c1.close();
    }

    private void executeRawQueryParam() {
        println("executeRawQueryParam called.");

        String SQL = "select name, age, phone " +
                " from "+TABLE_NAME + " where age > ?";

        String[] args = {"30"};

        Cursor c1 = db.rawQuery(SQL, args);
        int recordCount = c1.getCount();
        println("cursor count : " + recordCount);

        for (int i = 0; i < recordCount; i++) {
            c1.moveToNext();
            String name = c1.getString(0);
            int age = c1.getInt(1);
            String phone = c1.getString(2);

            println("Record #"+i+" : " +name +", " + age+", " +phone);
        }

        c1.close();
    }

    private void println(String s) {
        tvStatus.setText(tvStatus.getText().toString()+ '\n'
                +s);
    }
}

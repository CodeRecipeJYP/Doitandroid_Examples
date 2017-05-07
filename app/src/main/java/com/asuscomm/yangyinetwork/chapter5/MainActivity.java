package com.asuscomm.yangyinetwork.chapter5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        CustomView mView = new CustomView(this);
        setContentView(mView);
    }
}

package com.asuscomm.yangyinetwork.doitandroid_partial_examples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        startLogService();
    }
    
    private void startLogService() {
        Log.d(TAG, "startLogService: ");
        Intent intent = new Intent(getApplicationContext(), MyService.class);
        startService(intent);
    }
}

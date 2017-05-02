package com.asuscomm.yangyinetwork.doitandroid_examples.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.asuscomm.yangyinetwork.doitandroid_examples.R;

public class MenuActivity extends AppCompatActivity {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        initView();
    }

    private void initView() {
        findViewById(R.id.gogakBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick() called with: v = [" + v + "]");
                startActivityForResult();
            }
        });

        findViewById(R.id.machulBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick() called with: v = [" + v + "]");
            }
        });

        findViewById(R.id.sangpumBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick() called with: v = [" + v + "]");
            }
        });
    }
}

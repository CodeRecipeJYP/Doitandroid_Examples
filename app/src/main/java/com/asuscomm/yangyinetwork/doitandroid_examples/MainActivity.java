package com.asuscomm.yangyinetwork.doitandroid_examples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MainActivity extends AppCompatActivity {
    String TAG = "JYP/MainActivity";
    Button btn1, btn2;
    EditText input1, input2;
    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "onCreate() called with: token = [" + token + "]");

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: btn1");
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

        FirebaseInstanceId.getInstance().getToken();
    }


    private void println(String s) {
        tvStatus.setText(tvStatus.getText().toString()+ '\n'
                +s);
    }
}

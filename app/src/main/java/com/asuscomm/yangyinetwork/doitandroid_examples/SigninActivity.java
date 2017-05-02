package com.asuscomm.yangyinetwork.doitandroid_examples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SigninActivity extends AppCompatActivity {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();
    private EditText mEmailEditText;
    private EditText mPwEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        
        initView();
    }
    
    private void initView() {
        mEmailEditText= (EditText) findViewById(R.id.emailEditText);
        mPwEditText = (EditText) findViewById(R.id.pwEditText);
        findViewById(R.id.submitBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValidForm()) {
                    String email = mEmailEditText.getText().toString();
                    String pw = mPwEditText.getText().toString();
                    signin(email,pw);
                } else {
                    
                }
            }
        });
    }
    
    private boolean isValidForm() {
        return true;
    }
    
    private void signin(String email, String pw) {
        Log.d(TAG, "signin() called with: email = [" + email + "], pw = [" + pw + "]");
    }
}

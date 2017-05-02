package com.asuscomm.yangyinetwork.doitandroid_examples.signin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.asuscomm.yangyinetwork.doitandroid_examples.R;
import com.asuscomm.yangyinetwork.doitandroid_examples.menu.MenuActivity;

public class SigninActivity extends AppCompatActivity {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();
    private EditText mEmailEditText;
    private EditText mPwEditText;
    private Button mSubmitBtn;
    public interface KEYS {
        String ACCOUNT = "account";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        
        initView();
    }
    
    private void initView() {
        mEmailEditText= (EditText) findViewById(R.id.emailEditText);
        mPwEditText = (EditText) findViewById(R.id.pwEditText);
        mSubmitBtn = (Button)findViewById(R.id.submitBtn);

        Log.d(TAG, "initView: setClickable false"); // ???
        mSubmitBtn.setClickable(false);
        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmailEditText.getText().toString();

                if(isValidEmail(email)) {
                    String pw = mPwEditText.getText().toString();
                    signin(email,pw);
                } else {
                    Toast.makeText(SigninActivity.this, "Invalid Email.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mSubmitBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(mSubmitBtn.isClickable()) {
                    Log.d(TAG, "onTouch: clickable");
                    return false;
                } else {
                    Log.d(TAG, "onTouch: unclickable");
                    Toast.makeText(SigninActivity.this, "Please fill the forms.", Toast.LENGTH_SHORT).show();

                    return true; // It means I consumed the touch event
                }
            }
        });

        mEmailEditText.addTextChangedListener(mTextWatcher);
        mPwEditText.addTextChangedListener(mTextWatcher);
    }

    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            Log.d(TAG, "afterTextChanged: ");
            mSubmitBtn.setClickable(isFilledForm());
        }
    };
    
    private boolean isFilledForm() {
        if (mEmailEditText.getText().length() > 0 & mPwEditText.getText().length() > 0)
        {
            Log.d(TAG, "isValidForm: true");
            return true;
        }
        Log.d(TAG, "isValidForm: false");
        return false;
    }

    private boolean isValidEmail(String email) {
        Log.d(TAG, "isValidEmail() called with: email = [" + email + "]");
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();

    }
    
    private void signin(String email, String pw) {
        Log.d(TAG, "signin() called with: email = [" + email + "], pw = [" + pw + "]");
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        intent.putExtra(KEYS.ACCOUNT,email);
        startActivity(intent);
    }
}

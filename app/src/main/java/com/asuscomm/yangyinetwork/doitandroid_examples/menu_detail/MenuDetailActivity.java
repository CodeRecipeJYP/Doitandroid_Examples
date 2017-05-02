package com.asuscomm.yangyinetwork.doitandroid_examples.menu_detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.asuscomm.yangyinetwork.doitandroid_examples.R;
import com.asuscomm.yangyinetwork.doitandroid_examples.menu.MenuActivity;
import com.asuscomm.yangyinetwork.doitandroid_examples.menu_detail.domain.RequestData;

public class MenuDetailActivity extends AppCompatActivity {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();
    private RequestData requestData;

    public interface KEYS {
        String MESSAGE = "message";
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);

        Log.d(TAG, "onCreate: ");
        processIntent();
        initView();
    }

    private void initView() {
        Log.d(TAG, "initView: ");
        ((Button)findViewById(R.id.titleTextView)).setText(requestData.getRequest());
        findViewById(R.id.closeBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra(KEYS.MESSAGE, requestData.getRequest()+" 종료");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void processIntent() {
        Bundle bundle = getIntent().getExtras();
        requestData = bundle.getParcelable(MenuActivity.KEY_REQUEST_DATA);
        Log.d(TAG, "processIntent: "+requestData.toString());
    }
}

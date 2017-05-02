package com.asuscomm.yangyinetwork.doitandroid_examples.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.asuscomm.yangyinetwork.doitandroid_examples.R;
import com.asuscomm.yangyinetwork.doitandroid_examples.menu_detail.MenuDetailActivity;
import com.asuscomm.yangyinetwork.doitandroid_examples.menu_detail.domain.RequestData;
import com.asuscomm.yangyinetwork.doitandroid_examples.menu_detail.domain.Requests;

public class MenuActivity extends AppCompatActivity {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();
    public static final String KEY_REQUEST_DATA = "request_data";

    interface REQUEST_CODE {
        int gogak = 1;
        int machul = 2;
        int sangpum = 3;
    }

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
                Intent intent = new Intent(getApplicationContext(), MenuDetailActivity.class);
                RequestData requestData = new RequestData(Requests.gogak);
                intent.putExtra(KEY_REQUEST_DATA,requestData);
                startActivityForResult(intent, REQUEST_CODE.gogak);
            }
        });

        findViewById(R.id.machulBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick() called with: v = [" + v + "]");
                Intent intent = new Intent(getApplicationContext(), MenuDetailActivity.class);
                RequestData requestData = new RequestData(Requests.machul);
                intent.putExtra(KEY_REQUEST_DATA,requestData);
                startActivityForResult(intent, REQUEST_CODE.machul);
            }
        });

        findViewById(R.id.sangpumBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick() called with: v = [" + v + "]");
                Intent intent = new Intent(getApplicationContext(), MenuDetailActivity.class);
                RequestData requestData = new RequestData(Requests.sangpum);
                intent.putExtra(KEY_REQUEST_DATA,requestData);
                startActivityForResult(intent, REQUEST_CODE.sangpum);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            String srcActivity = "";

            switch (requestCode) {
                case REQUEST_CODE.gogak:
                    srcActivity = Requests.gogak;
                    break;
                case REQUEST_CODE.machul:
                    srcActivity = Requests.machul;
                    break;
                case REQUEST_CODE.sangpum:
                    srcActivity = Requests.sangpum;
                    break;
            }

            String message = (String)data.getExtras().get(MenuDetailActivity.KEYS.MESSAGE);
            Toast.makeText(this, "From : " + srcActivity + " Message : "+message, Toast.LENGTH_SHORT).show();
        } else if(resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "RESULT_CANCELED", Toast.LENGTH_SHORT).show();
        }
    }
}

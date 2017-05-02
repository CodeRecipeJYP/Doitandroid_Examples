package com.asuscomm.yangyinetwork.doitandroid_examples.menu_detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.asuscomm.yangyinetwork.doitandroid_examples.R;
import com.asuscomm.yangyinetwork.doitandroid_examples.menu.MenuActivity;
import com.asuscomm.yangyinetwork.doitandroid_examples.menu_detail.domain.RequestData;

public class MenuDetailActivity extends AppCompatActivity {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_detail);

        Log.d(TAG, "onCreate: ");
        processIntent();
    }

    private void processIntent() {
        Bundle bundle = getIntent().getExtras();
        RequestData requestData = bundle.getParcelable(MenuActivity.KEY_REQUEST_DATA);
        Log.d(TAG, "processIntent: "+requestData.toString());
    }
}

package com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.asuscomm.yangyinetwork.doitandroid_examples.ui.main.fragments.adapter.CustomFragmentPagerAdapter;
import com.asuscomm.yangyinetwork.doitandroid_examples.R;

public class MainActivity extends AppCompatActivity {
    String TAG = "JYP/MainActivity";
    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStatus = (TextView) findViewById(R.id.tvStatus);
        println("init ViewPager");
        TabLayout tabs = (TabLayout) findViewById(R.id.main_tabs);
        ViewPager pager = (ViewPager) findViewById(R.id.main_pager);
        pager.setAdapter(new CustomFragmentPagerAdapter(getSupportFragmentManager()));

    }

    private void println(String s) {
        tvStatus.setText(tvStatus.getText().toString()+ '\n'
                +s);
        Log.d(TAG, "println: "+s);
    }
}

package com.asuscomm.yangyinetwork.chapter5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
//    MyMainFragment myMainFragment;
//    MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        myMainFragment = (MyMainFragment)getSupportFragmentManager().findFragmentById(R.id.myMainFrag);
//        menuFragment = new MenuFragment();
    }

//    public void onFragmentChanged(int index) {
//        if(index == 0) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit();
//        }
//    }
}

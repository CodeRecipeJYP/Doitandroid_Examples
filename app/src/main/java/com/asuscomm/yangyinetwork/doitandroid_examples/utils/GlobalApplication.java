package com.asuscomm.yangyinetwork.doitandroid_examples.utils;

import android.app.Application;
import android.util.Log;

import com.asuscomm.yangyinetwork.doitandroid_examples.BuildConfig;
import com.facebook.stetho.Stetho;

/**
 * Created by jaeyoung on 2017. 6. 18..
 */

public class GlobalApplication extends Application {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate: ");
        if(BuildConfig.DEBUG) {
            initStetho();
        }
    }

    public void initStetho() {
        Log.d(TAG, "initStetho: ");
        Stetho.initializeWithDefaults(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}

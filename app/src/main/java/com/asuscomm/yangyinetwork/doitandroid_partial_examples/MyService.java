package com.asuscomm.yangyinetwork.doitandroid_partial_examples;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service implements Runnable {
    private final String TAG = "jaeyoung/"+getClass().getSimpleName();
    private int count = 0;

    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate: ");
        super.onCreate();

        Thread loggingThread = new Thread(this);
        loggingThread.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void run() {
        while(count < 30) {
            Log.i(TAG, "run: count = "+count);
            count++;

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

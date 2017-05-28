package com.asuscomm.yangyinetwork.doitandroid_examples;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by jaeyoung on 2017. 5. 28..
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {   
    private final String TAG = "JYP/"+getClass().getSimpleName();

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "onTokenRefresh: refreshedToken=["+refreshedToken+"]");
        sendRegisterationToServer(refreshedToken);
    }

    private void sendRegisterationToServer(String token) {
        Log.d(TAG, "sendRegisterationToServer() called with: token = [" + token + "]");
    }
}

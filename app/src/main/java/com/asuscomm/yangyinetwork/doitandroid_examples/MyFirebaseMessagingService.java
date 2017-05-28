package com.asuscomm.yangyinetwork.doitandroid_examples;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by jaeyoung on 2017. 5. 28..
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private final String TAG = "JYP/"+getClass().getSimpleName();

    private static final int NOTIFICATION_ID = 1;

    private NotificationManager mNotificationManager;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "onMessageReceived() called with: remoteMessage = [" + remoteMessage + "]");

        if(remoteMessage.getData().size()>0) {
            Log.d(TAG, "onMessageReceived: Message data payload : "+remoteMessage.getData());
        }

        if(remoteMessage.getNotification() != null) {
            Log.d(TAG, "onMessageReceived: "+remoteMessage.getNotification());
            Log.d(TAG, "onMessageReceived: NotificationBody : "+remoteMessage.getNotification().getBody());
            mNotificationManager.notify(NOTIFICATION_ID, createNotification(remoteMessage.getNotification().getBody(),
                    true));
        }
    }




    private Notification createNotification (String title, boolean makeHeadsUpNotification){
        Notification.Builder notificationBuilder = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_notification)
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setContentTitle("Sample Notification")
                .setContentText("This is a normal notification.");
        if (makeHeadsUpNotification) {
            Intent push = new Intent();
            push.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            push.setClass(this, MainActivity.class);

            PendingIntent fullScreenPendingIntent = PendingIntent.getActivity(this, 0,
                    push, PendingIntent.FLAG_CANCEL_CURRENT);
            notificationBuilder
                    .setContentText(title)
                    .setFullScreenIntent(fullScreenPendingIntent, true);
        }
        return notificationBuilder.build();
    }

    @Override
    public void onCreate () {
        super.onCreate();
        mNotificationManager = (NotificationManager) this.getSystemService(Context
                .NOTIFICATION_SERVICE);
    }
}
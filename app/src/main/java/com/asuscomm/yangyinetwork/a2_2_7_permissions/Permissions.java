package com.asuscomm.yangyinetwork.a2_2_7_permissions;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by jaeyoung on 2017. 5. 5..
 */

public class Permissions {
    private static final String TAG = "jaeyoung/"+"Permissions";
    
    public static void chkPermissions(Activity activity, String permission) {
        
        int permissionCheck = ContextCompat.checkSelfPermission(activity, permission);
        
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "chkPermissions: 권힌 있음");
        } else {
            Log.d(TAG, "chkPermissions: 권한 없음");
            
            requestPermissions(activity, permission);
        }
    }
    
    public static void requestPermissions(Activity activity, String permission){
        int idx = 0;
        if(ActivityCompat.shouldShowRequestPermissionRationale(
                activity, permission)){
            Log.d(TAG, "requestPermissions: 권한설명 필요");
        } else {
            ActivityCompat.requestPermissions(
                    activity, new String[] {permission}, idx);
        }
    }
}

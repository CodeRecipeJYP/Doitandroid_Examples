package com.asuscomm.yangyinetwork.doitandroid_examples;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String TAG = "JYP/MainActivity";
    Button btn1, btn2;
    EditText input1, input2;
    TextView tvStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: btn1");
                startLocationService();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: btn2");
            }
        });

        input1 = (EditText) findViewById(R.id.input1);
        input2 = (EditText) findViewById(R.id.input2);
        tvStatus = (TextView) findViewById(R.id.tvStatus);
    }


    private void println(String s) {
        tvStatus.setText(tvStatus.getText().toString() + '\n'
                + s);
    }


    void requestPermissions(String permission){
                int idx = 0;
                if(ActivityCompat.shouldShowRequestPermissionRationale(
                        this, permission)){
                        Log.d(TAG, "requestPermissions: 권한설명 필요");
                    } else {
                        ActivityCompat.requestPermissions(
                                        this, new String[] {permission}, idx);
                    }
            }

    private void startLocationService() {
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(Manifest.permission.ACCESS_FINE_LOCATION);
            requestPermissions(Manifest.permission.ACCESS_COARSE_LOCATION);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "startLocationService: permisision return");
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
        }

        Log.d(TAG, "startLocationService: getLastLocation");
        Location lastLocation = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (lastLocation != null) {

            Double latitude = lastLocation.getLatitude();
            Double longitude = lastLocation.getLongitude();
            Log.d(TAG, "startLocationService: "+"Latitude : "+latitude +"Longitude : "+ longitude);
            println("Latitude : "+latitude +"Longitude : "+ longitude);
        }
        else {
            Log.d(TAG, "startLocationService: lastLocation is null");
        }
    }
}

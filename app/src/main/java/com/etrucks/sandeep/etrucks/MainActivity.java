package com.etrucks.sandeep.etrucks;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String[] INITIAL_PERMS={
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) ==
                        PackageManager.PERMISSION_GRANTED) {

        } else {
            Toast.makeText(this, "Permission problem", Toast.LENGTH_LONG).show();
            ActivityCompat.requestPermissions(MainActivity.this,INITIAL_PERMS,120);


        }

        Intent intent = new Intent(this, MyService.class);
        startService(intent);

        /*
       Thread worker= new Thread(new Runnable() {
            public void run() {
                // a potentially  time consuming task

                try {
                    for(int i=0;i<100;i++)
                    ts.doInBackground();


                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        worker.start();

*/





    }//end onCreate










}//end mainactivity

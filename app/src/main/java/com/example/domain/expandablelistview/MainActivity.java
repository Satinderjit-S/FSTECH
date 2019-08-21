package com.example.domain.expandablelistview;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    final String UNLOCKSCRIPT= "AT+GTOUT=gv350m,0,,,1,5,2,0,0,0,,,,,,,2,0,0,0,,,FFFF$";
    final String LOCKSCRIPT = "AT+GTOUT=gv350m,0,,,0,0,0,1,5,2,,,,,,,4,0,0,0,,,FFFF$";
    final String LOCKSCRIPTOLD="AT+GTOUT=gv300w,0,,,1,5,2,0,0,0,2,,,,,,,FFFF$";
    final String UNLOCKSCRIPTOLD="AT+GTOUT=gv300w,0,,,0,0,0,1,5,2,4,,0,0,,,,FFFF$";

    String vehicleSelected="E-055";
    HashMap<String, String> mapKeyScript = new HashMap<>();

    String [] vehicles={"E-055","S-077","H-224","S-331","M-427","M-703","T-848","M-877","S-913","R-943","R-833","H-541"};
    String [] numPhone={"6398607525","5879253110","6395816393","6398604278","5879253151","8736082549","6398604281","6395829718","5879253140","6395829714","6399638910","6399638266"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<vehicles.length;i++)
        {
            mapKeyScript.put(vehicles[i],numPhone[i]);
        }
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, vehicles);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        ImageButton btnLock = (ImageButton)findViewById(R.id.lock);
        btnLock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(vehicleSelected=="E-055" || vehicleSelected=="M-427" )
                {
                    oldlockFunction(mapKeyScript.get(vehicleSelected));
                }else{
                    lockFunction(mapKeyScript.get(vehicleSelected));
                }
            }
        });

        ImageButton btnUnlock = (ImageButton)findViewById(R.id.unlock);
        btnUnlock.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(vehicleSelected=="E-055" || vehicleSelected=="M-427" )
                {
                    oldunlockFunction(mapKeyScript.get(vehicleSelected));
                }else{
                    unlockFunction(mapKeyScript.get(vehicleSelected));
                }
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),vehicles[position] , Toast.LENGTH_LONG).show();
        vehicleSelected=vehicles[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    void lockFunction(String num)
    {
        Uri uri = Uri.parse("smsto:"+num);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", LOCKSCRIPT);
        startActivity(intent);
    }
    void unlockFunction(String num)
    {
        Uri uri = Uri.parse("smsto:"+num);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", UNLOCKSCRIPT);
        startActivity(intent);

    }
    void oldlockFunction(String num)
    {
        Uri uri = Uri.parse("smsto:"+num);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", LOCKSCRIPTOLD);
        startActivity(intent);

    }
    void oldunlockFunction(String num)
    {
        Uri uri = Uri.parse("smsto:"+num);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", UNLOCKSCRIPTOLD);
        startActivity(intent);

    }



}

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
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ExplandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    final String UNLOCKSCRIPT= "AT+GTOUT=gv350m,0,,,1,5,2,0,0,0,,,,,,,2,0,0,0,,,FFFF$";
    final String LOCKSCRIPT = "AT+GTOUT=gv350m,0,,,0,0,0,1,5,2,,,,,,,4,0,0,0,,,FFFF$";
    final String LOCKSCRIPTOLD="AT+GTOUT=gv300w,0,,,1,5,2,0,0,0,2,,,,,,,FFFF$";
    final String UNLOCKSCRIPTOLD="AT+GTOUT=gv300w,0,,,0,0,0,1,5,2,4,,0,0,,,,FFFF$";
    final String NUMS331="6398604278";
    final String NUMT848="6398604281";
    final String NUME55="6398607525";
    final String NUMM44="5879253122";
    final String NUMS913="5879253140";
    final String NUMM427="5879253151";
    final String NUMS77="5879253110";
    final String NUMR947="6395829714";
    final String NUMH224="6395816393";
    final String NUMM703="8736082549";
    final String NUMM877="6395829718";
    final String NUMR833="6399638910";
    final String NUMH541="6399638266";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expListView = (ExpandableListView) findViewById(R.id.mainlistview);

        // preparing list data
        prepareListData();
        listAdapter = new ExplandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                String carnum = listDataHeader.get(groupPosition);
                switch(carnum)
                {
                    case "E-055":
                        if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition)=="Lock Vehicle")
                        {
                            oldlockFunction(NUME55);

                        }
                        else
                            oldunlockFunction(NUME55);
                            break;
                    case "M-427":
                        if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition)=="Lock Vehicle")
                        {
                            oldlockFunction(NUMM427);
                        }
                        else
                            oldunlockFunction(NUMM427);
                        break;
                    case "S-077":
                        if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition)=="Lock Vehicle")
                        {
                            lockFunction(NUMS77);

                        }
                        else
                            unlockFunction(NUMS77);
                            break;
                    case "H-224":
                        if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition)=="Lock Vehicle")
                        {
                            lockFunction(NUMH224);
                        }
                        else
                            unlockFunction(NUMH224);
                            break;
                    case "S-331":
                        if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition)=="Lock Vehicle")
                        {
                            lockFunction(NUMS331);
                        }
                        else
                            unlockFunction(NUMS331);
                            break;

                    case "M-703":
                        if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition)=="Lock Vehicle")
                        {
                            lockFunction(NUMM703);
                        }
                        else
                            unlockFunction(NUMM703);
                            break;
                    case "T-848":
                        if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition)=="Lock Vehicle")
                        {
                            lockFunction(NUMT848);
                        }
                        else
                            unlockFunction(NUMT848);
                            break;
                    case "M-877":
                        if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition)=="Lock Vehicle")
                        {
                            lockFunction(NUMM877);
                        }
                        else
                            unlockFunction(NUMM877);
                            break;
                    case "S-913":
                        if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition)=="Lock Vehicle")
                        {
                            lockFunction(NUMS913);
                        }
                        else
                            unlockFunction(NUMS913);
                            break;
                    case "R-943":
                        if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition)=="Lock Vehicle")
                        {
                            lockFunction(NUMR947);
                        }
                        else
                            unlockFunction(NUMR947);
                            break;
                    case "R-833":
                        if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition)=="Lock Vehicle")
                        {
                            lockFunction(NUMR833);
                        }
                        else
                            unlockFunction(NUMR833);
                        break;
                    case "H-541":
                        if(listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition)=="Lock Vehicle")
                        {
                            lockFunction(NUMH541);
                        }
                        else
                            unlockFunction(NUMH541);
                        break;
                }

                return false;
            }
        });
    }
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("E-055");
        listDataHeader.add("S-077");
        listDataHeader.add("H-224");
        listDataHeader.add("S-331");
        listDataHeader.add("M-427");
        listDataHeader.add("M-703");
        listDataHeader.add("T-848");
        listDataHeader.add("M-877");
        listDataHeader.add("S-913");
        listDataHeader.add("R-943");
        listDataHeader.add("R-833");
        listDataHeader.add("H-541");


        // Adding child data
        List<String> lockunlock = new ArrayList<String>();
        lockunlock.add("Lock Vehicle");
        lockunlock.add("Unlock Vehicle");

        for ( int i=0;i<listDataHeader.size();i++)
        {
            listDataChild.put(listDataHeader.get(i), lockunlock); // Header, Child data
        }

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

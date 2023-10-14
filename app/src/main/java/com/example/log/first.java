package com.example.log;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class first extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    FirebaseAuth mAuth;
    TextView u;
    DatabaseReference ref,cbase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.bar);
        ref= FirebaseDatabase.getInstance().getReference();
        cbase=ref.child("u");
        mAuth = FirebaseAuth.getInstance();
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        u = findViewById(R.id.user);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);



        CardView mys = findViewById(R.id.myst);
        CardView rom = findViewById(R.id.rom);
        CardView hor = findViewById(R.id.hor);
        CardView act = findViewById(R.id.act);
        CardView fan = findViewById(R.id.fan);
        CardView bio = findViewById(R.id.bio);

        CardView chi = findViewById(R.id.chi);
        CardView sci = findViewById(R.id.sci);
        CardView spr = findViewById(R.id.spr);
        CardView tam = findViewById(R.id.tam);
        CardView coo = findViewById(R.id.coo);
        CardView eng = findViewById(R.id.eng);
        CardView oth = findViewById(R.id.oth);
        CardView tec = findViewById(R.id.tec);

        tec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if(networkInfo!=null && networkInfo.isConnected()==true){
                    startActivity(new Intent(first.this, tecc.class));
                }
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Check your internet connection")
                            .setMessage("Turn on internet connection")
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                            .setMessage("Turn on WIFI ?")
                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                                                }
                                            })
                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                                            .setMessage("Turn on Mobile Data ?")
                                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    Intent intent = new Intent();
                                                                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity"));
                                                                    startActivity(intent);
                                                                }
                                                            })
                                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    finish();
                                                                }
                                                            })
                                                            .show();
                                                }
                                            })
                                            .show();

                                }
                            })
                            .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            })
                            .show();
                }
            }
        });

        mys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if(networkInfo!=null && networkInfo.isConnected()==true){
                    startActivity(new Intent(first.this, MainActivity.class));
                }
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Check your internet connection")
                            .setMessage("Turn on internet connection")
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                            .setMessage("Turn on WIFI ?")
                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                                                }
                                            })
                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                                            .setMessage("Turn on Mobile Data ?")
                                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    Intent intent = new Intent();
                                                                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity"));
                                                                    startActivity(intent);
                                                                }
                                                            })
                                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    finish();
                                                                }
                                                            })
                                                            .show();
                                                }
                                            })
                                            .show();

                                }
                            })
                            .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            })
                            .show();
                }            }
        });
        rom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if(networkInfo!=null && networkInfo.isConnected()==true){
                    startActivity(new Intent(first.this, romm.class));
                }
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Check your internet connection")
                            .setMessage("Turn on internet connection")
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                            .setMessage("Turn on WIFI ?")
                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                                                }
                                            })
                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                                            .setMessage("Turn on Mobile Data ?")
                                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    Intent intent = new Intent();
                                                                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity"));
                                                                    startActivity(intent);
                                                                }
                                                            })
                                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    finish();
                                                                }
                                                            })
                                                            .show();
                                                }
                                            })
                                            .show();

                                }
                            })
                            .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            })
                            .show();
                }            }
        });
        hor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if(networkInfo!=null && networkInfo.isConnected()==true){
                    startActivity(new Intent(first.this, horr.class));
                }
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Check your internet connection")
                            .setMessage("Turn on internet connection")
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                            .setMessage("Turn on WIFI ?")
                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                                                }
                                            })
                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                                            .setMessage("Turn on Mobile Data ?")
                                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    Intent intent = new Intent();
                                                                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity"));
                                                                    startActivity(intent);
                                                                }
                                                            })
                                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    finish();
                                                                }
                                                            })
                                                            .show();
                                                }
                                            })
                                            .show();

                                }
                            })
                            .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            })
                            .show();
                }            }
        });
        act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if(networkInfo!=null && networkInfo.isConnected()==true){
                    startActivity(new Intent(first.this, actt.class));
                }
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Check your internet connection")
                            .setMessage("Turn on internet connection")
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                            .setMessage("Turn on WIFI ?")
                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                                                }
                                            })
                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                                            .setMessage("Turn on Mobile Data ?")
                                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    Intent intent = new Intent();
                                                                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity"));
                                                                    startActivity(intent);
                                                                }
                                                            })
                                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    finish();
                                                                }
                                                            })
                                                            .show();
                                                }
                                            })
                                            .show();

                                }
                            })
                            .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            })
                            .show();
                }            }
        });
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if(networkInfo!=null && networkInfo.isConnected()==true){
                    startActivity(new Intent(first.this, fann.class));
                }
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Check your internet connection")
                            .setMessage("Turn on internet connection")
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                            .setMessage("Turn on WIFI ?")
                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                                                }
                                            })
                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                                            .setMessage("Turn on Mobile Data ?")
                                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    Intent intent = new Intent();
                                                                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity"));
                                                                    startActivity(intent);
                                                                }
                                                            })
                                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    finish();
                                                                }
                                                            })
                                                            .show();
                                                }
                                            })
                                            .show();

                                }
                            })
                            .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            })
                            .show();
                }            }
        });


        bio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if(networkInfo!=null && networkInfo.isConnected()==true){
                    startActivity(new Intent(first.this, bioo.class));
                }
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Check your internet connection")
                            .setMessage("Turn on internet connection")
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                            .setMessage("Turn on WIFI ?")
                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                                                }
                                            })
                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                                            .setMessage("Turn on Mobile Data ?")
                                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    Intent intent = new Intent();
                                                                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity"));
                                                                    startActivity(intent);
                                                                }
                                                            })
                                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    finish();
                                                                }
                                                            })
                                                            .show();
                                                }
                                            })
                                            .show();

                                }
                            })
                            .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            })
                            .show();
                }            }
        });
        chi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if(networkInfo!=null && networkInfo.isConnected()==true){
                    startActivity(new Intent(first.this, chii.class));
                }
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Check your internet connection")
                            .setMessage("Turn on internet connection")
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                            .setMessage("Turn on WIFI ?")
                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                                                }
                                            })
                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                                            .setMessage("Turn on Mobile Data ?")
                                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    Intent intent = new Intent();
                                                                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity"));
                                                                    startActivity(intent);
                                                                }
                                                            })
                                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    finish();
                                                                }
                                                            })
                                                            .show();
                                                }
                                            })
                                            .show();

                                }
                            })
                            .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            })
                            .show();
                }            }
        });
        sci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if(networkInfo!=null && networkInfo.isConnected()==true){
                    startActivity(new Intent(first.this, scii.class));
                }
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Check your internet connection")
                            .setMessage("Turn on internet connection")
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                            .setMessage("Turn on WIFI ?")
                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                                                }
                                            })
                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                                            .setMessage("Turn on Mobile Data ?")
                                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    Intent intent = new Intent();
                                                                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity"));
                                                                    startActivity(intent);
                                                                }
                                                            })
                                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    finish();
                                                                }
                                                            })
                                                            .show();
                                                }
                                            })
                                            .show();

                                }
                            })
                            .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            })
                            .show();
                }            }
        });
        spr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if(networkInfo!=null && networkInfo.isConnected()==true){
                    startActivity(new Intent(first.this, sprr.class));
                }
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Check your internet connection")
                            .setMessage("Turn on internet connection")
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                            .setMessage("Turn on WIFI ?")
                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                                                }
                                            })
                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                                            .setMessage("Turn on Mobile Data ?")
                                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    Intent intent = new Intent();
                                                                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity"));
                                                                    startActivity(intent);
                                                                }
                                                            })
                                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    finish();
                                                                }
                                                            })
                                                            .show();
                                                }
                                            })
                                            .show();

                                }
                            })
                            .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            })
                            .show();
                }            }
        });
        tam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if(networkInfo!=null && networkInfo.isConnected()==true){
                    startActivity(new Intent(first.this, tamm.class));
                }
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Check your internet connection")
                            .setMessage("Turn on internet connection")
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                            .setMessage("Turn on WIFI ?")
                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                                                }
                                            })
                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                                            .setMessage("Turn on Mobile Data ?")
                                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    Intent intent = new Intent();
                                                                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity"));
                                                                    startActivity(intent);
                                                                }
                                                            })
                                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    finish();
                                                                }
                                                            })
                                                            .show();
                                                }
                                            })
                                            .show();

                                }
                            })
                            .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            })
                            .show();
                }            }
        });
        coo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if(networkInfo!=null && networkInfo.isConnected()==true){
                    startActivity(new Intent(first.this, cooo.class));
                }
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Check your internet connection")
                            .setMessage("Turn on internet connection")
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                            .setMessage("Turn on WIFI ?")
                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                                                }
                                            })
                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                                            .setMessage("Turn on Mobile Data ?")
                                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    Intent intent = new Intent();
                                                                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity"));
                                                                    startActivity(intent);
                                                                }
                                                            })
                                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    finish();
                                                                }
                                                            })
                                                            .show();
                                                }
                                            })
                                            .show();

                                }
                            })
                            .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            })
                            .show();
                }            }
        });
        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if(networkInfo!=null && networkInfo.isConnected()==true){
                    startActivity(new Intent(first.this, engg.class));
                }
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Check your internet connection")
                            .setMessage("Turn on internet connection")
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                            .setMessage("Turn on WIFI ?")
                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                                                }
                                            })
                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                                            .setMessage("Turn on Mobile Data ?")
                                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    Intent intent = new Intent();
                                                                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity"));
                                                                    startActivity(intent);
                                                                }
                                                            })
                                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    finish();
                                                                }
                                                            })
                                                            .show();
                                                }
                                            })
                                            .show();

                                }
                            })
                            .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            })
                            .show();
                }            }
        });
        oth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                if(networkInfo!=null && networkInfo.isConnected()==true){
                    startActivity(new Intent(first.this, othh.class));
                }
                else{
                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Check your internet connection")
                            .setMessage("Turn on internet connection")
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                            .setMessage("Turn on WIFI ?")
                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    startActivity(new Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                                                }
                                            })
                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    AlertDialog alertDialog = new AlertDialog.Builder(first.this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Enable internet Connection")
                                                            .setMessage("Turn on Mobile Data ?")
                                                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    Intent intent = new Intent();
                                                                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$DataUsageSummaryActivity"));
                                                                    startActivity(intent);
                                                                }
                                                            })
                                                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                                                @Override
                                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                                    finish();
                                                                }
                                                            })
                                                            .show();
                                                }
                                            })
                                            .show();

                                }
                            })
                            .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    finish();
                                }
                            })
                            .show();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                startActivity(new Intent(first.this,login.class));
                mAuth.signOut();
                finish();
                break;            case R.id.info:
                Toast.makeText(first.this,"Upgrade your knowledge with Reap",Toast.LENGTH_LONG).show();
                break;
            case R.id.about:
                Toast.makeText(first.this,"Created by Ashwin Balaji TR",Toast.LENGTH_LONG).show();
                break;
            case R.id.share:
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                String body = "Reap , a platform of E-book with variety of books and notes . Install and gain your knowledge";
                String sub = "www.google.com";
                i.putExtra(Intent.EXTRA_SUBJECT,sub);
                i.putExtra(Intent.EXTRA_TEXT,body);
                startActivity(Intent.createChooser(i,"Share Using"));
                break;
            case R.id.home:
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser()==null || !mAuth.getCurrentUser().isEmailVerified()){
            finish();
            mAuth.signOut();
            startActivity(new Intent(first.this,login.class));
        }
        cbase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue().toString();
                String aa = value;
                String b = "User Count : ";
                String c = b+aa;
                u.setText(c);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }
}
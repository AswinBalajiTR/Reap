package com.example.log;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class splash extends AppCompatActivity {
    private static int sp=3050;
    TextView t,u,v,w;
    RelativeLayout x;
    LottieAnimationView a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        a=findViewById(R.id.b);
        t=findViewById(R.id.a);
        u=findViewById(R.id.c);
        v=findViewById(R.id.d);
        w=findViewById(R.id.e);
        x=findViewById(R.id.r);
        a.animate().setDuration(5000).setStartDelay(4000);
        x.animate().setDuration(5000).setStartDelay(10000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splash.this,login.class));
                finish();
            }
        },sp);
    }
}
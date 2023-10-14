package com.example.log;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.WindowManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.URLEncoder;

public class Display extends AppCompatActivity {
    WebView browser;
    FirebaseAuth mAuth;
    DatabaseReference ref,cbase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected() == true) {
            String reff =  getIntent().getStringExtra("ref");
            String secc =  getIntent().getStringExtra("sec");
            ref= FirebaseDatabase.getInstance().getReference(reff).child(secc);
            cbase=ref.child("view");
            mAuth = FirebaseAuth.getInstance();
            browser = (WebView) findViewById(R.id.webView);
            browser.getSettings().setJavaScriptEnabled(true);
            browser.getSettings().setDomStorageEnabled(true);
            browser.clearCache(true);
            String link = getIntent().getStringExtra("bookurl");
            String bookname = getIntent().getStringExtra("bname");
            String Url ="";

            ProgressDialog pd = new ProgressDialog(this);
            pd.setTitle(bookname);
            pd.setMessage("Opening...");
            pd.show();
            browser.setWebViewClient(new WebViewClient(){
                @Override
                public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                    Toast.makeText(Display.this, "error"+handler.toString(), Toast.LENGTH_SHORT).show();
                    handler.proceed();
                }
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }

                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                }
                @Override
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    super.onReceivedError(view, errorCode, description, failingUrl);
                    Toast.makeText(Display.this, "Error"+description, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                            WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    pd.dismiss();
                    cbase.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String value = snapshot.getValue().toString();
                            String aa = value;
                            int b = Integer.parseInt(aa);
                            int c = b+1;
                            String fi = String.valueOf(c);
                            cbase.setValue(fi);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) { }
                    });
                    super.onPageFinished(view, url);
                }
            });
            try {
                Url= URLEncoder.encode(link,"UTF-8");
            }
            catch (Exception ex){}
            String url = "https://docs.google.com/gview?embedded=true&url=" + Url;
            browser.loadUrl(url);

        }
        else {
            Toast.makeText(this, "No Internet Connection", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
package com.example.log;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class login<FirebaseUser> extends AppCompatActivity {
    Button b;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b = findViewById(R.id.flogin);
        mAuth=FirebaseAuth.getInstance();
        ProgressDialog p = new ProgressDialog(this);
        p.setTitle("Loading !!!");
        p.setMessage("Please wait for sometime.....");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.show();
                startActivity(new Intent(login.this,enter.class));
                p.dismiss();

            }
        });
        TextView a = findViewById(R.id.fcreate);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.show();
                startActivity(new Intent(login.this,creatr.class));
                p.dismiss();

            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser()!=null&&mAuth.getCurrentUser().isEmailVerified()){
            finish();
            startActivity(new Intent(login.this,first.class));
        }
    }
}
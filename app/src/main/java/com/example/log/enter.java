package com.example.log;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class enter extends AppCompatActivity {
    EditText em , ps;
    Button in;
    DatabaseReference mbase,cbase;
    FirebaseAuth mAuth;
    ProgressDialog p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        em=findViewById(R.id.email_address);
        ps=findViewById(R.id.cpass);
        in=findViewById(R.id.loginn);
        mbase = FirebaseDatabase.getInstance().getReference();
        cbase = mbase.child("u");
        mAuth=FirebaseAuth.getInstance();
        p=new ProgressDialog(enter.this);

        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = em.getText().toString();
                final String pass = ps.getText().toString();
                if(email.isEmpty() && pass.isEmpty()){
                    Toast.makeText(enter.this,"Enter all fields",Toast.LENGTH_SHORT).show();
                }
                if(email.isEmpty()&&(! pass.isEmpty())){
                    em.setError("Enter your email !");
                    em.requestFocus();
                }
                if((! email.isEmpty())&& pass.isEmpty()){
                    ps.setError("Enter your password !");
                    ps.requestFocus();
                }
                if((!(email.isEmpty()))&&(!(pass.isEmpty()))){
                    p.setTitle("Signing In");
                    p.setMessage("Please wait for sometime");
                    p.show();
                    mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                if(mAuth.getCurrentUser().isEmailVerified()){
                                    startActivity(new Intent(enter.this,first.class));
                                    p.dismiss();
                                    finish();
                                }
                                else {
                                    Toast.makeText(enter.this, "Verify your mail and sign in", Toast.LENGTH_SHORT).show();
                                    p.dismiss();
                                }
                            }
                            else {
                                String m =task.getException().toString();
                                Toast.makeText(enter.this, "Error :"+m, Toast.LENGTH_SHORT).show();
                                p.dismiss();
                            }
                        }
                    });

                }
            }
        });

        TextView a = findViewById(R.id.create);
        TextView b = findViewById(R.id.tt);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.show();
                startActivity(new Intent(enter.this,creatr.class));
                finish();
                p.dismiss();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.show();
                startActivity(new Intent(enter.this,reset.class));
                p.dismiss();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser()!=null&&mAuth.getCurrentUser().isEmailVerified()){
            finish();
            startActivity(new Intent(enter.this,first.class));

        }
    }
}
package com.example.log;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class reset extends AppCompatActivity {
    EditText email;
    Button re;
    FirebaseAuth mAuth;
    ProgressDialog pg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        email=findViewById(R.id.email_address);
        mAuth=FirebaseAuth.getInstance();
        re=findViewById(R.id.loginn);
        pg=new ProgressDialog(reset.this);

        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail=email.getText().toString();
                if(mail.isEmpty()){
                    email.setError("Enter your email !");
                    email.requestFocus();
                }
                else{
                    pg.setTitle("Loading !");
                    pg.setMessage("Please wait for sometime");
                    pg.show();
                    mAuth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                pg.dismiss();
                                Toast.makeText(reset.this,"Password reset link has been sent to your mail",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(reset.this,enter.class));
                                finish();
                            }
                            else {
                                pg.dismiss();
                                String msg=task.getException().toString();
                                Toast.makeText(reset.this,"Error : "+msg,Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });

    }
}
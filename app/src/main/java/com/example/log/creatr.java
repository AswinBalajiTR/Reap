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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class creatr extends AppCompatActivity {
    EditText mail ,pass,cpass;
    Button create;
    FirebaseAuth mAuth;
    ProgressDialog pp;
    DatabaseReference ref,cbase,ubase,href;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creatr);

        mail=findViewById(R.id.email_address);
        pass=findViewById(R.id.cpass);
        cpass=findViewById(R.id.cccpass);

        create=findViewById(R.id.up);

        mAuth=FirebaseAuth.getInstance();

        ref=FirebaseDatabase.getInstance().getReference();
        cbase=ref.child("u");
        href=FirebaseDatabase.getInstance().getReference("user");

        pp=new ProgressDialog(creatr.this);

        TextView a = findViewById(R.id.tt);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(creatr.this,enter.class));
                finish();
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = mail.getText().toString();
                final String pwd = pass.getText().toString();
                String cpwd = cpass.getText().toString();
                if(email.isEmpty() &&  pwd.isEmpty() && cpwd.isEmpty()){
                    Toast.makeText(creatr.this,"Enter all fields !",Toast.LENGTH_SHORT).show();
                }
                if(!email.isEmpty()  && !pwd.isEmpty() && !cpwd.isEmpty() && !pwd.equals(cpwd)){
                    Toast.makeText(creatr.this,"Password doesn't match !",Toast.LENGTH_SHORT).show();
                    cpass.setText("");
                }
                if(email.isEmpty()  || pwd.isEmpty() || cpwd.isEmpty()){
                    Toast.makeText(creatr.this,"Complete the fields !",Toast.LENGTH_SHORT).show();
                }
                if(!email.isEmpty()  && !pwd.isEmpty() && !cpwd.isEmpty() && pwd.equals(cpwd)){
                    pp.setTitle("Creating Account");
                    pp.setMessage("Please wait for sometime.....");
                    pp.show();
                    mAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            String id = mAuth.getCurrentUser().getUid();
                                            ubase = href.child(id);
                                            ubase.addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                    ubase.child("count").setValue("0");
                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError error) {

                                                }
                                            });
                                            cbase.addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                    String value = snapshot.getValue().toString();
                                                    String aa = value;
                                                    int b = Integer.parseInt(aa);
                                                    cbase.setValue(b+1);

                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError error) {
                                                }
                                            });

                                            pp.dismiss();
                                            Toast.makeText(creatr.this,"Verify your mail and sign in",Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(creatr.this,enter.class));
                                            finish();
                                        }
                                        else {
                                            pp.dismiss();
                                            String ms = task.getException().toString();
                                            Toast.makeText(creatr.this,"Error : "+ms,Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                            else{
                                pp.dismiss();
                                String mm = task.getException().toString();
                                Toast.makeText(creatr.this,"Error : "+mm,Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
}
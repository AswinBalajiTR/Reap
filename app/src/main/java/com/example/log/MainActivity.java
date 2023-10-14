package com.example.log;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    personAdapter adapter;
    DatabaseReference mbase;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pd = new ProgressDialog(this);
        pd.setTitle("Loading");
        pd.setMessage("Books are on the way....");
        pd.show();


        androidx.appcompat.widget.Toolbar toolbar;
        toolbar = findViewById(R.id.bar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        RecyclerView recyclerView = findViewById(R.id.recycler1);
        mbase = FirebaseDatabase.getInstance().getReference("mys");
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        ((LinearLayoutManager) layoutManager).setStackFromEnd(true); // it will reverse the stack (bottom to top)
        ((LinearLayoutManager) layoutManager).setReverseLayout(true); // When set to true, If RecyclerView is LTR, than it will layout from RTL
        recyclerView.setLayoutManager(layoutManager);
        FirebaseRecyclerOptions<book> options = new FirebaseRecyclerOptions.Builder<book>().setQuery(mbase, book.class).build();
        adapter = new personAdapter(options);
        recyclerView.setAdapter(adapter);

        mbase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                pd.dismiss();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                pd.dismiss();

            }
        });





        }

    @Override protected void onStart()
    {
        super.onStart();
        adapter.startListening();

    }
    @Override protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }

}
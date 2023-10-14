package com.example.log;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class selection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);

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

        mys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(selection.this, MainActivity.class));
            }
        });
        tec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(selection.this, tecc.class));
            }
        });
        rom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(selection.this, romm.class));
            }
        });
        hor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(selection.this, horr.class));
            }
        });
        act.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(selection.this, actt.class));
            }
        });
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(selection.this, fann.class));
            }
        });


        bio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(selection.this, bioo.class));
            }
        });
        chi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(selection.this, chii.class));
            }
        });
        sci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(selection.this, scii.class));
            }
        });
        spr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(selection.this, sprr.class));
            }
        });
        tam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(selection.this, tamm.class));
            }
        });
        coo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(selection.this, cooo.class));
            }
        });
        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(selection.this, engg.class));
            }
        });
        oth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(selection.this, othh.class));
            }
        });
    }

}
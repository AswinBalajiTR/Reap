package com.example.log;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.squareup.picasso.Picasso;

public class predis extends AppCompatActivity {

    Button submit;
    ImageView bookimage;
    TextView bookname , author,page,desc,view;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predis);

        submit = findViewById(R.id.readbook);
        bookimage=findViewById(R.id.bookimage);
        bookname = findViewById(R.id.bookname);
        author = findViewById(R.id.author);
        page = findViewById(R.id.pages);
        view = findViewById(R.id.view);
        desc = findViewById(R.id.desc);

        String c = getIntent().getStringExtra("rate");
        String d = getIntent().getStringExtra("view");
        view.setText(d);
        int cc = Integer.parseInt(c);
        RatingBar a = findViewById(R.id.dummyrating);
        a.setRating(cc);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               disp();

            }
        });

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void disp() {
        ProgressDialog pd = new ProgressDialog(predis.this);
        pd.setTitle("Loading !");
        pd.setMessage("Please wait for sometime....");
        pd.show();
        String burl = getIntent().getStringExtra("url");
        String name = getIntent().getStringExtra("bookname");
        String ref = getIntent().getStringExtra("ref");
        String sec = getIntent().getStringExtra("sec");
        if(!burl.isEmpty() && !name.isEmpty() && !ref.isEmpty() && !sec.isEmpty()){
            Intent i = new Intent(predis.this,Display.class);
            i.putExtra("bookurl",burl);
            i.putExtra("bname",name);
            i.putExtra("ref",ref);
            i.putExtra("sec",sec);
            pd.dismiss();
            startActivity(i);
        }
        else {
            disp();
        }
    }

    @Override
    protected void onStart() {
        String by = getIntent().getStringExtra("author");
        String name = getIntent().getStringExtra("bookname");
        String iurl = getIntent().getStringExtra("iurl");
        String pages = getIntent().getStringExtra("pgs");
        String about = getIntent().getStringExtra("abt");
        page.setText(pages);
        desc.setText(about);
        toolbar.setTitle(name);
        Picasso.get().load(iurl).into(bookimage);
        bookname.setText(name);
        author.setText(by);
        super.onStart();
    }
}
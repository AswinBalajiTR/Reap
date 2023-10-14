package com.example.log;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;


class personAdapter extends FirebaseRecyclerAdapter<book, personAdapter.personsViewholder> {

    private Context   mContext;

    public personAdapter(@NonNull FirebaseRecyclerOptions<book> options)
    {
        super(options);
    }


    @Override
    protected void
    onBindViewHolder(@NonNull personsViewholder holder, int position, @NonNull book model)
    {
        holder.bookname.setText(model.getBookname());
        holder.desc.setText(model.getDesc());
        holder.url.setText(model.getUrl());
        holder.iurl.setText(model.getIurl());
        holder.pgs.setText(model.getPgs());
        holder.abt.setText(model.getAbt());
        holder.rate.setText(model.getRate());
        holder.view.setText(model.getView());
        holder.ref.setText(model.getRef());
        holder.sec.setText(model.getSec());
        int a = Integer.parseInt(model.getRate());
        holder.rating.setRating(a);
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.a.equals(holder.b)){
                    holder.like.setImageResource(R.drawable.hred);
                    holder.a="red";
                    holder.b="white";
                }
                else {
                    holder.like.setImageResource(R.drawable.hwhite);
                    holder.a="red";
                    holder.b="red";
                }

            }
        });

        Picasso.get().load(model.getIurl()).into(holder.image);

        holder.r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.r.getContext(),predis.class);
                intent.putExtra("iurl",model.getIurl());
                intent.putExtra("url",model.getUrl());
                intent.putExtra("author",model.getDesc());
                intent.putExtra("pgs",model.getPgs());
                intent.putExtra("abt",model.getAbt());
                intent.putExtra("rate",model.getRate());
                intent.putExtra("ref",model.getRef());
                intent.putExtra("sec",model.getSec());
                intent.putExtra("view",model.getView());
                intent.putExtra("bookname",model.getBookname());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.r.getContext().startActivity(intent);
            }
        });
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.r.getContext(),predis.class);
                intent.putExtra("iurl",model.getIurl());
                intent.putExtra("url",model.getUrl());
                intent.putExtra("author",model.getDesc());
                intent.putExtra("pgs",model.getPgs());
                intent.putExtra("abt",model.getAbt());
                intent.putExtra("rate",model.getRate());
                intent.putExtra("ref",model.getRef());
                intent.putExtra("sec",model.getSec());
                intent.putExtra("view",model.getView());
                intent.putExtra("bookname",model.getBookname());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.r.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public personsViewholder
    onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person, parent, false);
        return new personAdapter.personsViewholder(view);
    }


    class personsViewholder extends RecyclerView.ViewHolder {
        TextView bookname, desc,url,iurl,pgs,abt,rate,view,ref,sec;
        RatingBar rating;
        RelativeLayout r;
        ImageView image,like;
        String a,b;
        public personsViewholder(@NonNull View itemView)
        {
            super(itemView);
            bookname = itemView.findViewById(R.id.firstname);
            desc = itemView.findViewById(R.id.lastname);
            url = itemView.findViewById(R.id.url);
            iurl = itemView.findViewById(R.id.iurl);
            pgs = itemView.findViewById(R.id.pgs);
            abt = itemView.findViewById(R.id.abt);
            ref = itemView.findViewById(R.id.ref);
            sec = itemView.findViewById(R.id.sec);
            r=itemView.findViewById(R.id.dd);
            rating = itemView.findViewById(R.id.rating);
            view = itemView.findViewById(R.id.view);
            rate=itemView.findViewById(R.id.rate);
            image=itemView.findViewById(R.id.img);
            a="white";
            b="white";
            like=itemView.findViewById(R.id.like);
        }
    }
}
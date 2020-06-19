package com.harshita.moviebuff;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MovieAdapter  extends  RecyclerView.Adapter<MovieAdapter.ViewHolder>{

    //private ArrayList<Movie > mMovie = new ArrayList<>();

    private ArrayList<String> mTitle = new ArrayList<>();
    private static final String TAG = MainActivity.class.getName();
    //private Context mContext;

    public MovieAdapter(ArrayList<String> mTitle) {
        this.mTitle = mTitle;
        //this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.title.setText(mTitle.get(position));
        //Glide.with(mContext).load("https://image.tmdb.org/t/p/w500" + "").
                //into(holder.poster);


       /* holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "clicked", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "apple"+Integer.toString(mTitle.size()));
        return mTitle.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView poster;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            //poster = itemView.findViewById(R.id.poster_image);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

}

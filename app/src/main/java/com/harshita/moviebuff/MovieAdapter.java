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

import retrofit2.Callback;

public class MovieAdapter  extends  RecyclerView.Adapter<MovieAdapter.ViewHolder>{

    private ArrayList<Movie > mMovie = new ArrayList<>();
    private RecyclerViewClickListener mListener;
    //private ArrayList<String> mTitle = new ArrayList<>();

    private static final String TAG = MainActivity.class.getName();

    private Context mContext;

    public MovieAdapter(ArrayList<Movie> mMovie, Context mContext, RecyclerViewClickListener listener) {
        this.mMovie = mMovie;
        this.mContext = mContext;
        mListener = listener;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, mListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.title.setText(mMovie.get(position).getmTitle());
        Glide.with(mContext).load("https://image.tmdb.org/t/p/w500" + mMovie.get(position).getmPoster()).
                into(holder.poster);


        /*holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "clicked", Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        //Log.d(TAG, "apple"+Integer.toString(mTitle.size()));
        return mMovie.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        ImageView poster;
        LinearLayout parentLayout;

        private RecyclerViewClickListener mListener;

        public ViewHolder(@NonNull View itemView, RecyclerViewClickListener listener) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            poster = itemView.findViewById(R.id.poster_iamge);
            parentLayout = itemView.findViewById(R.id.parent_layout);

            mListener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }


    }



}

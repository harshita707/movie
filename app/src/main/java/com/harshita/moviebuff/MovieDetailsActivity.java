package com.harshita.moviebuff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MovieDetailsActivity extends AppCompatActivity {

    private ImageView backdropImage;
    private ImageView posterImage;
    private TextView movieName;
    private TextView rating;
    private TextView releaseDate;
    private TextView overview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details_activity);

        backdropImage = findViewById(R.id.backdrop_image);
        posterImage = findViewById(R.id.movie_poster);
        movieName = findViewById(R.id.movie_name);
        rating = findViewById(R.id.movie_rating);
        releaseDate = findViewById(R.id.movie_release_date);
        overview = findViewById(R.id.movie_overview);

        Movie details = (Movie) getIntent().getExtras().getSerializable("MOVIE_DETAILS");

        if( details != null){
            Glide.with(this).load("https://image.tmdb.org/t/p/w500" + details.getmPoster()).
                    into(posterImage);
            Glide.with(this).load("https://image.tmdb.org/t/p/w500" + details.getmBackdrop()).
                    into(backdropImage);
            movieName.setText(details.getmTitle());
            rating.setText(Double.toString(details.getmRating()));
            releaseDate.setText(details.getmReleaseDate());
            overview.setText(details.getmOverview());

        }

    }
}

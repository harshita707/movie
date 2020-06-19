package com.harshita.moviebuff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity  {

    public static String BASE_URL = "https://api.themoviedb.org";
    public static int PAGE = 1;
    public static String API_KEY = "1282154094d0a0c0eb48f9b0867eabe7";
    public static String LANGUAGE = "en-US";
    public static String CATEGORY = "popular";

    private ArrayList<Movie> mMovies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

        ApiInterface myInterface = retrofit.create(ApiInterface.class);
        final Context c=this;
        Call<MovieResults> call = myInterface.listOfMovies(CATEGORY,API_KEY,LANGUAGE,PAGE);
        call.enqueue(new Callback<MovieResults>() {
            @Override
            public void onResponse(Call<MovieResults> call, Response<MovieResults> response) {
                MovieResults results = response.body();
                List<MovieResults.ResultsBean> listOfMovies = results.getResults();

                for (int i = 0; i < 20; i++) {

                    MovieResults.ResultsBean currentMovie = listOfMovies.get(i);
                    mMovies.add(new Movie(currentMovie.getTitle(), currentMovie.getPosterPath(), currentMovie.getBackdropPath(), currentMovie.getVoteAverage(),
                            currentMovie.getReleaseDate(), currentMovie.getOverview()));


                }
                RecyclerView recyclerView = findViewById(R.id.recycler_view);
                LinearLayoutManager llm = new LinearLayoutManager(getBaseContext());
                llm.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(llm);

                RecyclerViewClickListener listener = new RecyclerViewClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                       // Toast.makeText(getBaseContext(), "Position " + position,
                        //        Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this , MovieDetailsActivity.class);
                        intent.putExtra("MOVIE_DETAILS" , mMovies.get(position));
                        startActivity(intent);

                    }
                };

                MovieAdapter adapter = new MovieAdapter(mMovies,getBaseContext(), listener);
                recyclerView.setAdapter(adapter);




            }

            @Override
            public void onFailure(Call<MovieResults> call, Throwable t) {

                t.printStackTrace();
            }


        });

    }

}

package com.harshita.moviebuff;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static String BASE_URL = "https://api.themoviedb.org";
    public static int PAGE = 1;
    public static String API_KEY = "1282154094d0a0c0eb48f9b0867eabe7";
    public static String LANGUAGE = "en-US";
    public static String CATEGORY = "popular";

    private TextView tv;
    private TextView tv2;
    private RecyclerView recyclerView;


    //private ArrayList<Movie> mMovies = new ArrayList<>();
    private ArrayList<String> mTitle = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.text);
        tv2=findViewById(R.id.text2);
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

                MovieResults.ResultsBean currentMovie = listOfMovies.get(0);
                tv.setText(currentMovie.getTitle());

                for (int i = 0; i < 20; i++) {

                    MovieResults.ResultsBean currenMovie = listOfMovies.get(i);
                    //mMovies.add(new Movie(currentMovie.getTitle(), ""));

                    mTitle.add(currenMovie.getTitle());

                }
                currentMovie = listOfMovies.get(19);
                tv2.setText(Integer.toString(mTitle.size()));

                recyclerView = findViewById(R.id.recycler_view);
                recyclerView.setLayoutManager(new LinearLayoutManager(c));
                MovieAdapter adapter = new MovieAdapter(mTitle);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<MovieResults> call, Throwable t) {

                t.printStackTrace();
            }
        });





    }
}

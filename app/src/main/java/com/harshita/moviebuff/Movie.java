package com.harshita.moviebuff;

public class Movie {

    private String mTitle;
    private String mPoster;

    public Movie(String mTitle, String mPoster) {
        this.mTitle = mTitle;
        this.mPoster = mPoster;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmPoster() {
        return mPoster;
    }
}

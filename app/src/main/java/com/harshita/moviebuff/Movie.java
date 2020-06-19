package com.harshita.moviebuff;

import java.io.Serializable;

public class Movie implements Serializable {

    private String mTitle;
    private String mPoster;
    private String mBackdrop;
    private Double mRating;
    private String mReleaseDate;
    private String mOverview;

    public Movie(String mTitle, String mPoster, String mBackdrop, Double mRating, String mReleaseDate, String mOverview) {
        this.mTitle = mTitle;
        this.mPoster = mPoster;
        this.mBackdrop = mBackdrop;
        this.mRating = mRating;
        this.mReleaseDate = mReleaseDate;
        this.mOverview = mOverview;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmPoster() {
        return mPoster;
    }

    public void setmPoster(String mPoster) {
        this.mPoster = mPoster;
    }

    public String getmBackdrop() {
        return mBackdrop;
    }

    public void setmBackdrop(String mBackdrop) {
        this.mBackdrop = mBackdrop;
    }

    public Double getmRating() {
        return mRating;
    }

    public void setmRating(Double mRating) {
        this.mRating = mRating;
    }

    public String getmReleaseDate() {
        return mReleaseDate;
    }

    public void setmReleaseDate(String mReleaseDate) {
        this.mReleaseDate = mReleaseDate;
    }

    public String getmOverview() {
        return mOverview;
    }

    public void setmOverview(String mOverview) {
        this.mOverview = mOverview;
    }
}

package com.example.netflixcloneandroidapp.model.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TrendingNow {

    private int page;

    @SerializedName("results")
    private List<Movie> movies;

    private int total_pages;
    private int total_results;

    public List<Movie> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "TrendingNow{" +
                "page=" + page +
                ", movies=" + movies +
                ", total_pages=" + total_pages +
                ", total_results=" + total_results +
                '}';
    }
}

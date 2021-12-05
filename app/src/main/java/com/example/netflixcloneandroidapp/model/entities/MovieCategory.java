package com.example.netflixcloneandroidapp.model.entities;

import java.util.List;

public class MovieCategory {
    String categoryTitle;
    List<Movie> categoryMovieList;

    public MovieCategory(String categoryTitle, List<Movie> categoryMovieList) {
        this.categoryTitle = categoryTitle;
        this.categoryMovieList = categoryMovieList;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public List<Movie> getCategoryMovieList() {
        return categoryMovieList;
    }

    public void setCategoryMovieList(List<Movie> categoryMovieList) {
        this.categoryMovieList = categoryMovieList;
    }
}

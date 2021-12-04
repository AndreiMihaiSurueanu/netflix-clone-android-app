package com.example.netflixcloneandroidapp.model;

import androidx.lifecycle.MutableLiveData;

import com.example.netflixcloneandroidapp.model.entities.Movie;
import com.example.netflixcloneandroidapp.model.web_services.RetrofitClient;

import java.util.List;

public class MoviesRepository {

    private static MoviesRepository instance;

    private final RetrofitClient retrofitClient;
    private final MutableLiveData<List<Movie>> trendingNowMovies;

    MoviesRepository() {
        retrofitClient = RetrofitClient.getRetrofitClientInstance();
        trendingNowMovies = new MutableLiveData<>();
    }

    public static MoviesRepository getInstance(){
        if(instance == null) {
            instance = new MoviesRepository();
        }
        return instance;
    }

}

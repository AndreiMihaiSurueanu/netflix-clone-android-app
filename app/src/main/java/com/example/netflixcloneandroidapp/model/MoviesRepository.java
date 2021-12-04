package com.example.netflixcloneandroidapp.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.netflixcloneandroidapp.model.entities.Movie;
import com.example.netflixcloneandroidapp.model.web_services.RetrofitClient;

import java.io.IOException;
import java.util.List;

public class MoviesRepository {

    private static MoviesRepository instance;

    private final RetrofitClient retrofitClient;
    private final MutableLiveData<List<Movie>> trendingNowMovies;
    private final MutableLiveData<List<Movie>> discoverMovies;

    MoviesRepository() {
        retrofitClient = RetrofitClient.getRetrofitClientInstance();
        trendingNowMovies = new MutableLiveData<>();
        discoverMovies = new MutableLiveData<>();
    }

    public static MoviesRepository getInstance(){
        if(instance == null) {
            instance = new MoviesRepository();
        }
        return instance;
    }

    public void loadTrendingNow() throws IOException {
        trendingNowMovies.postValue(retrofitClient.loadTrendingNow());
    }

    public void loadDiscoverMovie() throws IOException {
        discoverMovies.postValue(retrofitClient.loadDiscoverMovie());
    }

    public LiveData<List<Movie>> getTrendingNow() {
        return trendingNowMovies;
    }

    public LiveData<List<Movie>> getDiscoverMovie() {
        return discoverMovies;
    }

}

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
    private final MutableLiveData<List<Movie>> newReleasesMovies;
    private final MutableLiveData<List<Movie>> comedyMovies;

    MoviesRepository() {
        retrofitClient = RetrofitClient.getRetrofitClientInstance();
        trendingNowMovies = new MutableLiveData<>();
        newReleasesMovies = new MutableLiveData<>();
        comedyMovies = new MutableLiveData<>();
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

    public LiveData<List<Movie>> getTrendingNow() {
        return trendingNowMovies;
    }

    public void loadNewReleases() throws IOException {
        newReleasesMovies.postValue(retrofitClient.loadNewReleases());
    }

    public LiveData<List<Movie>> getNewReleases() {
        return newReleasesMovies;
    }

    public void loadComedyMovies() throws IOException {
        comedyMovies.postValue(retrofitClient.loadComedyMovies());
    }

    public LiveData<List<Movie>> getComedyMovies() {
        return comedyMovies;
    }

}

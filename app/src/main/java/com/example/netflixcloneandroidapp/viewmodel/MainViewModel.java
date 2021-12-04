package com.example.netflixcloneandroidapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.netflixcloneandroidapp.model.MoviesRepository;
import com.example.netflixcloneandroidapp.model.entities.Movie;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainViewModel extends ViewModel {

    private MoviesRepository moviesRepository;
    private final ExecutorService executorService;

    public MainViewModel() {
        this.moviesRepository = MoviesRepository.getInstance();
        executorService = Executors.newCachedThreadPool();
    }

    public LiveData<List<Movie>> getTrendingNow() {
        return moviesRepository.getTrendingNow();
    }

}

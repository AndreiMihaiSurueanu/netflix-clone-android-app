package com.example.netflixcloneandroidapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.netflixcloneandroidapp.model.MoviesRepository;
import com.example.netflixcloneandroidapp.model.entities.Movie;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainViewModel extends ViewModel {

    private MoviesRepository moviesRepository;
    private final ExecutorService executorService;

    public MainViewModel() {
        this.moviesRepository = MoviesRepository.getInstance();
        executorService = Executors.newCachedThreadPool();
    }

    public void loadTrendingNow() {
        final Future future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    moviesRepository.loadTrendingNow();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LiveData<List<Movie>> getTrendingNow() {
        return moviesRepository.getTrendingNow();
    }

}

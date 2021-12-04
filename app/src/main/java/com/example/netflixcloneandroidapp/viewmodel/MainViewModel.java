package com.example.netflixcloneandroidapp.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.netflixcloneandroidapp.model.MoviesRepository;
import com.example.netflixcloneandroidapp.model.entities.Movie;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainViewModel extends AndroidViewModel {

    private final MoviesRepository moviesRepository;
    private final ExecutorService executorService;

    public MainViewModel(Application app) {
        super(app);
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

    public void loadDiscoverMovie() {
        final Future future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    moviesRepository.loadDiscoverMovie();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LiveData<List<Movie>> getDiscoverMovie() {
        return moviesRepository.getDiscoverMovie();
    }

}

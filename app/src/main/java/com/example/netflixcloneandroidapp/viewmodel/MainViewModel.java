package com.example.netflixcloneandroidapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.netflixcloneandroidapp.model.MoviesRepository;
import com.example.netflixcloneandroidapp.model.entities.Movie;

import java.util.List;

public class MainViewModel extends ViewModel {

    private MoviesRepository moviesRepository;

    public MainViewModel() {
        this.moviesRepository = MoviesRepository.getInstance();
    }

}

package com.example.netflixcloneandroidapp.view.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.netflixcloneandroidapp.R;
import com.example.netflixcloneandroidapp.model.entities.Movie;
import com.example.netflixcloneandroidapp.model.entities.MovieCategory;
import com.example.netflixcloneandroidapp.view.adapters.CategoryRowItemRecyclerAdapter;
import com.example.netflixcloneandroidapp.view.adapters.MainRecyclerAdapter;
import com.example.netflixcloneandroidapp.viewmodel.MainViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mainRecyclerView;
    MainRecyclerAdapter mainRecyclerAdapter;

    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);



        List<MovieCategory> movieCategoryList = new ArrayList<>();
        movieCategoryList.add( new MovieCategory("New Releases", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("Trending Now", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("My List", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("NETFLIX ORIGINALS", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("Continue Watching for Malcolm", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("Watch It Again", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("Comedies", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("TV Shows", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("Crime TV Shows", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("Critically-acclaimed Movies", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("Because you watched White Chicks", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("Because you watched The Flash", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("Because you watched Kevin Heart I'm a Grown Little Man", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("Because you added Inglorious Bastards to your list", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("Animation", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("Suspenseful Movies", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("Binge-worthy TV Shows", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("Violent Movies", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("Family Comedies", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("TV Action & Adventure", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("TV Sci-Fi & Horror", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("Irreverent Comedies", new ArrayList<>()));
        movieCategoryList.add( new MovieCategory("Irreverent Movies", new ArrayList<>()));

        setMainCategoryRecycler(movieCategoryList);

        ObserveTrendingNow();
        ObserveNewReleases();
        ObserveComedyMovies();

        mainViewModel.loadMovies();

        OpenMovieListener();

    }

    private void ObserveTrendingNow() {
        mainViewModel.getTrendingNow().observe(this, new Observer<List<Movie>>(){
            @Override
            public void onChanged(List<Movie> trendingNowMovies) {
                // Observing for any data change
                if (trendingNowMovies != null) {
                    mainRecyclerAdapter.setTrendingNowList(trendingNowMovies);
                }
            }
        });
    }

    private void ObserveNewReleases() {
        mainViewModel.getNewReleases().observe(this, new Observer<List<Movie>>(){
            @Override
            public void onChanged(List<Movie> newReleasesMovies) {
                // Observing for any data change
                if (newReleasesMovies != null) {
                    mainRecyclerAdapter.setNewReleasesMovieList(newReleasesMovies);
                }
            }
        });
    }

    private void ObserveComedyMovies() {
        mainViewModel.getComedyMovies().observe(this, new Observer<List<Movie>>(){
            @Override
            public void onChanged(List<Movie> comedyMovies) {
                // Observing for any data change
                if (comedyMovies != null) {
                    mainRecyclerAdapter.setComedyMovieList(comedyMovies);
                }
            }
        });
    }

    private void setMainCategoryRecycler(List<MovieCategory> allMovieCategoryList){

        mainRecyclerView = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainRecyclerView.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this, allMovieCategoryList);
        mainRecyclerView.setAdapter(mainRecyclerAdapter);

    }

    private void OpenMovieListener() {
            mainRecyclerAdapter.setOnItemClickListener(new CategoryRowItemRecyclerAdapter.OnMovieListener() {
            @Override
            public void onItemClick(Movie movie) {
                Intent intent = new Intent(MainActivity.this, MovieDetails.class);
                intent.putExtra("movie", movie);
                startActivity(intent);
            }
        });
    }
}
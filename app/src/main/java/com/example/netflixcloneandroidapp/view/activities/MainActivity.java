package com.example.netflixcloneandroidapp.view.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.netflixcloneandroidapp.R;
import com.example.netflixcloneandroidapp.model.entities.Movie;
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



        List<String> listOfCategories = new ArrayList();
        listOfCategories.add("New Releases");
        listOfCategories.add("Trending Now");
        listOfCategories.add("My List");
        listOfCategories.add("NETFLIX ORIGINALS");
        listOfCategories.add("Continue Watching for Malcolm");
        listOfCategories.add("Watch It Again");
        listOfCategories.add("Comedies");
        listOfCategories.add("TV Shows");
        listOfCategories.add("Crime TV Shows");
        listOfCategories.add("Critically-acclaimed Movies");
        listOfCategories.add("Because you watched White Chicks");
        listOfCategories.add("Because you watched RV");
        listOfCategories.add("Because you watched The Flash");
        listOfCategories.add("Because you watched Kevin Heart I'm a Grown Little Man");
        listOfCategories.add("Because you added Inglorious Bastards to your list");
        listOfCategories.add("Animation");
        listOfCategories.add("Suspenseful Movies");
        listOfCategories.add("Binge-worthy TV Shows");
        listOfCategories.add("Violent Movies");
        listOfCategories.add("Family Comedies");
        listOfCategories.add("TV Action & Adventure");
        listOfCategories.add("TV Sci-Fi & Horror");
        listOfCategories.add("Irreverent Comedies");
        listOfCategories.add("Irreverent Movies");

        ObserveTrendingNow(listOfCategories);

//        setMainCategoryRecycler(listOfCategories);

    }

    private void ObserveTrendingNow(List<String> listOfCategories) {
        mainViewModel.getTrendingNow().observe(this, new Observer<List<Movie>>(){
            @Override
            public void onChanged(List<Movie> trendingNowMovies) {
                // Observing for any data change
                if (trendingNowMovies != null) {
                    setMainCategoryRecycler(listOfCategories, trendingNowMovies);
                }
            }
        });
    }

    private void setMainCategoryRecycler(List<String> allCategoryList, List<Movie> trendingNowMovies){

        mainRecyclerView = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainRecyclerView.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this, allCategoryList, trendingNowMovies);
        mainRecyclerView.setAdapter(mainRecyclerAdapter);

    }
}
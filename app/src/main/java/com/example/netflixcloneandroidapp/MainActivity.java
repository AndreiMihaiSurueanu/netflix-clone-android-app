package com.example.netflixcloneandroidapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mainRecyclerView;
    MainRecyclerAdapter mainRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        setMainCategoryRecycler(listOfCategories);

    }

    private void setMainCategoryRecycler(List<String> allCategoryList) {

        mainRecyclerView = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mainRecyclerView.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this, allCategoryList);
        mainRecyclerView.setAdapter(mainRecyclerAdapter);

    }
}
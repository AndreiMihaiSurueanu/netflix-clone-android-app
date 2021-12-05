package com.example.netflixcloneandroidapp.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.netflixcloneandroidapp.R;
import com.example.netflixcloneandroidapp.model.entities.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainRecyclerViewHolder>{

    Context context;
    List<Movie> trendingNowList = new ArrayList<>();
    List<Movie> newReleasesMovieList = new ArrayList<>();
    List<Movie> comedyMovieList = new ArrayList<>();
    List<String> listOfCategories;
    CategoryRowItemRecyclerAdapter itemRecyclerAdapter;
    CategoryRowItemRecyclerAdapter.OnMovieListener movieListener;

    public MainRecyclerAdapter(Context context, List<String> listOfCategories) {
        this.context = context;
        this.listOfCategories = listOfCategories;
    }

    @NonNull
    @Override
    public MainRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.main_recycler_category_row_item, parent,false);
        return new MainRecyclerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MainRecyclerViewHolder holder, int position) {
        holder.categoryTitle.setText(listOfCategories.get(position));
        if(listOfCategories.get(position) == "New Releases")
            setCatItemRecycler(holder.categoryRowRecycler, newReleasesMovieList);
        if(listOfCategories.get(position) == "Trending Now")
            setCatItemRecycler(holder.categoryRowRecycler, trendingNowList);
        if(listOfCategories.get(position) == "Comedies")
            setCatItemRecycler(holder.categoryRowRecycler, comedyMovieList);
    }

    @Override
    public int getItemCount() {
        return listOfCategories.size();
    }

    public void setTrendingNowList(List<Movie> trendingNowList) {
        this.trendingNowList = trendingNowList;
        if (itemRecyclerAdapter != null)
            itemRecyclerAdapter.setMovieList(trendingNowList);
        notifyDataSetChanged();
    }

    public void setNewReleasesMovieList(List<Movie> newReleasesMovieList) {
        this.newReleasesMovieList = newReleasesMovieList;
        if (itemRecyclerAdapter != null)
            itemRecyclerAdapter.setMovieList(newReleasesMovieList);
        notifyDataSetChanged();
    }

    public void setComedyMovieList(List<Movie> comedyMovieList) {
        this.comedyMovieList = comedyMovieList;
        if (itemRecyclerAdapter != null)
            itemRecyclerAdapter.setMovieList(comedyMovieList);
        notifyDataSetChanged();
    }

    public class MainRecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView categoryTitle;
        RecyclerView categoryRowRecycler;

        public MainRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryTitle = itemView.findViewById(R.id.category_title);
            categoryRowRecycler = itemView.findViewById(R.id.category_row_recycler);

        }
    }

    private void setCatItemRecycler(RecyclerView recyclerView, List<Movie> categoryItemList){

        itemRecyclerAdapter = new CategoryRowItemRecyclerAdapter(context, categoryItemList);
        itemRecyclerAdapter.setOnItemClickListener(movieListener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(itemRecyclerAdapter);

    }

    public void setOnItemClickListener(CategoryRowItemRecyclerAdapter.OnMovieListener movieListener) {
        this.movieListener = movieListener;
    }
}

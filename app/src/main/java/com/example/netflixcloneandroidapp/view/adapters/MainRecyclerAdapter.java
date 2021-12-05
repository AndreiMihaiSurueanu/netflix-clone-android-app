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
import com.example.netflixcloneandroidapp.model.entities.MovieCategory;

import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainRecyclerViewHolder>{

    Context context;
    List<MovieCategory> listOfMovieCategories;
    CategoryRowItemRecyclerAdapter itemRecyclerAdapter;
    CategoryRowItemRecyclerAdapter.OnMovieListener movieListener;

    public MainRecyclerAdapter(Context context, List<MovieCategory> listOfMovieCategories) {
        this.context = context;
        this.listOfMovieCategories = listOfMovieCategories;
    }

    @NonNull
    @Override
    public MainRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.main_recycler_category_row_item, parent,false);
        return new MainRecyclerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MainRecyclerViewHolder holder, int position) {
        holder.categoryTitle.setText(listOfMovieCategories.get(position).getCategoryTitle());
        setCatItemRecycler(holder.categoryRowRecycler, listOfMovieCategories.get(position).getCategoryMovieList());
    }

    @Override
    public int getItemCount() {
        return listOfMovieCategories.size();
    }

    public void setTrendingNowList(List<Movie> trendingNowList) {
        listOfMovieCategories.get(1).setCategoryMovieList(trendingNowList);
        notifyDataSetChanged();
    }

    public void setNewReleasesMovieList(List<Movie> newReleasesMovieList) {
        listOfMovieCategories.get(0).setCategoryMovieList(newReleasesMovieList);
        notifyDataSetChanged();
   }

    public void setComedyMovieList(List<Movie> comedyMovieList) {
        listOfMovieCategories.get(6).setCategoryMovieList(comedyMovieList);
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

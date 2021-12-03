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

import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainRecyclerViewHolder>{

    Context context;
    List<String> listOfCategories;
    List<Movie> movieList;

    public MainRecyclerAdapter(Context context, List<String> listOfCategories, List<Movie> movieList) {
        this.context = context;
        this.listOfCategories = listOfCategories;
        this.movieList = movieList;
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
        setCatItemRecycler(holder.categoryRowRecycler, movieList);
    }

    @Override
    public int getItemCount() {
        return listOfCategories.size();
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

        CategoryRowItemRecyclerAdapter itemRecyclerAdapter = new CategoryRowItemRecyclerAdapter(context, categoryItemList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(itemRecyclerAdapter);

    }
}

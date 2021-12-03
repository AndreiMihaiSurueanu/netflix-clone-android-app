package com.example.netflixcloneandroidapp.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.netflixcloneandroidapp.R;
import com.example.netflixcloneandroidapp.model.entities.Movie;

import java.util.List;

public class CategoryRowItemRecyclerAdapter extends RecyclerView.Adapter<CategoryRowItemRecyclerAdapter.CategoryRowItemRecyclerViewHolder>{

    Context context;
    List<Movie> movieList;

    public CategoryRowItemRecyclerAdapter(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public CategoryRowItemRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.category_row_items, parent, false);
        return new CategoryRowItemRecyclerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRowItemRecyclerViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load("https://image.tmdb.org/t/p/w500" + movieList.get(position).getBackdrop_path())
                .into(holder.itemImage);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class CategoryRowItemRecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;

        public CategoryRowItemRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.item_image);

        }
    }
}

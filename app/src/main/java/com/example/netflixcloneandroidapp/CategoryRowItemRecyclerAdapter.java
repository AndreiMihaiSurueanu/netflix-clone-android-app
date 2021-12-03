package com.example.netflixcloneandroidapp;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryRowItemRecyclerAdapter extends RecyclerView.Adapter<CategoryRowItemRecyclerAdapter.CategoryRowItemRecyclerViewHolder>{
    @NonNull
    @Override
    public CategoryRowItemRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRowItemRecyclerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CategoryRowItemRecyclerViewHolder extends RecyclerView.ViewHolder {
        public CategoryRowItemRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

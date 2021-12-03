package com.example.netflixcloneandroidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainRecyclerViewHolder>{

    Context context;
    List<String> listOfCategories;

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

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MainRecyclerViewHolder extends RecyclerView.ViewHolder {
        public MainRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

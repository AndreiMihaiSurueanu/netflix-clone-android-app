package com.example.netflixcloneandroidapp.model.web_services;

import android.util.Log;

import com.example.netflixcloneandroidapp.model.entities.Movie;
import com.example.netflixcloneandroidapp.model.entities.TrendingNow;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance;
    TmdbApiInterface tmdbApiInterface;
    List<Movie> trendingMoviesList;

    RetrofitClient() {
        tmdbApiInterface = new Retrofit.Builder()
                .baseUrl(ApiConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(TmdbApiInterface.class);
    }

    public static RetrofitClient getRetrofitClientInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }


    public List<Movie> getTrendingNow() {

        Call<TrendingNow> trendingNowCall = tmdbApiInterface.trendingNowCall(ApiConfig.API_KEY);
        trendingNowCall.enqueue(new Callback<TrendingNow>() {
            @Override
            public void onResponse(Call<TrendingNow> call, Response<TrendingNow> response) {
                trendingMoviesList = response.body().getMovies();
            }

            @Override
            public void onFailure(Call<TrendingNow> call, Throwable t) {
                Log.i("Retrofit", "Something went wrong :(");
            }
        });
        return trendingMoviesList;
    }

}

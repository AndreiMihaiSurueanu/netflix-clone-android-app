package com.example.netflixcloneandroidapp.model.web_services;

import com.example.netflixcloneandroidapp.model.entities.Movie;
import com.example.netflixcloneandroidapp.model.entities.TrendingNow;

import java.io.IOException;
import java.util.List;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance;
    TmdbApiInterface tmdbApiInterface;

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


    public List<Movie> loadTrendingNow() throws IOException {

        Response response = tmdbApiInterface.trendingNowCall(ApiConfig.API_KEY).execute();
        return ((TrendingNow) response.body()).getMovies();

    }

}

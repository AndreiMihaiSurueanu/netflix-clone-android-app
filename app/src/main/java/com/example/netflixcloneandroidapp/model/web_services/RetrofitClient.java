package com.example.netflixcloneandroidapp.model.web_services;

import com.example.netflixcloneandroidapp.model.entities.Movie;
import com.example.netflixcloneandroidapp.model.entities.TrendingNow;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Movie> loadDiscoverMovie() throws IOException {

        Map<String, String> parameters = new HashMap<>();
        parameters.put("api_key", ApiConfig.API_KEY);
        parameters.put("sort_by", "release_date.desc");
        parameters.put("primary_release_date.lte", "2021-12-04");

        Response response = tmdbApiInterface.discoverMovieCall(parameters).execute();
        return ((TrendingNow) response.body()).getMovies();

    }

}

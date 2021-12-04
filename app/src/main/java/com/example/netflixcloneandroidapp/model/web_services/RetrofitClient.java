package com.example.netflixcloneandroidapp.model.web_services;

import com.example.netflixcloneandroidapp.model.entities.Movie;
import com.example.netflixcloneandroidapp.model.entities.MovieRequestResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        return ((MovieRequestResponse) response.body()).getMovies();

    }

    public List<Movie> loadNewReleases() throws IOException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();


        Map<String, String> parameters = new HashMap<>();
        parameters.put("api_key", ApiConfig.API_KEY);
        parameters.put("sort_by", "release_date.desc");
        parameters.put("primary_release_date.lte", now.toString());

        Response response = tmdbApiInterface.discoverMovieCall(parameters).execute();
        return ((MovieRequestResponse) response.body()).getMovies();

    }

    public List<Movie> loadComedyMovies() throws IOException {

        // Genre
        // "id": 35,
        // "name": "Comedy"

        Map<String, String> parameters = new HashMap<>();
        parameters.put("api_key", ApiConfig.API_KEY);
        parameters.put("with_genres", "35");

        Response response = tmdbApiInterface.discoverMovieCall(parameters).execute();
        return ((MovieRequestResponse) response.body()).getMovies();

    }

}

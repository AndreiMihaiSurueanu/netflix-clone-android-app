package com.example.netflixcloneandroidapp.model.web_services;

import com.example.netflixcloneandroidapp.model.entities.TrendingNow;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface TmdbApiInterface {

    // Trending Now     == TODO == Add {media_type}/{time_window}
    // https://api.themoviedb.org/3/trending/all/day?api_key={api_key}
    @GET("trending/all/day")
    Call<TrendingNow> trendingNowCall(
            @Query("api_key") String key
    );

    // Discover Movie
    // https://api.themoviedb.org/3/discover/movie
    // ?api_key={api_key}&sort_by=release_date.desc&release_date.lte=2021-12-04
    @GET("discover/movie")
    Call<TrendingNow> discoverMovieCall(@QueryMap Map<String, String> parameters);
}

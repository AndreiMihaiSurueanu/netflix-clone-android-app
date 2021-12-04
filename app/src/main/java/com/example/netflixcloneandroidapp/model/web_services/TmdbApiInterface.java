package com.example.netflixcloneandroidapp.model.web_services;

import com.example.netflixcloneandroidapp.model.entities.TrendingNow;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TmdbApiInterface {

    // Trending Now     == TODO == Add {media_type}/{time_window}
    // https://api.themoviedb.org/3/trending/all/day?api_key={api_key}
    @GET("trending/all/day")
    Call<TrendingNow> trendingNowCall(
            @Query("api_key") String key
    );
}

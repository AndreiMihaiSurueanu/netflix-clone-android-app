package com.example.netflixcloneandroidapp.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.netflixcloneandroidapp.R;
import com.example.netflixcloneandroidapp.model.entities.Movie;

public class MovieDetails extends AppCompatActivity {

    ImageView moviePoster, movieBackdrop;
    TextView movieTitle, movieDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        moviePoster = findViewById(R.id.movie_card_poster);
        movieBackdrop = findViewById(R.id.movie_backdrop);
        movieTitle = findViewById(R.id.movie_title);
        movieDescription = findViewById(R.id.movie_description);

        GetDataFromIntent();
    }

    private void GetDataFromIntent() {
        if(getIntent().hasExtra("movie")){
            Movie movieModel = getIntent().getParcelableExtra("movie");

            Glide.with(this)
                    .load("https://image.tmdb.org/t/p/original" + movieModel.getBackdrop_path())
                    .into(movieBackdrop);
            Glide.with(this)
                    .load("https://image.tmdb.org/t/p/original" + movieModel.getPoster_path())
                    .into(moviePoster);

            movieTitle.setText(movieModel.getTitle());
            movieDescription.setText(movieModel.getOverview());

        }
    }
}
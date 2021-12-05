package com.example.netflixcloneandroidapp.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.netflixcloneandroidapp.R;

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

    }
    }
}
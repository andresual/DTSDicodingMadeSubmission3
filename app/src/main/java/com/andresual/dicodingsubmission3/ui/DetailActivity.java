package com.andresual.dicodingsubmission3.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.andresual.dicodingsubmission3.R;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }
}

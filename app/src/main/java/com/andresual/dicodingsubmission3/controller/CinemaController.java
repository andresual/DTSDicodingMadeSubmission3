package com.andresual.dicodingsubmission3.controller;

import com.andresual.dicodingsubmission3.fragment.MovieFragment;
import com.andresual.dicodingsubmission3.fragment.TvFragment;

public class CinemaController {

    private static CinemaController mInstance;
    public static CinemaController getInstance() {
        if (mInstance == null) {
            mInstance = new CinemaController();
        }
        return mInstance;
    }

    public void fetchMovieData(MovieFragment movieFragment) {

    }

    public void fetchTvData(TvFragment tvFragment) {

    }
}

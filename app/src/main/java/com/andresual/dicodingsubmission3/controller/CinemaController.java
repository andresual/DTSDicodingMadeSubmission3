package com.andresual.dicodingsubmission3.controller;

import android.content.Context;
import android.util.Log;

import com.andresual.dicodingsubmission3.fragment.MovieFragment;
import com.andresual.dicodingsubmission3.fragment.TvFragment;
import com.andresual.dicodingsubmission3.model.MovieModel;
import com.andresual.dicodingsubmission3.model.TvModel;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

import com.andresual.dicodingsubmission3.api.*;

public class CinemaController {

    Context context;
    private ArrayList<MovieModel> movieModelArrayList = new ArrayList<>();
    private ArrayList<TvModel> tvModelArrayList = new ArrayList<>();

    //singleton
    private static CinemaController mInstance;
    public static CinemaController getInstance() {
        if (mInstance == null) {
            mInstance = new CinemaController();
        }
        return mInstance;
    }

    public void fetchMovieData(final MovieFragment movieFragment) {

        RequestQueue queue = Volley.newRequestQueue(Objects.requireNonNull(movieFragment.getContext()));
        StringRequest sr = new StringRequest(Request.Method.GET, apis.base_movie_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("response", response);
                        try {
                            JSONObject obj = new JSONObject(response);

                                JSONArray jsonArray = obj.getJSONArray("results");
                                Log.i("data", jsonArray.toString());
                                movieModelArrayList = new ArrayList<>();
                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject hasil = jsonArray.getJSONObject(i);
                                    Log.i( "onResponse: ", hasil.toString());
                                    MovieModel movieModel = new MovieModel();
                                    movieModel.setPopularity(hasil.getString("popularity"));
                                    movieModel.setVoteCount(hasil.getString("vote_count"));
                                    movieModel.setVideo(hasil.getString("video"));
                                    movieModel.setPosterPath(hasil.getString("poster_path"));
                                    movieModel.setId(hasil.getString("id"));
                                    movieModel.setAdult(hasil.getString("adult"));
                                    movieModel.setBackdropPath(hasil.getString("backdrop_path"));
                                    movieModel.setOriginalLanguage(hasil.getString("original_language"));
                                    movieModel.setOriginalTitle(hasil.getString("original_title"));
                                    movieModel.setTitle(hasil.getString("title"));
                                    movieModel.setVoteAverage(hasil.getString("vote_average"));
                                    movieModel.setOverview(hasil.getString("overview"));
                                    movieModel.setReleaseDate(hasil.getString("release_date"));
                                    movieModelArrayList.add(movieModel);
//                                    Log.i("userdata", salesModelArrayList.toString());
                            }
                            movieFragment.fetchMovieData(movieModelArrayList);

                        } catch (Throwable t) {
                            Log.i("dmas", "Could not parse malformed JSON: \"" + response + "\"");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                String message = null;

            }
        });
        queue.add(sr);
}

    public void fetchTvData(final TvFragment tvFragment) {
        RequestQueue queue = Volley.newRequestQueue(Objects.requireNonNull(tvFragment.getContext()));
        StringRequest sr = new StringRequest(Request.Method.GET, apis.base_tv_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("response", response);
                        try {
                            JSONObject obj = new JSONObject(response);

                            JSONArray jsonArray = obj.getJSONArray("results");
                            Log.i("data", jsonArray.toString());
                            tvModelArrayList = new ArrayList<>();
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject hasil = jsonArray.getJSONObject(i);
                                Log.i( "onResponse: ", hasil.toString());
                                TvModel tvModel = new TvModel();
                                tvModel.setOriginalName(hasil.getString("original_name"));
                                tvModel.setName(hasil.getString("name"));
                                tvModel.setPopularity(hasil.getString("popularity"));
                                tvModel.setOriginCountry(hasil.getString("origin_country"));
                                tvModel.setVoteCount(hasil.getString("vote_count"));
                                tvModel.setFirstAirDate(hasil.getString("first_air_date"));
                                tvModel.setBackdropPath(hasil.getString("backdrop_path"));
                                tvModel.setOriginalLanguage(hasil.getString("original_language"));
                                tvModel.setId(hasil.getString("id"));
                                tvModel.setVoteAverage(hasil.getString("vote_average"));
                                tvModel.setOverview(hasil.getString("overview"));
                                tvModel.setPosterPath(hasil.getString("poster_path"));
                                tvModelArrayList.add(tvModel);
//                                    Log.i("userdata", salesModelArrayList.toString());
                            }
                            tvFragment.fetchTvData(tvModelArrayList);

                        } catch (Throwable t) {
                            Log.i("dmas", "Could not parse malformed JSON: \"" + response + "\"");
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                String message = null;

            }
        });
        queue.add(sr);
    }
}

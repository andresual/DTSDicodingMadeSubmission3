package com.andresual.dicodingsubmission3.controller;

import android.content.Context;
import android.util.Log;

import com.andresual.dicodingsubmission3.fragment.MovieFragment;
import com.andresual.dicodingsubmission3.fragment.TvFragment;
import com.andresual.dicodingsubmission3.model.MovieModel;
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
    ArrayList<MovieModel> movieModelArrayList = new ArrayList<>();

    //singleton
    private static CinemaController mInstance;
    public static CinemaController getInstance() {
        if (mInstance == null) {
            mInstance = new CinemaController();
        }
        return mInstance;
    }

    public void fetchMovieData(MovieFragment movieFragment) {

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
//                                    userActive.setUserId(hasil.getString("token"));
//                                    userActive.setUserName(hasil.getString("name"));
//                                    userActive.setNamaSls(hasil.getString("namasls"));
//                                    userActive.setAlamatSls(hasil.getString("alamatsls"));
//                                    userActive.setKodeSls(hasil.getString("kodesls"));
//                                    userActive.setSupervisor(hasil.getString("supervisor"));
//                                    userActive.setNonaktif(hasil.getString("nonaktif"));
//                                    userActive.setPlafon(hasil.getString("plafon"));
//                                    salesModelArrayList.add(userActive);
//                                    Log.i("userdata", salesModelArrayList.toString());
                            }
//                            movieFragment.fetchMovieData(returnModel);

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

    public void fetchTvData(TvFragment tvFragment) {

    }
}

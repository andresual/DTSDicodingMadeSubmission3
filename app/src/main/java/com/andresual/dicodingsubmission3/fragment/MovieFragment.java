package com.andresual.dicodingsubmission3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andresual.dicodingsubmission3.R;
import com.andresual.dicodingsubmission3.controller.CinemaController;

public class MovieFragment extends Fragment {

    RecyclerView rvMovie;

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_movie, container, false);

        rvMovie = view.findViewById(R.id.rv_movie);

        fetchMovieData();

        return view;
    }

    public void fetchMovieData() {
        CinemaController.getInstance().fetchMovieData(this);
    }
}

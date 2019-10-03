package com.andresual.dicodingsubmission3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.andresual.dicodingsubmission3.R;
import com.andresual.dicodingsubmission3.adapter.MovieAdapter;
import com.andresual.dicodingsubmission3.model.MovieModel;
import com.andresual.dicodingsubmission3.util.MainViewModel;

import java.util.ArrayList;

public class MovieFragment extends Fragment {

    private MovieAdapter movieAdapter;
    private ProgressBar progressBar;

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

        progressBar = view.findViewById(R.id.progressBar);
        RecyclerView rvMovie = view.findViewById(R.id.rv_movie);
        rvMovie.setLayoutManager(new LinearLayoutManager(getActivity()));
        movieAdapter = new MovieAdapter(getActivity());
        rvMovie.setHasFixedSize(true);
        movieAdapter.notifyDataSetChanged();
        rvMovie.setAdapter(movieAdapter);

        MainViewModel mainViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MainViewModel.class);

        mainViewModel.getMovieList().observe(this, new Observer<ArrayList<MovieModel>>() {
            @Override
            public void onChanged(ArrayList<MovieModel> movieModels) {
                if (movieModels != null) {
                    Log.i("onChanged: ", movieModels.toString());
                    movieAdapter.setData(movieModels);
                    showLoading(false);
                }
            }
        });

        mainViewModel.setMovieList(MovieFragment.this);
        showLoading(true);
        return view;
    }

    private void showLoading(Boolean state) {

        if (state) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
        }
    }
}

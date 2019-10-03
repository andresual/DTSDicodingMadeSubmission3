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
import com.andresual.dicodingsubmission3.adapter.TvAdapter;
import com.andresual.dicodingsubmission3.model.TvModel;
import com.andresual.dicodingsubmission3.util.MainViewModel;

import java.util.ArrayList;

public class TvFragment extends Fragment {

    private TvAdapter tvAdapter;
    private ProgressBar progressBar;

    public TvFragment() {
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
        final View view = inflater.inflate(R.layout.fragment_tv, container, false);

        progressBar = view.findViewById(R.id.progressBar);
        RecyclerView rvTv = view.findViewById(R.id.rv_tv);
        rvTv.setLayoutManager(new LinearLayoutManager(getActivity()));
        tvAdapter = new TvAdapter(getActivity());
        rvTv.setHasFixedSize(true);
        tvAdapter.notifyDataSetChanged();
        rvTv.setAdapter(tvAdapter);

        MainViewModel mainViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(MainViewModel.class);

        mainViewModel.getTvList().observe(this, new Observer<ArrayList<TvModel>>() {
            @Override
            public void onChanged(ArrayList<TvModel> tvModels) {
                if (tvModels != null) {
                    showLoading(false);
                    Log.i("onChanged: ", tvModels.toString());
                    tvAdapter.setData(tvModels);
                    showLoading(false);
                }
            }
        });

        mainViewModel.setTvList(TvFragment.this);
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

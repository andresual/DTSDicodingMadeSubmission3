package com.andresual.dicodingsubmission3.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andresual.dicodingsubmission3.R;
import com.andresual.dicodingsubmission3.adapter.TvAdapter;
import com.andresual.dicodingsubmission3.controller.CinemaController;
import com.andresual.dicodingsubmission3.model.TvModel;

import java.util.ArrayList;

public class TvFragment extends Fragment {

    RecyclerView rvTv;

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

        rvTv = view.findViewById(R.id.rv_tv);
        rvTv.setHasFixedSize(true);

        CinemaController.getInstance().fetchTvData(this);

        return view;
    }

    public void fetchTvData(ArrayList<TvModel> tvModelArrayList) {
        rvTv.setLayoutManager(new LinearLayoutManager(getActivity()));
        TvAdapter tvAdapter = new TvAdapter(getActivity(), tvModelArrayList);
        rvTv.setAdapter(tvAdapter);
    }
}

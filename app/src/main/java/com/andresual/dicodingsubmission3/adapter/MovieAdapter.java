package com.andresual.dicodingsubmission3.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.andresual.dicodingsubmission3.R;
import com.andresual.dicodingsubmission3.api.apis;
import com.andresual.dicodingsubmission3.model.MovieModel;
import com.andresual.dicodingsubmission3.ui.DetailActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private ArrayList<MovieModel> mData = new ArrayList<>();
    private Context context;

    public MovieAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<MovieModel> items) {
        mData.clear();
        mData.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
        return new MovieViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, final int position) {
        MovieModel movieModel = mData.get(position);

        holder.tvTitle.setText(movieModel.getTitle());
        holder.tvAverage.setText(movieModel.getVoteAverage());
        holder.tvYear.setText(movieModel.getReleaseDate());

        Glide.with(holder.itemView.getContext())
                .load(apis.base_img_url+movieModel.getPosterPath())
                .apply(new RequestOptions())
                .into(holder.ivMovie);

        holder.cvMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MovieModel movieModel = new MovieModel();
                movieModel.setId(mData.get(position).getId());
                movieModel.setTitle(mData.get(position).getTitle());
                movieModel.setPopularity(mData.get(position).getPopularity());
                movieModel.setVoteAverage(mData.get(position).getVoteAverage());
                movieModel.setReleaseDate(mData.get(position).getReleaseDate());
                movieModel.setAdult(mData.get(position).getAdult());
                movieModel.setOverview(mData.get(position).getOverview());
                movieModel.setPosterPath(mData.get(position).getPosterPath());
                Intent moveWithObjectIntent = new Intent(context, DetailActivity.class);
                moveWithObjectIntent.putExtra("code", "1");
                moveWithObjectIntent.putExtra(DetailActivity.EXTRA_MOVIE, movieModel);
                context.startActivity(moveWithObjectIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvYear;
        TextView tvAverage;
        ImageView ivMovie;
        CardView cvMovie;

        MovieViewHolder(@NonNull View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tv_title);
            tvYear = view.findViewById(R.id.tv_year);
            ivMovie = view.findViewById(R.id.iv_hero);
            cvMovie = view.findViewById(R.id.cv_item);
            tvAverage = view.findViewById(R.id.tv_vote_avg);
        }
    }
}

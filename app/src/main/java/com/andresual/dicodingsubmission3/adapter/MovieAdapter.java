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

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ListViewHolder> {

    private ArrayList<MovieModel> movieModelArrayList;
    Context context;

    public MovieAdapter(Context context, ArrayList<MovieModel> movieAdapterArrayList) {
        this.movieModelArrayList = movieAdapterArrayList;
        this.context = context;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvYear;
        TextView tvAverage;
        ImageView ivMovie;
        CardView cvMovie;

        public ListViewHolder(@NonNull View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tv_title);
            tvYear = view.findViewById(R.id.tv_year);
            ivMovie = view.findViewById(R.id.iv_hero);
            cvMovie = view.findViewById(R.id.cv_item);
            tvAverage = view.findViewById(R.id.tv_vote_avg);
        }
    }

    @NonNull
    @Override
    public MovieAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_movie, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieAdapter.ListViewHolder holder, final int position) {
        MovieModel movieModel = movieModelArrayList.get(position);

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
                movieModel.setTitle(movieModelArrayList.get(position).getTitle());
                movieModel.setReleaseDate(movieModelArrayList.get(position).getReleaseDate());
//                movieModel.getPosterPath(movieModelArrayList.get(position).getPosterPath());
                Intent moveWithObjectIntent = new Intent(context, DetailActivity.class);
                moveWithObjectIntent.putExtra(DetailActivity.EXTRA_MOVIE, movieModel);
                context.startActivity(moveWithObjectIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieModelArrayList.size();
    }
}

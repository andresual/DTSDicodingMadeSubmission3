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
import com.andresual.dicodingsubmission3.model.TvModel;
import com.andresual.dicodingsubmission3.ui.DetailActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.ListViewHolder> {

    private ArrayList<TvModel> mData = new ArrayList<>();
    private Context context;

    public TvAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<TvModel> items) {
        mData.clear();
        mData.addAll(items);
        notifyDataSetChanged();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvYear;
        TextView tvAverage;
        ImageView ivTv;
        CardView cvTv;

        ListViewHolder(@NonNull View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tv_title);
            tvYear = view.findViewById(R.id.tv_year);
            ivTv = view.findViewById(R.id.iv_hero);
            cvTv = view.findViewById(R.id.cv_item);
            tvAverage = view.findViewById(R.id.tv_vote_avg);
        }
    }

    @NonNull
    @Override
    public TvAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_tv, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TvAdapter.ListViewHolder holder, final int position) {
        TvModel tvModel = mData.get(position);

        holder.tvTitle.setText(tvModel.getName());
        holder.tvAverage.setText(tvModel.getVoteAverage());
        holder.tvYear.setText(tvModel.getFirstAirDate());

        Glide.with(holder.itemView.getContext())
                .load(apis.base_img_url+tvModel.getPosterPath())
                .apply(new RequestOptions())
                .into(holder.ivTv);

        holder.cvTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TvModel tvModel = new TvModel();
                tvModel.setId(mData.get(position).getId());
                tvModel.setOriginalName(mData.get(position).getOriginalName());
                tvModel.setPopularity(mData.get(position).getPopularity());
                tvModel.setVoteAverage(mData.get(position).getVoteAverage());
                tvModel.setFirstAirDate(mData.get(position).getFirstAirDate());
                tvModel.setOverview(mData.get(position).getOverview());
                tvModel.setPosterPath(mData.get(position).getPosterPath());
                Intent moveWithObjectIntent = new Intent(context, DetailActivity.class);
                moveWithObjectIntent.putExtra("code", "2");
                moveWithObjectIntent.putExtra(DetailActivity.EXTRA_TV, tvModel);
                context.startActivity(moveWithObjectIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}

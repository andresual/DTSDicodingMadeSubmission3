package com.andresual.dicodingsubmission3.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.andresual.dicodingsubmission3.R;
import com.andresual.dicodingsubmission3.api.apis;
import com.andresual.dicodingsubmission3.model.MovieModel;
import com.andresual.dicodingsubmission3.model.TvModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    public static final String EXTRA_TV = "extra_tv";
    private CollapsingToolbarLayout collapsing;
    private ImageView imgMovie;
    private FloatingActionButton btnFav;
    private TextView tvPopularity1;
    private TextView tvVoteAverage1;
    private TextView tvReleaseDate1;
    private TextView tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Objects.equals(this.getIntent().getStringExtra("code"), "1")) {
            setContentView(R.layout.activity_detail_movie);
            initViewMovie();
        } else if (Objects.equals(this.getIntent().getStringExtra("code"), "2")) {
            setContentView(R.layout.activity_detail_tv);
            initViewTv();
        }

    }

    public void initViewMovie() {

        collapsing = findViewById(R.id.collapsing);
        imgMovie = findViewById(R.id.img_movie);
        btnFav = findViewById(R.id.btn_fav);
        tvPopularity1 = findViewById(R.id.tv_popularity1);
        tvVoteAverage1 = findViewById(R.id.tv_vote_average1);
        tvReleaseDate1 = findViewById(R.id.tv_release_date1);
        TextView textView5 = findViewById(R.id.tv_adult1);
        tvDesc = findViewById(R.id.tv_desc);

        MovieModel movieModel = getIntent().getParcelableExtra(EXTRA_MOVIE);
        collapsing.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsing.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        assert movieModel != null;
        collapsing.setTitle(movieModel.getTitle());

        Glide.with(this)
                .load(apis.base_img_url+movieModel.getPosterPath())
                .apply(new RequestOptions())
                .into(imgMovie);

        tvPopularity1.setText(movieModel.getPopularity());
        tvVoteAverage1.setText(movieModel.getVoteAverage());
        tvReleaseDate1.setText(movieModel.getReleaseDate());

        if (movieModel.getAdult().equals("false")) {
            textView5.setVisibility(View.INVISIBLE);
        }

        tvDesc.setText(movieModel.getOverview());

        btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailActivity.this, "BeLom bisa, tunggu sapmisen 4", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void initViewTv() {

        collapsing = findViewById(R.id.collapsing);
        imgMovie = findViewById(R.id.img_movie);
        btnFav = findViewById(R.id.btn_fav);
        tvPopularity1 = findViewById(R.id.tv_popularity1);
        tvVoteAverage1 = findViewById(R.id.tv_vote_average1);
        tvReleaseDate1 = findViewById(R.id.tv_release_date1);
        tvDesc = findViewById(R.id.tv_desc);

        TvModel tvModel = getIntent().getParcelableExtra(EXTRA_TV);
        collapsing.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsing.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
        assert tvModel != null;
        collapsing.setTitle(tvModel.getOriginalName());

        Glide.with(this)
                .load(apis.base_img_url+tvModel.getPosterPath())
                .apply(new RequestOptions())
                .into(imgMovie);

        tvPopularity1.setText(tvModel.getPopularity());
        tvVoteAverage1.setText(tvModel.getVoteAverage());
        tvReleaseDate1.setText(tvModel.getFirstAirDate());

        tvDesc.setText(tvModel.getOverview());

        btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailActivity.this, "BeLom bisa, tunggu sapmisen 4", Toast.LENGTH_LONG).show();
            }
        });
    }
}

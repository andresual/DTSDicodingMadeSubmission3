package com.andresual.dicodingsubmission3.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TvModel implements Parcelable {

    private String originalName;
    private String name;
    private String popularity;
    private String originCountry;
    private String voteCount;
    private String firstAirDate;
    private String backdropPath;
    private String originalLanguage;
    private String id;
    private String voteAverage;
    private String overview;
    private String posterPath;

    public TvModel() {
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(String voteCount) {
        this.voteCount = voteCount;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    protected TvModel(Parcel in) {
        originalName = in.readString();
        name = in.readString();
        popularity = in.readString();
        originCountry = in.readString();
        voteCount = in.readString();
        firstAirDate = in.readString();
        backdropPath = in.readString();
        originalLanguage = in.readString();
        id = in.readString();
        voteAverage = in.readString();
        overview = in.readString();
        posterPath = in.readString();
    }

    public static final Creator<TvModel> CREATOR = new Creator<TvModel>() {
        @Override
        public TvModel createFromParcel(Parcel in) {
            return new TvModel(in);
        }

        @Override
        public TvModel[] newArray(int size) {
            return new TvModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(originalName);
        parcel.writeString(name);
        parcel.writeString(popularity);
        parcel.writeString(originCountry);
        parcel.writeString(voteCount);
        parcel.writeString(firstAirDate);
        parcel.writeString(backdropPath);
        parcel.writeString(originalLanguage);
        parcel.writeString(id);
        parcel.writeString(voteAverage);
        parcel.writeString(overview);
        parcel.writeString(posterPath);
    }
}

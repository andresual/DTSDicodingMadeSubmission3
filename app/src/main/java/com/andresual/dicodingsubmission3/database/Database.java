package com.andresual.dicodingsubmission3.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;

import com.andresual.dicodingsubmission3.model.MovieModel;
import com.andresual.dicodingsubmission3.model.TvModel;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {

    // TODO: 16/09/2019 buat dataaset untuk menampung isi cart
    private static final String DB_NAME = "cinemadb.db";
    private static final int DB_VER = 1;

    public Database(Context context) {
        super(context, DB_NAME,null, DB_VER);
    }

    public List<MovieModel> getMovieFav() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"id","popularity","vote_count","video","poster_path", "id_movie", "adult", "backdrop_path", "original_language", "original_title", "title", "vote_average", "overview", "release_date"};
        String sqlTable = "tb_movie";

        qb.setTables(sqlTable);
        Cursor c = qb.query(db, sqlSelect,null,null,null,null,null);

        final List<MovieModel> result = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                result.add(new MovieModel(
                        c.getString(c.getColumnIndex("popularity")),
                        c.getString(c.getColumnIndex("vote_count")),
                        c.getString(c.getColumnIndex("video")),
                        c.getString(c.getColumnIndex("poster_path")),
                        c.getString(c.getColumnIndex("id_movie")),
                        c.getString(c.getColumnIndex("adult")),
                        c.getString(c.getColumnIndex("backdrop_path")),
                        c.getString(c.getColumnIndex("original_language")),
                        c.getString(c.getColumnIndex("original_title")),
                        c.getString(c.getColumnIndex("title")),
                        c.getString(c.getColumnIndex("vote_average")),
                        c.getString(c.getColumnIndex("overview")),
                        c.getString(c.getColumnIndex("release_date"))
                ));
            } while (c.moveToNext());
        } return result;
    }

    public void addMovieFav(MovieModel movieModel) {

        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("INSERT OR REPLACE INTO tb_movie(popularity,vote_count,video,poster_path,id_movie,adult,backdrop_path,original_language,original_title,title,vote_average,overview,release_date) VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                movieModel.getPopularity(),
                movieModel.getVoteCount(),
                movieModel.getVideo(),
                movieModel.getPosterPath(),
                movieModel.getId(),
                movieModel.getAdult(),
                movieModel.getBackdropPath(),
                movieModel.getOriginalLanguage(),
                movieModel.getOriginalTitle(),
                movieModel.getTitle(),
                movieModel.getVoteAverage(),
                movieModel.getOverview(),
                movieModel.getReleaseDate());

        db.execSQL(query);
        Log.i("Insertmovie: ", query);
    }

    public void cleanMovieFav()
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("DELETE FROM tb_movie");
        db.execSQL(query);
    }

    public void deleteMovie(String id) {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("DELETE FROM " + "tb_movie" + " " + "WHERE " + "id= '" + id+"'");
        db.execSQL(query);
        Log.i("DeleteCart: ", query);
    }

//    public void UpdateCart(String qty, String productId) {
//        SQLiteDatabase db = getWritableDatabase();
//        String query = String.format("UPDATE tb_cart SET Quantity = " + qty + " WHERE ProductId ='" + productId+"'");
//        db.execSQL(query);
//        Log.i("UpdateCart: ", query);
//    }

    public List<TvModel> getTvFav() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"id","original_name","name","popularity","origin_country", "vote_count", "first_air_date", "backdrop_path", "original_language", "original_title", "id_tv", "vote_average", "overview", "poster_path"};
        String sqlTable = "tb_tv";

        qb.setTables(sqlTable);
        Cursor c = qb.query(db, sqlSelect,null,null,null,null,null);

        final List<TvModel> result = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                result.add(new TvModel(
                        c.getString(c.getColumnIndex("original_name")),
                        c.getString(c.getColumnIndex("name")),
                        c.getString(c.getColumnIndex("popularity")),
                        c.getString(c.getColumnIndex("origin_country")),
                        c.getString(c.getColumnIndex("vote_count")),
                        c.getString(c.getColumnIndex("first_air_date")),
                        c.getString(c.getColumnIndex("backdrop_path")),
                        c.getString(c.getColumnIndex("original_language")),
                        c.getString(c.getColumnIndex("id_tv")),
                        c.getString(c.getColumnIndex("vote_average")),
                        c.getString(c.getColumnIndex("overview")),
                        c.getString(c.getColumnIndex("poster_path"))
                ));
            } while (c.moveToNext());
        } return result;
    }

    public void addTvFav(TvModel tvModel) {

        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("INSERT OR REPLACE INTO tb_tv(original_name,name,popularity,original_count,vote_count,first_air_date,backdrop_path,original_language,id_tv,vote_average,overview,poster_path) VALUES('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                tvModel.getOriginalName(),
                tvModel.getName(),
                tvModel.getPopularity(),
                tvModel.getOriginCountry(),
                tvModel.getVoteCount(),
                tvModel.getFirstAirDate(),
                tvModel.getBackdropPath(),
                tvModel.getOriginalLanguage(),
                tvModel.getId(),
                tvModel.getVoteAverage(),
                tvModel.getOverview(),
                tvModel.getPosterPath());

        db.execSQL(query);
        Log.i("Inserttv: ", query);
    }

    public void cleanTvFav()
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("DELETE FROM tb_tv");
        db.execSQL(query);
    }

    public void deleteTv(String id) {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("DELETE FROM " + "tb_tv" + " " + "WHERE " + "id= '" + id+"'");
        db.execSQL(query);
        Log.i("Deletetv: ", query);
    }
}
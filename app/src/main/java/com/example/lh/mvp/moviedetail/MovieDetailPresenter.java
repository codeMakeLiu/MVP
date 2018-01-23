package com.example.lh.mvp.moviedetail;

import android.app.Activity;
import android.content.res.Resources;

import com.example.lh.mvp.R;
import com.example.lh.mvp.beans.Movie;

/**
 * Created by lh on 2018/1/21.
 */

public class MovieDetailPresenter implements MovieDetailContract.Presenter {

    Movie movie;
    MovieDetailContract.View view;

    /**
     * g构造方法就是Presenter和View交互的地方
     * @param movie
     * @param view
     */
    public MovieDetailPresenter(Movie movie, MovieDetailContract.View view) {
        this.movie = movie;
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        showMovieDetail();
    }

    private void showMovieDetail() {
        view.showToolBar(movie.getTitle());
        view.showImage(movie.getImages().getLarge());
    }

    @Override
    public void loadMovieInfo() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("导演");
        for (Movie.DirectorsBean dire :
                movie.getDirectors()) {
            stringBuilder.append(dire.getName());
            stringBuilder.append("");
        }
        stringBuilder.append("\n");
        view.setMovieInfoFrag(stringBuilder.toString());
    }

    @Override
    public void loadMovie() {
        view.setMovieToFrag(movie.getAlt());
    }
}

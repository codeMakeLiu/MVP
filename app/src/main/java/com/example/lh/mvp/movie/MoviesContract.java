package com.example.lh.mvp.movie;

import com.example.lh.mvp.BasePresenter;
import com.example.lh.mvp.BaseView;
import com.example.lh.mvp.beans.Movie;

import java.util.List;

/**
 * Created by lh on 2018/1/14.
 */

public interface MoviesContract {
    interface View extends BaseView<Presenter>{
        void showMovies(List<Movie> movies);

        void showNoMoview();

        void showLoading(boolean activity);
    }
    interface Presenter extends BasePresenter{
        void loadMovies(boolean forceUpdate);
    }
}

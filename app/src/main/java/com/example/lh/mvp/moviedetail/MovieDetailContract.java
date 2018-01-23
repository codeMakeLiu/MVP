package com.example.lh.mvp.moviedetail;

import com.example.lh.mvp.BasePresenter;
import com.example.lh.mvp.BaseView;
import com.example.lh.mvp.movie.MoviesContract;

/**
 * Created by lh on 2018/1/20.
 */

public interface MovieDetailContract {
    interface View extends BaseView<Presenter>{

        void showToolBar(String title);
        void showImage(String url);
        void setMovieInfoFrag(String movieInfo);
        void setMovieToFrag(String movie);

    }
    interface Presenter extends BasePresenter{
        void loadMovieInfo();
        void loadMovie();
    }
}

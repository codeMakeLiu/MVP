package com.example.lh.mvp.movie;

import com.example.lh.mvp.api.IDBService;
import com.example.lh.mvp.beans.HotMovieInfo;
import com.example.lh.mvp.beans.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lh on 2018/1/14.
 */

public class MoviesPresenter implements MoviesContract.Presenter {

    private final MoviesContract.View mMoviesView;
    private final IDBService idbService;
    private final boolean mFirstLoad = true;

    public MoviesPresenter(MoviesContract.View mMoviesView, IDBService idbService) {
        this.mMoviesView = mMoviesView;
        this.idbService = idbService;
        mMoviesView.setPresenter(this);
    }


    @Override
    public void start() {
        loadMovies(true);
    }

    @Override
    public void loadMovies(boolean forceUpdate) {
        loadMoviess(forceUpdate||mFirstLoad,true);
    }

    private void loadMoviess(boolean forceUpdate, final boolean showDialogUI) {

        if (showDialogUI){
            mMoviesView.showLoading(true);
        }

        if (forceUpdate){
            idbService.searchHotMovies().enqueue(new Callback<HotMovieInfo>() {
                @Override
                public void onResponse(Call<HotMovieInfo> call, Response<HotMovieInfo> response) {
                    List<Movie> movie = response.body().getMovie();
                    if (showDialogUI){
                        mMoviesView.showLoading(false);
                    }
                    processMovie(movie);
                }

                @Override
                public void onFailure(Call<HotMovieInfo> call, Throwable t) {
                    if (showDialogUI){
                        mMoviesView.showLoading(false);
                    }
                }
            });
        }

    }

    private void processMovie(List<Movie> movie) {
        if (movie.isEmpty()){
            processEmptyTask();
        }else {
            mMoviesView.showMovies(movie);
        }
    }

    private void processEmptyTask() {
        mMoviesView.showNoMoview();
    }
}

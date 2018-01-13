package com.example.lh.mvp.api;

import com.example.lh.mvp.beans.HotMovieInfo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by lh on 2018/1/13.
 */

public interface IDBService {
    String BASE_URL = "http://api.douban.com/v2/";

    @GET("movie/in_theaters")
    Call<HotMovieInfo> searchHotMovies();
}

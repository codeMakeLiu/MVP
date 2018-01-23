package com.example.lh.mvp.api;

import com.example.lh.mvp.beans.BookInfo;
import com.example.lh.mvp.beans.HotMovieInfo;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by lh on 2018/1/13.
 */

public interface IDBService {
    String BASE_URL = "https://api.douban.com/v2/";

    @GET("movie/in_theaters")
    Call<HotMovieInfo> searchHotMovies();
    @GET("book/search")
    Observable<BookInfo> searchBooks(@Query("q")String name);
//    @GET("book/search")
//    Call<BookInfo> searchBooks(@Query("q")String name);
    @GET
    Observable<BookInfo> getBlog(@Url String url);
}

package com.example.lh.mvp.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lh on 2018/1/13.
 */

public class DBManager {

    private static IDBService idbService;

    public synchronized static IDBService creatDBService(){
        if (idbService == null){
            Retrofit retrofit = creatRetrofit();
            idbService = retrofit.create(IDBService.class);
        }
        return idbService;
    }

    private static Retrofit creatRetrofit(){
        OkHttpClient httpClient;
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();

        return new Retrofit.Builder()
                .baseUrl(IDBService.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//轉換為rxjava
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)//攔截請求的數據，方便打log看
                .build();
//        return new Retrofit.Builder()
//                .baseUrl(IDBService.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .client(httpClient)
//                .build();
    }
}

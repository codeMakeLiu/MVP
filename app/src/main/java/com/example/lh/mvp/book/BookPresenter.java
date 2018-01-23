package com.example.lh.mvp.book;

import android.util.Log;

import com.example.lh.mvp.BasePresenter;
import com.example.lh.mvp.BaseView;
import com.example.lh.mvp.api.DBManager;
import com.example.lh.mvp.api.IDBService;
import com.example.lh.mvp.beans.Book;
import com.example.lh.mvp.beans.BookInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lh on 2018/1/21.
 */

public class BookPresenter implements BookContract.Presenter{
    IDBService idbService;
    BookContract.View view;

    public BookPresenter(IDBService idbService, BookContract.View view) {
        this.idbService = idbService;
        this.view = view;
        view.setPresenter(this);
    }



    @Override
    public void start() {
        loadBook(true);
    }

    @Override
    public void loadBook(boolean forceUpdate) {
        loadBooks(forceUpdate,true);
    }

    private void loadBooks(boolean forceUpdate, final boolean isUpdateUI) {
        if (isUpdateUI){
            view.loadShow(true);
        }
        if (forceUpdate){
//            idbService.searchBooks("黑客").enqueue(new Callback<BookInfo>() {
//                @Override
//                public void onResponse(Call<BookInfo> call, Response<BookInfo> response) {
//                    Log.e("aaaaaaaaaaa",response.body().getCount()+"");
//                    List<Book> list = response.body().getBook();
//                    if (isUpdateUI){
//                        view.loadShow(false);
//                    }
//                    processMovie(list);
//                }
//
//                @Override
//                public void onFailure(Call<BookInfo> call, Throwable t) {
//                    Log.e("aaaaaaaaaaa",t.toString());
//                    if (isUpdateUI){
//                        view.loadShow(false);
//                    }
//                }
//            });

            /**
             * 被观察者.subscribe(觀察者)
             */
            Observable<BookInfo> bookInfoObservable = DBManager.creatDBService().searchBooks("黑客");
            Subscription subscribe = bookInfoObservable
                    .subscribeOn(Schedulers.io())//异步线程請求
                    .observeOn(AndroidSchedulers.mainThread())//回到主线程
                    .subscribe(new Subscriber<BookInfo>() {//订阅
                        @Override
                        public void onCompleted() {
                            if (isUpdateUI) {
                                view.loadShow(false);
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (isUpdateUI) {
                                view.loadShow(false);
                            }
                        }

                        @Override
                        public void onNext(BookInfo bookInfo) {
                            List<Book> list = bookInfo.getBook();
                            processMovie(list);
                        }
                    });
            /**
             * 終止聯網請求
             */
//            subscribe.unsubscribe();
        }
    }

    private void processMovie(List<Book> list) {
        if (list.isEmpty()){
            processEmptyTask();
        }else {
            view.loadBook(list);
        }
    }

    private void processEmptyTask() {
        view.loadNoBook();
    }
}

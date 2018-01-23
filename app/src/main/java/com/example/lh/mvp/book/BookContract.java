package com.example.lh.mvp.book;

import com.example.lh.mvp.BasePresenter;
import com.example.lh.mvp.BaseView;
import com.example.lh.mvp.beans.Book;

import java.util.List;

/**
 * Created by lh on 2018/1/21.
 */

public interface BookContract {
    interface Presenter extends BasePresenter {
        void loadBook(boolean forceUpdate);
    }
    interface View extends BaseView<Presenter> {
        void loadBook(List<Book> bookList);
        void loadNoBook();
        void loadShow(boolean active);
    }
}

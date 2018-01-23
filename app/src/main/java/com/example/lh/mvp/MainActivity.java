package com.example.lh.mvp;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;

import com.example.lh.mvp.api.DBManager;
import com.example.lh.mvp.book.BookContract;
import com.example.lh.mvp.book.BookFragment;
import com.example.lh.mvp.book.BookPresenter;
import com.example.lh.mvp.movie.MovieFragment;
import com.example.lh.mvp.movie.MoviesContract;
import com.example.lh.mvp.movie.MoviesPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.view_pager);
        setUpViewPager(viewPager);
        TabLayout tabLayout = findViewById(R.id.sliding_tabs);
        if (tabLayout != null){
            tabLayout.addTab(tabLayout.newTab());
            tabLayout.addTab(tabLayout.newTab());
            tabLayout.setupWithViewPager(viewPager);
        }
    }

    private void setUpViewPager(ViewPager viewPager) {
        DBPagerAdapter dbPagerAdapter = new DBPagerAdapter(getSupportFragmentManager());
        MovieFragment movieFragment = MovieFragment.getInstance();
        BookFragment bookFragment = new BookFragment();
        dbPagerAdapter.addFragment(movieFragment,
                getResources().getString(R.string.tab_movie_fragment));
        dbPagerAdapter.addFragment(bookFragment,
                getResources().getString(R.string.tab_book_fragment));
        viewPager.setAdapter(dbPagerAdapter);
        creatPresenter(movieFragment);
        creatPresenters(bookFragment);

    }

    private void creatPresenters(BookContract.View bookFragment) {
        new BookPresenter(DBManager.creatDBService(), bookFragment);
    }

    private void creatPresenter(MoviesContract.View movieBiew) {
        new MoviesPresenter(movieBiew,DBManager.creatDBService());
    }

    static class DBPagerAdapter extends FragmentPagerAdapter{

        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public DBPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment,String title){
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}

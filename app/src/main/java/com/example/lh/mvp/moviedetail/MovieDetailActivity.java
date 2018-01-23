package com.example.lh.mvp.moviedetail;

import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.example.lh.mvp.R;
import com.example.lh.mvp.beans.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends FragmentActivity implements MovieDetailContract.View {

    MovieDetailContract.Presenter presenter;
    String movieInfo = null;
    String movieAlt = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        new MovieDetailPresenter((Movie) getIntent().getSerializableExtra("movie"),this);
        ViewPager viewPager = findViewById(R.id.view_pager);
        setViewPager(viewPager);
        TabLayout sliding_tabs = findViewById(R.id.sliding_tabs);
        if (sliding_tabs == null) return;
        sliding_tabs.addTab(sliding_tabs.newTab());
        sliding_tabs.addTab(sliding_tabs.newTab());
        sliding_tabs.setupWithViewPager(viewPager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.start();
    }

    private void setViewPager(ViewPager viewPager) {
        presenter.loadMovie();
        presenter.loadMovieInfo();
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager());
        myAdapter.addFragment(new MovieDetailOneFragment(),"信息");
        myAdapter.addFragment(new MovieDetailTwoFragment(),"链接");
        viewPager.setAdapter(myAdapter);
    }

    @Override
    public void setPresenter(MovieDetailContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showToolBar(String title) {
        android.support.v7.widget.Toolbar collapsingToolbarLayout = findViewById(R.id.movie_toolbar);
        collapsingToolbarLayout.setTitle(title);
    }

    @Override
    public void showImage(String url) {
        Log.e("aaaaaaaaaaa",url);
        ImageView movie_image = findViewById(R.id.movie_image);
        Picasso.with(getApplicationContext()).load(url).into(movie_image);
    }

    @Override
    public void setMovieInfoFrag(String movieInfo) {

    }

    @Override
    public void setMovieToFrag(String movie) {

    }

    class MyAdapter extends FragmentPagerAdapter{
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        public void addFragment(Fragment fragment, String info) {
            mFragments.add(fragment);
            mFragmentTitles.add(info);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}

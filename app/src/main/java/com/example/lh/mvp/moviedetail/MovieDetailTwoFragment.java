package com.example.lh.mvp.moviedetail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lh.mvp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailTwoFragment extends Fragment {


    public MovieDetailTwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_detail_two, container, false);
    }

}

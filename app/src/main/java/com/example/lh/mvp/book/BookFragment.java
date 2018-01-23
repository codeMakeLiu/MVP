package com.example.lh.mvp.book;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.lh.mvp.R;
import com.example.lh.mvp.api.DBManager;
import com.example.lh.mvp.beans.Book;
import com.example.lh.mvp.beans.Book;
import com.example.lh.mvp.movie.MovieFragment;
import com.example.lh.mvp.movie.MoviesContract;
import com.example.lh.mvp.moviedetail.MovieDetailActivity;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookFragment extends Fragment implements BookContract.View{
    private List<Book> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    BookFragment.MyAdapter myAdapter;

    public BookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book, container, false);
        recyclerView = view.findViewById(R.id.ry);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (recyclerView == null) return;
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity().getApplicationContext(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        myAdapter = new BookFragment.MyAdapter(movieList, getContext(), R.layout.fragment_movie_item);
        recyclerView.setAdapter(myAdapter);
    }

    private BookContract.Presenter mPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

//        loadMovies(new Callback<HotMovieInfo>() {
//            @Override
//            public void onResponse(Call<HotMovieInfo> call, Response<HotMovieInfo> response) {
//                movieList = response.body().getMovie();
//                myAdapter.setData(movieList);
//            }
//
//            @Override
//            public void onFailure(Call<HotMovieInfo> call, Throwable t) {
//
//            }
//        });

        if (mPresenter != null){
            mPresenter.start();
        }
    }

    @Override
    public void setPresenter(BookContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void loadBook(List<Book> bookList) {
        myAdapter.replaceDate(bookList);
    }

    @Override
    public void loadNoBook() {

    }

    @Override
    public void loadShow(boolean active) {
        if(getView() == null) return;
        final ProgressBar progressBar = getView().findViewById(R.id.pb);
        if (active){
            progressBar.setVisibility(View.VISIBLE);
        }else {
            progressBar.setVisibility(View.GONE);
        }
    }
    static class MyAdapter extends RecyclerView.Adapter<BookFragment.MovieViewHolder>{

        private List<Book> movieList;
        private Context context;
        private int layoutId;

        public MyAdapter(List<Book> movieList, Context context, int layoutId) {
            setData(movieList);
            this.context = context;
            this.layoutId = layoutId;
        }

        @Override
        public BookFragment.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(context).inflate(layoutId, parent, false);
            return new BookFragment.MovieViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder(BookFragment.MovieViewHolder holder, int position) {
            if (holder == null) return;
            holder.updateMovie(movieList.get(position));
        }

        @Override
        public int getItemCount() {
            return movieList.size();
        }

        public void setData(List<Book> movieList) {
            this.movieList = movieList;
        }

        public void replaceDate(List<Book> movies) {
            setData(movies);
            notifyDataSetChanged();
        }
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView imageView;
        private TextView title,average;
        private RatingBar ratingBar;
        private Book movie;

        public MovieViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.movie_cover);
            title = itemView.findViewById(R.id.movie_title);
            average = itemView.findViewById(R.id.movie_average);
            ratingBar = itemView.findViewById(R.id.rating_star);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (movie == null||itemView == null) return;
            Context context = itemView.getContext();
            Intent intent = new Intent(context, MovieDetailActivity.class);
            intent.putExtra("movie",movie);

            if (context instanceof Activity){
                Activity activity = (Activity) context;
                Bundle cover = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, imageView, "cover").toBundle();
                ActivityCompat.startActivity(activity,intent,cover);
            }
        }

        private void updateMovie(Book movie) {
            if (movie == null) return;
            this.movie = movie;
            Context context = itemView.getContext();

            Picasso.with(context).load(movie.getImages().getLarge())
                    .placeholder(context.getResources().getDrawable(R.mipmap.ic_launcher))
                    .into(imageView);
            title.setText(movie.getTitle());
            final String averages = movie.getRating().getAverage();

            if (averages.equals(null)){
                ratingBar.setVisibility(View.GONE);
                average.setText(context.getResources().getString(R.string.string_no_note));
            }else {
                ratingBar.setVisibility(View.VISIBLE);
                ratingBar.setStepSize(0.5f);
                ratingBar.setRating( Float.valueOf(movie.getRating().getAverage())/2);
                average.setText(String.valueOf(averages));
            }

        }

    }
}

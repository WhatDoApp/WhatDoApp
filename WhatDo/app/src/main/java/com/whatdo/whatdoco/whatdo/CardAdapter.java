package com.whatdo.whatdoco.whatdo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>{

    List<Category> mItems;

    public CardAdapter() {
        super();
        mItems = new ArrayList<Category>();
        Category movie = new Category();
        movie.setName("The Amazing Spider-Man 2");
        movie.setThumbnail(R.drawable.what_do_logo_transparent_no_background);
        mItems.add(movie);

        movie = new Category();
        movie.setName("X-men: Days of Future Past");
        movie.setThumbnail(R.drawable.what_do_logo_transparent_no_background);
        mItems.add(movie);

        movie = new Category();
        movie.setName("The Hunger Game");
        movie.setThumbnail(R.drawable.what_do_logo_transparent_no_background);
        mItems.add(movie);

        movie = new Category();
        movie.setName("Guardians of the Galaxy");
        movie.setThumbnail(R.drawable.what_do_logo_transparent_no_background);
        mItems.add(movie);

        movie = new Category();
        movie.setName("Maleficent");
        movie.setThumbnail(R.drawable.what_do_logo_transparent_no_background);
        mItems.add(movie);

        movie = new Category();
        movie.setName("How to Train Your Dragon 2");
        movie.setThumbnail(R.drawable.what_do_logo_transparent_no_background);
        mItems.add(movie);

        movie = new Category();
        movie.setName("What If");
        movie.setThumbnail(R.drawable.what_do_logo_transparent_no_background);
        mItems.add(movie);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_card, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Category movie = mItems.get(i);
        viewHolder.tvMovie.setText(movie.getName());
        viewHolder.imgThumbnail.setImageResource(movie.getThumbnail());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imgThumbnail;
        public TextView tvMovie;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);
            tvMovie = (TextView)itemView.findViewById(R.id.tv_movie);
        }
    }
}

package me.solacruz.flixster;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import me.solacruz.flixster.Models.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{

    //list of movies
    ArrayList<Movie> movies;

    //initialize with list

    public MovieAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }


    //creates and inflates a new view
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(
                LayoutInflater.from(viewGroup.getContext()).inflate(
                        R.layout.item_movie,
                        viewGroup,
                        false
                )
        );
    }

    //binds an inflated view to a new item
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Movie current = movies.get(i);

        viewHolder.tvTitle.setText(current.getTitle());
        viewHolder.tvOverview.setText(current.getOverview());

        Glide.with(viewHolder.ivPosterImage)
                .load(current.getPosterPath())
                .apply(
                        RequestOptions.fitCenterTransform()
                ).into(viewHolder.ivPosterImage);
    }

    //returns the total number of items in the list
    @Override
    public int getItemCount() {
        return movies.size();
    }

    //create the view holder as a static inner class
    public static class ViewHolder extends RecyclerView.ViewHolder{
        //track view objects
        ImageView ivPosterImage;
        TextView tvTitle;
        TextView tvOverview;

        public ViewHolder(View itemView){
            super(itemView);

            //look up the objects by ID
            ivPosterImage=(ImageView) itemView.findViewById(R.id.ivPosterImage);
            tvOverview=(TextView) itemView.findViewById(R.id.tvOverview);
            tvTitle=(TextView) itemView.findViewById(R.id.tvTitle);
        }
    }
}

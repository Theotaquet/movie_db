package be.helha.projet.model;

import be.helha.projet.model.movie.*;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import be.helha.projet.R;
import be.helha.projet.activity.MenuActivity;


public class MovieCustomAdapter extends RecyclerView.Adapter<MovieCustomAdapter.CustomViewHolder>
{

    private Context context;
    public static List<Movie> movies;

    public static class CustomViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tvTitle;
        private ImageView ivPoster;


        public CustomViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_movie_item_title);
            ivPoster = itemView.findViewById(R.id.iv_movie_item_image);


        }
    }

    public MovieCustomAdapter(Context context, List<Movie> movies)
    {
        this.context = context;
        this.movies = movies;
    }



    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.movie_item,parent,false);
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final Movie m = movies.get(position);
        holder.tvTitle.setText(m.getShowTitle());
        Picasso.with(context).load(m.getPoster()).into(holder.ivPoster);
        holder.ivPoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                MovieDialogFragment movieDialogFragment = new MovieDialogFragment();
                movieDialogFragment.setMovie(m);
                movieDialogFragment.show(((FragmentActivity)context).getSupportFragmentManager(),"tag");


            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

}

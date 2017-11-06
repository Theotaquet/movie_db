package be.helha.projet.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import be.helha.projet.R;
import be.helha.projet.activity.MenuActivity;

public class ActorCustomAdapter extends RecyclerView.Adapter<ActorCustomAdapter.CustomViewHolder>
{
    private Context context;
    private List<Actor> actors;

    public static class CustomViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tvName;
        private ImageView ivPoster;


        public CustomViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_actor_name);
            ivPoster = itemView.findViewById(R.id.iv_actor_image);


        }
    }

    public ActorCustomAdapter(Context context, List<Actor> actors)
    {
        this.context = context;
        this.actors = actors;
    }



    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.actor_item,parent,false);
        return new ActorCustomAdapter.CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final Actor actor = actors.get(position);
        holder.tvName.setText(actor.getName());
        Picasso.with(context).load(actor.getProfilePath()).into(holder.ivPoster);
        holder.ivPoster.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                MovieCustomAdapter movieCustomAdapter = new MovieCustomAdapter(context,actor.getMovies());
                ((MenuActivity)context).getRvMovieList().setAdapter(movieCustomAdapter);

                TVSeriesCustomAdapter TVSeriesCustomAdapter = new TVSeriesCustomAdapter(context,actor.getTVSeries());
                ((MenuActivity)context).getRvTVSeriesList().setAdapter(TVSeriesCustomAdapter);

                ((MenuActivity)context).getRvActorList().setAdapter(null);


            }
        });

    }

    @Override
    public int getItemCount() {
        return actors.size();
    }
}

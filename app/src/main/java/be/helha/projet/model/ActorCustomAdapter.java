package be.helha.projet.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import be.helha.projet.R;

/**
 * Created by Clement on 02-11-17.
 */

public class ActorCustomAdapter extends RecyclerView.Adapter<TVSeriesCustomAdapter.CustomViewHolder>
{
    private Context context;
    public static List<Actor> actors;

    public static class CustomViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tvFirstName;
        private TextView tvName;
        private ImageView ivPoster;


        public CustomViewHolder(View itemView) {
            super(itemView);
            //tvTitle = itemView.findViewById(R.id.tv_tvSeries_item_title);
            ivPoster = itemView.findViewById(R.id.iv_tvSeries_item_image);


        }
    }

    public ActorCustomAdapter(Context context, List<Actor> actors)
    {
        this.context = context;
        this.actors = actors;
    }



    @Override
    public TVSeriesCustomAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.tvseries_item,parent,false);
        return new TVSeriesCustomAdapter.CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TVSeriesCustomAdapter.CustomViewHolder holder, int position) {
        final Actor actor = actors.get(position);
        //holder.tvTitle.setText(tv.getName());
        //Picasso.with(context).load(tv.getPosterPath()).into(holder.ivPoster);

        //holder.ivPoster.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view)
            //{
                //TVSeriesDialogFragment tvSeriesDialogFragment = new TVSeriesDialogFragment();
                //tvSeriesDialogFragment.setTv(tv);
                //movieDialogFragment.show(((FragmentActivity)context).getSupportFragmentManager(),"tag");


           // }
       // });

    }

    @Override
    public int getItemCount() {
        return actors.size();
    }
}

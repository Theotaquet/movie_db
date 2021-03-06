package be.helha.projet.model;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import be.helha.projet.R;


public class TVSeriesCustomAdapter extends RecyclerView.Adapter<TVSeriesCustomAdapter.CustomViewHolder>
{

    private Context context;
    private List<TVSeries> tvSeries;

    public static class CustomViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tvTitle;
        private ImageView ivPoster;


        public CustomViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_tvSeries_item_title);
            ivPoster = itemView.findViewById(R.id.iv_tvSeries_item_image);


        }
    }

    public TVSeriesCustomAdapter(Context context, List<TVSeries> tvSeries)
    {
        this.context = context;
        this.tvSeries = tvSeries;
    }



    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.tvseries_item,parent,false);
        return new CustomViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final TVSeries tv = tvSeries.get(position);
        holder.tvTitle.setText(tv.getName());
        Picasso.with(context).load(tv.getPosterPath()).into(holder.ivPoster);

        holder.ivPoster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                TVSeriesDialogFragment tvSeriesDialogFragment = new TVSeriesDialogFragment();
                tvSeriesDialogFragment.setTvSeries(tv);
                tvSeriesDialogFragment.show(((FragmentActivity)context).getSupportFragmentManager(),"tag");
            }
        });

    }

    @Override
    public int getItemCount() {
        return tvSeries.size();
    }

}

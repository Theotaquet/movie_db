package be.helha.projet.model;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import be.helha.projet.R;

public class TVSeriesDialogFragment extends DialogFragment
{
    private TVSeries tvSeries;

    private WebView wbTitle;
    private RatingBar RbRating;
    private ImageView iv_poster;
    private WebView wbDetails;

    /*->titre
    ->affiche
    ->genre
    ->année début/fin
    ->status (en cours / finie)
    ->nombre d'épisodes
    ->créateur
    ->casting
    ->évaluation*/

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View dialogView = inflater.inflate(R.layout.selected_tvseries_item, null);
        String text;

        wbTitle = dialogView.findViewById(R.id.tv_selected_tvseries_item_title);
        text = "<html><body>"+
                "<p align=\"justify\">"+tvSeries.getName()+"</p>"+
                "</body></html>";

        wbTitle.loadData(text, "text/html", "utf-8");

        RbRating = dialogView.findViewById(R.id.rb_selected_tvseries_item_rating);
        RbRating.setRating((float)(tvSeries.getPopularity()));

        iv_poster = dialogView.findViewById(R.id.iv_selected_tvseries_item_poster);
        Picasso.with(getContext()).load(tvSeries.getPosterPath()).into(iv_poster);

        wbDetails = dialogView.findViewById(R.id.tv_selected_tvseries_item_details);

        String actors = "<table border=\"1\" style =\"border-collapse: collapse;\">";
        actors += ("<th>Actors</th><th>characters</th>");
        for(Actor a : tvSeries.getActors())
        {
            actors += ("<tr><td>"+a.getName()+"</td><td>"+a.getCharacter()+"</td></tr>");
        }
        actors += "</table>";
        String genres = "";
        String creators ="";
        for(String s : tvSeries.getGenres())
        {
            genres += (s+", ");
        }
        if(!genres.equals(""))
        {
            genres = genres.substring(0,genres.length()-2);
        }

        for(String s : tvSeries.getCreators())
        {
            creators += (s+", ");
        }
        if(!creators.equals(""))
        {
            creators = creators.substring(0,creators.length()-2);
        }


        text = "<html><body>"+
                "<p align=\"justify\">"+((tvSeries.getGenres().size()>1)?"Genres : ":"Genre : ")+genres+"</p>"+

                "<p align=\"justify\"> Number of episodes : "+ tvSeries.getNumberOfEpisodes()+"</p>"+
                "<p align=\"justify\">"+"In production : "+((tvSeries.isInProduction())?"yes":"no")+"</p>"+
                "<p align=\"justify\">"+"First air date : "+tvSeries.getFirstAirDate()+"</p>"+
                "<p align=\"justify\">"+"Last air date : "+ tvSeries.getLastAirDate()+"</p>"+
                "<p align=\"justify\">"+tvSeries.getOverview()+"</p>"+
                "<p align=\"justify\">Created by : "+creators+"</p>"+
                actors+
                "</body></html>";
        wbDetails.loadData(text, "text/html", "utf-8");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        builder.setView(dialogView);
        return builder.create();
    }



    public void setTvSeries(TVSeries tv)
    {
        this.tvSeries = tv;
    }




}

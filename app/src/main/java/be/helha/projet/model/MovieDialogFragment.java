package be.helha.projet.model;
import android.os.Bundle;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.FloatProperty;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


import be.helha.projet.R;
import be.helha.projet.activity.MenuActivity;

public class MovieDialogFragment extends DialogFragment
{
    private Movie movie;

    private WebView wbTitle;
    private RatingBar RbRating;
    private ImageView iv_poster;
    private WebView wbDetails;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View dialogView = inflater.inflate(R.layout.selected_movie_item, null);
        String text;

        wbTitle = dialogView.findViewById(R.id.tv_selected_movie_item_title);
        text = "<html><body>"+
                "<p align=\"justify\">"+movie.getTitle()+"</p>"+
                "</body></html>";

        wbTitle.loadData(text, "text/html", "utf-8");

        RbRating = dialogView.findViewById(R.id.rb_selected_movie_item_rating);
        RbRating.setRating((float)(movie.getVoteAverage()));

        iv_poster = dialogView.findViewById(R.id.iv_selected_movie_item_poster);
        Picasso.with(getContext()).load(movie.getPosterPath()).into(iv_poster);

        wbDetails = dialogView.findViewById(R.id.tv_selected_movie_item_details);

        String actors = "<table border=\"1\" style =\"border-collapse: collapse;\">";
        actors += ("<th>Actors</th><th>characters</th>");
        for(Actor a : movie.getActors())
        {
            actors += ("<tr><td>"+a.getName()+"</td><td>"+a.getCharacter()+"</td></tr>");
        }
        actors += "</table>";
        String genres = "";
        for(String s : movie.getGenres())
        {
            genres += (s+", ");
        }
        if(!genres.equals(""))
        {
            genres = genres.substring(0,genres.length()-2);
        }
        text = "<html><body>"+
                "<p align=\"justify\">"+((movie.getGenres().size()>1)?"Genres : ":"Genre : ")+genres+"</p>"+
                "<p align=\"justify\"> Release date : "+movie.getReleaseDate()+"</p>"+
                "<p align=\"justify\"> Duration : "+movie.getRuntime()+" min</p>"+
                "<p align=\"justify\">"+movie.getOverview()+"</p>"+
                "<p align=\"justify\">Director : "+movie.getDirector()+"</p>"+
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




    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }






}

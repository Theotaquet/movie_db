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

    private TextView tvTitle;
    private RatingBar RbRating;
    private ImageView iv_poster;
    private WebView wbSummury;
    private TextView tvGenres;
    private TextView tvDirector;
    private TextView tvReleaseDate;

    /*->titre
->affiche
->genre
->date
->durée
->réalisateur
->casting
->evaluation*/

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View dialogView = inflater.inflate(R.layout.selected_movie_item, null);

        tvTitle = dialogView.findViewById(R.id.tv_selected_movie_item_title);
        tvTitle.setText(movie.getTitle());

        RbRating = dialogView.findViewById(R.id.rb_selected_movie_item_rating);
        RbRating.setRating((float)(movie.getVoteAverage()));

        iv_poster = dialogView.findViewById(R.id.iv_selected_movie_item_poster);
        Picasso.with(getContext()).load(movie.getPosterPath()).into(iv_poster);

        wbSummury = dialogView.findViewById(R.id.tv_selected_movie_item_overview);
        String text;
        text = "<html><body><p align=\"justify\">";
        text+= movie.getOverview();
        text+= "</p></body></html>";
        wbSummury.loadData(text, "text/html", "utf-8");

        tvGenres = dialogView.findViewById(R.id.tv_selected_movie_item_genre);
        String text2 = "Genres : ";
        for(String s : movie.getGenres())
        {
            text2 += (s+" ");
        }
        tvGenres.setText(text2);

        tvReleaseDate = dialogView.findViewById(R.id.tv_selected_movie_item_releaseDate);


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                    }
                })
               .setNegativeButton("Nop", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        builder.setView(dialogView);
        return builder.create();
    }



    public void setMovie(Movie movie)
    {
        this.movie = movie;
    }




}

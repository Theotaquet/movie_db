package be.helha.projet.model;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class TVSeriesDialogFragment extends DialogFragment
{
    private TVSeries tvSeries;

    private TextView tv_title;
    private RatingBar rb_rating;
    private ImageView iv_poster;
    private TextView tv_summury;
    private TextView tv_director;
    private TextView tv_releaseYear;

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
        // Use the Builder class for convenient dialog construction
        /*LayoutInflater inflater = LayoutInflater.from(getActivity());
        View dialogView = inflater.inflate(R.layout.selected_movie_item, null);
        tv_title = dialogView.findViewById(R.id.tv_selected_movie_item_title);
        rb_rating = dialogView.findViewById(R.id.rb_selected_movie_item_rating);
        rb_rating.setRating(Float.parseFloat(movie.getRating()));
        iv_poster = dialogView.findViewById(R.id.iv_selected_movie_item_poster);
        Picasso.with(getContext()).load(movie.getPoster()).into(iv_poster);
        tv_title.setText(movie.getShowTitle());
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());*/
        /*builder.setMessage("Le message s'affiche bien")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                    }
                })
               .setNegativeButton("Nop", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });*/
        // Create the AlertDialog object and return it
        //builder.setView(dialogView);
        return null;
       // return builder.create();
    }



    public void setTvSeries(TVSeries tv)
    {
        this.tvSeries = tvSeries;
    }




}

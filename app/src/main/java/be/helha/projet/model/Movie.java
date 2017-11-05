
package be.helha.projet.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import be.helha.projet.model.Actor;


public class Movie {

    private List<String> genres;
    private int id;
    private String posterPath;
    private String releaseDate;
    private int revenue;
    private int runtime;
    private String overview;
    private String title;
    private List<Actor> actors;
    private double voteAverage;
    private String director;


    /**
     * No args constructor for use in serialization
     * 
     */
    public Movie() {
        genres = new ArrayList<String>();
        actors = new ArrayList<Actor>();

    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }


    public void createMovie(String json)
    {
        try {
            JSONObject obj = new JSONObject(json);
            for(int i = 0;i<obj.getJSONArray("genres").length();i++)
            {
                genres.add((String)obj.getJSONArray("genres").getJSONObject(i).get("name"));
            }
            setId((int)obj.get("id"));
            try {
                if (((String) obj.get("poster_path")).equals("null")) {

                    setPosterPath("https://www.boris-oliviero.com/pics/films/default.jpg");
                }
                else
                {
                    setPosterPath("http://image.tmdb.org/t/p/w500" + (String) obj.get("poster_path"));
                }
            }
            catch(Exception e)
            {
                setPosterPath("https://www.boris-oliviero.com/pics/films/default.jpg");
            }
            try
            {
                setTitle((String)obj.get("title"));
            }
            catch (Exception e)
            {

            }
            try
            {
                setOverview((String)obj.get("overview"));
            }
            catch (Exception e)
            {

            }
            try
            {
                setVoteAverage((Double)obj.get("vote_average")/2);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            try
            {
                setReleaseDate((String)obj.get("release_date"));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

            try
            {
                setRuntime((Integer)obj.get("runtime"));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }






        }
        catch(JSONException e)
        {

        }
    }

    public void setCredits(String json)
    {
        try {
            JSONObject obj = new JSONObject(json);
            JSONArray cast = obj.getJSONArray("cast");
            for(int i = 0;i<cast.length();i++)
            {
                if (!((String)cast.getJSONObject(i).get("character")).contains(("uncredited")))
                {
                    actors.add(new Actor((String) cast.getJSONObject(i).get("name"), (String) cast.getJSONObject(i).get("character")));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public List<Actor> getActors()
    {
        return actors;
    }

}


package be.helha.projet.model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import be.helha.projet.model.Actor;

public class TVSeries {

    private String name;
    private String firstAirDate;
    private String lastAirDate;
    private boolean inProduction;
    private List<String> genres;
    private int id;
    private int numberOfEpisodes;
    private String overview;
    private double popularity;
    private String posterPath;
    private List<String> creators;
    private List<Actor> actors;


    /**
     * No args constructor for use in serialization
     * 
     */
    public TVSeries()
    {
        genres = new ArrayList<String>();
        creators = new ArrayList<String>();
        actors = new ArrayList<Actor>();
    }


    public void createTVSeries(String json)
    {
        try {
            JSONObject obj = new JSONObject(json);
            for(int i = 0;i<obj.getJSONArray("genres").length();i++)
            {
                genres.add((String)obj.getJSONArray("genres").getJSONObject(i).get("name"));
            }
            for(int i = 0;i<obj.getJSONArray("created_by").length();i++)
            {
                creators.add((String)obj.getJSONArray("created_by").getJSONObject(i).get("name"));
            }

            setId((int)obj.get("id"));

            setName((String)obj.get("name"));

            try {
                if (((String) obj.get("poster_path")).equals("null")) {

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
            try {
                setOverview((String) obj.get("overview"));
            }
            catch(Exception e)
            {

            }
            try
            {
                setFirstAirDate((String)obj.get("first_air_date"));
            }
            catch (Exception e)
            {

            }
            try
            {
                setLastAirDate((String)obj.get("last_air_date"));
            }
            catch (Exception e)
            {

            }
            try
            {
                setInProduction((boolean)obj.get("in_production"));
            }
            catch (Exception e)
            {

            }
            try
            {
                setNumberOfEpisodes((int)obj.get("number_of_episodes"));
            }
            catch (Exception e)
            {

            }
            try
            {
                setPopularity((double)obj.get("popularity")/10);
            }
            catch (Exception e)
            {

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
                actors.add(new Actor((String)cast.getJSONObject(i).get("name"),(String)cast.getJSONObject(i).get("character")));
            }
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public String getLastAirDate() {
        return lastAirDate;
    }

    public void setLastAirDate(String lastAirDate) {
        this.lastAirDate = lastAirDate;
    }

    public boolean isInProduction() {
        return inProduction;
    }

    public void setInProduction(boolean inProduction) {
        this.inProduction = inProduction;
    }

    public List<String> getGenres() {
        return genres;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<String> getCreators() {
        return creators;
    }


    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> credits) {
        this.actors = credits;
    }
}

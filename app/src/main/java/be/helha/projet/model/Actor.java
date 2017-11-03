package be.helha.projet.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Clement on 19-10-17.
 */

public class Actor
{
    private String name;
    private String character;
    private String profilePath;
    private int id;


    public Actor()
    {

    }

    public Actor(String name, String character) {
        this.name = name;
        this.character = character;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getProfilePath() {
        return profilePath;
    }

    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void createActor(String json)
    {
        try {
            JSONObject obj = new JSONObject(json);
            setId((int)obj.get("id"));
            try {
                if (((String) obj.get("poster_path")).equals("null")) {

                    setProfilePath("https://www.boris-oliviero.com/pics/films/default.jpg");
                }
                else
                {
                    setProfilePath("http://image.tmdb.org/t/p/w500" + (String) obj.get("profile_path"));
                }
            }
            catch(Exception e)
            {
                setProfilePath("https://www.boris-oliviero.com/pics/films/default.jpg");
            }
            try
            {
                setName((String)obj.get("name"));
            }
            catch (Exception e)
            {

            }
        }
        catch(JSONException e)
        {

        }
    }
}

package be.helha.projet.task;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import be.helha.projet.model.Actor;
import be.helha.projet.model.Movie;
import be.helha.projet.model.TVSeries;


public class ActorAsyncTask extends AsyncTask<String,Void,List<Actor>>
{
    public interface Listener
    {
        void onPreExecuteActorAsyncTask();
        void onPostExecuteActorAsyncTask(List<Actor> actors);
    }

    private Listener listener;
    private List<Actor> actors;

    public List<Actor> getActors()
    {
        return actors;
    }

    public ActorAsyncTask(Listener listener)
    {
        this.listener = listener;
        this.actors = new ArrayList<Actor>();
    }
    @Override
    protected void onPreExecute()
    {
        listener.onPreExecuteActorAsyncTask();
    }

    @Override
    protected List<Actor> doInBackground(String... strings)
    {
        String query = strings[0];
        try
        {
            query.replace(" ", "%20");
            String address = "https://api.themoviedb.org/3/search/person?api_key=cc4b67c52acb514bdf4931f7cedfd12b&query="+query;
            String responseText = makeRequest(address);
            //Log.i("response", responseText);
            JSONObject jsonObject = new JSONObject(responseText);
            //Log.i("length",jsonObject.getJSONArray("results").length()+"");
            JSONArray results = jsonObject.getJSONArray("results");
            int id;
            for (int i = 0; i < results.length(); i++)
            {
                Actor actor = new Actor();

                actor.createActor(results.getJSONObject(i).toString());
                JSONArray knownFor = results.getJSONObject(i).getJSONArray("known_for");

                for(int j = 0; j < knownFor.length(); j++)
                {
                    if(knownFor.getJSONObject(j).get("media_type").equals("tv"))
                    {
                        id = (int)knownFor.getJSONObject(j).get("id");
                        address = "https://api.themoviedb.org/3/tv/"+id+"?api_key=cc4b67c52acb514bdf4931f7cedfd12b";
                        makeRequest(address);
                        TVSeries tv = new TVSeries();
                        tv.createTVSeries(makeRequest(address));
                        address = "https://api.themoviedb.org/3/tv/"+id+"/credits?api_key=cc4b67c52acb514bdf4931f7cedfd12b";
                        tv.setCredits(makeRequest(address));
                        actor.addTVSeries(tv);
                    }
                    else
                    {
                        id = (int)knownFor.getJSONObject(j).get("id");
                        address = "https://api.themoviedb.org/3/movie/"+id+"?api_key=cc4b67c52acb514bdf4931f7cedfd12b";
                        Movie m = new Movie();
                        m.createMovie(makeRequest(address));
                        address = makeRequest("https://api.themoviedb.org/3/movie/" + id + "/credits?api_key=cc4b67c52acb514bdf4931f7cedfd12b");
                        m.setCredits(address);
                        actor.addMovie(m);
                    }

                }
                Log.i("",results.getJSONObject(i).toString());
                this.actors.add(actor);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return actors;
    }

    public String makeRequest(String request)
    {
        String responseText = "";
        try {
            URL url = new URL(request);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(30000);
            connection.connect();
            InputStream response = connection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(response));
            String line;

            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                builder
                        .append(line)
                        .append("\n");
            }
            responseText = builder.toString();
            connection.disconnect();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return responseText;
    }

    @Override
    protected void onPostExecute(List<Actor> actors) {
        listener.onPostExecuteActorAsyncTask(actors);
    }


}

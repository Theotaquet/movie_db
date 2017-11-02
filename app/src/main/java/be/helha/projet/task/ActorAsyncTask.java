package be.helha.projet.task;

import android.os.AsyncTask;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import be.helha.projet.model.Actor;


public class ActorAsyncTask extends AsyncTask<String,Void,List<Actor>>
{
    public interface Listener
    {
        void onPreExecuteMovieAsyncTask();
        void onPostExecuteMovieAsyncTask(List<Actor> actors);
    }

    private Listener listener;
    public List<Actor> actors;

    public ActorAsyncTask(Listener listener)
    {
        this.listener = listener;
        this.actors = new ArrayList<Actor>();
    }
    @Override
    protected void onPreExecute()
    {
        listener.onPreExecuteMovieAsyncTask();
    }

    @Override
    protected List<Actor> doInBackground(String... strings)
    {
        String research = strings[0];
        try
        {
            research.replace(" ","%20");
            //
            String address = "https://api.themoviedb.org/3/search/person?api_key=cc4b67c52acb514bdf4931f7cedfd12b&query="+research;
            URL url = new URL(address);
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
            String responseText = builder.toString();

            try
            {
                if(responseText.charAt(0)!='[')
                {
                    responseText = "["+responseText+"]";
                }
                JSONArray json = new JSONArray(responseText);
                for(int i = 0;i<json.length();i++) {
                    Actor actor = new Actor();
                    actors.add(actor);
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            connection.disconnect();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return actors;
    }

    @Override
    protected void onPostExecute(List<Actor> actors) {
        listener.onPostExecuteMovieAsyncTask(actors);
    }


}

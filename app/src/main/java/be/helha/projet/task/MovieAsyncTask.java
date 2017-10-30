package be.helha.projet.task;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import be.helha.projet.model.Movie;


public class MovieAsyncTask extends AsyncTask<String,Void,List<Movie>>
{
    public interface Listener
     {
        void onPreExecuteMovieAsyncTask();
        void onPostExecuteMovieAsyncTask(List<Movie> movies);
     }

    private Listener listener;
    public List<Movie> movies;

    public MovieAsyncTask(Listener listener)
    {
        this.listener = listener;
        this.movies = new ArrayList<>();
    }
    @Override
    protected void onPreExecute()
    {
        listener.onPreExecuteMovieAsyncTask();
    }

    @Override
    protected List<Movie> doInBackground(String... strings)
    {
        String category = strings[0];
        String research = strings[1];
        try
        {
            research.replace(" ","%20");
            //
            String address = "https://api.themoviedb.org/3/search/"+category+"?api_key=cc4b67c52acb514bdf4931f7cedfd12b&query=the%20simpsons";
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
                   Movie m = new Movie();
                   m.setShowTitle(json.getJSONObject(i).getString("show_title"));
                   m.setSummary(json.getJSONObject(i).getString("summary"));
                   m.setPoster(json.getJSONObject(i).getString("poster").replaceFirst("http","https"));
                   m.setRating(json.getJSONObject(i).getString("rating"));
                   //m.set
                   movies.add(m);
               }

            } catch (Exception e)
            {
                e.printStackTrace();
            }
            connection.disconnect();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return movies;
    }

    @Override
    protected void onPostExecute(List<Movie> movies) {
        listener.onPostExecuteMovieAsyncTask(movies);
    }


}

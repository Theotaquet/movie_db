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

import be.helha.projet.model.Movie;
import be.helha.projet.model.TVSeries;


public class MovieAsyncTask extends AsyncTask<String,Void,List<Movie>>
{
    public interface Listener
     {
        void onPreExecuteMovieAsyncTask();
        void onPostExecuteMovieAsyncTask(List<Movie> movies);
     }

    private Listener listener;
    private List<Movie> movies;

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
        String query = strings[0];
        try {
            query.replace(" ", "%20");
            String address = "https://api.themoviedb.org/3/search/movie?api_key=cc4b67c52acb514bdf4931f7cedfd12b&query="+query;
            String responseText = makeRequest(address);
            //Log.i("response", responseText);
            JSONObject jsonObject = new JSONObject(responseText);
            //Log.i("length",jsonObject.getJSONArray("results").length()+"");
            JSONArray results = jsonObject.getJSONArray("results");
            for (int i = 0; i < results.length(); i++)
            {
                Movie movie = new Movie();
                int id = Integer.parseInt(results.getJSONObject(i).get("id").toString());
                //Log.i("id",id+"");
                address = "https://api.themoviedb.org/3/movie/"+id+"?api_key=cc4b67c52acb514bdf4931f7cedfd12b";
                responseText = makeRequest(address);
                //Log.i("",id+" "+responseText);


                movie.createMovie(responseText);


                this.movies.add(movie);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return movies;
    }

    public List<Movie> getMovies()
    {
        return movies;
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
    protected void onPostExecute(List<Movie> movies) {
        listener.onPostExecuteMovieAsyncTask(movies);
    }


}

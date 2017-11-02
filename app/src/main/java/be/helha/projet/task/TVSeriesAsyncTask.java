package be.helha.projet.task;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import be.helha.projet.model.TVSeries;


public class TVSeriesAsyncTask extends AsyncTask<String,Void,List<TVSeries>>
{
    public interface Listener
    {
        void onPreExecuteTVSeriesAsyncTask();
        void onPostExecuteTVSeriesAsyncTask(List<TVSeries> tvSeries);
    }

    private Listener listener;
    public List<TVSeries> tvSeries;

    public TVSeriesAsyncTask(Listener listener)
    {
        this.listener = listener;
        this.tvSeries = new ArrayList<>();
    }
    @Override
    protected void onPreExecute()
    {
        listener.onPreExecuteTVSeriesAsyncTask();
    }

    @Override
    protected List<TVSeries> doInBackground(String... strings)
    {
        String category = strings[0];
        String query = strings[1];
        try {
            query.replace(" ", "%20");
            String address = "https://api.themoviedb.org/3/search/" + category + "?api_key=cc4b67c52acb514bdf4931f7cedfd12b&query=" + query;
            String responseText = makeRequest(address);
            Log.i("response", responseText);
            JSONObject jsonObject = new JSONObject(responseText);
            Log.i("length",jsonObject.getJSONArray("results").length()+"");

            for (int i = 0; i < jsonObject.getJSONArray("results").length(); i++)
            {
                TVSeries tv = new TVSeries();
                int id = Integer.parseInt(jsonObject.getJSONArray("results").getJSONObject(i).get("id").toString());
                Log.i("id",id+"");
                address = "https://api.themoviedb.org/3/tv/" + id + "?api_key=cc4b67c52acb514bdf4931f7cedfd12b";
                responseText = makeRequest(address);
                tv.createTVSeries(responseText);
                //Log.i()

                //Log.i("tv",tv.getPosterPath());
                //tv.setCredits(responseText);
                this.tvSeries.add(tv);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return tvSeries;
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

        }
        return responseText;
    }

    @Override
    protected void onPostExecute(List<TVSeries> movies) {
        listener.onPostExecuteTVSeriesAsyncTask(movies);
    }

    public List<TVSeries> getTvSeries()
    {
        return tvSeries;
    }


}


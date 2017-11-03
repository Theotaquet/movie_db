package be.helha.projet.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.List;

import be.helha.projet.R;
import be.helha.projet.model.Actor;
import be.helha.projet.model.Movie;
import be.helha.projet.model.TVSeries;
import be.helha.projet.model.TVSeriesCustomAdapter;
import be.helha.projet.task.ActorAsyncTask;
import be.helha.projet.task.MovieAsyncTask;
import be.helha.projet.task.TVSeriesAsyncTask;

public class MenuActivity extends AppCompatActivity implements MovieAsyncTask.Listener, TVSeriesAsyncTask.Listener, ActorAsyncTask.Listener{

    private Button btnTitle;
    private Spinner spinCategory;
    private RecyclerView rvMovieList;
    private RecyclerView rvTVSeriesList;

    private MovieAsyncTask movieAsyncTask;
    private TVSeriesAsyncTask tvSeriesAsyncTask;
    private ActorAsyncTask actorAsyncTask;

    private String category;
    private ImageView ivSearch;
    private ImageView ivConfirm;
    private EditText etSearch;

    private Menu menu;
    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        category = "movie";
        ActionBar ab = getSupportActionBar();
        ab.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ab.setCustomView(R.layout.action_bar);
        etSearch = (EditText)findViewById(R.id.et_action_bar);
        etSearch.setVisibility(View.INVISIBLE);
        ivConfirm = (ImageView)findViewById(R.id.iv_confirm);
        ivSearch = (ImageView)findViewById(R.id.iv_search);
        ivSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etSearch.getVisibility() == View.INVISIBLE)
                {
                    etSearch.setVisibility(View.VISIBLE);
                    /*etSearch.setActivated(true);
                    etSearch.setPressed(true);
                    etSearch.setCursorVisible(true);
                    etSearch.setTextIsSelectable(true);
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);*/
                }
                else {
                    etSearch.setVisibility(View.INVISIBLE);
                }
            }
        });

        rvMovieList = (RecyclerView) findViewById(R.id.rv_main_listMovie);
        rvMovieList.setHasFixedSize(true);
        rvMovieList.setLayoutManager(new LinearLayoutManager(MenuActivity.this));

        rvTVSeriesList = (RecyclerView) findViewById(R.id.rv_main_listTVSeries);
        rvTVSeriesList.setHasFixedSize(true);
        rvTVSeriesList.setLayoutManager(new LinearLayoutManager(MenuActivity.this));

        etSearch = (EditText)findViewById(R.id.et_action_bar);

        btnTitle = (Button)findViewById(R.id.btn_title);
        btnTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("test","test");
                tvSeriesAsyncTask = new TVSeriesAsyncTask(MenuActivity.this);
                tvSeriesAsyncTask.execute("tv",etSearch.getText().toString());
            }
        });


    }



    @Override
    public void onPreExecuteMovieAsyncTask()
    {

    }

    @Override
    public void onPreExecuteActorAsyncTask() {

    }

    @Override
    public void onPostExecuteActorAsyncTask(List<Actor> actors) {
        //test

    }

    @Override
    public void onPostExecuteMovieAsyncTask(List<Movie> movies)
    {


    }

    @Override
    public void onPreExecuteTVSeriesAsyncTask() {

    }

    @Override
    public void onPostExecuteTVSeriesAsyncTask(List<TVSeries> tvSeries) {
        rvTVSeriesList.setAdapter(new TVSeriesCustomAdapter(this,tvSeriesAsyncTask.getTvSeries()));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        this.menu = menu;
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        this.item = item;
        switch (item.getItemId()) {
            case R.id.menu_movie:
                category = "movie";
                return true;
            case R.id.menu_tvseries:
                category = "tvseries";
                return true;
            case R.id.menu_actor:
                category = "actor";
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void launchAsyncTask()
    {
        switch(item.getItemId())
        {
            case R.id.menu_movie:
                movieAsyncTask = new MovieAsyncTask(MenuActivity.this);
                tvSeriesAsyncTask.execute(etSearch.getText().toString());
                break;

            case R.id.menu_tvseries:
                tvSeriesAsyncTask = new TVSeriesAsyncTask(MenuActivity.this);
                tvSeriesAsyncTask.execute(etSearch.getText().toString());
                break;

            case R.id.menu_actor:
                actorAsyncTask = new ActorAsyncTask(MenuActivity.this);
                actorAsyncTask.execute(etSearch.getText().toString());
                break;
        }
    }
}

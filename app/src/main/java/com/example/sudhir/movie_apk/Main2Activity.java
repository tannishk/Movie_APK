package com.example.sudhir.movie_apk;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.sudhir.movie_apk.Movie_Folder.Movie;
import com.example.sudhir.movie_apk.Movie_Folder.Popular_list;
import com.example.sudhir.movie_apk.RecyclerView.MovieAdapter;
import com.example.sudhir.movie_apk.Retrofiles.ApiService;
import com.example.sudhir.movie_apk.Retrofiles.RetroClient;

import java.util.ArrayList;
import java.util.StringTokenizer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {
    RecyclerView recyclerView;
    // ArrayList<String> strings;
    MovieAdapter adapter;
    ArrayList<Movie> movieArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.popularmovie_list);
        //strings = new ArrayList<>();
        movieArrayList = new ArrayList<>();
       // adapter = new MovieAdapter(this,movieArrayList);
       // recyclerView.setAdapter(adapter);
        Intent i = getIntent();
        String year = i.getStringExtra("year");
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        ApiService apiService = RetroClient.getApiService();
        Call<Popular_list> call = apiService.getPopularList(year);
        call.enqueue(new Callback<Popular_list>() {
            @Override
            public void onResponse(Call<Popular_list> call, Response<Popular_list> response) {
                if(response.isSuccessful())
                {
                    Log.d("Result",response.body().toString());
                    movieArrayList = response.body().getResults();
                    Log.d("MovieArrayLIst ",movieArrayList.get(0).getPoster_path());
                    adapter = new MovieAdapter(getApplicationContext(),movieArrayList);
                    adapter.setOnItemClickListener(new MovieAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout)findViewById(R.id.snackbar1_action);
                            Intent i = new Intent();
                            Bundle b = new Bundle();
                            b.putSerializable("movie",movieArrayList.get(position));
                            i.putExtras(b);
                            i.setClass(Main2Activity.this,ScrollingActivity.class);
                            startActivity(i);
                           // String name = movieArrayList.get(position).getOriginal_title();
                          //  Snackbar.make(coordinatorLayout,name,Snackbar.LENGTH_LONG).show();
                        }
                    });
                    recyclerView.setAdapter(adapter);
                    //adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Popular_list> call, Throwable t) {
                Log.i("Faileure","Failure  ");
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}

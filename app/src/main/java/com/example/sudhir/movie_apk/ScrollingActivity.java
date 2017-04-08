package com.example.sudhir.movie_apk;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sudhir.movie_apk.Movie_Folder.Movie;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class ScrollingActivity extends AppCompatActivity {

    TextView tv,tv2,tv3,tv4,tv5;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent i = getIntent();
        Bundle b = i.getExtras();
        Movie m = (Movie) b.getSerializable("movie");
        setTitle(m.getOriginal_title());
        tv = (TextView) findViewById(R.id.movie_title);
        tv.setText(m.getOriginal_title());
        tv2 = (TextView) findViewById(R.id.movie_overview);
        tv2.setText(m.getOverview());
        tv3 = (TextView) findViewById(R.id.movie_release_date);
        tv3.setText(m.getRelease_date());
        tv4 = (TextView) findViewById(R.id.movie_popularity);
        tv4.setText(String.valueOf(m.getPopularity()));
        tv5 = (TextView) findViewById(R.id.movie_vote_average);
        tv5.setText(String.valueOf(m.getVote_average()));
        iv = (ImageView) findViewById(R.id.movie_Scroll_image);
        String url = "http://image.tmdb.org/t/p/w185/"+m.getPoster_path();
        Picasso.with(this)
                .load(url)
                .into(iv);

        //Toolbar tl = (Toolbar) findViewById(R.id.toolbar_layout);
       // tl.setTitle(m.getOriginal_title());
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

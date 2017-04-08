package com.example.sudhir.movie_apk.Movie_Folder;

import android.graphics.Movie;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
//import com.example.sudhir.movie_apk.Movie_Folder.Movie;

import java.util.ArrayList;

/**
 * Created by sudhir on 25/03/17.
 */

public class Popular_list {
    @SerializedName("results")
    ArrayList<com.example.sudhir.movie_apk.Movie_Folder.Movie> results = new ArrayList<>();

    public ArrayList<com.example.sudhir.movie_apk.Movie_Folder.Movie> getResults() {
        return results;
    }

    public void setResults(ArrayList<com.example.sudhir.movie_apk.Movie_Folder.Movie> movies) {
        this.results = movies;
    }
}

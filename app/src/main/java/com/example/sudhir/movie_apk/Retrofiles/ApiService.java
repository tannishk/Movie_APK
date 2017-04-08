package com.example.sudhir.movie_apk.Retrofiles;

import com.example.sudhir.movie_apk.Movie_Folder.Popular_list;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by sudhir on 25/03/17.
 */

public interface ApiService {
    @GET("discover/movie?certification_country=US&api_key=15957831591d00b2cc3963a9c2218870")
    Call<Popular_list> getPopularList(@Query("primary_release_year") String year);
}

package com.example.sudhir.movie_apk.Retrofiles;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sudhir on 25/03/17.
 */

public class RetroClient {
    private static final String ROOT_URL = "https://api.themoviedb.org/3/";
    static Retrofit retrofit = null;
    public static Retrofit getRetrofitInstance()
    {
        if(retrofit == null){
        retrofit =  new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();}
        return retrofit;
    }
    public static ApiService getApiService(){
        return  getRetrofitInstance().create(ApiService.class);
    }
}

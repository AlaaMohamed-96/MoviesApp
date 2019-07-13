package com.example.moviesapp.APIs;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIManager {
    private static Retrofit retrofit;

    public static Retrofit getInstance(){
        if(retrofit==null){
            retrofit =new Retrofit.Builder()
                    .baseUrl("https://api.themoviedb.org/3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static WebServece getApis(){
        return  getInstance().create(WebServece.class);
    }
}

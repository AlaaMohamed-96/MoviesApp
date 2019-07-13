package com.example.moviesapp.APIs;

import com.example.moviesapp.APIs.model.MoveisResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WebServece {

    @GET("movie/top_rated")
    Call <MoveisResponse> getMovies(@Query("api_key") String apikey , @Query("language") String language ,
                                    @Query("page") int page );
}

package com.example.moviesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.moviesapp.APIs.APIManager;
import com.example.moviesapp.APIs.model.MoveisResponse;
import com.example.moviesapp.APIs.model.ResultsItem;
import com.example.moviesapp.Adapter.MoviesRecyclerAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<ResultsItem> movies;
    MoviesRecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        initRecyclerView();
        loadMovies();
    }

    public void initRecyclerView(){
        adapter = new MoviesRecyclerAdapter(null);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void loadMovies() {
        APIManager.getApis().getMovies("eb85bd817cd23bd00374f5edd14d7c18" , "en-US" ,1 )
                .enqueue(new Callback<MoveisResponse>() {
                    @Override
                    public void onResponse(Call<MoveisResponse> call, Response<MoveisResponse> response) {
                      List<ResultsItem> resultsItems =response.body().getResults();

                   Log.d("testtest", String.valueOf(resultsItems.get(0).getPosterPath()))   ;

                   adapter.changeData(resultsItems);

                    }

                    @Override
                    public void onFailure(Call<MoveisResponse> call, Throwable t) {
                        Log.d("testtest",t.getMessage().toString())   ;
                    }
                });
    }


}

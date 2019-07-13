package com.example.moviesapp.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.moviesapp.APIs.model.ResultsItem;
import com.example.moviesapp.R;


import java.util.List;


public class MoviesRecyclerAdapter extends RecyclerView.Adapter<MoviesRecyclerAdapter.ViewHolder> {

    List<ResultsItem> movies;

    public MoviesRecyclerAdapter(List<ResultsItem> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
      View view=  LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_movie_view,viewGroup,false);
      return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        ResultsItem movie= movies.get(position);
        viewHolder.movieTitle.setText(movie.getTitle());
        viewHolder.movieVote.setText(String.valueOf(movie.getVoteAverage()));
        Glide.with(viewHolder.itemView)
                .load("https://image.tmdb.org/t/p/w185_and_h278_bestv2"+movie.getPosterPath())
                .into(viewHolder.movieImage);


//        if(onPlayClickListener!=null){
//            viewHolder.play.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    onPlayClickListener.onItemClick(position,channel);
//                }
//            });
//        }
////        if(onStopClickListener!=null){
////            viewHolder.stop.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////                    onStopClickListener.onItemClick(position,channel);
////                }
////            });
////        }
    }

   public void changeData(List<ResultsItem> movies){
        this.movies=movies;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if(movies==null)return 0;
        return movies.size();
    }

//    public interface OnItemClickListener{
//        void onItemClick(int pos, RadiosItem radiosItem);
//    }
    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView movieImage;
        TextView movieTitle;
        TextView movieVote;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.movie_image);
            movieTitle = itemView.findViewById(R.id.movie_title);
            movieVote = itemView.findViewById(R.id.vote);
        }
    }
}

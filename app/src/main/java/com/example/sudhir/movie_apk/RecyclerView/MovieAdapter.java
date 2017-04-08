package com.example.sudhir.movie_apk.RecyclerView;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sudhir.movie_apk.Movie_Folder.Movie;
import com.example.sudhir.movie_apk.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by sudhir on 27/03/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private ArrayList<Movie> mMovies;
    private Context mContext;
    private OnItemClickListener listener;
    public MovieAdapter(Context context,ArrayList<Movie> movies)
    {
        mMovies = movies;
        mContext = context;
    }
    private Context getmContext(){
        return mContext;
    }
    public interface OnItemClickListener {
        void onItemClick(View view,int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;
        private Context context;
        public ViewHolder(final View itemView){
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.movie_title);
            imageView = (ImageView) itemView.findViewById(R.id.movie_image);
           // this.context = context;
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if(listener!=null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION)
                        {
                            listener.onItemClick(itemView,position);
                        }
                    }
                }
            });
        }
//
//        @Override
//        public void onClick(View view) {
//            int position = getAdapterPosition();
//            Movie m = mMovies.get(position);
//            Snackbar snackbar = Snackbar.make(view,m.getOriginal_title(),Snackbar.LENGTH_LONG);
//            snackbar.show();
//        }
    }

    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View moviewView = inflater.inflate(R.layout.row,parent,false);
        ViewHolder viewHolder = new ViewHolder(moviewView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MovieAdapter.ViewHolder holder, int position) {
        Movie movie = mMovies.get(position);

        TextView textView = holder.textView;
        textView.setText(movie.getOriginal_title());
        ImageView imageView = holder.imageView;
        String url = "http://image.tmdb.org/t/p/w185/"+movie.getPoster_path();
        Picasso.with(mContext)
                .load(url)
                .into(imageView);

    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }
}

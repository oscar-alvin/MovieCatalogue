package dicoding.com.moviecatalogue.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;
import dicoding.com.moviecatalogue.APIHelper.ApiClient;
import dicoding.com.moviecatalogue.R;
import dicoding.com.moviecatalogue.model.TrendingMovie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private Context context;
    private List<TrendingMovie> trendingMovies;

    private onMovieItemClick onMovieItemClick;

    public void setOnItemClickCallback(onMovieItemClick onMovieItemClick) {
        this.onMovieItemClick = onMovieItemClick;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mtitle, mrelease, moverview, muserScore;
        public AppCompatImageView imgMovie;
        public AppCompatRatingBar ratingMov;
        public ProgressBar progressBar;

        public MyViewHolder(View view) {
            super(view);
            mtitle     = view.findViewById(R.id.ltv_title);
            mrelease   = view.findViewById(R.id.ltv_release);
            moverview  = view.findViewById(R.id.ltv_overview);
            imgMovie   = view.findViewById(R.id.liv_Movie);
            ratingMov  = view.findViewById(R.id.ratingBar);
            muserScore = view.findViewById(R.id.tv_userscore);
            progressBar= view.findViewById(R.id.progressBarIV);
        }
    }

    public MovieAdapter(Context c, List<TrendingMovie> trendingMovieList){
        this.context = c;
        this.trendingMovies = trendingMovieList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final TrendingMovie trendingMovie = trendingMovies.get(holder.getAdapterPosition());
        holder.mtitle.setText(trendingMovie.getTitleMovie());
        holder.mrelease.setText(trendingMovie.getReleaseMovie());
        holder.moverview.setText(trendingMovie.getDetailMovie().equals("")
                ? "Detail Untuk Bahasa Ini Tidak Tersedia":trendingMovie.getDetailMovie());
        holder.ratingMov.setRating(trendingMovie.getPoint());
        holder.muserScore.setText(String.valueOf(trendingMovie.getPoint()) );
        Glide.with(context).load(ApiClient.PosterUrl + trendingMovie.getPosterMovie())
                .error(R.drawable.ic_error_photo_24dp)
                .addListener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .fitCenter().into(holder.imgMovie);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMovieItemClick.onItemClick(trendingMovie.getIdMovie());
            }
        });
    }

    @Override
    public int getItemCount() {
        return trendingMovies.size();
    }

    public interface onMovieItemClick {
        void onItemClick(int idmoviedb);
    }
}

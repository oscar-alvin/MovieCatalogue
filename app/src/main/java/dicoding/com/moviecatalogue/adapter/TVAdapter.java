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
import dicoding.com.moviecatalogue.model.TrendingTV;

public class TVAdapter extends RecyclerView.Adapter<TVAdapter.MyViewHolder> {
    private Context context;
    private List<TrendingTV> tvies;

    private onMovieItemClick onMovieItemClick;

    public void setOnItemClickCallback(onMovieItemClick onMovieItemClick) {
        this.onMovieItemClick = onMovieItemClick;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvtitle, tvrelease, tvoverview, muserScore;
        public AppCompatImageView imgTV;
        public AppCompatRatingBar ratingMov;
        public ProgressBar progressBar;

        public MyViewHolder(View view) {
            super(view);
            tvtitle = view.findViewById(R.id.ltv_title);
            tvrelease = view.findViewById(R.id.ltv_release);
            tvoverview = view.findViewById(R.id.ltv_overview);
            imgTV = view.findViewById(R.id.liv_Movie);
            ratingMov = view.findViewById(R.id.ratingBar);
            muserScore = view.findViewById(R.id.tv_userscore);
            progressBar= view.findViewById(R.id.progressBarIV);
        }
    }

    public TVAdapter(Context c, List<TrendingTV> trendingTvList){
        this.context = c;
        this.tvies = trendingTvList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final TrendingTV trendingTv = tvies.get(holder.getAdapterPosition());

        holder.tvtitle.setText(trendingTv.getTitleTV());
        holder.tvrelease.setText(trendingTv.getFirstAirTV());
        holder.tvoverview.setText(trendingTv.getDetailTV().equals("")
        ? "Detail Untuk Bahasa Ini Tidak Tersedia" : trendingTv.getDetailTV());
        holder.ratingMov.setRating(trendingTv.getPoint());
        holder.muserScore.setText(String.valueOf(trendingTv.getPoint()) );
        Glide.with(context).load(ApiClient.PosterUrl + trendingTv.getPosterTV())
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
                }).fitCenter().into(holder.imgTV);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMovieItemClick.onItemClick(trendingTv.getIdTV());
            }
        });
    }

    @Override
    public int getItemCount() {
        return tvies.size();
    }

    public interface onMovieItemClick {
        void onItemClick(int idtv);
    }
}

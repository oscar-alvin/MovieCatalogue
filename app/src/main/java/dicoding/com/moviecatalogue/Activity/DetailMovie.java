package dicoding.com.moviecatalogue.Activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dicoding.com.moviecatalogue.APIHelper.ApiClient;
import dicoding.com.moviecatalogue.APIHelper.ApiInterface;
import dicoding.com.moviecatalogue.APIHelper.HelperMovieDB;
import dicoding.com.moviecatalogue.R;
import dicoding.com.moviecatalogue.adapter.ArtistAdapter;
import dicoding.com.moviecatalogue.model.Artis;
import dicoding.com.moviecatalogue.model.GetArtis;
import dicoding.com.moviecatalogue.model.Movie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailMovie extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ImageView posterMovie;
    private TextView tahun, genre, durasi, release, sinopsis, point;
    private ProgressBar progressBar;
    private Button btnmoreArt;
    private RecyclerView recyclerView;
//    ArtistAdapter artisAdapter;
//    ApiInterface mApiInterface;
    private DetailMovieModel detailMovieModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailmovie);

        Toolbar toolbar = findViewById(R.id.toolbarMov);
        setSupportActionBar(toolbar);

        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.white));

        final int idmovie = getIntent().getIntExtra("extra_idmovie", 0);

        detailMovieModel = ViewModelProviders.of(this).get(DetailMovieModel.class);
        detailMovieModel.getMovie(idmovie).observe(this, getMovieOb);
        detailMovieModel.getListCast(idmovie).observe(this, getListArtis);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        tahun        = findViewById(R.id.tv_tahun);
        posterMovie  = findViewById(R.id.iv_posterMov);
        genre        = findViewById(R.id.tv_genre);
        durasi       = findViewById(R.id.tv_durasi);
        release      = findViewById(R.id.tv_release);
        sinopsis     = findViewById(R.id.tv_ketm);
        point        = findViewById(R.id.tv_point) ;
        btnmoreArt   = findViewById(R.id.btn_moreart);
        recyclerView = findViewById(R.id.recycler_artis);
        progressBar  = findViewById(R.id.progressBarDetailMov);
    }

    private Observer<Movie> getMovieOb = new Observer<Movie>() {
        @Override
        public void onChanged(Movie movie) {
            if(movie != null) {
                setDataMovie(movie);
            } else {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), getString(R.string.status_fail), Toast.LENGTH_SHORT).show();
            }
        }

    };

    private Observer<List<Artis>> getListArtis = new Observer<List<Artis>>() {
        @Override
        public void onChanged(List<Artis> artis) {
            if(artis.size()>0){
                RecyclerView.LayoutManager manager = new LinearLayoutManager(DetailMovie.this,
                        LinearLayoutManager.HORIZONTAL, false);
                recyclerView.setLayoutManager(manager);
                ArtistAdapter artisAdapter = new ArtistAdapter(DetailMovie.this, artis);
                recyclerView.setAdapter(artisAdapter);
            }
        }
    };

    void setDataMovie(Movie movie){
        collapsingToolbarLayout.setTitle(movie.getTitleMovie());
        genre.setText("");
        genre.setText(HelperMovieDB.List2String(movie.getGenreMovie()));
        durasi.setText(HelperMovieDB.convertDuration2String(this, movie.getDurasiMovie()));
        release.setText(movie.getReleaseMovie());
        Glide.with(this).load(ApiClient.BackDropUrl + movie.getBackdropMovie())
                .error(R.drawable.ic_error_photo_24dp)
                .addListener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                }).into(posterMovie);
        sinopsis.setText(movie.getDetailMovie().equals("") ? "Detail Untuk Bahasa Ini Tidak Tersedia":movie.getDetailMovie());
        tahun.setText(movie.getReleaseMovie().substring(0, 4));
        point.setText(String.valueOf((int)movie.getPopularity()) );

        btnmoreArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moreArt = new Intent(Intent.ACTION_VIEW);
                moreArt.setData(Uri.parse("https://www.themoviedb.org/search?query=" + collapsingToolbarLayout.getTitle() + "&language=en-US"));
                startActivity(moreArt);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

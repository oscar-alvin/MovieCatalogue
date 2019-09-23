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
import dicoding.com.moviecatalogue.model.TVShow;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailTV extends AppCompatActivity {
    private ImageView posterTV;
    private TextView seasons, genre, durasi, firstAir, sinopsis, point;
    private Button btnmoreArt;
    private ProgressBar progressBar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private RecyclerView recyclerView;
    private DetailTVModel detailTVModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_tv);
		
		Toolbar toolbar = findViewById(R.id.toolbarTV);
        setSupportActionBar(toolbar);
		
		collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.white));

        final int id = getIntent().getIntExtra("extra_idtv", 0);
        detailTVModel = ViewModelProviders.of(this).get(DetailTVModel.class);
        detailTVModel.getTVShow(id).observe(this, getTVshowOb);
        detailTVModel.getListCast(id).observe(this, getListArtis);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        posterTV = findViewById(R.id.iv_posterTV);
        seasons = findViewById(R.id.tv_seasonsTV);
        genre = findViewById(R.id.tv_genreTV);
        durasi = findViewById(R.id.tv_durasiTV);
        firstAir = findViewById(R.id.tv_firstAirTV);
        sinopsis = findViewById(R.id.tv_ketmTV);
        point = findViewById(R.id.tv_pointTV);
        btnmoreArt = findViewById(R.id.btn_moreartTV);
        recyclerView = findViewById(R.id.recycler_artisTV);
        progressBar  = findViewById(R.id.progressBarTV);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
    }

    private Observer<TVShow> getTVshowOb = new Observer<TVShow>() {
        @Override
        public void onChanged(TVShow tvShow) {
            if(tvShow != null) {
                setDataTV(tvShow);
            }else {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), getString(R.string.status_fail), Toast.LENGTH_SHORT).show();
            }
        }
    };

    private Observer<List<Artis>> getListArtis = new Observer<List<Artis>>() {
        @Override
        public void onChanged(List<Artis> artis) {
            if(artis.size()>0){
                RecyclerView.LayoutManager manager = new LinearLayoutManager(DetailTV.this,
                        LinearLayoutManager.HORIZONTAL, false);
                recyclerView.setLayoutManager(manager);
                ArtistAdapter artisAdapter = new ArtistAdapter(DetailTV.this, artis);
                recyclerView.setAdapter(artisAdapter);
            }
        }
    };

    void setDataTV(TVShow tvShow) {
        collapsingToolbarLayout.setTitle(tvShow.getTitleTV());
        Glide.with(this).load(ApiClient.BackDropUrl + tvShow.getBackDropTV())
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
                }).into(posterTV);
        genre.setText  ("");
        genre.setText(HelperMovieDB.List2String(tvShow.getGenreTV()));
        durasi.setText (HelperMovieDB.convertDuration2String(this, tvShow.getDurasiTV().get(0))) ;
        firstAir.setText(tvShow.getFirstAirDate());
        sinopsis.setText(tvShow.getDetailTV().equals("")? "Detail Untuk Bahasa Ini Tidak Tersedia" : tvShow.getDetailTV());
        seasons.setText(String.valueOf(tvShow.getNumberSeasons()) );
        point.setText(String.valueOf((int)tvShow.getPoint()) );

        btnmoreArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moreArt = new Intent(Intent.ACTION_VIEW);
                moreArt.setData(Uri.parse("https://www.themoviedb.org/search?query="+ collapsingToolbarLayout.getTitle()+"&language=en-US"));
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

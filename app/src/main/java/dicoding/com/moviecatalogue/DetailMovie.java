package dicoding.com.moviecatalogue;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import dicoding.com.moviecatalogue.adapter.artistAdapter;
import dicoding.com.moviecatalogue.model.movie;

public class DetailMovie extends AppCompatActivity {
    private ImageView posterMovie;
    private TextView tahun, genre, durasi, release, sinopsis, point;
    private Button btnmoreArt;
    private RecyclerView recyclerView;
    private artistAdapter artisAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailmovie);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setCollapsedTitleTextColor(
                ContextCompat.getColor(this, R.color.white));
        collapsingToolbarLayout.setExpandedTitleColor(
                ContextCompat.getColor(this, R.color.white));

        final movie mdata = (movie)getIntent().getParcelableExtra("extra_movie");
        collapsingToolbarLayout.setTitle(mdata.getTitleMovie());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tahun = (TextView)findViewById(R.id.tv_tahun);
        posterMovie = (ImageView)findViewById(R.id.iv_poster);
        genre = (TextView)findViewById(R.id.tv_genre);
        durasi = (TextView)findViewById(R.id.tv_durasi);
        release = (TextView)findViewById(R.id.tv_release);
        sinopsis = (TextView)findViewById(R.id.tv_ketm);
        point = (TextView)findViewById(R.id.tv_point) ;
        btnmoreArt = (Button)findViewById(R.id.btn_moreart);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_artis);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(manager);
        artisAdapter = new artistAdapter(this, mdata.getArtisName(), mdata.getArtisPhoto());
        recyclerView.setAdapter(artisAdapter);

        genre.setText  ("Genres  : "+mdata.getGenreMovie());
        durasi.setText ("Runtime : "+(int)mdata.getDurasiMovie()/60+"h "+mdata.getDurasiMovie()%60+"m");
        release.setText("Release : "+mdata.getReleaseMovie());
        Glide.with(this).load(mdata.getPosterMovie()).into(posterMovie);
        sinopsis.setText(mdata.getDetailMovie());
        tahun.setText("Year : "+mdata.getTahunMovie());
        point.setText("Score : "+mdata.getPoint());

        btnmoreArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moreArt = new Intent(Intent.ACTION_VIEW);
                moreArt.setData(Uri.parse("https://www.themoviedb.org/search?query="+ mdata.getTitleMovie()+"&language=en-US"));
                startActivity(moreArt);
            }
        });

    }
}

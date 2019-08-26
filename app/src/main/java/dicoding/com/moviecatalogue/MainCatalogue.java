package dicoding.com.moviecatalogue;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import dicoding.com.moviecatalogue.adapter.movieAdapter;
import dicoding.com.moviecatalogue.model.movie;

public class MainCatalogue extends AppCompatActivity {
    ListView listView;
    movieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_catalogue);

        listView  = (ListView)findViewById(R.id.list_movie);

        movieAdapter = new movieAdapter(this);
        movieAdapter.setMovies(new InitMovie().getAll());

        listView.setAdapter(movieAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                movie m = (movie) movieAdapter.getItem(position);
                Intent detMovie = new Intent(getApplicationContext(), DetailMovie.class);
                detMovie.putExtra("extra_movie", m);
                startActivity(detMovie);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_about :
                startActivity(new Intent(MainCatalogue.this, About.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

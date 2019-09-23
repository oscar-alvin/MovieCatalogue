package dicoding.com.moviecatalogue.fragment;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dicoding.com.moviecatalogue.Activity.DetailMovie;
import dicoding.com.moviecatalogue.R;
import dicoding.com.moviecatalogue.adapter.MovieAdapter;
import dicoding.com.moviecatalogue.model.TrendingMovie;

public class FragmentMovie extends Fragment {
    private RecyclerView recyclerMovie;
    private MovieAdapter movieAdapter;
    private ProgressBar progressBar;
    private FragmentMovieModel fragmentMovieModel;
    private ImageButton reload;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressBar    = view.findViewById(R.id.progressBarRVMovie);
        recyclerMovie  = view.findViewById(R.id.list_movie);
        reload         = view.findViewById(R.id.imgBtn_reloadMov);

        fragmentMovieModel = ViewModelProviders.of(this).get(FragmentMovieModel.class);
        feedData();

        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feedData();
            }
        });
    }

    private void feedData(){
        fragmentMovieModel.getTM().observe(this, new Observer<List<TrendingMovie>>() {
            @Override
            public void onChanged(List<TrendingMovie> trendingMovieList) {
                reload.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);
                if (trendingMovieList != null) {
                    RecyclerView.LayoutManager mlayourManager = new LinearLayoutManager(getActivity().getApplicationContext());
                    recyclerMovie.setLayoutManager(mlayourManager);
                    movieAdapter = new MovieAdapter(getActivity(), trendingMovieList);
                    recyclerMovie.setAdapter(movieAdapter);
                    progressBar.setVisibility(View.GONE);

                    movieAdapter.setOnItemClickCallback(new MovieAdapter.onMovieItemClick() {
                        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                        @Override
                        public void onItemClick(int idmoviedb) {
                            Intent detMovie = new Intent(getActivity(), DetailMovie.class);
                            detMovie.putExtra("extra_idmovie", idmoviedb);
                            getActivity().startActivity(detMovie, ActivityOptions.makeSceneTransitionAnimation(getActivity()).toBundle());
                        }
                    });
                }else {
                    progressBar.setVisibility(View.GONE);
                    reload.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), getString(R.string.status_fail), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

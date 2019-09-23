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
import dicoding.com.moviecatalogue.Activity.DetailTV;
import dicoding.com.moviecatalogue.R;
import dicoding.com.moviecatalogue.adapter.TVAdapter;
import dicoding.com.moviecatalogue.model.TrendingTV;

public class FragmentTV extends Fragment {
    private RecyclerView recyclerTV;
    private TVAdapter tvAdapter;
    private ProgressBar progressBar;
    private ImageButton reload;
    private FragmentTVModel fragmentTVModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = view.findViewById(R.id.progressBarRVTV);
        recyclerTV  = view.findViewById(R.id.list_tv);
        reload      = view.findViewById(R.id.imgBtn_reloadTV);

        fragmentTVModel = ViewModelProviders.of(this).get(FragmentTVModel.class);
        feedData();

        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feedData();
            }
        });
    }

    void feedData(){
        fragmentTVModel.getTT().observe(this, new Observer<List<TrendingTV>>() {
            @Override
            public void onChanged(List<TrendingTV> trendingTVS) {
                reload.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);
                if (trendingTVS != null) {
                    RecyclerView.LayoutManager mlayourManager = new LinearLayoutManager(getActivity().getApplicationContext());
                    recyclerTV.setLayoutManager(mlayourManager);
                    tvAdapter = new TVAdapter(getActivity(), trendingTVS);
                    recyclerTV.setAdapter(tvAdapter);
                    progressBar.setVisibility(View.GONE);

                    tvAdapter.setOnItemClickCallback(new TVAdapter.onMovieItemClick() {
                        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                        @Override
                        public void onItemClick(int idtv) {
                            Intent detMovie = new Intent(getActivity(), DetailTV.class);
                            detMovie.putExtra("extra_idtv", idtv);
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

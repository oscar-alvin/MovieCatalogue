package dicoding.com.moviecatalogue.fragment;

import android.util.Log;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dicoding.com.moviecatalogue.APIHelper.ApiClient;
import dicoding.com.moviecatalogue.APIHelper.ApiInterface;
import dicoding.com.moviecatalogue.model.GetTrendingMovie;
import dicoding.com.moviecatalogue.model.TrendingMovie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FragmentMovieModel extends ViewModel {
    private MutableLiveData<List<TrendingMovie>> mutableMovie;

    public LiveData<List<TrendingMovie>> getTM(){
        if(mutableMovie == null) {
            mutableMovie = new MutableLiveData<>();
            LoadTrending();
        }else if(mutableMovie.getValue() == null){
            LoadTrending();
        }
        return mutableMovie;
    }

    void LoadTrending() {
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface mApiInterface = retrofit.create(ApiInterface.class);
        Call<GetTrendingMovie> TrendingCall = mApiInterface.getTrending("trending","movie",
                "week",ApiClient.MyApi);
        TrendingCall.enqueue(new Callback<GetTrendingMovie>() {
            @Override
            public void onResponse(Call<GetTrendingMovie> call, Response<GetTrendingMovie>
                    response) {
                if(response.isSuccessful()) {
                    mutableMovie.setValue(response.body().getListTrendingMovies());
                }
            }

            @Override
            public void onFailure(Call<GetTrendingMovie> call, Throwable t) {
                Log.e("Retrofit Fail", t.getMessage());
                mutableMovie.setValue(null);
            }
        });
    }
}

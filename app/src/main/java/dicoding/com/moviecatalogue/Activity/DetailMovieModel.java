package dicoding.com.moviecatalogue.Activity;

import android.util.Log;

import java.util.List;
import java.util.Locale;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dicoding.com.moviecatalogue.APIHelper.ApiClient;
import dicoding.com.moviecatalogue.APIHelper.ApiInterface;
import dicoding.com.moviecatalogue.model.Artis;
import dicoding.com.moviecatalogue.model.GetArtis;
import dicoding.com.moviecatalogue.model.Movie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailMovieModel extends ViewModel {
    private MutableLiveData<Movie> mutableMov;
    private MutableLiveData<List<Artis>> mutableCast;

    public LiveData<Movie> getMovie(int id){
        if(mutableMov == null){
            mutableMov = new MutableLiveData<>();
            GetDetailsByID(id);
        }
        return mutableMov;
    }

    public LiveData<List<Artis>> getListCast(int id){
        if(mutableCast == null){
            mutableCast = new MutableLiveData<>();
            LoadCast(id);
        }
        return mutableCast;
    }

    void GetDetailsByID(int id) {
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface mApiInterface = retrofit.create(ApiInterface.class);
        Call<Movie> MovieCall = mApiInterface.getDetailsMov("movie", id, ApiClient.MyApi, Locale.getDefault());
        MovieCall.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if(response.isSuccessful()) {
                    mutableMov.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Log.e("Retrofit Fail", t.getMessage());
                mutableMov.setValue(null);
            }
        });
    }

    void LoadCast(final int idmov) {
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface mApiInterface = retrofit.create(ApiInterface.class);
        Call<GetArtis> ArtCall = mApiInterface.getArtis("movie",idmov, ApiClient.MyApi);
        ArtCall.enqueue(new Callback<GetArtis>() {
            @Override
            public void onResponse(Call<GetArtis> call, Response<GetArtis>
                    response) {
                if(response.isSuccessful()) {
                    mutableCast.setValue(response.body().getListDataArtis());
                }
            }

            @Override
            public void onFailure(Call<GetArtis> call, Throwable t) {
                Log.e("Retrofit Fail Get", t.toString());
                mutableCast.setValue(null);
            }
        });
    }
}

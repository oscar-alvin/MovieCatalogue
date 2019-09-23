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
import dicoding.com.moviecatalogue.model.TVShow;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailTVModel extends ViewModel {
    private MutableLiveData<TVShow> mutableTV;
    private MutableLiveData<List<Artis>> mutableCast;

    public MutableLiveData<TVShow> getTVShow(int id){
        if(mutableTV == null){
            mutableTV = new MutableLiveData<>();
            GetDetailsByID(id);
        }
        return mutableTV;
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
        Call<TVShow> MovieCall = mApiInterface.getDetailsTV("tv", id, ApiClient.MyApi, Locale.getDefault());
        MovieCall.enqueue(new Callback<TVShow>() {
            @Override
            public void onResponse(Call<TVShow> call, Response<TVShow> response) {
                if(response.isSuccessful()) {
                    mutableTV.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<TVShow> call, Throwable t) {
                Log.e("Retrofit Fail", t.getMessage());
                mutableTV.setValue(null);
            }
        });
    }

    void LoadCast(final int idmov) {
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface mApiInterface = retrofit.create(ApiInterface.class);
        Call<GetArtis> ArtCall = mApiInterface.getArtis("tv", idmov, ApiClient.MyApi);
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
                Log.e("Retrofit Get", t.toString());
                mutableCast.setValue(null);
            }
        });
    }
}

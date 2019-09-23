package dicoding.com.moviecatalogue.fragment;

import android.util.Log;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dicoding.com.moviecatalogue.APIHelper.ApiClient;
import dicoding.com.moviecatalogue.APIHelper.ApiInterface;
import dicoding.com.moviecatalogue.model.GetTrendingTV;
import dicoding.com.moviecatalogue.model.TrendingTV;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FragmentTVModel extends ViewModel {
    private MutableLiveData<List<TrendingTV>> mutableTV;

    public LiveData<List<TrendingTV>> getTT(){
        if(mutableTV == null) {
            mutableTV = new MutableLiveData<>();
            LoadTrending();
        }else if(mutableTV.getValue()==null){
            LoadTrending();
        }
        return mutableTV;
    }

    void LoadTrending() {
        Retrofit retrofit = ApiClient.getClient();
        ApiInterface mApiInterface = retrofit.create(ApiInterface.class);
        Call<GetTrendingTV> TrendingCall = mApiInterface.getTrendingTV("trending","tv",
                "week",ApiClient.MyApi );
        TrendingCall.enqueue(new Callback<GetTrendingTV>() {
            @Override
            public void onResponse(Call<GetTrendingTV> call, Response<GetTrendingTV>
                    response) {
                if(response.isSuccessful()) {
                    mutableTV.setValue(response.body().getTrendingTV());
                }
            }

            @Override
            public void onFailure(Call<GetTrendingTV> call, Throwable t) {
                Log.e("Retrofit Fail", t.getMessage());
                mutableTV.setValue(null);
            }
        });
    }
}

package dicoding.com.moviecatalogue.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetTrendingMovie {
    @SerializedName("page")
    String status;
    @SerializedName("results")
    List<TrendingMovie> listTrendingMovies;

    public List<TrendingMovie> getListTrendingMovies() {
        return listTrendingMovies;
    }

}

package dicoding.com.moviecatalogue.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetTrendingTV {
    @SerializedName("page")
    String status;
    @SerializedName("results")
    List<TrendingTV> listTrendingTVS;

    public List<TrendingTV> getTrendingTV() {
        return listTrendingTVS;
    }

}

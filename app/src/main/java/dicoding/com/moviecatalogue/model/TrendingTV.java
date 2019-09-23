package dicoding.com.moviecatalogue.model;

import com.google.gson.annotations.SerializedName;

public class TrendingTV {
    @SerializedName("id")
    private int idTV;
    @SerializedName("original_name")
    private String titleTV;
    @SerializedName("first_air_date")
    private String firstAirTV;
    @SerializedName("overview")
    private String detailTV;
    @SerializedName("poster_path")
    private String posterTV;
    @SerializedName("vote_average")
    private Float point;
    @SerializedName("popularity")
    private float popularity;

    public int getIdTV() {
        return idTV;
    }

    public String getTitleTV() {
        return titleTV;
    }

    public String getFirstAirTV() {
        return firstAirTV;
    }

    public String getDetailTV() {
        return detailTV;
    }

    public Float getPoint() {
        return point;
    }

    public String getPosterTV() {
        return posterTV;
    }

    public float getPopularity() {
        return popularity;
    }
}

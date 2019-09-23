package dicoding.com.moviecatalogue.model;

import com.google.gson.annotations.SerializedName;

public class TrendingMovie {
    @SerializedName("id")
    private int idMovie;
    @SerializedName("original_title")
    private String titleMovie;
    @SerializedName("release_date")
    private String releaseMovie;
    @SerializedName("overview")
    private String detailMovie;
    @SerializedName("poster_path")
    private String posterMovie;
    @SerializedName("vote_average")
    private float point;
    @SerializedName("popularity")
    private float popularity;

    public int getIdMovie() {
        return idMovie;
    }

    public String getTitleMovie() {
        return titleMovie;
    }

    public String getReleaseMovie() {
        return releaseMovie;
    }

    public String getDetailMovie() {
        return detailMovie;
    }

    public String getPosterMovie() {
        return posterMovie;
    }

    public float getPoint() {
        return point;
    }

    public float getPopularity() {
        return popularity;
    }
}

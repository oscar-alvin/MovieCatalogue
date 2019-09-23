package dicoding.com.moviecatalogue.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TVShow {
    @SerializedName("id")
    private int idTV;
    @SerializedName("original_name")
    private String titleTV;
    @SerializedName("overview")
    private String detailTV;
    @SerializedName("backdrop_path")
    private String backDropTV;
    @SerializedName("vote_average")
    private float point;
    @SerializedName("homepage")
    private String Homepage;
    @SerializedName("poster_path")
    private String posterTV;
    @SerializedName("genres")
    private List<Genre> genreTV;
    @SerializedName("episode_run_time")
    private List<Integer> durasiTV;
    @SerializedName("first_air_date")
    private String firstAirDate;
    @SerializedName("number_of_seasons")
    private int NumberSeasons;
    @SerializedName("popularity")
    private float popularity;


    public int getIdTV() {
        return idTV;
    }

    public String getTitleTV() {
        return titleTV;
    }

    public String getDetailTV() {
        return detailTV;
    }

    public String getBackDropTV() {
        return backDropTV;
    }

    public float getPoint() {
        return point;
    }

    public String getHomepage() {
        return Homepage;
    }

    public String getPosterTV() {
        return posterTV;
    }

    public List<Genre> getGenreTV() {
        return genreTV;
    }

    public List<Integer> getDurasiTV() {
        return durasiTV;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public int getNumberSeasons() {
        return NumberSeasons;
    }

    public float getPopularity() {
        return popularity;
    }
}

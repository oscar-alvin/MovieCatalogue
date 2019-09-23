package dicoding.com.moviecatalogue.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {
    @SerializedName("id")
    private int idMovie;
    @SerializedName("original_title")
    private String titleMovie;
    @SerializedName("genres")
    private List<Genre> genreMovie;
    @SerializedName("runtime")
    private int durasiMovie;
    @SerializedName("release_date")
    private String releaseMovie;
    @SerializedName("popularity")
    private Float popularity;
    @SerializedName("overview")
    private String detailMovie;
    @SerializedName("poster_path")
    private String posterMovie;
    @SerializedName("backdrop_path")
    private String backdropMovie;
    @SerializedName("vote_average")
    private float point;
    @SerializedName("homepage")
    private String homepage;
    @SerializedName("status")
    private String status;

    public int getIdMovie() {
        return idMovie;
    }

    public String getTitleMovie() {
        return titleMovie;
    }

    public List<Genre> getGenreMovie() {
        return genreMovie;
    }

    public int getDurasiMovie() {
        return durasiMovie;
    }

    public String getReleaseMovie() {
        return releaseMovie;
    }

    public float getPopularity() {
        return popularity;
    }

    public String getDetailMovie() {
        return detailMovie;
    }

    public String getPosterMovie() {
        return posterMovie;
    }

    public String getBackdropMovie() {
        return backdropMovie;
    }

    public float getPoint() {
        return point;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getStatus() {
        return status;
    }
}

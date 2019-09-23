package dicoding.com.moviecatalogue.APIHelper;

import java.util.Locale;

import dicoding.com.moviecatalogue.model.GetArtis;
import dicoding.com.moviecatalogue.model.GetTrendingMovie;
import dicoding.com.moviecatalogue.model.GetTrendingTV;
import dicoding.com.moviecatalogue.model.Movie;
import dicoding.com.moviecatalogue.model.TVShow;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("{pathmoviedb}/{idmovie}/credits")
    Call<GetArtis> getArtis(
            @Path("pathmoviedb") String pathmdb,
            @Path("idmovie") int idmovie,
            @Query("api_key") String apimoviedb
    );

    @GET("{pathmoviedb}/{tipe}/{timewindow}")
    Call<GetTrendingMovie> getTrending(
            @Path("pathmoviedb") String pathmdb,
            @Path("tipe") String tipe,
            @Path("timewindow") String timewindow,
            @Query("api_key") String apimoviedb
    );

    @GET("{pathmoviedb}/{tipe}/{timewindow}")
    Call<GetTrendingTV> getTrendingTV(
            @Path("pathmoviedb") String pathmdb,
            @Path("tipe") String tipe,
            @Path("timewindow") String timewindow,
            @Query("api_key") String apimoviedb
    );

    @GET("{pathmoviedb}/{idmoviedb}")
    Call<Movie> getDetailsMov(
            @Path("pathmoviedb") String pathmdb,
            @Path("idmoviedb") int idmdb,
            @Query("api_key") String apimdb,
            @Query("language") Locale lang
    );

    @GET("{pathmoviedb}/{idmoviedb}")
    Call<TVShow> getDetailsTV(
            @Path("pathmoviedb") String pathmdb,
            @Path("idmoviedb") int idmdb,
            @Query("api_key") String apimdb,
            @Query("language") Locale lang
    );

}

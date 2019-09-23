package dicoding.com.moviecatalogue.APIHelper;

import java.util.concurrent.TimeUnit;

import dicoding.com.moviecatalogue.BuildConfig;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String ProfilUrl = "https://image.tmdb.org/t/p/w185";
    public static final String PosterUrl = "https://image.tmdb.org/t/p/w185";
    public static final String BackDropUrl = "https://image.tmdb.org/t/p/w780";
    public static final String MyApi = BuildConfig.TMDB_API_KEY;

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit==null) {
            final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }
}

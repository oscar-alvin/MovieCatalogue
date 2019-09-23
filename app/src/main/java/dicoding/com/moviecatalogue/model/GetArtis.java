package dicoding.com.moviecatalogue.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetArtis {
    @SerializedName("id")
    String status;
    @SerializedName("cast")
    List<Artis> listDataArtis;

    public String getStatus() {
        return status;
    }

    public List<Artis> getListDataArtis() {
        return listDataArtis;
    }
}

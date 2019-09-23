package dicoding.com.moviecatalogue.model;

import com.google.gson.annotations.SerializedName;

public class Artis {
    @SerializedName("cast_id")
    private int idArtis;
    @SerializedName("credit_id")
    private String idCredit;
    @SerializedName("name")
    private String nameArtis;
    @SerializedName("character")
    private String karakterArtis;
    @SerializedName("profile_path")
    private String profilArtis;
	@SerializedName("order")
	private int order;

    public Artis(){
    }

    public Artis(int idArtis, String idCredit, String nameArtis, String karakterArtis, String profilArtis, int order) {
        this.idArtis = idArtis;
        this.idCredit = idCredit;
        this.nameArtis = nameArtis;
        this.karakterArtis = karakterArtis;
        this.profilArtis = profilArtis;
        this.order = order;
    }

    public int getIdArtis() {
        return idArtis;
    }

    public void setIdArtis(int idArtis) {
        this.idArtis = idArtis;
    }

    public String getIdCredit() {
        return idCredit;
    }

    public void setIdCredit(String idCredit) {
        this.idCredit = idCredit;
    }

    public String getNameArtis() {
        return nameArtis;
    }

    public void setNameArtis(String nameArtis) {
        this.nameArtis = nameArtis;
    }

    public String getKarakterArtis() {
        return karakterArtis;
    }

    public void setKarakterArtis(String karakterArtis) {
        this.karakterArtis = karakterArtis;
    }

    public String getProfilArtis() {
        return profilArtis;
    }

    public void setProfilArtis(String profilArtis) {
        this.profilArtis = profilArtis;
    }
	
	public int getOrder(){
		return this.order;
	}
	
	public void setOrder(int order){
		this.order = order;
	}

}

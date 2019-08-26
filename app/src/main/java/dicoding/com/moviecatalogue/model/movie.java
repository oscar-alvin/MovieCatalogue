package dicoding.com.moviecatalogue.model;

import android.os.Parcel;
import android.os.Parcelable;

public class movie implements Parcelable {
    private int idMovie;
    private String titleMovie;
    private String genreMovie;
    private int durasiMovie;
    private String releaseMovie;
    private int tahunMovie;
    private String detailMovie;
    private int posterMovie;
    private String[] artisName;
    private int[] artisPhoto;
    private int point;

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public String getTitleMovie() {
        return titleMovie;
    }

    public void setTitleMovie(String titleMovie) {
        this.titleMovie = titleMovie;
    }

    public String getGenreMovie() {
        return genreMovie;
    }

    public void setGenreMovie(String genreMovie) {
        this.genreMovie = genreMovie;
    }

    public int getDurasiMovie() {
        return durasiMovie;
    }

    public void setDurasiMovie(int lamaMovie) {
        this.durasiMovie = lamaMovie;
    }

    public int getTahunMovie() {
        return tahunMovie;
    }

    public void setTahunMovie(int tahunrilisMovie) {
        this.tahunMovie = tahunrilisMovie;
    }

    public String getReleaseMovie() {
        return releaseMovie;
    }

    public void setReleaseMovie(String releaseMovie) {
        this.releaseMovie = releaseMovie;
    }

    public String getDetailMovie() {
        return detailMovie;
    }

    public void setDetailMovie(String detailMovie) {
        this.detailMovie = detailMovie;
    }

    public int getPosterMovie() {
        return posterMovie;
    }

    public void setPosterMovie(int posterMovie) {
        this.posterMovie = posterMovie;
    }

    public String[] getArtisName() {
        return artisName;
    }

    public void setArtisName(String[] artisName) {
        this.artisName = artisName;
    }

    public int[] getArtisPhoto() {
        return artisPhoto;
    }

    public void setArtisPhoto(int[] artisPhoto) {
        this.artisPhoto = artisPhoto;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.idMovie);
        dest.writeString(this.titleMovie);
        dest.writeString(this.genreMovie);
        dest.writeInt(this.durasiMovie);
        dest.writeString(this.releaseMovie);
        dest.writeInt(this.tahunMovie);
        dest.writeString(this.detailMovie);
        dest.writeInt(this.posterMovie);
        dest.writeStringArray(this.artisName);
        dest.writeIntArray(this.artisPhoto);
        dest.writeInt(this.point);
    }

    public movie() {
    }

    protected movie(Parcel in) {
        this.idMovie = in.readInt();
        this.titleMovie = in.readString();
        this.genreMovie = in.readString();
        this.durasiMovie = in.readInt();
        this.releaseMovie = in.readString();
        this.tahunMovie = in.readInt();
        this.detailMovie = in.readString();
        this.posterMovie = in.readInt();
        this.artisName = in.createStringArray();
        this.artisPhoto = in.createIntArray();
        this.point = in.readInt();
    }

    public static final Parcelable.Creator<movie> CREATOR = new Parcelable.Creator<movie>() {
        @Override
        public movie createFromParcel(Parcel source) {
            return new movie(source);
        }

        @Override
        public movie[] newArray(int size) {
            return new movie[size];
        }
    };
}

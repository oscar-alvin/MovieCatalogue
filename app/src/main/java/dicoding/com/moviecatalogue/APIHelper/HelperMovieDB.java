package dicoding.com.moviecatalogue.APIHelper;

import android.content.Context;

import java.util.List;

import dicoding.com.moviecatalogue.R;
import dicoding.com.moviecatalogue.model.Genre;

public class HelperMovieDB {

    public static String convertDuration2String(Context c, int duration){
        String resultDuration = "";
                resultDuration = (duration >=60 ? duration/60 +" "+c.getString(R.string.hour)+" " : "")+
                (duration %60 > 0 ? duration %60 +" "+c.getString(R.string.min): "");
        return resultDuration;
    }
    public static String List2String(List<Genre> data){
        String result = "";
        for(int i=0; i<data.size(); i++){
            result+= data.get(i).getGenre();
            if(i<data.size()-1){
                result+=" | ";
            }
        }
        return result;
    }
}

package dicoding.com.moviecatalogue.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import dicoding.com.moviecatalogue.R;
import dicoding.com.moviecatalogue.model.movie;

public class movieAdapter extends BaseAdapter {
    private Context context;
    private List<movie> movies;

    public movieAdapter(Context context){
        this.context = context;
    }

    public void setMovies(List<movie> movies){
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        }
        ViewHolder viewHolder = new ViewHolder(convertView);
        movie m = (movie)getItem(position);
        viewHolder.bind(m);

        return convertView;
    }

    private class ViewHolder{
        private TextView mid, mtitle, mdurasi, mgenre;
        private ImageView imgMovie;

        ViewHolder(View view){
            mid = (TextView)view.findViewById(R.id.ltv_idm);
            mtitle = (TextView)view.findViewById(R.id.ltv_title);
            mdurasi = (TextView)view.findViewById(R.id.ltv_durasi);
            mgenre = (TextView)view.findViewById(R.id.ltv_genre);
            imgMovie = (ImageView) view.findViewById(R.id.liv_Movie);
        }
        void bind(movie movie){
            mid.setText(movie.getIdMovie()+"");
            if(movie.getTahunMovie()>0)
                mtitle.setText(movie.getTitleMovie()+"("+movie.getTahunMovie()+")");
            else mtitle.setText(movie.getTitleMovie());
            if(movie.getDurasiMovie()/60>1){
                mdurasi.setText((int)movie.getDurasiMovie()/60 +"h "+movie.getDurasiMovie()%60+"m");
            }else mdurasi.setText(movie.getDurasiMovie()%60+"m");
            mgenre.setText(movie.getGenreMovie());
            Glide.with(context).load(movie.getPosterMovie()).override(80, 80).centerCrop().into(imgMovie);
        }
    }
}

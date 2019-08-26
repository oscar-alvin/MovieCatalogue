package dicoding.com.moviecatalogue.adapter;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import dicoding.com.moviecatalogue.R;

public class artistAdapter extends RecyclerView.Adapter<artistAdapter.MyViewHolder> {

    private Context context;
    private String[] artisName;
    private int[] artistPhoto;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView artisName;
        public ImageView artisPhoto;
        public Button seedet;

        public MyViewHolder(View view) {
            super(view);

            artisPhoto = view.findViewById(R.id.pi_artisImg);
            artisName = view.findViewById(R.id.pi_artisName);
            seedet = view.findViewById(R.id.btn_seeArtist);
        }
    }

    public artistAdapter(Context c, String[] name, int[] photo){
        this.context = c;
        this.artisName = name;
        this.artistPhoto = photo;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_artist, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.artisName.setText(getArtistNameAt(position));
        Glide.with(context).load(getArtistPhotoAt(position)).override(100,100).centerCrop().into(holder.artisPhoto);
        holder.seedet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent seeart = new Intent(Intent.ACTION_WEB_SEARCH);
                seeart.putExtra(SearchManager.QUERY, getArtistNameAt(position));
                context.startActivity(seeart);
            }
        });
    }

    @Override
    public int getItemCount() {
        return artisName.length;
    }

    private String getArtistNameAt(int pos){
        return artisName[pos];
    }
    private int getArtistPhotoAt(int pos){
        return artistPhoto[pos];
    }
}
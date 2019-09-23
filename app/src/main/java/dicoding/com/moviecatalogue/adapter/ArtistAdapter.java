package dicoding.com.moviecatalogue.adapter;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import dicoding.com.moviecatalogue.APIHelper.ApiClient;
import dicoding.com.moviecatalogue.R;
import dicoding.com.moviecatalogue.model.Artis;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.MyViewHolder> {
    private Context context;
    private List<Artis> castList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView artisName, artisRole;
        public ImageView artisPhoto;
        public ProgressBar progressBar;

        public MyViewHolder(View view) {
            super(view);
            artisPhoto = view.findViewById(R.id.pi_artisImg);
            artisName = view.findViewById(R.id.pi_artisName);
            artisRole = view.findViewById(R.id.pi_artisRole);
            progressBar = view.findViewById(R.id.progressBar2);
        }
    }

    public ArtistAdapter(Context c, List<Artis> castList){
        this.context = c;
        this.castList = castList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_artist, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        if(holder.getAdapterPosition()<castList.size()){
            final Artis art = castList.get(holder.getAdapterPosition());
            holder.artisName.setText(art.getNameArtis());
            holder.artisRole.setText(art.getKarakterArtis().length()>100 ?
                    art.getKarakterArtis().substring(0,100)+"..." : art.getKarakterArtis());
                Glide.with(context).load(ApiClient.ProfilUrl + art.getProfilArtis())
                        .error(R.drawable.ic_error_photo_24dp)
                        .addListener(new RequestListener<Drawable>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                    holder.progressBar.setVisibility(View.GONE);
                    return false;
                }

                @Override
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    holder.progressBar.setVisibility(View.GONE);
                    return false;
                }
            }).override(100, 150).fitCenter().into(holder.artisPhoto);

                holder.artisPhoto.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent seeart = new Intent(Intent.ACTION_WEB_SEARCH);
                        seeart.putExtra(SearchManager.QUERY, art.getNameArtis());
                        context.startActivity(seeart);
                    }
                });
        }

    }

    @Override
    public int getItemCount() {
        if(castList.size()>5){
            return 5;
        }
        return castList.size();
    }
}
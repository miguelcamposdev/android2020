package com.miguelcr.tmdb_viewmodelrepository.ui;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.miguelcr.tmdb_viewmodelrepository.R;
import com.miguelcr.tmdb_viewmodelrepository.common.Constantes;
import com.miguelcr.tmdb_viewmodelrepository.models.Series;
import com.miguelcr.tmdb_viewmodelrepository.viewmodel.SeriesViewModel;

import java.util.List;

public class MySeriesRecyclerViewAdapter extends RecyclerView.Adapter<MySeriesRecyclerViewAdapter.ViewHolder> {

    private List<Series> mValues;
    SeriesViewModel seriesViewModel;
    Context context;


    public MySeriesRecyclerViewAdapter(Context ctx, List<Series> series, SeriesViewModel seriesViewModel) {
        this.context = ctx;
        mValues = series;
        this.seriesViewModel = seriesViewModel;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_series, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if(mValues != null){
            holder.mItem = mValues.get(position);
            Glide.with(context)
                    .load(Constantes.POSTER_PATH_URL_W500 + holder.mItem.getPosterPath())
                    //.error(Glide.with(context).load(R.drawable.image_not_loaded_icon))
                    //.thumbnail(Glide.with(context).load(R.drawable.loading_gif).transform( new CenterCrop()))
                    .into(holder.ivPosterPath);

            // TODO: hacemos uso del ViewModel
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != seriesViewModel) {
                        seriesViewModel.setIdSerieSeleccionada(holder.mItem.getId());
                    }
                }
            });
        }
    }

    public void setData(List<Series> list){
        this.mValues.clear();
        this.mValues.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mValues != null){
            return mValues.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView ivPosterPath;
        public final TextView mContentView;
        public Series mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ivPosterPath = view.findViewById(R.id.imageViewPosterPath);
            mContentView = (TextView) view.findViewById(R.id.content);
        }
    }
}

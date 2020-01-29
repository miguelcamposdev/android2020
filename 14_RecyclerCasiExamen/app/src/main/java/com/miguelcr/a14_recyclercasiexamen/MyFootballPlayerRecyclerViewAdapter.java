package com.miguelcr.a14_recyclercasiexamen;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class MyFootballPlayerRecyclerViewAdapter extends RecyclerView.Adapter<MyFootballPlayerRecyclerViewAdapter.ViewHolder> {

    private Context ctx;
    private final List<FootballPlayer> mValues;
    private final IFootballPlayerListener mListener;

    public MyFootballPlayerRecyclerViewAdapter(Context ctx, List<FootballPlayer> mValues, IFootballPlayerListener mListener) {
        this.ctx = ctx;
        this.mValues = mValues;
        this.mListener = mListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_footballplayer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        // Setear los datos en los View Components
        holder.tvNombre.setText(holder.mItem.getNombre());
        holder.tvGoles.setText(holder.mItem.getGoles() + " goles");

        Glide.with(ctx)
                .load(holder.mItem.getPhotoUrl())
                .into(holder.ivFoto);

        holder.ivFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onFootballPlayerClick(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView ivFoto;
        public final TextView tvNombre;
        public final TextView tvGoles;
        public FootballPlayer mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ivFoto = view.findViewById(R.id.imageViewFoto);
            tvNombre = view.findViewById(R.id.textViewNombre);
            tvGoles = view.findViewById(R.id.textViewGoles);
        }

    }
}

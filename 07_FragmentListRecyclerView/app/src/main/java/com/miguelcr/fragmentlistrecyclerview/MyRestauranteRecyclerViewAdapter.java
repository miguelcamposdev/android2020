package com.miguelcr.fragmentlistrecyclerview;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.miguelcr.fragmentlistrecyclerview.dummy.DummyContent.DummyItem;

import java.util.List;


public class MyRestauranteRecyclerViewAdapter extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder> {

    private final List<Restaurante> mValues;
    private Context ctx;
    private int layout;

    public MyRestauranteRecyclerViewAdapter(Context ctx, int layout, List<Restaurante> objects) {
        this.ctx = ctx;
        this.layout = layout;
        mValues = objects;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_restaurante, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tvNombre.setText(holder.mItem.getNombre());
        holder.tvDireccion.setText(holder.mItem.getDireccion());
        holder.tvValoracion.setText(holder.mItem.getValoracion() + " / 5");
        holder.tvTelefono.setText(holder.mItem.getTelefono());

        // Glide
        Glide.with(ctx)
                .load(holder.mItem.getPhotoUrl())
                .centerCrop()
                .into(holder.ivFoto);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView ivFoto;
        public final TextView tvNombre;
        public final TextView tvDireccion;
        public final TextView tvValoracion;
        public final TextView tvTelefono;
        public Restaurante mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ivFoto = view.findViewById(R.id.imageViewFoto);
            tvNombre = view.findViewById(R.id.textViewNombre);
            tvDireccion = view.findViewById(R.id.textViewDireccion);
            tvValoracion = view.findViewById(R.id.textViewValoracion);
            tvTelefono = view.findViewById(R.id.textViewTelefono);

        }
    }
}

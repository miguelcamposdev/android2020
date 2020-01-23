package com.miguelcr.a11_tabnavigation;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.miguelcr.a11_tabnavigation.interfaces.IUsuarioListener;
import com.miguelcr.a11_tabnavigation.models.Usuario;

import java.util.List;

public class MyUsuariosRecyclerViewAdapter extends RecyclerView.Adapter<MyUsuariosRecyclerViewAdapter.ViewHolder> {

    private final List<Usuario> mValues;
    private final IUsuarioListener mListener;
    private Context ctx;

    public MyUsuariosRecyclerViewAdapter(Context context, List<Usuario> items, IUsuarioListener listener) {
        mValues = items;
        mListener = listener;
        this.ctx = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_usuarios, parent, false);
        return new ViewHolder(view);
    }


    // El que se encarga de dibujar cada elemento de la lista
    // Y si hubiera eventos (click) también se definen aquí

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.tvNombre.setText(holder.mItem.getNombre());

        Glide.with(ctx)
                .load(holder.mItem.getUrlFoto())
                .into(holder.ivFoto);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.usuarioClick(holder.mItem);
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
        public Usuario mItem;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            ivFoto = view.findViewById(R.id.imageViewFoto);
            tvNombre = view.findViewById(R.id.textViewNombre);
        }

    }
}

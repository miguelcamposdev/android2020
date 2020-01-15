package com.miguelcr.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

public class AlumnosAdapter extends ArrayAdapter<Alumno> {
    Context ctx;
    int layoutPlantilla;
    List<Alumno> listaDatos;

    public AlumnosAdapter(@NonNull Context context, int resource, @NonNull List<Alumno> objects) {
        super(context, resource, objects);
        this.ctx = context;
        this.layoutPlantilla = resource;
        this.listaDatos = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(ctx).inflate(layoutPlantilla, parent, false);

        // Rescatar una referencia de cada elemento visual de la plantilla (template)
        TextView tvNombre = v.findViewById(R.id.textViewNombre);
        TextView tvEdad = v.findViewById(R.id.textViewEdad);
        ImageView ivFoto = v.findViewById(R.id.imageViewFoto);

        // Obtener los datos del alumno actual que debo dibujar
        Alumno alumnoActual = listaDatos.get(position);
        String nombre = alumnoActual.getNombre();
        int edad = alumnoActual.getEdad();
        String urlFoto = alumnoActual.getFotoUrl();

        // Insertar en los componentes de la plantilla
        // los datos del alumno actual
        tvNombre.setText(nombre);
        tvEdad.setText(String.valueOf(edad));

        Glide.with(ctx)
                .load(urlFoto)
                .centerCrop()
                .into(ivFoto);

        return v;
    }
}

package com.miguelcr.a11_tabnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetalleUsuarioActivity extends AppCompatActivity {
    ImageView ivFotoDetalle;
    TextView tvNombreDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_usuario);

        // Obtengo la referencia a los View components
        tvNombreDetalle = findViewById(R.id.textViewNombreDetalle);
        ivFotoDetalle = findViewById(R.id.imageViewFotoDetalle);

        // Obtengo los parámetros que me han pasado
        Bundle extras = getIntent().getExtras();

        String nombre = extras.getString(Constantes.EXTRA_USUARIO_NOMBRE);
        String urlFoto = extras.getString(Constantes.EXTRA_USUARIO_FOTO);

        // Inserto la información en los View Components
        tvNombreDetalle.setText(nombre);

        Glide.with(this)
                .load(urlFoto)
                .into(ivFotoDetalle);

    }
}

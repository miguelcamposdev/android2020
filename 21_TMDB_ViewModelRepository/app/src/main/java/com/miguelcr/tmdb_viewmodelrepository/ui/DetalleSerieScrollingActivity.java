package com.miguelcr.tmdb_viewmodelrepository.ui;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.miguelcr.tmdb_viewmodelrepository.R;
import com.miguelcr.tmdb_viewmodelrepository.common.Constantes;
import com.miguelcr.tmdb_viewmodelrepository.models.SerieDetail;
import com.miguelcr.tmdb_viewmodelrepository.viewmodel.DetalleSerieViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetalleSerieScrollingActivity extends AppCompatActivity {
    int idSerie;
    DetalleSerieViewModel detalleSerieViewModel;
    @BindView(R.id.textViewCreatedBy) TextView tvCreatedBy;
    @BindView(R.id.textViewDescripcionSerie) TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_serie_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // ButterKnife
        ButterKnife.bind(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // idSerie
        Bundle extras = getIntent().getExtras();
        idSerie = extras.getInt(Constantes.EXTRA_ID_SERIE);

        Toast.makeText(this, "Id: " + idSerie, Toast.LENGTH_SHORT).show();

        detalleSerieViewModel = new ViewModelProvider(this).get(DetalleSerieViewModel.class);


        detalleSerieViewModel.getSerie(idSerie).observe(this, new Observer<SerieDetail>() {
            @Override
            public void onChanged(SerieDetail serieDetail) {
                if(serieDetail != null) {
                    tvCreatedBy.setText(serieDetail.getCreatedBy().get(0).getName());
                    tvDescripcion.setText(serieDetail.getOverview());
                }
            }
        });

    }
}

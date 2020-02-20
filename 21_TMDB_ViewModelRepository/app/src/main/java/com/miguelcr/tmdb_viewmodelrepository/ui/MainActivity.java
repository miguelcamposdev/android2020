package com.miguelcr.tmdb_viewmodelrepository.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.miguelcr.tmdb_viewmodelrepository.R;
import com.miguelcr.tmdb_viewmodelrepository.common.Constantes;
import com.miguelcr.tmdb_viewmodelrepository.viewmodel.SeriesViewModel;

public class MainActivity extends AppCompatActivity {
    SeriesViewModel seriesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seriesViewModel = new ViewModelProvider(this).get(SeriesViewModel.class);

        seriesViewModel.getIdSerieSeleccionada().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer idSerie) {
                if(idSerie != null) {
                    Intent i = new Intent(MainActivity.this, DetalleSerieScrollingActivity.class);
                    i.putExtra(Constantes.EXTRA_ID_SERIE, idSerie);
                    startActivity(i);
                }
            }
        });

    }
}

package com.miguelcr.tmdb_viewmodelrepository.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.miguelcr.tmdb_viewmodelrepository.models.Series;
import com.miguelcr.tmdb_viewmodelrepository.repository.SeriesTmdbApiRepository;

import java.util.List;

public class SeriesViewModel extends AndroidViewModel {
    MutableLiveData<List<Series>> series;
    SeriesTmdbApiRepository seriesTmdbApiRepository;
    MutableLiveData<Integer> idSerieSeleccionada;

    public SeriesViewModel(@NonNull Application application) {
        super(application);
        seriesTmdbApiRepository = new SeriesTmdbApiRepository();
        this.idSerieSeleccionada = new MutableLiveData<>();
        this.idSerieSeleccionada.setValue(null);
    }

    public MutableLiveData<List<Series>> getSeries() {
        series = seriesTmdbApiRepository.getSeriesPopulares();
        return series;
    }

    public void setIdSerieSeleccionada(Integer idSerieSeleccionada) {
        this.idSerieSeleccionada.setValue(idSerieSeleccionada);
    }

    public MutableLiveData<Integer> getIdSerieSeleccionada() {
        return idSerieSeleccionada;
    }
}

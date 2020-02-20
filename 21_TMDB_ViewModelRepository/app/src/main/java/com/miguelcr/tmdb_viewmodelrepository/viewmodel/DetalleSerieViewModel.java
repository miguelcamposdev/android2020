package com.miguelcr.tmdb_viewmodelrepository.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.miguelcr.tmdb_viewmodelrepository.models.SerieDetail;
import com.miguelcr.tmdb_viewmodelrepository.repository.SeriesTmdbApiRepository;

public class DetalleSerieViewModel extends AndroidViewModel {
    MutableLiveData<SerieDetail> serie;
    SeriesTmdbApiRepository seriesTmdbApiRepository;


    public DetalleSerieViewModel(@NonNull Application application) {
        super(application);
        seriesTmdbApiRepository = new SeriesTmdbApiRepository();
    }

    public MutableLiveData<SerieDetail> getSerie(int idSerie) {
        serie = seriesTmdbApiRepository.getSerie(idSerie);
        return serie;
    }
}

package com.miguelcr.tmdb_viewmodelrepository.repository;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.miguelcr.tmdb_viewmodelrepository.common.MyApp;
import com.miguelcr.tmdb_viewmodelrepository.models.PopularSeries;
import com.miguelcr.tmdb_viewmodelrepository.models.SerieDetail;
import com.miguelcr.tmdb_viewmodelrepository.models.Series;
import com.miguelcr.tmdb_viewmodelrepository.retrofit.ServiceGenerator;
import com.miguelcr.tmdb_viewmodelrepository.retrofit.TheMoviedbService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesTmdbApiRepository {
    TheMoviedbService service;
    ServiceGenerator serviceGenerator;

    MutableLiveData<List<Series>> seriesPopulares;

    public SeriesTmdbApiRepository(){
        service = serviceGenerator.createService(TheMoviedbService.class);
        seriesPopulares = null;
    }

    public MutableLiveData<List<Series>> getSeriesPopulares(){
        final MutableLiveData<List<Series>> data = new MutableLiveData<>();

        Call<PopularSeries> call = service.getPopularsSeries("1");
        call.enqueue(new Callback<PopularSeries>() {
            @Override
            public void onResponse(Call<PopularSeries> call, Response<PopularSeries> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body().getResults());
                } else {
                    Toast.makeText(MyApp.getContext(), "Error on the response from the Api", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PopularSeries> call, Throwable t) {
                Toast.makeText(MyApp.getContext(), "Error in the connection", Toast.LENGTH_SHORT).show();
            }
        });
        return data;
    }

    public MutableLiveData<SerieDetail> getSerie(int idSerie) {
        // https://api.themoviedb.org/3/tv/456?api_key=433d2c486572afb242c6fe7c1ddc6771&language=en-US
        final MutableLiveData<SerieDetail> data = new MutableLiveData<>();

        Call<SerieDetail> call = service.getSerieDetail(String.valueOf(idSerie));
        call.enqueue(new Callback<SerieDetail>() {
            @Override
            public void onResponse(Call<SerieDetail> call, Response<SerieDetail> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SerieDetail> call, Throwable t) {

            }
        });
        
        return data;
    }
}

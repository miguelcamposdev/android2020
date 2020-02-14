package com.miguelcr.a20_marcadorbaloncesto;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class MarcadorViewModel extends AndroidViewModel {
    Context ctx;
    public MutableLiveData<Integer> puntuacionEquipoA = new MutableLiveData<>();
    public MutableLiveData<Integer> puntuacionEquipoB = new MutableLiveData<>();

    public MarcadorViewModel(@NonNull Application application) {
        super(application);
        ctx = application.getApplicationContext();
        this.puntuacionEquipoA.postValue(0);
        this.puntuacionEquipoB.postValue(0);
    }

    public void incrementarPuntuacionEquipoA(int incremento) {
        int valorActual = this.puntuacionEquipoA.getValue();
        this.puntuacionEquipoA.postValue(valorActual + incremento);
    }

    public void incrementarPuntuacionEquipoB(int incremento) {
        int valorActual = this.puntuacionEquipoB.getValue();
        this.puntuacionEquipoB.postValue(valorActual + incremento);
    }

    public MutableLiveData<Integer> getPuntuacionEquipoA() {
        return this.puntuacionEquipoA;
    }

    public MutableLiveData<Integer> getPuntuacionEquipoB() {
        return this.puntuacionEquipoB;
    }
}

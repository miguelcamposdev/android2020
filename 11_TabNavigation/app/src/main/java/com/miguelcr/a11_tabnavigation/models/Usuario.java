package com.miguelcr.a11_tabnavigation.models;

public class Usuario {
    private String nombre;
    private String urlFoto;

    public Usuario(String nombre, String urlFoto) {
        this.nombre = nombre;
        this.urlFoto = urlFoto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }
}

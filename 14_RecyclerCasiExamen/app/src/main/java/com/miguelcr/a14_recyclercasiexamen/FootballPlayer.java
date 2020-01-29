package com.miguelcr.a14_recyclercasiexamen;

public class FootballPlayer {
    private String nombre;
    private String photoUrl;
    private int goles;

    public FootballPlayer(String nombre, String photoUrl, int goles) {
        this.nombre = nombre;
        this.photoUrl = photoUrl;
        this.goles = goles;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }
}

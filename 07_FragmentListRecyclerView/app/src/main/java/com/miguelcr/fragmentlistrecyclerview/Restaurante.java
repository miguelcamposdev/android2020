package com.miguelcr.fragmentlistrecyclerview;

class Restaurante {
    private String nombre;
    private String photoUrl;
    private float valoracion;
    private String direccion;
    private String telefono;

    public Restaurante(String nombre, String photoUrl, float valoracion, String direccion, String telefono) {
        this.nombre = nombre;
        this.photoUrl = photoUrl;
        this.valoracion = valoracion;
        this.direccion = direccion;
        this.telefono = telefono;
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

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

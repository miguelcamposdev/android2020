package com.miguelcr.customlistview;

class Alumno {
    private String nombre;
    private String fotoUrl;
    private int edad;

    public Alumno(String nombre, String fotoUrl, int edad) {
        this.nombre = nombre;
        this.fotoUrl = fotoUrl;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}

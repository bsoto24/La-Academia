package com.openlab.perusemide_tecnico.entity;

/**
 * Created by Bryam Soto on 04/11/2017.
 */

public class Deporte {

    private String deporte;
    private String descripcion;
    private int imagen;

    public Deporte(String deporte, String descripcion, int imagen) {
        this.deporte = deporte;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}

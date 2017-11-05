package com.openlab.perusemide_tecnico.entity;

/**
 * Created by Bryam Soto on 04/11/2017.
 */

public class Evento {

    private String titulo;
    private String deporte;
    private String fecha;
    private String lugar;
    private int imagen;

    public Evento(String titulo, String deporte, String fecha, String lugar, int imagen) {
        this.titulo = titulo;
        this.deporte = deporte;
        this.fecha = fecha;
        this.lugar = lugar;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}

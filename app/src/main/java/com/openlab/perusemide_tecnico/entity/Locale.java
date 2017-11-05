package com.openlab.perusemide_tecnico.entity;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

import java.io.Serializable;

public class Locale implements ClusterItem, Serializable {

    private String localId;
    private String localNombre;
    private String localDireccion;
    private String localLatitud;
    private String localLongitud;
    private String localTaller;
    private int icon;

    public Locale(String localId, String localNombre, String localDireccion, String localLatitud, String localLongitud, String localTaller, int icon) {
        this.localId = localId;
        this.localNombre = localNombre;
        this.localDireccion = localDireccion;
        this.localLatitud = localLatitud;
        this.localLongitud = localLongitud;
        this.localTaller = localTaller;
        this.icon = icon;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public String getLocalNombre() {
        return localNombre;
    }

    public void setLocalNombre(String localNombre) {
        this.localNombre = localNombre;
    }

    public String getLocalDireccion() {
        return localDireccion;
    }

    public void setLocalDireccion(String localDireccion) {
        this.localDireccion = localDireccion;
    }

    public String getLocalLatitud() {
        return localLatitud;
    }

    public void setLocalLatitud(String localLatitud) {
        this.localLatitud = localLatitud;
    }

    public String getLocalLongitud() {
        return localLongitud;
    }

    public void setLocalLongitud(String localLongitud) {
        this.localLongitud = localLongitud;
    }

    public String getLocalTaller() {
        return localTaller;
    }

    public void setLocalTaller(String localTaller) {
        this.localTaller = localTaller;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    @Override
    public LatLng getPosition() {
        return new LatLng(Double.parseDouble(getLocalLatitud()), Double.parseDouble(getLocalLongitud()));
    }
}
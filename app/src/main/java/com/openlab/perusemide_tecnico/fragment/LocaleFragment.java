package com.openlab.perusemide_tecnico.fragment;

import android.Manifest;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.openlab.perusemide_tecnico.R;
import com.openlab.perusemide_tecnico.activity.DeporteActivity;
import com.openlab.perusemide_tecnico.core.BaseFragment;
import com.openlab.perusemide_tecnico.entity.Locale;
import com.openlab.perusemide_tecnico.presenter.LocalePresenter;
import com.openlab.perusemide_tecnico.services.GPS_Service;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class LocaleFragment extends BaseFragment implements OnMapReadyCallback, LocationListener, ClusterManager.OnClusterClickListener<Locale>, ClusterManager.OnClusterItemClickListener<Locale> {

    protected LocationManager mLocationManager;
    MapView mMapView;
    boolean bandera_camara = false;
    boolean gps_enabled = false;
    LatLng punto;
    private BroadcastReceiver broadcastReceiver;
    private int bandera_mapa = 0;
    private GoogleMap mMap;
    private LocalePresenter localePresenter;
    private Location location;
    private Drawable icLocal;

    public static LocaleFragment newInstance() {
        return new LocaleFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        icLocal = getResources().getDrawable(R.drawable.ic_stadium);
        if (!runtime_permissions()) {
            Intent intent = new Intent(getContext(), GPS_Service.class);
            getActivity().startService(intent);
            System.out.println("Inicia Servicio");
        }

        mLocationManager = (LocationManager) getContext().getSystemService(getContext().LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_map, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MapsInitializer.initialize(getActivity());

        mMapView = (MapView) view.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (Build.VERSION.SDK_INT >= 23 && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            bandera_mapa = 1;
            return;
        }
        bandera_mapa = 0;
        mMap.setMyLocationEnabled(true);
        if (Build.VERSION.SDK_INT >= 23 && punto == null) {
            punto = new LatLng(-12.08036, -77.02569340000002);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(punto));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(14));
        }
        if (Build.VERSION.SDK_INT < 23 && punto == null) {
            punto = new LatLng(-12.08036, -77.02569340000002);
        }

        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String bestProvider = locationManager.getBestProvider(criteria, true);
        Location location = locationManager.getLastKnownLocation(bestProvider);
        if (location != null) {
            onLocationChanged(location);
        }
        locationManager.requestLocationUpdates(bestProvider, 20000, 0, this);
        mMap.clear();

        localePresenter = new LocalePresenter(mMap, getContext(), this);
        localePresenter.mostrarLocales();

        googleMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
            @Override
            public boolean onMyLocationButtonClick() {
                if (!gps_enabled) {
                    new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("GPS desactivado")
                            .setContentText("Active su GPS para continuar")
                            .setConfirmText("Ir a Ajustes")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    sDialog.dismissWithAnimation();

                                    Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(i);
                                }
                            })
                            .setCancelText("Cancelar")
                            .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sweetAlertDialog) {
                                    sweetAlertDialog.dismissWithAnimation();
                                }
                            })
                            .show();
                }

                return false;
            }
        });
    }

    public void mostrar(final Locale locale) {
        RelativeLayout root = new RelativeLayout(getActivity());
        root.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        final Dialog customDialog = new Dialog(getContext(), R.style.Theme_Dialog_Translucent);
        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.getWindow().setGravity(Gravity.CENTER_HORIZONTAL);
        customDialog.setContentView(R.layout.dialog_locale);

        TextView titulo = (TextView) customDialog.findViewById(R.id.tv_clinica);
        TextView direccion = (TextView) customDialog.findViewById(R.id.tv_direccion);
        TextView taller = (TextView) customDialog.findViewById(R.id.tv_horario_atencion);

        titulo.setText(locale.getLocalNombre());
        direccion.setText(locale.getLocalDireccion());
        taller.setText(locale.getLocalTaller());

        (customDialog.findViewById(R.id.btn_promocion)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog.dismiss();
                Intent intent = new Intent(getContext(), DeporteActivity.class);
                intent.putExtra("locale", locale);
                startActivity(intent);
            }
        });
        customDialog.show();
    }

    private boolean runtime_permissions() {
        if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 100);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        mLocationManager.removeUpdates(this);
        if (broadcastReceiver != null) {
            getActivity().unregisterReceiver(broadcastReceiver);
        }
        mMapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (bandera_mapa == 1 && (Build.VERSION.SDK_INT >= 23 && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED)) {
            onMapReady(mMap);

        }
        if (mMap == null) {
            mMapView.onResume();
        }

        LocationManager lm = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {

        }
        mMapView.onResume();

    }

    //Implementar para que corra despues
    private void setUpMapIfNeeded() {
        if (mMap == null) {
            ((SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
        }
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        Intent i = new Intent(getContext(), GPS_Service.class);
        getActivity().stopService(i);
    }


    @Override
    public void onLocationChanged(Location locate) {
        location = locate;
        if (!bandera_camara) {
            try {
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                punto = new LatLng(latitude, longitude);
                mMap.moveCamera(CameraUpdateFactory.newLatLng(punto));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(14));
            } catch (Exception e) {
            }
            bandera_camara = true;
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {
        if (s.equals(LocationManager.GPS_PROVIDER)) {
            showGPSDiabledDialog();
        }
    }

    public void showGPSDiabledDialog() {
        new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                .setTitleText("GPS desactivado")
                .setContentText("Active su GPS para continuar")
                .setConfirmText("Ir a Ajustes")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();
                        Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);
                    }
                })
                .setCancelText("Salir")
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismiss();
                        getActivity().finish();
                    }
                })
                .show();
    }

    public GoogleMap getMap() {
        setUpMapIfNeeded();
        return mMap;
    }

    @Override
    public boolean onClusterClick(Cluster<Locale> cluster) {
        double minLat = 0;
        double minLng = 0;
        double maxLat = 0;
        double maxLng = 0;
        for (Locale p : cluster.getItems()) {
            double lat = p.getPosition().latitude;
            double lng = p.getPosition().longitude;
            if (minLat == 0 & minLng == 0 & maxLat == 0 & maxLng == 0) {
                minLat = maxLat = lat;
                minLng = maxLng = lng;
            }
            if (lat > maxLat) {
                maxLat = lat;
            }
            if (lng > maxLng) {
                maxLng = lng;
            }
            if (lat < minLat) {
                minLat = lat;
            }
            if (lng < minLng) {
                minLng = lng;
            }
        }

        LatLng sw = new LatLng(minLat, minLng);
        LatLng ne = new LatLng(maxLat, maxLng);
        LatLngBounds bounds = new LatLngBounds(sw, ne);

        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 50));
        if(mMap.getCameraPosition().zoom == mMap.getMaxZoomLevel()){
            ArrayList<Locale> locales = (ArrayList<Locale>) cluster.getItems();
            mostrar(locales.get(0));
        }

        return true;
    }

    @Override
    public boolean onClusterItemClick(Locale item) {
        mostrar(item);
        return false;
    }

}

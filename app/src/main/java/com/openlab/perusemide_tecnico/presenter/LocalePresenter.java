package com.openlab.perusemide_tecnico.presenter;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.clustering.ClusterManager;
import com.openlab.perusemide_tecnico.R;
import com.openlab.perusemide_tecnico.contract.LocaleContract;
import com.openlab.perusemide_tecnico.entity.Locale;
import com.openlab.perusemide_tecnico.fragment.LocaleFragment;

import java.util.ArrayList;

public class LocalePresenter implements LocaleContract {

    private GoogleMap mMap;
    private ClusterManager mClusterManager;
    private Context context;
    private LocaleFragment fragment;

    public LocalePresenter(GoogleMap mMap, Context context, LocaleFragment fragment) {
        this.mMap = mMap;
        this.context = context;
        this.fragment = fragment;
    }

    protected void showMarkers(ArrayList<Locale> items) {

        mClusterManager = new ClusterManager<>(context, mMap);
        mClusterManager.setRenderer(new StoreRenderer(context, fragment, mMap, mClusterManager));
        mMap.setOnCameraChangeListener(mClusterManager);
        mMap.setOnMarkerClickListener(mClusterManager);
        mMap.setOnInfoWindowClickListener(mClusterManager);
        mClusterManager.setOnClusterClickListener(fragment);
        mClusterManager.setOnClusterItemClickListener(fragment);

        addItems(items);
        mClusterManager.cluster();
    }

    @Override
    public void mostrarLocales() {
        ArrayList<Locale> datos = new ArrayList<>();

        datos.add(new Locale("1", "Cantolao", "Campo de Marte", "-12.0700534", "-77.0417081", "Academia de Futbol", R.drawable.ic_stadium));
        datos.add(new Locale("2", "Sporting Cristal", "Rimac", "-12.0593718", "-77.045644", "Academia de Futbol", R.drawable.ic_stadium));
        datos.add(new Locale("3", "Alianza Lima", "Estadio Matute", "-12.0690113", "-77.0271513", "Academia de Futbol", R.drawable.ic_stadium));
        datos.add(new Locale("4", "Sporting Cristal", "Rimac", "-12.0593718", "-77.045644", "Academia de Futbol", R.drawable.ic_stadium));
        datos.add(new Locale("5", "Complejo Deportivo Canto Grande", "San Juan de Lurigancho", "-11.951660", " -76.996424", "Academia de Fútbol", R.drawable.ic_stadium));
        datos.add(new Locale("6", "Complejo Deportivo Canto Grande", "San Juan de Lurigancho", "-11.951660", "-76.996424", "Academia de Atletismo", R.drawable.ic_stadium));
        datos.add(new Locale("7", "Complejo Deportivo Canto Grande", "San Juan de Lurigancho", "-11.951660", "-76.996424", "Academia de Basquetbol", R.drawable.ic_stadium));
        datos.add(new Locale("8", "Complejo Deportivo Canto Grande", "San Juan de Lurigancho", "-11.951660", "-76.996424", "Academia de Natación", R.drawable.ic_stadium));
        datos.add(new Locale("9", "Complejo Deportivo Canto Grande", "San Juan de Lurigancho", "-11.951660", "-76.996424", "Academia de Voleibol", R.drawable.ic_stadium));
        datos.add(new Locale("10", "Complejo Deportivo Canto Grande", "San Juan de Lurigancho", "-11.951660", "-76.996424", "Academia de Futbol Sala", R.drawable.ic_stadium));
        datos.add(new Locale("11", "Complejo Deportivo Los Olivos", "Los Olivos", "-11.973284", "-77.081289", "Academia de Atletismo", R.drawable.ic_stadium));
        datos.add(new Locale("12", "Complejo Deportivo Los Olivos", "Los Olivos", "-11.973284", "-77.081289", "Academia de Basquetbol", R.drawable.ic_stadium));
        datos.add(new Locale("13", "Complejo Deportivo Los Olivos", "Los Olivos", "-11.973284", "-77.081289", "Academia de Futbol", R.drawable.ic_stadium));
        datos.add(new Locale("14", "Complejo Deportivo Los Olivos", "Los Olivos", "-11.973284", "-77.081289", "Academia de voleibol", R.drawable.ic_stadium));
        datos.add(new Locale("15", "Complejo Deportivo Los Olivos", "Los Olivos", "-12.065870", "-77.006172", "Academia de voleibol", R.drawable.ic_stadium));
        datos.add(new Locale("16", "Coliseo Eduardo Dibos", "San Borja", "-12.110880", "-77.001147", "Academia de Basquetbol", R.drawable.ic_stadium));
        datos.add(new Locale("17", "Complejo Deportivo Oscar R.Benavides", "La Victoria", "-12.062560", "-77.024949", "Academia de Basquetbol", R.drawable.ic_stadium));
        datos.add(new Locale("18", "Complejo Deportivo Oscar R.Benavides", "La Victoria", "-12.062560", "-77.024949", "Academia de Atletismo", R.drawable.ic_stadium));
        datos.add(new Locale("19", "Complejo Deportivo Oscar R.Benavides", "La Victoria", "-12.062560", "-77.024949", "Academia de Fútbol", R.drawable.ic_stadium));
        datos.add(new Locale("20", "Complejo Deportivo Oscar R.Benavides", "La Victoria", "-12.062560", "-77.024949", "Academia de Voleibol", R.drawable.ic_stadium));
        datos.add(new Locale("21", "Estadio Guadalupano", "Independencia", "-12.005576", "-77.064240", "Academia de Fútbol", R.drawable.ic_stadium));
        datos.add(new Locale("22", "Estadio Guadalupano", "Independencia", "-12.005576", "-77.064240", "Academia de Atletismo", R.drawable.ic_stadium));
        datos.add(new Locale("23", "Complejo Deportivo Matute", "La Victoria", "-12.071577", "-77.023051", "Academia de Basquetbol", R.drawable.ic_stadium));
        datos.add(new Locale("24", "Complejo Deportivo Matute", "La Victoria", "-12.071577", "-77.023051", "Academia de Futbol", R.drawable.ic_stadium));
        datos.add(new Locale("25", "Complejo Deportivo Matute", "La Victoria", "-12.071577", "-77.023051", "Academia de Gimnasia", R.drawable.ic_stadium));
        datos.add(new Locale("26", "Complejo Deportivo Matute", "La Victoria", "-12.071577", "-77.023051", "Academia de Natacion", R.drawable.ic_stadium));
        datos.add(new Locale("27", "Complejo Deportivo Matute", "La Victoria", "-12.071577", "-77.023051", "Academia de Voleibol", R.drawable.ic_stadium));
        datos.add(new Locale("28", "Complejo Deportivo Carabayllo", "Carabayllo", "-11.871402", "-77.013901", "Academia de Voleibol", R.drawable.ic_stadium));
        datos.add(new Locale("29", "Complejo Deportivo Carabayllo", "Carabayllo", "-11.871402", "-77.013901", "Academia de Atletismo", R.drawable.ic_stadium));
        datos.add(new Locale("30", "Complejo Deportivo Carabayllo", "Carabayllo", "-11.871402", "-77.013901", "Academia de Basquetbol", R.drawable.ic_stadium));
        datos.add(new Locale("31", "Complejo Deportivo Carabayllo", "Carabayllo", "-11.871402", "-77.013901", "Academia de Boxeo", R.drawable.ic_stadium));
        datos.add(new Locale("32", "Complejo Deportivo Carabayllo", "Carabayllo", "-11.871402", "-77.013901", "Academia de Futbol", R.drawable.ic_stadium));
        datos.add(new Locale("33", "Federación Deportiva Peruana De Tenis", "Jesús María", "-12.069133", "-77.042138", "Club de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("34", "Barco Leds sac", "Miraflores", "-12.097034", "-77.069482", "Polideportivo de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("35", "Complejo de Tenis Emusa", "Santiago de Surco", "-12.135589", "-76.978232", "Club de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("36", "Country Club El Bosque", "Santiago de Surco", "-12.084956", "-76.995536", "Club de Campo de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("37", "Centro Promotor de Tenis ", "Cercado de Lima", "-12.122571", "-77.040343", "Gimnasio", R.drawable.ic_stadium));
        datos.add(new Locale("38", "Tenis Academia Montecarlo", "Cercado de Lima", "-12.120211", "-76.982109", "Gimnasio", R.drawable.ic_stadium));

        datos.add(new Locale("39", "Lima Golf Club", "San Isidro", "-12.099640", "-77.047315", "Club de Golf", R.drawable.ic_stadium));
        datos.add(new Locale("40", "Top tennis", "Cercado de Lima", "-12.089384", "-76.972295", "Gimnasio", R.drawable.ic_stadium));
        datos.add(new Locale("41", "Academia de Tenis Alejo Aramburu", "Santiago de Surco", "-12.123143", "-76.979495", "Pista de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("42", "Tayouck Club Tenis", "Miraflores", "-12.116997", " -77.033754", "Centro deportivo de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("43", "Complejo Deportivo-Municipalidad de San Isidro ", "San Isidro", "-12.108109", "-77.054440", "Polideportivo de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("44", "Club de Tenis de Mesa Killspin", "San Juan de Lurigancho", "-11.991910", "-77.010695", "Club de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("45", "Zivni Tenis", "Jesús María", "-12.065982", "-77.038665", "Pista de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("46", "Matellini Tenis Chorrillos", "Lima", "-12.171490", "-77.005661", "Pista de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("47", "Academia de Tenis Patrick Baumeler", "Santiago de Surco", "-12.120109", "-76.982746", "Pista de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("48", "Villa Deportiva Regional del Callao", "Bellavista", "-12.062388", "-77.121116", "Club de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("49", "Tenis Perú", "Jesús María", "-12.068939", "-77.042117", "Club de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("50", "Federación Peruana de gimnasia", "Cercado de Lima", "-12.079968", "-77.002466", "Gimnasio", R.drawable.ic_stadium));
        datos.add(new Locale("51", "Club de Regatas Lima", "Chorrillos", "-12.166548", "-77.036483", "Club de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("52", "Club Terrazas de Miraflores", "Miraflores", "-12.126046", "-77.034005", "Club de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("53", "Federación Deportiva Peruana De Tenis", "Jesús María", "-12.069133", "-77.042138", "Club de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("54", "Barco Leds sac", "Miraflores", "-12.097034", "-77.069482", "Polideportivo de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("55", "Complejo de Tenis Emusa", "Santiago de Surco", "-12.135589", "-76.978232", "Club de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("56", "Country Club El Bosque", "Santiago de Surco", "-12.084956", "-76.995536", "Club de Campo de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("57", "Centro Promotor de Tenis ", "Cercado de Lima", "-12.122571", "-77.040343", "Gimnasio", R.drawable.ic_stadium));
        datos.add(new Locale("58", "Tenis Academia Montecarlo", "Cercado de Lima", "-12.120211", "-76.982109", "Gimnasio", R.drawable.ic_stadium));
        datos.add(new Locale("59", "Lima Golf Club", "San Isidro", "-12.099640", "-77.047315", "Club de Golf", R.drawable.ic_stadium));
        datos.add(new Locale("60", "Top tennis", "Cercado de Lima", "-12.089384", "-76.972295", "Gimnasio", R.drawable.ic_stadium));
        datos.add(new Locale("61", "Academia de Tenis Alejo Aramburu", "Santiago de Surco", "-12.123143", "-76.979495", "Pista de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("62", "Tayouck Club Tenis", "Miraflores", "-12.116997", "-77.033754", "Centro deportivo de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("63", "Complejo Deportivo-Municipalidad de San Isidro ", "San Isidro", "-12.108109", "-77.054440", "Polideportivo de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("64", "Club de Tenis de Mesa Killspin", "San Juan de Lurigancho", "-11.991910", "-77.010695", "Club de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("65", "Zivni Tenis", "Jesús María", "-12.065982", "-77.038665", "Pista de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("66", "Matellini Tenis Chorrillos", "Lima", "-12.171490", "-77.005661", "Pista de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("67", "Academia de Tenis Patrick Baumeler", "Santiago de Surco", "-12.120109", "-76.982746", "Pista de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("68", "Villa Deportiva Regional del Callao", "Bellavista", "-12.062388", "-77.121116", "Club de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("69", "Tenis Perú", "Jesús María", "-12.068939", "-77.042117", "Club de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("70", "Federación Peruana de gimnasia", "Cercado de Lima", "-12.079968", "-77.002466", "Gimnasio", R.drawable.ic_stadium));
        datos.add(new Locale("71", "Club de Regatas Lima", "Chorrillos", "-12.166548", "-77.036483", "Club de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("72", "Club Terrazas de Miraflores", "Miraflores", "-12.126046", "-77.034005", "Club de Tenis", R.drawable.ic_stadium));
        datos.add(new Locale("73", "Club Regatas", "Chorrillos", "-12.165863", "-77.031786", "Academia de basquet", R.drawable.ic_stadium));
        datos.add(new Locale("74", "Club Regatas", "Chorrillos", "-12.165873", "-77.031796", "Academia de Squash", R.drawable.ic_stadium));
        datos.add(new Locale("75", "Club Regatas", "Chorrillos", "-12.165883", "-77.031806", "Academia de Voleibol", R.drawable.ic_stadium));
        datos.add(new Locale("76", "Club Regatas", "Chorrillos", "-12.165893", "-77.035716", "Academia de Badminton", R.drawable.ic_stadium));
        datos.add(new Locale("77", "Club Regatas", "Chorrillos", "-12.165803", "-77.032726", "Academia de natación", R.drawable.ic_stadium));
        datos.add(new Locale("78", "Club Regatas", "Chorrillos", "-12.165813", "-77.031736", "Academia de Paleta fronton", R.drawable.ic_stadium));
        datos.add(new Locale("79", "Club Regatas", "Chorrillos", "-12.165823", "-77.036746", "Academia de tenis", R.drawable.ic_stadium));
        datos.add(new Locale("80", "Club Regatas", "Chorrillos", "-12.165833", "-77.031756", "Academia de fulbito", R.drawable.ic_stadium));
        datos.add(new Locale("81", "Club Regatas", "Chorrillos", "-12.165843", "-77.033766", "Academia de Karate", R.drawable.ic_stadium));
        datos.add(new Locale("82", "Club Regatas", "Chorrillos", "-12.165853", "-77.031776", "Academia de judo", R.drawable.ic_stadium));
        datos.add(new Locale("83", "Club Regatas", "Chorrillos", "-12.165963", "-77.036786", "Academia de tennis de mesa", R.drawable.ic_stadium));
        datos.add(new Locale("84", "Club Regatas", "Chorrillos", "-12.165063", "-77.031886", "Academia de gimnasia", R.drawable.ic_stadium));
        datos.add(new Locale("85", "Club Regatas", "Chorrillos", "-12.165163", "-77.038986", "Academia de remo", R.drawable.ic_stadium));
        datos.add(new Locale("86", "Club Regatas", "Chorrillos", "-12.165205", "-77.033047", "Academia de basquet", R.drawable.ic_stadium));
        datos.add(new Locale("87", "Club Regatas", "Chorrillos", "-12.165305", "-77.039147", "Academia de Squash", R.drawable.ic_stadium));
        datos.add(new Locale("88", "Club Regatas", "Chorrillos", "-12.165405", "-77.033247", "Academia de Voleibol", R.drawable.ic_stadium));
        datos.add(new Locale("89", "Club Regatas", "Chorrillos", "-12.165505", "-77.032347", "Academia de Badminton", R.drawable.ic_stadium));
        datos.add(new Locale("90", "Club Regatas", "Chorrillos", "-12.165605", "-77.031447", "Academia de natación", R.drawable.ic_stadium));
        datos.add(new Locale("91", "Club Regatas", "La Punta", "-12.06913", "-77.161646", "Academia de remo", R.drawable.ic_stadium));

        showMarkers(datos);
    }

    private void addItems(ArrayList<Locale> items) {
        mClusterManager.addItems(items);
    }

}

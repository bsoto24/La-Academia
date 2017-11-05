package com.openlab.perusemide_tecnico.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.openlab.perusemide_tecnico.R;
import com.openlab.perusemide_tecnico.adapter.EventoAdapter;
import com.openlab.perusemide_tecnico.entity.Evento;
import com.toptoche.searchablespinnerlibrary.SearchableListDialog;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;

public class EventosActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    private SearchableSpinner spnDeporte;
    private RecyclerView rvEventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        showToolbar("Eventos", true);

        spnDeporte = (SearchableSpinner) findViewById(R.id.spn_deporte);
        rvEventos = (RecyclerView) findViewById(R.id.rv_eventos);

        rvEventos.setLayoutManager(new LinearLayoutManager(this));
        rvEventos.setAdapter(new EventoAdapter(this, getData()));

        List<String> deportes = new ArrayList<>();
        deportes.add("Futbol");
        deportes.add("Basket");
        deportes.add("Tenis");
        deportes.add("Fulbito");
        deportes.add("Karate");
        deportes.add("Judo");
        deportes.add("Boxeo");
        deportes.add("Atletismo");
        deportes.add("Natacion");
        deportes.add("Voley");
        deportes.add("Badminton");

        spnDeporte.setTitle("Selecciona un deporte");
        spnDeporte.setPositiveButton("OK");

        ArrayAdapter<String> deporteAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, deportes);
        deporteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDeporte.setAdapter(deporteAdapter);

    }

    private ArrayList<Evento> getData() {
        ArrayList<Evento> eventos = new ArrayList<>();
        eventos.add(new Evento("Curso de natación sub 10", "Natación", "Noviembre 09", "Estadio Nacional puerta Nº 8", R.drawable.natacion));
        eventos.add(new Evento("Taler judo sub 12", "Judo", "Noviembre 16", "Estadio Nacional puerta Nº 4", R.drawable.judo));
        eventos.add(new Evento("Curso de voley damas sub 14", "Voley", "Noviembre 21", "Coliseo Dibós", R.drawable.voley));
        return eventos;
    }

    public void showToolbar(String title, boolean upButton) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}

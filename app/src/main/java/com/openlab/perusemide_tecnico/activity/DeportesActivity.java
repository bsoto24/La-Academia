package com.openlab.perusemide_tecnico.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;

import com.openlab.perusemide_tecnico.R;
import com.openlab.perusemide_tecnico.adapter.DeporteAdapter;
import com.openlab.perusemide_tecnico.entity.Deporte;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.ArrayList;
import java.util.List;

public class DeportesActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    private SearchableSpinner spnDeporte;
    private RecyclerView rvDeportes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deportes);
        showToolbar("Deportes", true);

        spnDeporte = (SearchableSpinner) findViewById(R.id.spn_deporte);
        rvDeportes = (RecyclerView) findViewById(R.id.rv_deportes);

        rvDeportes.setLayoutManager(new GridLayoutManager(this, 2));
        rvDeportes.setAdapter(new DeporteAdapter(this, getData()));

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

    private ArrayList<Deporte> getData() {
        ArrayList<Deporte> deportes = new ArrayList<>();
        deportes.add(new Deporte("Voley", "", R.drawable.voley));
        deportes.add(new Deporte("Basket", "", R.drawable.basket));
        deportes.add(new Deporte("Judo", "", R.drawable.judo));
        deportes.add(new Deporte("Karate", "", R.drawable.karate));
        deportes.add(new Deporte("Natación", "", R.drawable.natacion));
        deportes.add(new Deporte("Atletismo", "", R.drawable.noti1));
        deportes.add(new Deporte("badminton", "", R.drawable.badminton));
        deportes.add(new Deporte("Tenis", "", R.drawable.tenis));
        deportes.add(new Deporte("Boxeo", "", R.drawable.boxeo));
        deportes.add(new Deporte("Futbol", "", R.drawable.futbol));
        deportes.add(new Deporte("Rugby", "", R.drawable.rugby));
        deportes.add(new Deporte("Maraton", "", R.drawable.maraton));

        return deportes;
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

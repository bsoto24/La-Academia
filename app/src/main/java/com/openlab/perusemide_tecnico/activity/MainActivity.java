package com.openlab.perusemide_tecnico.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.openlab.perusemide_tecnico.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showToolbar("La Academia", false);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        Intent intent = null;
        boolean flag = false;

        switch (item.getItemId()) {
            case R.id.nav_perfil:
                intent = new Intent(MainActivity.this, PerfilActivity.class);
                flag = true;
                break;
            case R.id.nav_beneficiarios:
                intent = new Intent(MainActivity.this, BeneficiariosActivity.class);
                flag = true;
                break;
            case R.id.nav_eventos:
                intent = new Intent(MainActivity.this, EventosActivity.class);
                flag = true;
                break;
            case R.id.nav_deportes:
                intent = new Intent(MainActivity.this, DeportesActivity.class);
                flag = true;
                break;
            case R.id.nav_complejos_deportivos:
                intent = new Intent(MainActivity.this, MapsActivity.class);
                flag = true;
                break;
            case R.id.nav_config:
                intent = new Intent(MainActivity.this, ConfiguracionActivity.class);
                flag = true;
                break;
            case R.id.nav_logout:
                intent = new Intent(MainActivity.this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                flag = true;
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        if (flag) {
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
        return true;
    }

    public void showToolbar(String title, boolean upButton) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}

package com.openlab.perusemide_tecnico.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.openlab.perusemide_tecnico.R;

public class InscripcionExitosaActivity extends AppCompatActivity {

    private Button btnListo;
    private FloatingActionButton fabDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscripcion_exitosa);

        btnListo = (Button) findViewById(R.id.btn_listo);
        fabDownload = (FloatingActionButton) findViewById(R.id.fab_download);

        fabDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Descargando DDJJ.pdf", Snackbar.LENGTH_SHORT).show();
            }
        });

        btnListo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InscripcionExitosaActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

    }
}

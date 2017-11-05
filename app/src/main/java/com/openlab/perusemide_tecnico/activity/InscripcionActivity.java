package com.openlab.perusemide_tecnico.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;

import com.openlab.perusemide_tecnico.R;

public class InscripcionActivity extends AppCompatActivity {

    private CardView cvBoy, cvGirl;
    private View viewBoy, viewGirl;
    private Button btnInscribirse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscripcion);


        cvBoy = (CardView) findViewById(R.id.cv_boy);
        cvGirl = (CardView) findViewById(R.id.cv_girl);
        viewBoy = (View) findViewById(R.id.view_boy);
        viewGirl = (View) findViewById(R.id.view_girl);

        btnInscribirse = (Button) findViewById(R.id.btn_incribirse);

        btnInscribirse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InscripcionActivity.this, InscripcionExitosaActivity.class);
                startActivity(intent);

            }
        });


        cvBoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewBoy.setVisibility(View.VISIBLE);
                viewGirl.setVisibility(View.GONE);
            }
        });

        cvGirl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewGirl.setVisibility(View.VISIBLE);
                viewBoy.setVisibility(View.GONE);
            }
        });

    }
}

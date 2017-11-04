package com.openlab.perusemide_tecnico.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.openlab.perusemide_tecnico.R;
import com.openlab.perusemide_tecnico.fragment.TutorialFragment;

/**
 * Created by Bryam Soto on 04/11/2017.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    protected static final String[] TITULO = new String[]{"Circuito deportivo", "Captación del talento", "Formación deportiva"};
    protected static final String[] DESCRIPCION = new String[]{"Es la fase donde   los participantes se inician en la actividad física y el deporte, debiendo pasar por esta etapa para recibir aprestamiento motor, donde los profesores brindan una enseñanza lúdica", "Mientras el participante se encuentre en el circuito deportivo, un equipo de scouts o cazatalentos se encargará de evaluar distintos aspectos motores, físicos y psicológicos del participante", "Esta etapa consiste en la enseñanza de un deporte específico con una carga horaria mayor (1 1/2 horas) durante 5 días a la semana, con el objetivo de desarrollar de la mejor manera al participante"};
    protected static final int[] IMAGEN = new int[]{R.drawable.circuito_deportivo, R.drawable.capacitacion_talento, R.drawable.formacion_deportiva};

    private int mCount = TITULO.length;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new TutorialFragment(IMAGEN[position], TITULO[position], DESCRIPCION[position]);
    }

    @Override
    public int getCount() {
        return mCount;
    }

}

package com.openlab.perusemide_tecnico.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.openlab.perusemide_tecnico.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.listener.PieChartOnValueSelectListener;
import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class BeneficiarioActivity extends AppCompatActivity {

    private PieChartView pieChart;
    private PieChartData data;
    private boolean hasLabels = false;
    private boolean hasLabelsOutside = true;
    private boolean hasLabelForSelected = true;
    private int correctas = 10, incorrectas = 2, no_respondidas = 3;

    private TextView tvCorrecta, tvIncorrecta, tvNoRespondida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beneficiario);

        pieChart = (PieChartView) findViewById(R.id.chart);

        pieChart.setOnValueTouchListener(new BeneficiarioActivity.ValueTouchListener());
        toggleLabels();
        generateData();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private class ValueTouchListener implements PieChartOnValueSelectListener {

        @Override
        public void onValueSelected(int arcIndex, SliceValue value) {

        }

        @Override
        public void onValueDeselected() {

        }
    }

    private void toggleLabels() {
        hasLabels = !hasLabels;
        if (hasLabels) {
            hasLabelForSelected = false;
            pieChart.setValueSelectionEnabled(hasLabelForSelected);
            if (hasLabelsOutside) {
                pieChart.setCircleFillRatio(0.7f);
            } else {
                pieChart.setCircleFillRatio(1.0f);
            }
        }
        generateData();
    }

    private void generateData() {
        List<SliceValue> values = new ArrayList<>();
        if (correctas > 0) {
            SliceValue sliceValueBuenas = new SliceValue((float) correctas, getResources().getColor(R.color.verde_ipd));
            values.add(sliceValueBuenas);
        }
        if (incorrectas > 0) {
            SliceValue sliceValueMalas = new SliceValue((float) incorrectas, getResources().getColor(R.color.naranja_ipd));
            values.add(sliceValueMalas);
        }
        if (no_respondidas > 0) {
            SliceValue sliceValueNoRespondidas = new SliceValue((float) no_respondidas, getResources().getColor(R.color.amarillo_ipd));
            values.add(sliceValueNoRespondidas);
        }
        data = new PieChartData(values);
        data.setHasLabels(hasLabels); // Muesta el valor de la particion
        pieChart.setPieChartData(data);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Intent intent = new Intent(BeneficiarioActivity.this, DetalleBeneficiarioActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }

    }

}

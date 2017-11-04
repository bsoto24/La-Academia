package com.openlab.perusemide_tecnico.activity;

import android.content.res.Configuration;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openlab.perusemide_tecnico.R;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.listener.ColumnChartOnValueSelectListener;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Column;
import lecho.lib.hellocharts.model.ColumnChartData;
import lecho.lib.hellocharts.model.SubcolumnValue;
import lecho.lib.hellocharts.view.ColumnChartView;

public class DetalleBeneficiarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_beneficiario);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }
    }

    /**
     * A fragment containing a column chart.
     */
    public static class PlaceholderFragment extends Fragment {

        private ColumnChartView chart;
        private ColumnChartData data;
        private boolean hasAxes = false;
        private boolean hasAxesNames = false;
        private boolean hasLabels = true;
        private boolean hasLabelForSelected = false;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            setHasOptionsMenu(true);
            View rootView = inflater.inflate(R.layout.fragment_column_chart, container, false);

            chart = (ColumnChartView) rootView.findViewById(R.id.chart);
            chart.setOnValueTouchListener(new ValueTouchListener());

            generateData();

            return rootView;
        }

        private void generateDefaultData() {

            List<Column> columns = new ArrayList<Column>();
            List<SubcolumnValue> values1 = new ArrayList<SubcolumnValue>();
            SubcolumnValue subcol1 = new SubcolumnValue(10, ContextCompat.getColor(getContext(), R.color.turquesa_ipd));
            values1.add(subcol1);
            Column column1 = new Column(values1);
            column1.setHasLabels(hasLabels);
            column1.setHasLabelsOnlyForSelected(hasLabelForSelected);

            columns.add(column1);

            List<SubcolumnValue> values2 = new ArrayList<SubcolumnValue>();
            SubcolumnValue subcol2 = new SubcolumnValue(15, ContextCompat.getColor(getContext(), R.color.amarillo_ipd));
            values1.add(subcol2);
            Column column2 = new Column(values2);
            column2.setHasLabels(hasLabels);
            column2.setHasLabelsOnlyForSelected(hasLabelForSelected);

            columns.add(column2);


            List<SubcolumnValue> values3 = new ArrayList<SubcolumnValue>();
            SubcolumnValue subcol3 = new SubcolumnValue(25, ContextCompat.getColor(getContext(), R.color.naranja_ipd));
            values1.add(subcol3);
            Column column3 = new Column(values3);
            column3.setHasLabels(hasLabels);
            column3.setHasLabelsOnlyForSelected(hasLabelForSelected);

            columns.add(column3);

            List<SubcolumnValue> values4 = new ArrayList<SubcolumnValue>();
            SubcolumnValue subcol4 = new SubcolumnValue(30, ContextCompat.getColor(getContext(), R.color.verde_ipd));
            values1.add(subcol4);
            Column column4 = new Column(values4);
            column4.setHasLabels(hasLabels);
            column4.setHasLabelsOnlyForSelected(hasLabelForSelected);

            columns.add(column4);

            List<SubcolumnValue> values5 = new ArrayList<SubcolumnValue>();
            SubcolumnValue subcol5 = new SubcolumnValue(40, ContextCompat.getColor(getContext(), R.color.morado_ipd));
            values1.add(subcol5);
            Column column5 = new Column(values5);
            column5.setHasLabels(hasLabels);
            column5.setHasLabelsOnlyForSelected(hasLabelForSelected);

            columns.add(column5);

            data = new ColumnChartData(columns);

            if (hasAxes) {
                Axis axisX = new Axis();
                Axis axisY = new Axis().setHasLines(true);
                if (hasAxesNames) {
                    axisX.setName("Deportes");
                    axisY.setName("Aptitudes");
                }

                data.setAxisXBottom(axisX);
                data.setAxisYLeft(axisY);
            } else {
                data.setAxisXBottom(null);
                data.setAxisYLeft(null);
            }

            chart.setColumnChartData(data);

        }

        private void generateData() {
            generateDefaultData();
        }

        private class ValueTouchListener implements ColumnChartOnValueSelectListener {

            @Override
            public void onValueSelected(int columnIndex, int subcolumnIndex, SubcolumnValue value) {
            }

            @Override
            public void onValueDeselected() {
            }

        }

    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            finish();
        }

    }

    @Override
    public void onBackPressed() {
        Snackbar.make(this.findViewById(R.id.container), "Gire el dispositivo", Snackbar.LENGTH_SHORT).show();
    }

}

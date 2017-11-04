package com.openlab.perusemide_tecnico.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.openlab.perusemide_tecnico.adapter.FragmentAdapter;
import com.openlab.perusemide_tecnico.R;
import com.pixelcan.inkpageindicator.InkPageIndicator;

public class TutorialActivity extends AppCompatActivity {


    FragmentAdapter mAdapter;
    ViewPager mPager;
    InkPageIndicator mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);


        mAdapter = new FragmentAdapter(getSupportFragmentManager());

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        mIndicator = (InkPageIndicator) findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
    }
}

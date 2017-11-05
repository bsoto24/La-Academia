package com.openlab.perusemide_tecnico.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.openlab.perusemide_tecnico.R;
import com.openlab.perusemide_tecnico.activity.DeporteActivity;
import com.openlab.perusemide_tecnico.activity.EventoActivity;
import com.openlab.perusemide_tecnico.entity.Deporte;

import java.util.ArrayList;

/**
 * Created by Bryam Soto on 04/11/2017.
 */

public class DeporteAdapter extends RecyclerView.Adapter<DeporteAdapter.DeporteVH> {

    private Activity activity;
    private ArrayList<Deporte> deportes;

    public DeporteAdapter(Activity activity, ArrayList<Deporte> deportes) {
        this.activity = activity;
        this.deportes = deportes;
    }

    @Override
    public DeporteVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DeporteVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_deporte, parent, false));
    }

    @Override
    public void onBindViewHolder(DeporteVH holder, int position) {
        Deporte deporte = deportes.get(position);
        holder.tvTitulo.setText(deporte.getDeporte());
        holder.imgDeporte.setImageResource(deporte.getImagen());

    }

    @Override
    public int getItemCount() {
        return deportes.size();
    }

    public class DeporteVH extends RecyclerView.ViewHolder {

        private TextView tvTitulo;
        private ImageView imgDeporte;

        public DeporteVH(View itemView) {
            super(itemView);

            tvTitulo = (TextView) itemView.findViewById(R.id.tv_titulo);
            imgDeporte = (ImageView) itemView.findViewById(R.id.img_deporte);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity, DeporteActivity.class);
                    activity.startActivity(intent);
                }
            });
        }
    }


}

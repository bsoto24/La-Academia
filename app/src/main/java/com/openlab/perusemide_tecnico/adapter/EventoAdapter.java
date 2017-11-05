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
import com.openlab.perusemide_tecnico.activity.EventoActivity;
import com.openlab.perusemide_tecnico.activity.EventosActivity;
import com.openlab.perusemide_tecnico.activity.InscripcionActivity;
import com.openlab.perusemide_tecnico.entity.Evento;

import java.util.ArrayList;

/**
 * Created by Bryam Soto on 04/11/2017.
 */

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.EventoVH> {

    private Activity activity;
    private ArrayList<Evento> eventos;

    public EventoAdapter(Activity activity, ArrayList<Evento> eventos) {
        this.activity = activity;
        this.eventos = eventos;
    }

    @Override
    public EventoVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EventoVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_evento, parent, false));
    }

    @Override
    public void onBindViewHolder(EventoVH holder, int position) {

        Evento evento = eventos.get(position);

        holder.tvTitulo.setText(evento.getTitulo());
        holder.tvDeporte.setText(evento.getDeporte());
        holder.tvFecha.setText(evento.getFecha());
        holder.tvLugar.setText(evento.getLugar());
        holder.imgEvento.setImageResource(evento.getImagen());

    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }

    public class EventoVH extends RecyclerView.ViewHolder {

        TextView tvTitulo, tvDeporte, tvFecha, tvLugar;
        ImageView imgEvento;

        public EventoVH(View itemView) {
            super(itemView);

            tvTitulo = (TextView) itemView.findViewById(R.id.tv_titulo);
            tvDeporte = (TextView) itemView.findViewById(R.id.tv_deporte);
            tvFecha = (TextView) itemView.findViewById(R.id.tv_fecha);
            tvLugar = (TextView) itemView.findViewById(R.id.tv_lugar);
            imgEvento = (ImageView) itemView.findViewById(R.id.img_evento);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity, EventoActivity.class);
                    activity.startActivity(intent);
                }
            });
        }


    }
}

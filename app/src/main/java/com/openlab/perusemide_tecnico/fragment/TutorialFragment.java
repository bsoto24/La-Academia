package com.openlab.perusemide_tecnico.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.openlab.perusemide_tecnico.R;
import com.openlab.perusemide_tecnico.activity.MainActivity;
import com.squareup.picasso.Picasso;

public class TutorialFragment extends Fragment {

    private int imagen;
    private String titulo, descripcion;

    public TutorialFragment() {

    }

    @SuppressLint("ValidFragment")
    public TutorialFragment(int imagen, String titulo, String descripcion) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tuto, container, false);

        TextView tvTitulo = (TextView) view.findViewById(R.id.tv_titulo);
        TextView tvDescripcion = (TextView) view.findViewById(R.id.tv_descripcion);
        ImageView imgTuto = (ImageView) view.findViewById(R.id.img_tuto);

        tvTitulo.setText(titulo);
        tvDescripcion.setText(descripcion);
        Picasso.with(getContext()).load(imagen).into(imgTuto);

        if (titulo.equals("Formación deportiva")) {
            Button btnEntendido = (Button) view.findViewById(R.id.btn_entendido);
            btnEntendido.setVisibility(View.VISIBLE);
            btnEntendido.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    getActivity().finish();
                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            });
        }

        return view;
    }
}

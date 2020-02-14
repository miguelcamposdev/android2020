package com.miguelcr.a20_marcadorbaloncesto;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MarcadorEquipoBFragment extends Fragment {
    TextView tvMarcador;
    Button btnOnePoint, btnTwoPoints, btnThreePoints;
    MarcadorViewModel marcadorViewModel;

    public MarcadorEquipoBFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_marcador_equipo_b, container, false);

        marcadorViewModel = new ViewModelProvider(getActivity()).get(MarcadorViewModel.class);

        tvMarcador = v.findViewById(R.id.team_b_score);
        btnOnePoint = v.findViewById(R.id.btn_add_one_point);
        btnTwoPoints = v.findViewById(R.id.btn_add_two_points);
        btnThreePoints = v.findViewById(R.id.btn_add_three_points);

        btnOnePoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marcadorViewModel.incrementarPuntuacionEquipoB(1);
            }
        });

        btnTwoPoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marcadorViewModel.incrementarPuntuacionEquipoB(2);
            }
        });

        btnThreePoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                marcadorViewModel.incrementarPuntuacionEquipoB(3);
            }
        });

        // Declaro el observer para saber cuándo cambia el marcador
        marcadorViewModel.getPuntuacionEquipoB().observe(getActivity(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tvMarcador.setText(String.valueOf(integer));
            }
        });

        return v;
    }

}

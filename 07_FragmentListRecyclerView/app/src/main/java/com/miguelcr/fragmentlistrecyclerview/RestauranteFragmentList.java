package com.miguelcr.fragmentlistrecyclerview;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miguelcr.fragmentlistrecyclerview.dummy.DummyContent;

import java.util.ArrayList;
import java.util.List;

public class RestauranteFragmentList extends Fragment {


    private int mColumnCount = 2;
    private IRestauranteListener mListener;
    private MyRestauranteRecyclerViewAdapter adapter;
    private List<Restaurante> restauranteList;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestauranteFragmentList() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_restaurante_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();

            RecyclerView recyclerView = (RecyclerView) view;

            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            restauranteList = new ArrayList<>();
            restauranteList.add(new Restaurante("Goiko Grill","https://static2.ideal.es/www/multimedia/201803/02/media/cortadas/GOIKO-kxhG--624x385@Ideal.jpg",3.0f,"Avda. República Argentina, 22, Sevilla","954112233"));
            restauranteList.add(new Restaurante("Goiko Grill","https://static2.ideal.es/www/multimedia/201803/02/media/cortadas/GOIKO-kxhG--624x385@Ideal.jpg",3.0f,"Avda. República Argentina, 22, Sevilla","954112233"));
            restauranteList.add(new Restaurante("Goiko Grill","https://static2.ideal.es/www/multimedia/201803/02/media/cortadas/GOIKO-kxhG--624x385@Ideal.jpg",3.0f,"Avda. República Argentina, 22, Sevilla","954112233"));

            adapter = new MyRestauranteRecyclerViewAdapter(
                    context,
                    R.layout.fragment_restaurante,
                    restauranteList);

            recyclerView.setAdapter(adapter);
        }

        return view;
    }

    // Recibo por parámetro el Activity donde he insertado el
    // fragmento (objeto context)

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IRestauranteListener) {
            mListener = (IRestauranteListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " el Activity no implementa la interface IRestauranteListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}

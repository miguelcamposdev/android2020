package com.miguelcr.a11_tabnavigation;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.miguelcr.a11_tabnavigation.interfaces.IUsuarioListener;
import com.miguelcr.a11_tabnavigation.models.Usuario;

import java.util.ArrayList;
import java.util.List;


public class UsuariosFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private IUsuarioListener mListener;
    private List<Usuario> usuarioList;
    private MyUsuariosRecyclerViewAdapter adapter;
    private RecyclerView recyclerView;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public UsuariosFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static UsuariosFragment newInstance(int columnCount) {
        UsuariosFragment fragment = new UsuariosFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_usuarios_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            // AsyncTask....
            usuarioList = new ArrayList<>();
            usuarioList.add(new Usuario("Pepe","https://s3.amazonaws.com/uifaces/faces/twitter/jsa/128.jpg"));
            usuarioList.add(new Usuario("Juan","https://s3.amazonaws.com/uifaces/faces/twitter/jsa/128.jpg"));
            usuarioList.add(new Usuario("María","https://s3.amazonaws.com/uifaces/faces/twitter/jsa/128.jpg"));
            usuarioList.add(new Usuario("Manolo","https://s3.amazonaws.com/uifaces/faces/twitter/jsa/128.jpg"));
            usuarioList.add(new Usuario("Manuela","https://s3.amazonaws.com/uifaces/faces/twitter/jsa/128.jpg"));


            adapter = new MyUsuariosRecyclerViewAdapter(getActivity(), usuarioList, mListener);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IUsuarioListener) {
            mListener = (IUsuarioListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement IUsuarioListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}

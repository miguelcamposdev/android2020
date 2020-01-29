package com.miguelcr.a14_recyclercasiexamen;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FootballPlayerFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    IFootballPlayerListener mListener;
    List<FootballPlayer> footballPlayerList;
    MyFootballPlayerRecyclerViewAdapter adapter;

    public FootballPlayerFragment() {
    }

    @SuppressWarnings("unused")
    public static FootballPlayerFragment newInstance(int columnCount) {
        FootballPlayerFragment fragment = new FootballPlayerFragment();
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
        View view = inflater.inflate(R.layout.fragment_footballplayer_list, container, false);

        footballPlayerList = new ArrayList<>();
        footballPlayerList.add(new FootballPlayer("Ronaldo","https://www.culemania.com/uploads/s1/72/94/10/0/637090249974632843.jpeg",10));
        footballPlayerList.add(new FootballPlayer("Messi","https://cadenaser00.epimg.net/ser/imagenes/2020/01/27/el_larguero/1580084180_076148_1580084809_miniatura_normal.jpg",3));
        footballPlayerList.add(new FootballPlayer("Pogba","https://www.culemania.com/uploads/s1/72/94/10/0/637090249974632843.jpeg",5));
        footballPlayerList.add(new FootballPlayer("Zubizarreta","https://www.culemania.com/uploads/s1/72/94/10/0/637090249974632843.jpeg",40));
        footballPlayerList.add(new FootballPlayer("Joaquín","https://www.culemania.com/uploads/s1/72/94/10/0/637090249974632843.jpeg",3));

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            adapter = new MyFootballPlayerRecyclerViewAdapter(
                    getActivity(),
                    footballPlayerList,
                    mListener
            );

            recyclerView.setAdapter(adapter);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IFootballPlayerListener) {
            mListener = (IFootballPlayerListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement IFootballPlayerListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


}

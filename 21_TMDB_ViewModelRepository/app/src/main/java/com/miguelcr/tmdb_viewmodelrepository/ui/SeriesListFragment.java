package com.miguelcr.tmdb_viewmodelrepository.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.miguelcr.tmdb_viewmodelrepository.R;
import com.miguelcr.tmdb_viewmodelrepository.models.Series;
import com.miguelcr.tmdb_viewmodelrepository.viewmodel.SeriesViewModel;

import java.util.List;

public class SeriesListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;
    private SeriesViewModel seriesViewModel;
    MySeriesRecyclerViewAdapter adapter;
    RecyclerView recyclerView;
    Observer<List<Series>> observer;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SeriesListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static SeriesListFragment newInstance(int columnCount) {
        SeriesListFragment fragment = new SeriesListFragment();
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

        seriesViewModel = new ViewModelProvider(getActivity()).get(SeriesViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_series_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();

            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            observer = new Observer<List<Series>>() {
                @Override
                public void onChanged(List<Series> series) {
                    adapter = new MySeriesRecyclerViewAdapter(
                            getActivity(),
                            series,
                            seriesViewModel //TODO IMPORTANTE: debemos pasarle al Adapter el ViewModel
                    );
                    recyclerView.setAdapter(adapter);
                }
            };

            seriesViewModel.getSeries().observe(getActivity(), observer);
        }
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity(), "onResume()", Toast.LENGTH_SHORT).show();

        //TODO IMPORTANTE
        seriesViewModel.getSeries().removeObserver(observer);

        seriesViewModel.getSeries().observe(getActivity(), new Observer<List<Series>>() {
            @Override
            public void onChanged(List<Series> series) {
                adapter.setData(series);
                recyclerView.setAdapter(adapter);
            }
        });

    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getActivity(), "onPause()", Toast.LENGTH_SHORT).show();
    }


}

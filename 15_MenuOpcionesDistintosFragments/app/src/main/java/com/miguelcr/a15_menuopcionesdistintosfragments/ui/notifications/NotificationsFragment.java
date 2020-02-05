package com.miguelcr.a15_menuopcionesdistintosfragments.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.miguelcr.a15_menuopcionesdistintosfragments.R;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    boolean ordenAsc = true;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        notificationsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // ATENCIÓN ESTE FRAGMENT TIENE UN MENÚ ADICIONAL DE OPCIONES
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_opciones_ranking, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_order_ranking:
                if(ordenAsc) {
                    item.setIcon(R.drawable.ic_dashboard_black_24dp);
                } else {
                    item.setIcon(R.drawable.ic_home_black_24dp);
                }
                ordenAsc = !ordenAsc;
                //TODO orederRanking();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
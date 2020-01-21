package com.miguelcr.a09_calendarinput;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ISeleccionarFechaListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mostrarCalendario(View view) {
        DialogFragment newFragment = DialogoFechaFragment.newInstance(this);
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    @Override
    public void onFechaSeleccionada(int year, int month, int day) {
        Toast.makeText(this, "año: " + year + "mes: " + "dia: " + day, Toast.LENGTH_SHORT).show();
    }
}

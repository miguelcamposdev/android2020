package com.miguelcr.a09_calendarinput;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DialogoFechaFragment  extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {
        static ISeleccionarFechaListener i;

        static DialogoFechaFragment newInstance(Activity activity) {
            i = (ISeleccionarFechaListener) activity;
            return new DialogoFechaFragment();
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            i.onFechaSeleccionada(year, month, day);
        }
}

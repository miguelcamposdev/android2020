package com.miguelcr.a13_dialogfragmentform;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class NuevoAlumnoDialogFragment extends DialogFragment {
    View v;
    EditText etNombre, etEdad;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Configura el dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Configuración del diálogo

        builder.setTitle("Nuevo alumno");
        builder.setMessage("Introduza los datos del nuevo alumno");

        // Hacer que el diálogo sólo se pueda cerrar desde el botón
        // Cancelar o Guardar
        builder.setCancelable(true);

        // Cargar el layout del formulario
        v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_nuevo_alumno, null);
        builder.setView(v);

        // Rescatar una referencia a cada View del layout
        etNombre = v.findViewById(R.id.editTextNombreAlumno);
        etEdad = v.findViewById(R.id.editTextEdadAlumno);

        builder.setPositiveButton(R.string.button_guardar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Guardar alumno

                String nombre = etNombre.getText().toString();
                String edadString = etEdad.getText().toString();

                if(nombre.isEmpty() || edadString.isEmpty()) {
                    if(nombre.isEmpty()) {
                        etNombre.setError("Escribe aquí un nombre hijo");
                    }

                    if(nombre.isEmpty()) {
                        etEdad.setError("Escribe la edad del alumno");
                    }

                } else {
                    //TODO: Falta utilizar Firebase para guardar el nuevo alumno

                    int edad = Integer.parseInt(etEdad.getText().toString());
                    Toast.makeText(getActivity(), "", Toast.LENGTH_SHORT).show();
                    // IMPORTANTE cerrar el diálogo
                    dialog.dismiss();
                }


            }
        });

        builder.setNegativeButton(R.string.button_cancelar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Cancelar diálogo
                dialog.dismiss();
            }
        });

        // Create the AlertDialog object and return it

        return builder.create();
    }
}

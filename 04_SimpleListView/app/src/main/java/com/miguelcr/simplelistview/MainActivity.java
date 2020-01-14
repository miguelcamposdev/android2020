package com.miguelcr.simplelistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lvAlumnos;
    List<String> alumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. obtenemos una referencia al ListView de la IU
        lvAlumnos = findViewById(R.id.listViewAlumnos);

        // 2. Defino la lista de alumnos con los datos a mostrar
        alumnos = new ArrayList<>();
        alumnos.add("Juanma");
        alumnos.add("Álvaro");
        alumnos.add("Miguel");
        alumnos.add("José Luis");
        alumnos.add("Lucas");
        alumnos.add("Daniel Leiva");
        alumnos.add("Ricardo");
        alumnos.add("Terrero");
        alumnos.add("Víctor");
        alumnos.add("Gonzalo");
        alumnos.add("Esperanza");
        alumnos.add("Alberto");
        alumnos.add("José Miguel");
        alumnos.add("D. Troncoso");
        alumnos.add("Pablo");
        alumnos.add("Alejandro");
        alumnos.add("Daniel S.");
        alumnos.add("Antonio");
        alumnos.add("José María");
        alumnos.add("J.A. Llamas");
        alumnos.add("Bargueño");
        alumnos.add("Ceacero");

        // 3. Adapter
        // ListView <<<<< Adapter >>>>>> List<String>
        // alumnos[0] >>> Juanma  >>> [ layouts/plantilla_alumno.xml ] >>> TextView
        // alumnos[1] >>> Álvaro  >>> [ layouts/plantilla_alumno.xml ] >>> TextView
        // ...

        ArrayAdapter adaptadorAlumnos = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alumnos);

        // 4. Conectar ese Adapter al ListView
        lvAlumnos.setAdapter(adaptadorAlumnos);

        // 5. Gestión eventos click
        lvAlumnos.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Alumno: " + alumnos.get(position), Toast.LENGTH_SHORT).show();
    }
}

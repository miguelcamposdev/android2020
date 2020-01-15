package com.miguelcr.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lvAlumnos;
    List<Alumno> alumnos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvAlumnos = findViewById(R.id.listViewAlumnos);

        alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Pepito","https://s3.amazonaws.com/uifaces/faces/twitter/jsa/128.jpg", 18));
        alumnos.add(new Alumno("Fulanito","https://s3.amazonaws.com/uifaces/faces/twitter/ritu/128.jpg", 20));
        alumnos.add(new Alumno("Manolito","https://s3.amazonaws.com/uifaces/faces/twitter/tonystubblebine/128.jpg", 20));
        alumnos.add(new Alumno("Juanita","https://s3.amazonaws.com/uifaces/faces/twitter/tonystubblebine/128.jpg", 25));
        alumnos.add(new Alumno("Menganita","https://s3.amazonaws.com/uifaces/faces/twitter/tonystubblebine/128.jpg", 20));
        alumnos.add(new Alumno("Surmanita","https://s3.amazonaws.com/uifaces/faces/twitter/tonystubblebine/128.jpg", 17));
        alumnos.add(new Alumno("Suprimo","https://s3.amazonaws.com/uifaces/faces/twitter/tonystubblebine/128.jpg", 20));
        alumnos.add(new Alumno("Surmano","https://s3.amazonaws.com/uifaces/faces/twitter/tonystubblebine/128.jpg", 20));

        // Adapter
        AlumnosAdapter adapter = new AlumnosAdapter(
          this,
          R.layout.lista_alumnos_item,
          alumnos
        );

        // Conectar el adapter a la lista
        lvAlumnos.setAdapter(adapter);
    }
}

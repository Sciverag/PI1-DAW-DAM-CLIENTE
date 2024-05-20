package es.ieslavereda.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

import es.ieslavereda.API.Connector;
import es.ieslavereda.MiraVereda.R;
import es.ieslavereda.activities.model.contenido.Corto;
import es.ieslavereda.activities.model.contenido.Pelicula;
import es.ieslavereda.activities.model.contenido.Serie;
import es.ieslavereda.base.BaseActivity;
import es.ieslavereda.activities.model.RecycleView;
import es.ieslavereda.base.CallInterface;

/**
 * @author
 * @since 2024-05-13
 * Actividad que muestra el contenido de la BBDD y la información del usuario
 */
public class ContenidoActivity extends BaseActivity implements CallInterface, View.OnClickListener {

    private RecyclerView listaContenido;
    private RecycleView recycleView;
    private List contenido;
    private Spinner filtro;
    private String path;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido);
        listaContenido = findViewById(R.id.recyclerViewContenido);
        filtro = findViewById(R.id.spinnerFiltro);

        filtro.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Contenidos.values()));
        filtro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        path = "contenido/pelicula/";
                        break;
                    case 1:
                        path = "contenido/corto/";
                        break;
                    case 2:
                        path = "serie/";
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        executeCall(new CallInterface() {
            @Override
            public void doInBackground() {
                contenido = Connector.getConector().getAsList(Pelicula.class, path);
            }

            @Override
            public void doInUI() {
                recycleView.notifyDataSetChanged();
            }
        });

        listaContenido.setOnClickListener(view -> {
            Intent intent = new Intent(this, ContenidoAmpliadoActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void doInBackground() {
        contenido = Connector.getConector().getAsList(Pelicula.class, path);
    }



    @Override
    public void doInUI() {
        hideProgress();
        RecycleView recycleView = new RecycleView(this, contenido);
        recycleView.setOnClickListener(this);
        listaContenido.setAdapter(recycleView);
        listaContenido.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(View view) {
    }

    public enum Contenidos {
        PELICULA("Películas"),
        CORTO("Cortos"),
        SERIE("Series");

        private String tipo;
        Contenidos(String tipo){
            this.tipo = tipo;
        }
    }
}

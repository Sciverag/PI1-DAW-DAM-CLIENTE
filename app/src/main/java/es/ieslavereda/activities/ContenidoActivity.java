package es.ieslavereda.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import es.ieslavereda.API.Connector;
import es.ieslavereda.MiraVereda.R;
import es.ieslavereda.activities.model.Contenido;
import es.ieslavereda.activities.model.MiRecyclerViewSerie;
import es.ieslavereda.activities.model.contenido.Corto;
import es.ieslavereda.activities.model.contenido.Pelicula;
import es.ieslavereda.activities.model.contenido.Serie;
import es.ieslavereda.base.BaseActivity;
import es.ieslavereda.activities.model.MiRecyclerView;
import es.ieslavereda.base.CallInterface;

/**
 * @author
 * @since 2024-05-13
 * Actividad que muestra el contenido de la BBDD
 */
public class ContenidoActivity extends BaseActivity implements CallInterface, View.OnClickListener {

    private RecyclerView listaContenido;
    private MiRecyclerView adaptador;
    private MiRecyclerViewSerie adaptadorSerie;
    private List contenido;
    private Spinner filtro;
    private String path = "contenido/pelicula/";
    private boolean primera;
    private String tipo;
    private Button volver, carrito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido);
        listaContenido = findViewById(R.id.recyclerViewContenido);
        filtro = findViewById(R.id.spinnerFiltro);
        volver = findViewById(R.id.buttonVolver2);
        carrito = findViewById(R.id.buttonCarrito);

        volver.setOnClickListener(view -> finish());
        carrito.setOnClickListener(view -> startActivity(new Intent(this, CarritoActivity.class)));

        filtro.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Contenidos.values()));

        executeCall(this);

        filtro.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Contenidos contenidos = (Contenidos) adapterView.getSelectedItem();
                path = contenidos.getPath();
                if(primera){
                    executeCall(new CallInterface() {
                        @Override
                        public void doInBackground() {
                            if (contenidos.getTipo().equals("Pelicula")){
                                contenido = Connector.getConector().getAsList(Pelicula.class, path);
                            } if (contenidos.getTipo().equals("Corto")){
                                contenido = Connector.getConector().getAsList(Corto.class, path);
                            } else if (contenidos.getTipo().equals("Serie")){
                                contenido = Connector.getConector().getAsList(Serie.class, path);
                            }
                        }


                        @Override
                        public void doInUI() {
                            if (contenidos.getTipo().equals("Serie")) {
                                adaptadorSerie = new MiRecyclerViewSerie(getBaseContext(), contenido);
                                listaContenido.setAdapter(adaptadorSerie);
                                tipo = "serie";
                            } else {
                                adaptador = new MiRecyclerView(getBaseContext(), contenido);
                                listaContenido.setAdapter(adaptador);
                                if (contenidos.getTipo().equals("Pelicula")) {
                                    tipo = "pelicula";
                                } else {
                                    tipo = "corto";
                                }
                            }
                            adaptador.setOnClickListener(v -> {
                                int position = listaContenido.getChildAdapterPosition(v);
                                Intent intent = new Intent(getBaseContext(), ContenidoAmpliadoActivity.class);

                                Contenido contenidoPasar = null;
                                Serie contenidoPasarSerie = null;
                                int id = 0;
                                if (contenido.get(position) instanceof Contenido) {
                                    contenidoPasar = (Contenido) contenido.get(position);
                                    id = contenidoPasar.getId();
                                } else {
                                    contenidoPasarSerie = (Serie) contenido.get(position);
                                    id = contenidoPasarSerie.getId();
                                }
                                intent.putExtra("id", id);
                                intent.putExtra("tipo", tipo);

                                startActivity(intent);
                            });
                            adaptadorSerie.setOnClickListener(view1 -> {
                                int position = listaContenido.getChildAdapterPosition(view1);
                                Intent intent = new Intent(getBaseContext(), ContenidoAmpliadoActivity.class);
                                Contenido contenidoPasar = null;
                                Serie contenidoPasarSerie = null;
                                int id = 0;
                                if (contenido.get(position) instanceof Contenido) {
                                    contenidoPasar = (Contenido) contenido.get(position);
                                    id = contenidoPasar.getId();
                                } else {
                                    contenidoPasarSerie = (Serie) contenido.get(position);
                                    id = contenidoPasarSerie.getId();
                                }
                                intent.putExtra("id", id);
                                intent.putExtra("tipo", "serie");

                                startActivity(intent);
                            });
                        }
                    });

                    adaptador.notifyDataSetChanged();
                }
                primera = true;
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }


        });

    }

    @Override
    public void doInBackground() {
        contenido = Connector.getConector().getAsList(Pelicula.class, path);
    }



    @Override
    public void doInUI() {
        hideProgress();
        adaptador = new MiRecyclerView(this, contenido);
        adaptador.setOnClickListener(this);
        listaContenido.setAdapter(adaptador);
        listaContenido.setLayoutManager(new LinearLayoutManager(this));
    }

    public enum Contenidos {
        PELICULA("Pelicula", "contenido/pelicula/"),
        CORTO("Corto", "contenido/corto/"),
        SERIE("Serie", "serie/");

        private String tipo;
        private String path;
        Contenidos(String tipo, String path){
            this.tipo = tipo;
            this.path = path;
        }

        @Override
        public String toString() {
            return tipo;
        }

        public String getTipo() {
            return tipo;
        }

        public String getPath() {
            return path;
        }
    }

    @Override
    public void onClick(View v) {
        int position = listaContenido.getChildAdapterPosition(v);
        Intent intent = new Intent(this, ContenidoAmpliadoActivity.class);

        Contenido contenidoPasar = null;
        Serie contenidoPasarSerie = null;
        int id = 0;
        if (contenido.get(position) instanceof Pelicula) {
            contenidoPasar = (Pelicula) contenido.get(position);
            id = contenidoPasar.getId();
            tipo = "pelicula";
        } else if (contenido.get(position) instanceof Corto) {
            contenidoPasar = (Corto) contenido.get(position);
            id = contenidoPasar.getId();
            tipo = "corto";
        } else {
            contenidoPasarSerie = (Serie) contenido.get(position);
            id = contenidoPasarSerie.getId();
            tipo = "serie";
        }
        intent.putExtra("id", id);
        intent.putExtra("tipo", tipo);
        startActivity(intent);
    }
}

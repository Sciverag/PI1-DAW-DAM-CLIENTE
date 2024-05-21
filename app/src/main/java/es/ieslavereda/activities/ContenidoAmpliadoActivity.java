package es.ieslavereda.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import es.ieslavereda.API.Connector;
import es.ieslavereda.MiraVereda.R;
import es.ieslavereda.activities.model.Contenido;
import es.ieslavereda.activities.model.contenido.Corto;
import es.ieslavereda.activities.model.contenido.Pelicula;
import es.ieslavereda.activities.model.contenido.Serie;
import es.ieslavereda.base.BaseActivity;
import es.ieslavereda.base.CallInterface;

public class ContenidoAmpliadoActivity extends BaseActivity implements CallInterface, View.OnClickListener  {

    private TextView titulo, descripcion, fecha, precio, duracion, director, reparto;
    private Contenido contenido;
    private Serie contenidoSerie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contenido_ampliado);
        titulo = findViewById(R.id.textViewTituloCompleto);
        descripcion = findViewById(R.id.textViewDescripcionCompleto);
        fecha = findViewById(R.id.textViewFechaCompleto);
        precio = findViewById(R.id.textViewPrecioCompleto);
        duracion = findViewById(R.id.textViewDuracionCompleto);
        director = findViewById(R.id.textViewDirectorCompleto);
        reparto = findViewById(R.id.textViewRepartoCompleto);

        if (contenidoSerie==null) {
            titulo.setText(contenido.getTitulo());
            descripcion.setText(contenido.getDescripcion());
            fecha.setText(contenido.getFechaEstreno().toString().substring(contenido.getFechaEstreno().toString().length()-4));
            precio.setText(contenido.getPrecio);
            duracion.setText(contenido.getDuracion_minutos()+"");
            director.setText(contenido.getDirector());
            reparto.setText(contenido.getActores());
        }

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void doInBackground() {
        String tipo = getIntent().getExtras().getString("tipo");
        if (tipo.equals("pelicula")) {
            contenido = Connector.getConector().get(Pelicula.class, "contenido/pelicula/id");
        } else if (tipo.equals("corto")) {
            contenido = Connector.getConector().get(Corto.class, "contenido/corto/id");
        } else if (tipo.equals("serie")) {
            contenidoSerie = Connector.getConector().get(Serie.class, "serie/id");
        }
    }

    @Override
    public void doInUI() {

    }
}

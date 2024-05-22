package es.ieslavereda.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import es.ieslavereda.MiraVereda.R;
import es.ieslavereda.activities.model.contenido.Capitulo;
import es.ieslavereda.base.BaseActivity;

public class CapituloActivity extends BaseActivity {

    private TextView titulo, descripcion, fecha, precio, duracion, director, reparto, temporada;
    private Capitulo capitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitulo);
        titulo = findViewById(R.id.textViewTituloCapitulo);
        descripcion = findViewById(R.id.textViewDescripcionCapitulo);
        fecha = findViewById(R.id.textViewFechaCapitulo);
        precio = findViewById(R.id.textViewPrecioCapitulo);
        duracion = findViewById(R.id.textViewNumeroEps);
        director = findViewById(R.id.textViewDirectorCapitulo);
        reparto = findViewById(R.id.textViewRepartoCapitulo);
        temporada = findViewById(R.id.textViewTemporada);

        capitulo = (Capitulo) getIntent().getExtras().get("capitulo");

        titulo.setText(capitulo.getTitulo());
        descripcion.setText(capitulo.getDescripcion());
        fecha.setText(capitulo.getFechaEstreno().toString().substring(capitulo.getFechaEstreno().toString().length()-7));
        precio.setVisibility(View.INVISIBLE);
        duracion.setText(capitulo.getDuracion_minutos()+" min");
        director.setText(capitulo.getDirector());
        reparto.setText(capitulo.getActores()+"...");
        temporada.setText(capitulo.getTemporada());
    }
}

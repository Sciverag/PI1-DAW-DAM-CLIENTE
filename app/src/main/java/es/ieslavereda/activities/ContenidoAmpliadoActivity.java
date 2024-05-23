package es.ieslavereda.activities;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.ieslavereda.API.Connector;
import es.ieslavereda.MiraVereda.R;
import es.ieslavereda.activities.model.CarroCompra;
import es.ieslavereda.activities.model.Contenido;
import es.ieslavereda.activities.model.MiRecyclerView;
import es.ieslavereda.activities.model.MiRecyclerViewCapitulos;
import es.ieslavereda.activities.model.MiRecyclerViewCarrito;
import es.ieslavereda.activities.model.contenido.Capitulo;
import es.ieslavereda.activities.model.contenido.Corto;
import es.ieslavereda.activities.model.contenido.Pelicula;
import es.ieslavereda.activities.model.contenido.Serie;
import es.ieslavereda.base.BaseActivity;
import es.ieslavereda.base.CallInterface;
import es.ieslavereda.base.ImageDownloader;

public class ContenidoAmpliadoActivity extends BaseActivity implements CallInterface, View.OnClickListener  {

    private TextView titulo, descripcion, fecha, precio, duracion, director, reparto, disponibleHasta;
    private ImageView imagen;
    private Button anyadirCarrito, volver;
    private RatingBar puntuacionUsuario;
    private RecyclerView listaContenido;
    private MiRecyclerViewCapitulos adaptador;
    private Contenido contenido;
    private Serie contenidoSerie;
    private List<Capitulo> capitulos;
    private int id;
    private float precioContenido;

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
        disponibleHasta = findViewById(R.id.textViewDisponibleHasta);
        imagen = findViewById(R.id.imagenCompleto);
        anyadirCarrito = findViewById(R.id.buttonComprar);
        volver = findViewById(R.id.buttonVolver);
        puntuacionUsuario = findViewById(R.id.puntuacionUsuario);
        listaContenido = findViewById(R.id.episodios);

        executeCall(this);

        volver.setOnClickListener(view -> finish());
        anyadirCarrito.setOnClickListener(view -> {
            Connector.getConector().post(CarroCompra.class, null, "carro/&user=tag&idCont="+id);
        });
    }

    @Override
    public void onClick(View view) {
        int position = listaContenido.getChildAdapterPosition(view);
        Intent intent = new Intent(this, CapituloActivity.class);
        intent.putExtra("id", capitulos.get(position).getId());
        startActivity(intent);
    }

    @Override
    public void doInBackground() {
        id = getIntent().getExtras().getInt("id");
        String tipo = getIntent().getExtras().getString("tipo");
        if (tipo.equals("pelicula")) {
            contenido = Connector.getConector().get(Pelicula.class, "contenido/pelicula/"+id);
            precioContenido = Connector.getConector().get(Float.class, "contenido/precio/"+id);
        } else if (tipo.equals("corto")) {
            contenido = Connector.getConector().get(Corto.class, "contenido/corto/"+id);
            precioContenido = Connector.getConector().get(Float.class, "contenido/precio/"+id);
        } else {
            contenidoSerie = Connector.getConector().get(Serie.class, "serie/"+id);
            capitulos = Connector.getConector().getAsList(Capitulo.class, "contenido/capitulo/&serie="+id);
        }
    }

    @Override
    public void doInUI() {
        if (contenido!=null) {
            titulo.setText(contenido.getTitulo());
            descripcion.setText(contenido.getDescripcion());
            fecha.setText(contenido.getFechaEstreno().toString().substring(contenido.getFechaEstreno().toString().length()-4));
            precio.setText(precioContenido+"€");
            duracion.setText(contenido.getDuracion_minutos()+" min");
            director.setText(contenido.getDirector());
            reparto.setText(contenido.getActores());
            ImageDownloader.downloadImage(contenido.getUrl_image(),imagen);
            puntuacionUsuario.setOnRatingBarChangeListener((ratingBar, v, b) -> Connector.getConector().post(Float.class, null, "contenido/update/puntuacion/&id=" + id + "&punt=" + puntuacionUsuario.getRating()));
            if (contenido instanceof Pelicula) {
                String disponibilidad = ((Pelicula) contenido).getDisponible_hasta().toString();
                String fecha2 =  disponibilidad.substring(4,10) + " " + disponibilidad.substring(disponibilidad.length()-4);
                disponibleHasta.setText(fecha2);
            }


        } else if (contenidoSerie!=null) {
            titulo.setText(contenidoSerie.getTitulo());
            descripcion.setText(contenidoSerie.getDescripcion());
            fecha.setText("Disponible hasta: " + contenidoSerie.getDisponible_hasta().toString().substring(contenidoSerie.getDisponible_hasta().toString().length() - 7));
            precio.setText("Precio individual por episodio");
            duracion.setText(capitulos.size() + " eps");
            director.setText(capitulos.get(0).getDirector());
            reparto.setText(capitulos.get(0).getActores() + "...");
            anyadirCarrito.setVisibility(View.INVISIBLE);
            String disponibilidad = contenidoSerie.getDisponible_hasta().toString();
            disponibleHasta.setText(disponibilidad.substring(disponibilidad.length() - 7));
            puntuacionUsuario.setVisibility(View.GONE);
            adaptador = new MiRecyclerViewCapitulos(this, capitulos);
            listaContenido.setAdapter(adaptador);
            listaContenido.setOnClickListener(this);
        }
    }
}

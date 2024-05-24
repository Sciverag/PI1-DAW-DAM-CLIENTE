package es.ieslavereda.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import es.ieslavereda.API.Connector;
import es.ieslavereda.MiraVereda.R;
import es.ieslavereda.activities.model.CarroCompra;
import es.ieslavereda.activities.model.Contenido;
import es.ieslavereda.activities.model.Factura;
import es.ieslavereda.activities.model.LineaFactura;
import es.ieslavereda.activities.model.MiRecyclerViewCarrito;
import es.ieslavereda.activities.model.contenido.Pelicula;
import es.ieslavereda.base.BaseActivity;
import es.ieslavereda.base.CallInterface;


/**
 * Actividad para mostrar y gestionar el carrito de compras.
 */
public class CarritoActivity extends BaseActivity implements CallInterface, View.OnClickListener {

    private RecyclerView recyclerViewCarrito;
    private TextView textViewTotal;
    private Button buttonFinalizar,buttonVolver;
    private MiRecyclerViewCarrito adaptadorRecyclerViewCarrito;
    private List<LineaFactura> lineasCarrito;
    private double totalAmount = 0.0;
    private String tagUsuario;
    private List<Contenido> contenidoCarro;
    private Factura factura;

    /**
     * Llamado cuando la actividad es creada por primera vez. Aquí es donde debes hacer toda la configuración
     * estática normal: crear vistas, enlazar datos a listas, etc.
     *
     * @param savedInstanceState Si la actividad está siendo re-inicializada después de haber sido previamente
     *                           apagada, entonces este Bundle contiene los datos que más recientemente suministró
     *                           en onSaveInstanceState(Bundle). Nota: De lo contrario, es null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        recyclerViewCarrito = findViewById(R.id.recyclerViewCarrito);
        textViewTotal = findViewById(R.id.textViewTotal);
        buttonFinalizar = findViewById(R.id.buttonFinalizar);
        buttonVolver = findViewById(R.id.buttonVolverCarrito);


        contenidoCarro = new ArrayList<>();
        buttonFinalizar.setOnClickListener(v -> {
            factura = Connector.getConector().get(Factura.class,"factura/finalizar/"+tagUsuario);
            if (factura != null)
                Toast.makeText(this,"Factura Creada al usuario" +tagUsuario,Toast.LENGTH_SHORT).show();
        });
        buttonVolver.setOnClickListener(view -> finish());

    }

    /**
     * Actualiza el precio total del carrito sumando el precio de todos los contenidos en el carrito.
     */
    private void actualizarPrecioTotal() {
        totalAmount = 0.0;
        for (Contenido contenido : contenidoCarro) {
            totalAmount += Connector.getConector().get(Float.class,"contenido/precio/"+contenido.getId());
        }
        textViewTotal.setText("€" + String.format("%.2f", totalAmount));
    }

    /**
     * Método llamado cuando una vista ha sido clicada.
     *
     * @param view La vista que fue clicada.
     */
    @Override
    public void onClick(View view) {

    }

    /**
     * Obtiene los datos del carrito de compras en segundo plano.
     * Este método se llama en un hilo de fondo para realizar operaciones de red.
     */
    @Override
    public void doInBackground() {
        tagUsuario = getIntent().getExtras().getString("tag_usuario");
        CarroCompra carro = Connector.getConector().get(CarroCompra.class,"carro/&user="+tagUsuario);
        int idCarro = carro.getId();
        lineasCarrito = Connector.getConector().getAsList(LineaFactura.class,"LineaFactura/&carro="+idCarro);
        for (LineaFactura linea : lineasCarrito){
            contenidoCarro.add(Connector.getConector().get(Contenido.class,"lineaFactura/"+linea.getId()));
        }
    }

    /**
     * Actualiza la interfaz de usuario con los datos del carrito obtenidos.
     * Este método se llama en el hilo de la interfaz de usuario para actualizar las vistas con los datos obtenidos en doInBackground.
     */
    @Override
    public void doInUI() {
        adaptadorRecyclerViewCarrito = new MiRecyclerViewCarrito(contenidoCarro, this);
        recyclerViewCarrito.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCarrito.setAdapter(adaptadorRecyclerViewCarrito);
        actualizarPrecioTotal();
    }
}

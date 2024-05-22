package es.ieslavereda.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import es.ieslavereda.API.Connector;
import es.ieslavereda.MiraVereda.R;
import es.ieslavereda.activities.model.CarroCompra;
import es.ieslavereda.activities.model.Contenido;
import es.ieslavereda.activities.model.LineaFactura;
import es.ieslavereda.activities.model.MiRecyclerViewCarrito;
import es.ieslavereda.base.BaseActivity;
import es.ieslavereda.base.CallInterface;

public class CarritoActivity extends BaseActivity implements CallInterface, View.OnClickListener {

    private RecyclerView recyclerViewCarrito;
    private TextView textViewTotal;
    private Button buttonFinalizar,buttonVolver;
    private MiRecyclerViewCarrito adaptadorRecyclerViewCarrito;
    private List<LineaFactura> lineasCarrito;
    private double totalAmount = 0.0;
    private String tagUsuario;
    private List<Contenido> contenidoCarro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        recyclerViewCarrito = findViewById(R.id.recyclerViewCarrito);
        textViewTotal = findViewById(R.id.textViewTotal);
        buttonFinalizar = findViewById(R.id.buttonFinalizar);
        buttonVolver = findViewById(R.id.buttonVolverCarrito);


        contenidoCarro = new ArrayList<>();
       // actualizarPrecioTotal();

        buttonFinalizar.setOnClickListener(v -> {
            Toast.makeText(CarritoActivity.this, "Checkout Clicked", Toast.LENGTH_SHORT).show();
        });
        buttonVolver.setOnClickListener(view -> finish());
    }

//    private void actualizarPrecioTotal() {
//        totalAmount = 0.0;
//        for (Contenido product : carritoContenido) {
//            totalAmount += 8;
//        }
//        textViewTotal.setText("$" + String.format("%.2f", totalAmount));
//    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void doInBackground() {
        tagUsuario = getIntent().getStringExtra("tag_usuario");
        CarroCompra carro = Connector.getConector().get(CarroCompra.class,"carro/&user="+tagUsuario);
        int idCarro = carro.getId();
        if (tagUsuario != null)
            lineasCarrito = Connector.getConector().get(List.class,"LineaFactura/"+idCarro);
        for (LineaFactura linea : lineasCarrito){
            contenidoCarro.add(Connector.getConector().get(Contenido.class,"lineaFactura/"+linea.getId()));
        }
    }

    @Override
    public void doInUI() {
        adaptadorRecyclerViewCarrito = new MiRecyclerViewCarrito(contenidoCarro, this);
        recyclerViewCarrito.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCarrito.setAdapter(adaptadorRecyclerViewCarrito);
    }
}

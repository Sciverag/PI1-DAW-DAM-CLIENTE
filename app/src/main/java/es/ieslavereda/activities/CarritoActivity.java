package es.ieslavereda.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import es.ieslavereda.MiraVereda.R;
import es.ieslavereda.activities.model.Contenido;
import es.ieslavereda.activities.model.GestorCarrito;
import es.ieslavereda.activities.model.MiRecyclerViewCarrito;

public class CarritoActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCarrito;
    private TextView textViewTotal;
    private Button buttonCheckout;
    private MiRecyclerViewCarrito adaptadorRecyclerViewCarrito;
    private List<Contenido> carritoContenido;
    private double totalAmount = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        recyclerViewCarrito = findViewById(R.id.recyclerViewCarrito);
        textViewTotal = findViewById(R.id.textViewTotal);
        buttonCheckout = findViewById(R.id.buttonCarrito);

        carritoContenido = GestorCarrito.getInstance().obtenerCarrito();
        adaptadorRecyclerViewCarrito = new MiRecyclerViewCarrito(carritoContenido, this);

        recyclerViewCarrito.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCarrito.setAdapter(adaptadorRecyclerViewCarrito);

        actualizarPrecioTotal();

        buttonCheckout.setOnClickListener(v -> {
            Toast.makeText(CarritoActivity.this, "Checkout Clicked", Toast.LENGTH_SHORT).show();
        });
    }

    private void actualizarPrecioTotal() {
        totalAmount = 0.0;
        for (Contenido product : carritoContenido) {
            totalAmount += 8;
        }
        textViewTotal.setText("$" + String.format("%.2f", totalAmount));
    }
}

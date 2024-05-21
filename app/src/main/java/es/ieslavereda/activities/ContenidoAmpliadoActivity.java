package es.ieslavereda.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import es.ieslavereda.MiraVereda.R;
import es.ieslavereda.base.BaseActivity;
import es.ieslavereda.base.CallInterface;

public class ContenidoAmpliadoActivity extends BaseActivity implements View.OnClickListener  {

    private TextView titulo, descripcion, fecha, precio, duracion, director, reparto;

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


        titulo.setText();

    }

    @Override
    public void onClick(View view) {

    }
}

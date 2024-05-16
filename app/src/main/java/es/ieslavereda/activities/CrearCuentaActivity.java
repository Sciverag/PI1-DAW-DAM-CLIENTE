package es.ieslavereda.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.ieslavereda.MiraVereda.R;

import es.ieslavereda.activities.model.Root;
import es.ieslavereda.activities.model.usuario.Usuario;
import es.ieslavereda.base.BaseActivity;

/**
 * @author
 * @since 2024-05-13
 * Actividad para crear una nueva cuenta de usuario.
 */
public class CrearCuentaActivity extends BaseActivity {

    private EditText nombre, contrasenya, confirmarContrasenya;
    private Button crearCuenta;
    private Root root;
    private ArrayList<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
        nombre = findViewById(R.id.editTextCrearUsuario);
        contrasenya = findViewById(R.id.editTextCrearContrasenya);
        confirmarContrasenya = findViewById(R.id.editTextContrasenyaConfirmacion);
        crearCuenta = findViewById(R.id.buttonConfirmarNuevaCuenta);

        usuarios = getIntent().getExtras().getParcelable("Usuarios");
        

        crearCuenta.setOnClickListener(view -> {
            if (usuarios.contains(nombre.getText().toString())) {
                setResult(RESULT_CANCELED);
            }
            if (contrasenya.getText().equals(confirmarContrasenya.getText())) {
                Intent intent = new Intent();
                intent.putExtra("Usuario", nombre.getText().toString());
                intent.putExtra("Contraseña", confirmarContrasenya.getText().toString());
            } else {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT);
            }
        });
    }

}

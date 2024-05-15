package es.ieslavereda.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import es.ieslavereda.MiraVereda.R;
import es.ieslavereda.activities.model.Root;
import es.ieslavereda.base.BaseActivity;


/**
 * @author
 * @since 2024-05-13
 * Actividad principal con 3 opciones, iniciar sesión, crear cuenta, y reiniciar contraseña.
 */
public class MainActivity extends BaseActivity {

    private EditText usuario, contrasenya;
    private Button iniciarSesion, crearCuenta, reiniciarContrasenya;
    private Root root;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        usuario = findViewById(R.id.editTextUsuario);
        contrasenya = findViewById(R.id.editTextContrasenya);
        iniciarSesion = findViewById(R.id.buttonIniciarSesion);
        crearCuenta = findViewById(R.id.buttonCrearCuenta);
        reiniciarContrasenya = findViewById(R.id.buttonReiniciarContrasenya);


    }


    /**
     * Inicia una nueva actividad para crear una cuenta y
     * muestra un mensaje sobre si la cuenta ha sido creada correctamente o no
     */
    public void CrearCuenta(View view) {
        Intent intent = new Intent(this, CrearCuentaActivity.class);
        ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == RESULT_OK) {

                        Toast.makeText(this, "Cuenta creada correctamente", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Creación de cuenta cancelada", Toast.LENGTH_SHORT).show();
                    }
                });
        resultLauncher.launch(intent);
    }

    /**
     * Usa las credenciales introducidas en la primera actividad para iniciar sesión.
     * Si el usuario no existe o se introduce una contraseña incorrecta se mostrará un mensaje indicandolo.
     */
    public void IniciarSesion(View view) {
//        if (llamadaAPI()==1) {
//            Intent intent = new Intent(this, ContenidoActivity.class);
//            startActivity(intent);
//            Toast.makeText(this, "Sesión iniciada como '" + usuario.getText() + "'", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
//        }

    }

    /**
     * Inicia una actividad para cambiar la contraseña del usuario introducido si existe.
     */
    public void ReiniciarContrasenya(View view) {
        Intent intent = new Intent(this, ReiniciarContrasenyaActivity.class);
        // intent.putExtra("Usuario", nombreUsuario);
        // intent.putExtra("Contraseña", contraseña);
        ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                //Cambiar contraseña del usuario a la introducida
            } else {
                Toast.makeText(this, "Cambio de contraseña cancelado", Toast.LENGTH_SHORT).show();
            }
        });
        resultLauncher.launch(intent);
    }

}
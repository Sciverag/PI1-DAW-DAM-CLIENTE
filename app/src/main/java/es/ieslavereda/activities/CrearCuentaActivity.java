package es.ieslavereda.activities;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import es.ieslavereda.API.Connector;
import es.ieslavereda.MiraVereda.R;

import es.ieslavereda.activities.model.Root;
import es.ieslavereda.activities.model.usuario.Usuario;
import es.ieslavereda.base.BaseActivity;
import es.ieslavereda.base.CallInterface;

/**
 * @author
 * @since 2024-05-13
 * Actividad para crear una nueva cuenta de usuario.
 */
public class CrearCuentaActivity extends BaseActivity implements CallInterface {

    private EditText nombreUsuario, contrasenya, confirmarContrasenya, email, nombre, apellido;
    private Button crearCuenta;
    private Root root;
    private Button cancelar;

    private Usuario login;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
        nombreUsuario = findViewById(R.id.editTextCrearUsuario);
        contrasenya = findViewById(R.id.editTextCrearContrasenya);
        confirmarContrasenya = findViewById(R.id.editTextContrasenyaConfirmacion);
        email = findViewById(R.id.editTextEmail);
        nombre = findViewById(R.id.editTextNombreCrear);
        apellido = findViewById(R.id.editTextApellidoCrear);
        crearCuenta = findViewById(R.id.buttonConfirmarNuevaCuenta);
        cancelar = findViewById(R.id.cancelarCrearCuenta);



        

        crearCuenta.setOnClickListener(view -> {
            if (contrasenya.getText().toString().equals(confirmarContrasenya.getText().toString())) {
                executeCall(new CallInterface() {
                    @Override
                    public void doInBackground() {
                        login = Connector.getConector().get(Usuario.class, "usuario/login/&user=" + nombreUsuario.getText().toString() + "&password=" + contrasenya.getText().toString());
                    }

                    @Override
                    public void doInUI() {
                        if (login!=null){
                            Toast.makeText(getBaseContext(), "El usuario ya existe", Toast.LENGTH_SHORT).show();
                        } else {
                            login = new Usuario(nombreUsuario.getText().toString(),
                                    nombre.getText().toString(),
                                    apellido.getText().toString(),
                                    email.getText().toString(),
                                    contrasenya.getText().toString(), null, 0, 0, null, null);
                            executeCall(new CallInterface() {
                                @Override
                                public void doInBackground() {
                                    usuario = Connector.getConector().post(Usuario.class, login, "usuario/add");
                                }

                                @Override
                                public void doInUI() {
                                    setResult(RESULT_OK);
                                    finish();
                                }
                            });
                            setResult(RESULT_OK);
                            finish();
                        }

                    }
                });
            } else {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            }
        });

        cancelar.setOnClickListener(view -> {
            setResult(RESULT_CANCELED);
            finish();
        });
    }

    @Override
    public void doInBackground() {

    }

    @Override
    public void doInUI() {

    }
}

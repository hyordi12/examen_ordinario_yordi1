package com.example.consolas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Login extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences("MySharedPreferences", MODE_PRIVATE);

        final EditText editTextUsuario = findViewById(R.id.editTextUsuario);
        final EditText editTextContraseña = findViewById(R.id.editTextContraseña);
        Button buttonIniciarSesion = findViewById(R.id.buttonIniciarSesion);
        Button buttonRegistrarse = findViewById(R.id.buttonRegistrarse);

        buttonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = editTextUsuario.getText().toString();
                String contraseña = editTextContraseña.getText().toString();


                String usuarioGuardado = sharedPreferences.getString("usuario", "");
                String contraseñaGuardada = sharedPreferences.getString("contraseña", "");

                if (usuario.equals(usuarioGuardado) && contraseña.equals(contraseñaGuardada)) {
                    Toast.makeText(Activity_Login.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(Activity_Login.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Activity_Login.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Activity_Login.this, Activity_Registro.class);
                startActivity(intent);
            }
        });
    }
}



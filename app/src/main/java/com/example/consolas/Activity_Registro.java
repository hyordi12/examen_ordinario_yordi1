package com.example.consolas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Registro extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        sharedPreferences = getSharedPreferences("MySharedPreferences", MODE_PRIVATE);

        final EditText editTextNombre = findViewById(R.id.editTextNombre);
        final EditText editTextUsuario = findViewById(R.id.editTextUsuario);
        final EditText editTextContraseña = findViewById(R.id.editTextContraseña);
        Button buttonGuardar = findViewById(R.id.buttonGuardar);
        Button buttonRegresar = findViewById(R.id.buttonRegresar);

        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editTextNombre.getText().toString();
                String usuario = editTextUsuario.getText().toString();
                String contraseña = editTextContraseña.getText().toString();

                if (!nombre.isEmpty() && !usuario.isEmpty() && !contraseña.isEmpty()) {
                    Toast.makeText(Activity_Registro.this, "Registro exitoso", Toast.LENGTH_SHORT).show();

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("nombre", nombre);
                    editor.putString("usuario", usuario);
                    editor.putString("contraseña", contraseña);
                    editor.apply();

                } else {
                    Toast.makeText(Activity_Registro.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Registro.this, Activity_Login.class);
                startActivity(intent);
            }
        });
    }
}

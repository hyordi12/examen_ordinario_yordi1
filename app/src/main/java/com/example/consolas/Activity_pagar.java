package com.example.consolas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Activity_pagar extends AppCompatActivity {

    private static final String PREF_NAME = "MySharedPreferences";
    private static final String KEY_PRODUCTOS_SELECCIONADOS = "productosSeleccionados";
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagar);

        SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        String productosSeleccionadosString = sharedPreferences.getString(KEY_PRODUCTOS_SELECCIONADOS, "");
        ArrayList<Producto> productosSeleccionados = new ArrayList<>();
        if (!productosSeleccionadosString.isEmpty()) {
            Type type = new TypeToken<ArrayList<Producto>>(){}.getType();
            productosSeleccionados = gson.fromJson(productosSeleccionadosString, type);
        }

        double total = 0;
        StringBuilder productosSeleccionadosStr = new StringBuilder();
        for (Producto producto : productosSeleccionados) {
            productosSeleccionadosStr.append(producto.getNombre()).append(" - ").append(producto.getPrecio()).append("\n");
            total += producto.getPrecio();
        }

        TextView textView = findViewById(R.id.textView);
        textView.setText(productosSeleccionadosStr.toString());

        TextView totalTextView = findViewById(R.id.totalTextView);
        totalTextView.setText("Total: " + total);

        Button buttonPagar = findViewById(R.id.buttonPagar);
        buttonPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Activity_pagar.this, "Gracias por su compra", Toast.LENGTH_SHORT).show();

                SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(KEY_PRODUCTOS_SELECCIONADOS);
                editor.apply();

                Intent intent = new Intent(Activity_pagar.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}























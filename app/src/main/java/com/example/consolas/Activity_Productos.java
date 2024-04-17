package com.example.consolas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Activity_Productos extends AppCompatActivity {

    private static final String PREF_NAME = "MySharedPreferences";
    private static final String KEY_PRODUCTOS_SELECCIONADOS = "productosSeleccionados";

    private ArrayList<Producto> productosSeleccionados = new ArrayList<>();
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        String productosSeleccionadosString = sharedPreferences.getString(KEY_PRODUCTOS_SELECCIONADOS, "");
        if (!productosSeleccionadosString.isEmpty()) {
            Type type = new TypeToken<ArrayList<Producto>>(){}.getType();
            productosSeleccionados = gson.fromJson(productosSeleccionadosString, type);
        }

        SharedPreferences sharedPreferencesPlatform = getSharedPreferences("MySharedPreferences", MODE_PRIVATE);
        String selectedPlatform = sharedPreferencesPlatform.getString("selectedPlatform", "");

        ArrayList<Producto> productos = new ArrayList<>();

        if ("Xbox".equals(selectedPlatform)) {
            productos.add(new Producto("Xbox series X", "Consola mas potente de Microsoft", R.drawable.series_x, 15000.0));
            productos.add(new Producto("Xbox series S", "Consola Digitalizada", R.drawable.series_s, 5000.0));
            productos.add(new Producto("Xbox one S", "Consola mas compacta y estilizada", R.drawable.one_s, 3000.0));
        } else if ("Playstation".equals(selectedPlatform)) {
            productos.add(new Producto("PlayStation 5", "Consola de ultima generacion de sony", R.drawable.play_5, 16000.0));
            productos.add(new Producto("PlayStation 5 Edition Spider", "consola edicion spiderman", R.drawable.edition_spider, 17000.0));
            productos.add(new Producto("PlayStation 4", "Tinene una amplia biblioteca de juegos", R.drawable.ps4, 3000.0));
        } else if ("Nintendo".equals(selectedPlatform)) {
            productos.add(new Producto("Nintendo Switch", "se puede jugar como una consola portáti", R.drawable.nintendo_switch, 9000.0));
            productos.add(new Producto("Nintendo 3DS", "Mantieine la ffuncionalidad de doble panatalla", R.drawable.nintendo_ds, 3500.0));
            productos.add(new Producto("Nintendo NES", "una de las consolas más influyentes de todos los tiempos", R.drawable.nes, 2000.0));
        }

        ListView listView = findViewById(R.id.listView);
        ProductoAdapter adapter = new ProductoAdapter(this, productos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Producto productoSeleccionado = productos.get(position);
            productosSeleccionados.add(productoSeleccionado);
            Toast.makeText(Activity_Productos.this, "Producto seleccionado: " + productoSeleccionado.getNombre(), Toast.LENGTH_SHORT).show();

            saveProductosSeleccionados();
        });

        Button buttonSiguiente = findViewById(R.id.buttonSiguiente);
        buttonSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Productos.this, Activity_pagar.class);
                intent.putExtra("productosSeleccionados", productosSeleccionados);
                startActivity(intent);
            }
        });

        Button buttonRegresar = findViewById(R.id.buttonRegresar);
        buttonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Productos.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void saveProductosSeleccionados() {
        String productosSeleccionadosString = gson.toJson(productosSeleccionados);
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_PRODUCTOS_SELECCIONADOS, productosSeleccionadosString);
        editor.apply();
    }
}










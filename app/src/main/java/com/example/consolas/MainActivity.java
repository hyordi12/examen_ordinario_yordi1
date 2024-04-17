package com.example.consolas;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonXbox = findViewById(R.id.Xbox);
        Button buttonPlaystation = findViewById(R.id.Playstation);
        Button buttonNintendo = findViewById(R.id.Nintendo);

        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPreferences", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if (v.getId() == R.id.Xbox) {
                    editor.putString("selectedPlatform", "Xbox");
                } else if (v.getId() == R.id.Playstation) {
                    editor.putString("selectedPlatform", "Playstation");
                } else if (v.getId() == R.id.Nintendo) {
                    editor.putString("selectedPlatform", "Nintendo");
                }

                editor.apply();

                Intent intent = new Intent(MainActivity.this, Activity_Productos.class);
                startActivity(intent);
            }
        };

        buttonXbox.setOnClickListener(buttonClickListener);
        buttonPlaystation.setOnClickListener(buttonClickListener);
        buttonNintendo.setOnClickListener(buttonClickListener);
    }
}












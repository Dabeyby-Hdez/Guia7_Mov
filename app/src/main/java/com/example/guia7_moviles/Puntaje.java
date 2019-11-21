package com.example.guia7_moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Puntaje extends AppCompatActivity {

    TextView txtPuntaje;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntaje);

        txtPuntaje = findViewById(R.id.txtPuntaje);
        sharedPreferences = this.getSharedPreferences("ArchivoPuntaje", this.MODE_PRIVATE);
        // Extraer dato
        int PuntajeActual = sharedPreferences.getInt("PuntajeActual",0);

        txtPuntaje.setText(Integer.toString(PuntajeActual));
    }
}

package com.example.guia7_moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnJugar, btnPuntaje, btnDatos, btnRespuesta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJugar = findViewById(R.id.btnJugar);
        btnPuntaje = findViewById(R.id.btnPuntaje);
        btnDatos = findViewById(R.id.btnDatos);
        btnRespuesta = findViewById(R.id.btnRespuesta);

        btnRespuesta.setOnClickListener(this);
        btnPuntaje.setOnClickListener(this);
        btnDatos.setOnClickListener(this);
        btnJugar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnDatos:
                Intent datos = new Intent(this, MisDatos.class );
                startActivity(datos);
                break;

            case R.id.btnJugar:
                Intent jugar = new Intent(this, Jugar.class);
                startActivity(jugar);
                break;
        }
    }
}

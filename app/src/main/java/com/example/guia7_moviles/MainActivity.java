package com.example.guia7_moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnJugar, btnPuntaje, btnDatos, btnRespuesta;
    int Numero= 0;
    SharedPreferences sharedPreferences;

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

        sharedPreferences = this.getSharedPreferences("ArchivoPuntaje", this.MODE_PRIVATE);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnJugar) {
            Intent datos = new Intent(this, Jugar.class);
            startActivity(datos);
        }
        else if (view.getId() == R.id.btnPuntaje){
            startActivity(new Intent(this, Puntaje.class));


        }
        else if(view.getId() == R.id.btnRespuesta){
            Numero = sharedPreferences.getInt("NumAdivinar",0);
            if (Numero != 0){
                Toast.makeText(this,"El número es: " + Numero, Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this,"Inicie el juego", Toast.LENGTH_LONG).show();
            }

        }

        else if (view.getId() == R.id.btnDatos){
            startActivity(new Intent(this, MisDatos.class));
        }


        }
    }


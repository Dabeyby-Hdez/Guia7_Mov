package com.example.guia7_moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Jugar extends AppCompatActivity  implements View.OnClickListener {

    TextView edtnumero, edtpuntos;
    Button btnAdivinar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);

        edtnumero = findViewById(R.id.edtnumero);
        edtpuntos = findViewById(R.id.edtpuntos);
        btnAdivinar = findViewById(R.id.btnAdivinar);
    }

    @Override
    public void onClick(View view) {

    }
}

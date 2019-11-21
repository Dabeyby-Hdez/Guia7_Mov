package com.example.guia7_moviles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Jugar extends AppCompatActivity {

    TextView edtnumero;
    Button btnAceptar;

    public static int Adivinar = 0;

    int Puntaje = 10;
    Random Numero = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugar);

        edtnumero = findViewById(R.id.edtnumero);
        btnAceptar = findViewById(R.id.btnAceptar);


        final Context context = this;
        SharedPreferences sharedPreferences = getSharedPreferences("ArchivoPuntaje", context.MODE_PRIVATE);

        // Guardar dato
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        // Extraer dato
        int NumGuardado = sharedPreferences.getInt("NumAdivinar", 0);

        if (NumGuardado == 0) {
            Adivinar = Numero.nextInt(10) + 1;
            editor.putInt("NumAdivinar", Adivinar);
            editor.commit();
            Toast.makeText(Jugar.this, "No se ha guardado ningún valor", Toast.LENGTH_SHORT).show();
        } else {
            Adivinar = NumGuardado;
        }

        // Extraer dato
        int PuntajeActual = sharedPreferences.getInt("PuntajeActual", 0);

        if (PuntajeActual == 0) {
            editor.putInt("PuntajeActual", Puntaje);
            editor.commit();
        } else {
            Puntaje = PuntajeActual;
        }
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtnumero.getText().length() != 0){
                    int NumUsuario = Integer.parseInt(edtnumero.getText().toString());

                    if (Adivinar == NumUsuario){
                        Toast.makeText(Jugar.this,"Adivinaste el número", Toast.LENGTH_SHORT).show();
                        Puntaje = Puntaje + 10;
                        editor.putInt("PuntajeActual", Puntaje);
                        editor.commit();
                        Adivinar = Numero.nextInt(10)+1;
                        editor.putInt("NumAdivinar", Adivinar);
                        editor.commit();
                    }
                    else
                    {
                        Toast.makeText(Jugar.this,"Introduce otro número", Toast.LENGTH_SHORT).show();
                        Puntaje = Puntaje - 1;
                        editor.putInt("PuntajeActual", Puntaje);
                        editor.commit();
                    }
                    edtnumero.setText("");
                }
            }
        });

}
}

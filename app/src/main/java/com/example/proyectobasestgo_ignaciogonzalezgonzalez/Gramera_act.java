package com.example.proyectobasestgo_ignaciogonzalezgonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Gramera_act extends AppCompatActivity {

    private EditText ptgramos;
    private TextView resultadoGramos;
    private int total = 651;
    private Button botonConvertir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gramera);

        ptgramos = findViewById(R.id.gramos);
        resultadoGramos = findViewById(R.id.tvResultadoGramos);
        botonConvertir = findViewById(R.id.btnConvertir);
    }


    public int multiplicacion(int a)
    {
        return a * 651;
    }
    public void Convertir(View view)
    {
        int resultadoFinal = 0;
        resultadoFinal = multiplicacion(Integer.parseInt(ptgramos.getText().toString()));

        resultadoGramos.setText(ptgramos.getText().toString() + "gramos" +"\nEn pesos es: " + resultadoFinal + "\n Valor actual del gramos de plata es de 651");
    }
}
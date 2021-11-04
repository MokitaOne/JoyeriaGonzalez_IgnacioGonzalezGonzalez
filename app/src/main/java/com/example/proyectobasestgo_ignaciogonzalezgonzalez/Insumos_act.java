package com.example.proyectobasestgo_ignaciogonzalezgonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Insumos;

public class Insumos_act extends AppCompatActivity {

    private Spinner insumos;
    private TextView result;
    private Insumos in = new Insumos(); //traer valores
    private RatingBar calificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        insumos = findViewById(R.id.spnInsumos);
        result = findViewById(R.id.result);
        calificar = findViewById(R.id.rt);
        //recibir bundle

        Bundle bun = getIntent().getExtras();//recibir los extras
        String[] listado = bun.getStringArray("Insumos");

        ArrayAdapter adapInsumos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        insumos.setAdapter(adapInsumos);
    }
    public void Calcular(View view)
    {
        String opcion = insumos.getSelectedItem().toString();//obtiene el spinner seleccionado
        int resultado = 0;


        //Ciclo For
        //declaracion - Condicion - incremento
        for(int i = 0; i < opcion.length(); i++)//en la condicion se toma el largo de las opciones
        {
            if(opcion.equals(in.getInsumos()[i]))//pregunto segun el insumo seleccionado...
            {
                //resultado = in.getPrecio()[i];//obtener los precios
                resultado = in.anadirAdicional(in.getPrecio()[i],350);
                calificar.setRating(i+1);//pintar estrellas
                break;
            }
        }
        result.setText("La opcion seleccionada es: " + opcion + "\nSu precio es: " + resultado);
    }
}
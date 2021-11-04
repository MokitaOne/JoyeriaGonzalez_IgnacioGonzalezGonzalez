package com.example.proyectobasestgo_ignaciogonzalezgonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Info_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }
    //Intent implicito no especifica la accion que quiere realizar
    public void Marcar(View view)
    {
        Intent i = new Intent(Intent.ACTION_DIAL);//Accion para marcar un numero
        i.setData(Uri.parse("tel:"+ "947307694"));//siempre va tel si no no marca
        startActivity(i);
    }
    public void Maps(View view)
    {
        //explicito
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
    }
}
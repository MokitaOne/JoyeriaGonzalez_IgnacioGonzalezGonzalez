package com.example.proyectobasestgo_ignaciogonzalezgonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;
import Objetos.Insumos;

public class Home_act extends AppCompatActivity {

    private Insumos in = new Insumos();
    private VideoView videoview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        videoview = findViewById(R.id.vw);

        //obtengo el video
        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.videoo;
        Uri uri = Uri.parse(ruta);//Parseo la ruta
        videoview.setVideoURI(uri);
        videoview.start();
        //Controles para el video
       // MediaController media = new MediaController(this);
        //videoview.setMediaController(media);//Le paso mi control

    }
    //tarea pesada
    /*public void Task(View view)
    {
       try {

           for(int i = 0; i <= 10; i++)
           {
               Thread.sleep(25000);//dormir un proceso
           }
       }
       catch (InterruptedException e)
       {
           e.printStackTrace();//Imprime la excepción de la pila de objetos de la maquina.
       }
    }*/
     public void Insumos(View view)
    {
        Intent i = new  Intent(this, Insumos_act.class);

        //preparar los valores

        Bundle bun = new Bundle();//necesario para enviar arreglos
        bun.putStringArray("Insumos", in.getInsumos());//rellena el bundle
        i.putExtras(bun);
        startActivity(i);
    }

    public void misClases(View view)
    {
        Intent i = new Intent(this, Clases_act.class);
        startActivity(i);
    }

    public void gramosAPesos(View view)
    {
        Intent i = new Intent(this, Gramera_act.class);
        startActivity(i);
    }
    public void informacion(View view)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }

}
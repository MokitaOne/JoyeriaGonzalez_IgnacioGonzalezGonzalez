package com.example.proyectobasestgo_ignaciogonzalezgonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Objetos.Administrador;
import Objetos.Insumos;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private TextView msj;
    private ProgressBar barra;
    private Button btn;
    private Administrador adm = new Administrador();// instancia del objeto
    private Insumos in = new Insumos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.etuser);
        pass = findViewById(R.id.etpass);
        msj = findViewById(R.id.msj);
        msj.setVisibility(View.INVISIBLE);//maneja la visibilidad de un elemento grafico
        barra = findViewById(R.id.pb);
        btn = findViewById(R.id.btn);
        barra.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //aqui se corre la tarea asincrona.
                new Task().execute();
            }
        });
    }
    //tarea asincrona
    class Task extends AsyncTask<String, Void, String>
    {

        //Configuracion inicial de la tarea asincrona
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE);
        }
        //quien se encarga de llevar un proceso en segundo plano
        @Override
        protected String doInBackground(String... strings) {
            try {
                for(int i = 0 ; i <=10; i++)
                {
                    Thread.sleep(100);
                }
            }
            catch(InterruptedException e)
                {
                    e.printStackTrace();
                }

            return null;
        }

        //Es donde termina la tarea asincrona
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            barra.setVisibility(View.INVISIBLE);

            String usuario = user.getText().toString().trim(); //trim remueve los espacios en blanco
            String contrasena = pass.getText().toString().trim();

            String userObj = adm.getUser().trim();
            String passObj = adm.getPass().trim();

            switch (usuario)
            {
                case "Ignacio":
                    if(usuario.equals(userObj) && contrasena.equals(passObj))
                    {
                        msj.setVisibility(View.INVISIBLE);
                        Intent i = new Intent(getBaseContext(), Home_act.class);//se saca el this porque no toma el contexto actual y toma el contexto base, es un intent explicito.

                        //preparar los valores

                        Bundle bun = new Bundle();//necesario para enviar arreglos
                        bun.putStringArray("Insumos", in.getInsumos());//rellena el bundle
                        i.putExtras(bun);
                        startActivity(i);
                    }
                    break;
                case "":
                    if (usuario.equals("") && contrasena.equals(""))
                    {
                        //campos vacios
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Campos Vacios Porfavor Ingrese Nuevamente");
                    }
                    break;
                default:
                    if(!usuario.equals(userObj) && !contrasena.equals(passObj))
                    {
                        //campos incorrectos
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Campos Incorrectos Porfavor Ingrese Nuevamente");
                    }
                    break;
            }

        }
    }
        //se paso el metodo al onepostexcecute
    //public void LoadSession(View view)
    public void Facebook(View view)//intent implicito
    {
        Intent i = new Intent(Intent.ACTION_VIEW);//Intent para abrir sitio web
        i.setData(Uri.parse("https://www.facebook.com/"));//paso de dirreccion web
        startActivity(i);
    }
    public void Youtube(View view)//intent implicito
    {
        Intent i = new Intent(Intent.ACTION_VIEW);//Intent para abrir sitio web
        i.setData(Uri.parse("https://www.youtube.com/"));//paso de dirreccion web
        startActivity(i);
    }
    public void Twitter(View view)//intent implicito
    {
        Intent i = new Intent(Intent.ACTION_VIEW);//Intent para abrir sitio web
        i.setData(Uri.parse("https://www.twitter.com/"));//paso de dirreccion web
        startActivity(i);
    }
    public void Info(View view)
    {
        Intent i = new Intent(this, Info_act.class);
                startActivity(i);
    }
}
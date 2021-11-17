package com.example.proyectobasestgo_ignaciogonzalezgonzalez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectobasestgo_ignaciogonzalezgonzalez.database.AdminSQLiteOpenHelper;

public class Clases_act extends AppCompatActivity {


    private EditText code, clase, intensi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clases);

        code = findViewById(R.id.code);
        clase = findViewById(R.id.clase);
        intensi = findViewById(R.id.intensi);
    }

    //Metodo para añadir clases
    public void guardarClases(View view)
    {
        AdminSQLiteOpenHelper  admin = new AdminSQLiteOpenHelper(this, "biofit", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();//Le doy permisos de sobreescritura

        //obtener los campos que scribe el cliente
        String codigo = code.getText().toString();
        String clas = clase.getText().toString();
        String intensidad = intensi.getText().toString();
        if(!codigo.isEmpty() && !clas.isEmpty() && !intensidad.isEmpty())
        {
            ContentValues cont = new ContentValues();//Permite contener valores
            cont.put("codigo", codigo);
            cont.put("clase", clas);
            cont.put("intensidad", intensidad);

            db.insert("clases", null, cont);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Has guardado una Venta.", Toast.LENGTH_SHORT).show();

        }else
        {
            Toast.makeText(getBaseContext(), "Los campos estan vacios ..", Toast.LENGTH_SHORT).show();
        }
    }
    //Metodo para consultar clases
    public void mostrarClases(View view)
    {
        AdminSQLiteOpenHelper  admin = new AdminSQLiteOpenHelper(this, "biofit", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();//Le doy permisos de sobreescritura

        String codigo = code.getText().toString();

        if(!codigo.isEmpty())
        {
            //Mostrar datos de la dataabase
            Cursor file = db.rawQuery("SELECT clase, intensidad FROM clases WHERE codigo="+codigo, null);
            if(file.moveToFirst())//Verifica si hay clases dentro de la consulta
            {
             clase.setText(file.getString(0));//Muestra al posicion de datos
             intensi.setText(file.getString(1));

            }else
            {
                Toast.makeText(getBaseContext(), "No hay Venta asociada", Toast.LENGTH_SHORT).show();
            }

        }else
        {
            Toast.makeText(getBaseContext(), "El codigo viene vacio.", Toast.LENGTH_SHORT).show();
        }


    }

    //metodo para eliminar clases
    public void eliminarClases(View view)
    {
        AdminSQLiteOpenHelper  admin = new AdminSQLiteOpenHelper(this, "biofit", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();//Le doy permisos de sobreescritura

        String codigo = code.getText().toString();
        if(!codigo.isEmpty())
        {
            //eliminamos..
            db.delete("clases", "codigo="+codigo, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(),"Has eliminado una Venta: "+ codigo, Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(getBaseContext(),"El campo codigo esta vacio", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para actualziar las clases
    public void actualizarClases(View view)
    {
        AdminSQLiteOpenHelper  admin = new AdminSQLiteOpenHelper(this, "biofit", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();//Le doy permisos de sobreescritura

        //obtener los campos que scribe el cliente
        String codigo = code.getText().toString();
        String clas = clase.getText().toString();
        String intensidad = intensi.getText().toString();
        if(!codigo.isEmpty() && !clas.isEmpty() && !intensidad.isEmpty())
        {
            ContentValues cont = new ContentValues();
            cont.put("clase", clas);
            cont.put("intensidad", intensidad);

            db.update("clases", cont , "codigo="+codigo, null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(),"Has actualizado una clase", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(getBaseContext(), "Campos vacios porfavor rellenar....", Toast.LENGTH_SHORT).show();
        }
    }

    //Metodo para limpiar los campos
    public void Clean()
    {
        code.setText("");
        clase.setText("");
        intensi.setText("");
    }

}
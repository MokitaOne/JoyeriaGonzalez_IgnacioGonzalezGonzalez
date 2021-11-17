package com.example.proyectobasestgo_ignaciogonzalezgonzalez.database;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper
{
    //Constructor para instanciar la database
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    //Crear trablas y campos
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE clases (codigo int primary key, clase text, intensidad text)");
    }
    //permite hacer cambios esquematicos en el modelo
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}

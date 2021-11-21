package com.example.septimaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public final static String DATABASE_NAME = "DB_PRUEBA";
    public final static String TABLE_NAME1 = "USUARIOS";
    public final static String COL1_1 = "ID";
    public final static String COL1_2 = "USUARIO";
    public final static String COL1_3 = "NOMBRE";
    public final static String COL1_4 = "APELLIDO";
    public final static String COL1_5 = "TELEFONO";
    public final static String COL1_6 = "PASSWORD";
    public final static String COL1_2 = "ID";
    public final static String COL2_2 = "USUARIO";
    public final static String COL3_2 = "ARTICULO";
    public final static String COL4_2 = "CANTIDAD";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE1_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NOMBRE TEXT,APELLIDO TEXT,TELEFONO INTERGER) ");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE2_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NOMBRE TEXT,APELLIDO TEXT,TELEFONO INTERGER) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);
    }

    public boolean inserData(String Nombre, String Apellido, String Telefono)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_2, Nombre);
        cv.put(COL_3, Apellido);
        cv.put(COL_4, Telefono);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result==-1) {
            return false;
        }
        else
        {
            return true;
        }

    }

    public Cursor getData(String Id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT *FROM " + TABLE_NAME + "WHERE ID='"+Id+"'", null);
        return cursor;
    }

    public boolean upDateData(String Id, String Nombre, String Apellido, String Telefono) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_2, Nombre);
        cv.put(COL_3, Apellido);
        cv.put(COL_4, Telefono);
        long result = db.update(TABLE_NAME, cv, "ID=?", new String[]{Id});
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public boolean deleteDAta(String Id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "ID=?", new String[]{Id});
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
}

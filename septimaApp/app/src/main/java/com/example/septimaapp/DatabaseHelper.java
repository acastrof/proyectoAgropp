package com.example.septimaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public final static String DATABASE_NAME = "DB_PRUEBA";
    public final static String TABLE1_NAME = "USUARIOS";
    public final static String COL1_1 = "ID";
    public final static String COL2_1 = "USUARIO";
    public final static String COL3_1 = "NOMBRE";
    public final static String COL4_1 = "APELLIDO";
    public final static String COL5_1 = "TELEFONO";
    public final static String COL6_1 = "CORREO";
    public final static String COL7_1 = "PASSWORD";
    public final static String TABLE2_NAME = "ULTIMO USUARIO ";
    public final static String COL1_2 = "ID";
    public final static String COL2_2 = "USUARIO";
    public final static String COL3_2 = "SESION";
    /*public final static String COL3_2 = "ARTICULO";
    public final static String COL4_2 = "CANTIDAD";
    public final static String COL_32="SESION";*/

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE1_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NOMBRE TEXT,APELLIDO TEXT,TELEFONO INTERGER,PASSEWORD TEXT,CORREO TEXT) ");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE2_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "USUARIO TEXT,ARTICULO TEXT,CANTIDAD INTERGER) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE1_NAME);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE2_NAME);
        onCreate(db);
    }
    public boolean insertUltimosUsuarios(String Nombre,String sesion)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL3_1, Nombre);
        cv.put(COL3_2, sesion);
        Long result = db.insert(TABLE2_NAME,null,cv);
        if(result==-1)
        {
            return false;
        }
        else {
            return true;
        }
    }

    public boolean inserData(String Usuario, String Nombre, String Apellido, String Telefono, String Correo, String Password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL2_1, Usuario);
        cv.put(COL3_1, Nombre);
        cv.put(COL4_1, Apellido);
        cv.put(COL5_1, Telefono);
        cv.put(COL6_1,Correo);
        cv.put(COL7_1, Password);
        long result = db.update(TABLE1_NAME, cv, "usuario=?", new String[]{Usuario});
        if (result==-1) {
            return false;
        }
        else
        {
            return true;
        }

    }
    public void insertUltimoUsuario(String toString, String s) {

    }

    public Cursor getDataUsuario(String Usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT *FROM " + TABLE1_NAME + " WHERE NOMBRE='"+COL3_1+"'", null);
        return cursor;
    }
    public Cursor getData(String ID)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT *FROM " + TABLE2_NAME + "WHERE ID='"+ID+"'", null);
        return cursor;
    }

    public boolean upDateData(String ID, String Usuario, String Nombre, String Apellido, String Telefono,String Correo,String Password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL2_1, Usuario);
        cv.put(COL3_1, Nombre);
        cv.put(COL4_1, Apellido);
        cv.put(COL5_1, Telefono);
        cv.put(COL6_1,Correo);
        cv.put(COL7_1, Password);
        long result = db.update(TABLE1_NAME, cv, "ID=?", new String[]{Usuario});
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getUltimo(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("SELECT *FROM "+TABLE2_NAME+" WHERE ID='"+id+"'",null);
        return cursor;
    }

    public boolean deleteDAta(String Usuario)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE1_NAME, "ID=?", new String[]{Usuario});
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }



}
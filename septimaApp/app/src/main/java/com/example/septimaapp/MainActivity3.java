package com.example.septimaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CursorAdapter;
import android.widget.Toast;
import android.widget.Toolbar;


import com.google.android.material.navigation.NavigationView;

public class MainActivity3 extends AppCompatActivity {

     TextView T1;
    DatabaseHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        T1=(TextView)findViewById(R.id.t1);
        DB= new DatabaseHelper(this);
        DB.getUltimo("1");
        //metodosesion();
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer=(DrawerLayout) findViewById(R.id.drawer_layout);
        //ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.apertura,R.string.cierre);
        //toggle.syncState();
        NavigationView navigationView=(NavigationView)findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }


    public boolean onNavigationItemSelected(@NonNull MenuItem item ) {
        switch (item.getItemId())
        {
            case R.id.op1Nav:
                T1.setText("Escogio opcion 1crear usuario");

                // Lanzar formulario
                Intent ALU=new Intent(this,LoginUsuario.class);
                startActivity(ALU);

                // Intent AFR=new Intent(this,RegistroUsuarios.class);
                // startActivity(AFR);
                break;
            case R.id.op2Nav:
                T1.setText("Comprar Articulos");
                //lanzar meunu
                Intent COM=new Intent(this,Compras.class);
                startActivity(COM);


                break;
        }
        DrawerLayout drawer =(DrawerLayout)findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

}
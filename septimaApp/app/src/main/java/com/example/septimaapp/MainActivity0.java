package com.example.septimaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity0 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    TextView T1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main0);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        T1=(TextView)findViewById(R.id.t1);
        DrawerLayout drawer=(DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.apertura,R.string.cierre);
        toggle.syncState();
        NavigationView navigationView=(NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item ) {
        switch (item.getItemId())
        {
            case R.id.op1Nav:
                T1.setText("Escogio opcion 1crear usuario");

                // Lanzar formulario
                Intent ALU=new Intent(this,RegistroUsuarios.class);
                startActivity(ALU);
                // Intent AFR=new Intent(this,RegistroUsuarios.class);
                // startActivity(AFR);
                break;
            case R.id.op2Nav:
                T1.setText("Comprar Articulos");
                Intent COM=new Intent(this,Compras.class);
                startActivity(COM);
                break;
            case R.id.op3Nav:Nav:
            T1.setText("Resumen de compras");
                Intent RES=new Intent(this,MainActivityrRegistroCompras.class);
                startActivity(RES);
                break;
            case R.id.op4Nav:Nav:
            T1.setText("Inf agroapp");
                Intent INF=new Intent(this,Informacion_app.class);
                startActivity(INF);
                break;

        }
        DrawerLayout drawer =(DrawerLayout)findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;

    }

}
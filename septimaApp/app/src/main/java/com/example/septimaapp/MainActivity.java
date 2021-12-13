package com.example.septimaapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

public abstract class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    TextView T1;
    Button B1;
    EditText E1, E2;
    Button B2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        T1 = (TextView) findViewById(R.id.t1);
        E1 = (EditText) findViewById(R.id.e1);
        E2 = (EditText) findViewById(R.id.e2);
        B1 = (Button) findViewById(R.id.b1);
        B2 = (Button) findViewById(R.id.b2);
    }

    public void atrial2activity(View view) {

        if (E1.getText().toString().equals("Andrea") && E2.getText().toString().equals("1010")) {
            AlertDialog.Builder ALERTA = new AlertDialog.Builder(this);
            ALERTA.setTitle("titulo de alerta");
            ALERTA.setMessage("Desea ingresar?");
            ALERTA.setPositiveButton("ingresar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent SA = new Intent(view.getContext(), MainActivity3.class);
                    startActivity(SA);
                }

            });
            ALERTA.setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast toast2 = Toast.makeText(view.getContext(), "se cancelo el ingreso", Toast.LENGTH_LONG);
                    toast2.setText(R.string.msj6);
                    toast2.setGravity(Gravity.CENTER, 0, 0);
                    toast2.show();
                    Intent SA = new Intent(view.getContext(), MainActivity.class);
                    startActivity(SA);

                }
            });
            ALERTA.create().show();

            /*Intent SA=new Intent(view.getContext(),segundaActivity.class);
            startActivity(SA);*/
        } else {
            T1.setText(R.string.msj2);
            Toast toast = Toast.makeText(this, "", Toast.LENGTH_LONG);
            toast.setText(R.string.msj2);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
    }
}

    /*Override
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

    }/*



}
 /*TextView T1;
    EditText E1,E2,E3,E4,E5,E6,E7;
    Button B1,B2;
    DatabaseHelper DB;
    CheckBox CHECK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        T1=(TextView)findViewById(R.id.t1);
        E1=(EditText)findViewById(R.id.e1);
        E2=(EditText)findViewById(R.id.e2);
        E3=(EditText)findViewById(R.id.e3);
        E4=(EditText)findViewById(R.id.e4);
        E5=(EditText)findViewById(R.id.e5);
        E6=(EditText)findViewById(R.id.e6);
        B1=(Button)findViewById(R.id.b1);
        B2=(Button)findViewById(R.id.b1);
        DB= new DatabaseHelper(this);
        CHECK=(CheckBox)findViewById(R.id.check);
        DB=new DatabaseHelper(this);
        DB.getUltimo("1");
        //metodosesion();
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer=(DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.apertura,R.string.cierre);
        toggle.syncState();
        NavigationView navigationView=(NavigationView)findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }/*

     */
    /*private void  metodosesion(){
        Cursor res=DB.getUltimo("1");
        String DATOS= null;
        if (res.moveToFirst())
        {
            DATOS="nombre"+res.getString(1)+"\\n sesión abierta";
        }
        T1.setText(DATOS);
    }
    public void metodoGuardar(View view){
        if(CHECK.isChecked()==true)
        {
            DB.insertUltimoUsuario(E1.getText().toString(),"1");
        }
         DB.inserData(E1.getText().toString(),E2.getText().toString(),E3.getText().toString(),E4.getText().toString(),E5.toString().toString(),E6.getText().toString(),E7.getText().toString());
     }
     public  void MetodoConsulta( View view){
        //criterio de busqueda
         Cursor res=DB.getData(E3.getText().toString());
         String DATOS= null;
         if (res.moveToFirst())
         {
             DATOS="ID: "+res.getString(0)+"\n NOMBRE: "+ res.getString(1)+"APELLIDO: "+ res.getString(3);
         }
         T1.setText(DATOS);
     }*/
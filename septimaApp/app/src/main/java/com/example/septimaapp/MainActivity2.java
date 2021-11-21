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

public class MainActivity2 extends AppCompatActivity {
    TextView T1;
    Button B1;
    EditText E1,E2;
    Button  B2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        T1=(TextView)  findViewById(R.id.t1);
        E1=(EditText)findViewById(R.id.e1);
        E2=(EditText)findViewById(R.id.e2);
        B1=(Button)findViewById(R.id.b1);
        B2=(Button)findViewById(R.id.b2);
    }
    public void atrial2activity(View view) {

        if(E1.getText().toString().equals("Andrea")&& E2.getText().toString().equals("1010"))
        {
            AlertDialog.Builder ALERTA=new AlertDialog.Builder(this);
            ALERTA.setTitle("titulo de alerta");
            ALERTA.setMessage("Desea ingresar?");
            ALERTA.setPositiveButton("ingresar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent SA=new Intent(view.getContext(),MainActivity2.class);
                    startActivity(SA);

                }
            });
            ALERTA.setNegativeButton("cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast toast2 = Toast.makeText(view.getContext(), "se cancelo el ingreso",Toast.LENGTH_LONG);
                    toast2.setText(R.string.msj6);
                    toast2.setGravity(Gravity.CENTER,0,0);
                    toast2.show();
                    Intent SA=new Intent(view.getContext(),MainActivity2.class);
                    startActivity(SA);

                }
            });
            ALERTA.create().show();

            /*Intent SA=new Intent(view.getContext(),segundaActivity.class);
            startActivity(SA);*/
        }
        else {
            T1.setText(R.string.msj2);
            Toast toast= Toast.makeText(this,"",Toast.LENGTH_LONG );
            toast.setText(R.string.msj2);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
    }
}
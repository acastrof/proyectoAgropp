package com.example.septimaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RegistroUsuarios extends AppCompatActivity {
    int op = 0;
    LinearLayout CONTE;
    Button B1,B2,B3,B4,B5;
    Fragment FRAG;
    EditText E1, E2, E3, E4, P, PC;
    TextView T1;
    DatabaseHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);
        CONTE = (LinearLayout) findViewById(R.id.contenedor);
        CONTE.setVisibility(View.INVISIBLE);
        E1 = (EditText) findViewById(R.id.e1);
        E2 = (EditText) findViewById(R.id.e2);
        E3 = (EditText) findViewById(R.id.e3);
        E4= (EditText) findViewById(R.id.e4);
        T1 = (TextView) findViewById(R.id.t1);
        B1=(Button)findViewById(R.id.b1);
        B2=(Button)findViewById(R.id.b2);
        B3=(Button)findViewById(R.id.b3);
        B4=(Button)findViewById(R.id.b4);
        B5=(Button)findViewById(R.id.b5);
        DB= new DatabaseHelper(this);
    }

        public void metodoPolitica(View view){

            switch (op) {
                case 0:
                    CONTE.setVisibility(View.VISIBLE);
                    FRAG = new fragmento1();
                    op = 1;
                    cargarfragmento(FRAG);
                    break;
                case 1:
                    FRAG = new fragmento2();
                    op = 2;
                    cargarfragmento(FRAG);
                    break;
                case 2:
                    CONTE.setVisibility(View.INVISIBLE);
                    op = 0;
                    break;
        }
        }


    private void cargarfragmento(Fragment frag) {
        FragmentManager manger = getSupportFragmentManager();
        FragmentTransaction transaction = manger.beginTransaction();
        transaction.replace(R.id.fragmentContainerView, frag);
        transaction.commit();
    }
    public void crearUsuario(View view) {
        String Nombre, Apellido, Telefono;
        int v1, v2, v3;
        Nombre = E1.getText().toString();
        v1 = validarCaracteres(1, Nombre);
        Apellido = E2.getText().toString();
        v2 = validarCaracteres(1, Apellido);
        Telefono = E3.getText().toString();
        v3 = validarCaracteres(2, Telefono);
        if (v1!=1 || v2!= 1|| v3!=1 )
        {
            T1.setText("error");
            //no se creara usuario
        } else {
            //crear usuario nuevo
            T1.setText("Ok");
            //guardar
            if(DB.inserData(Nombre,Apellido,Telefono));
            {
                T1.setText("registro exitoso");
            }


        }
    }

    private int validarCaracteres(int i, String cadena) {
        int validacion = 1, pos, c ;
        switch (i)
        {
            case 1:
                //caracteres alfabeticos
                for (pos = 0; pos < cadena.length();pos = pos + 1)
                {
                    c = cadena.charAt(pos);
                    if (c < 67 || c >90)
                    {
                        validacion = 0;
                        pos = cadena.length();
                    }
                }
                break;
            case 2:
                //caracteres numericos
                for (pos = 0; pos<cadena.length(); pos=pos+1)
                {
                    c = cadena.charAt(pos);
                    if (c<48 || c> 57)

                    {
                        validacion = 0;
                        pos=cadena.length();

                    }
                }
                break;
        }
        return validacion;

    }

    public void metodoColsultar(View view) {
        //criterio de busqueda

        Cursor res= DB.getData(E4.getText().toString());
        String DATOS=null;
        if(res.moveToFirst())
        {

            DATOS="ID:"+res.getString(0)+"\n NOMBRE:"+res.getString(1)+ "\n APELLIDO:"+res.getString(2)+ "\n TELEFONO"+res.getString(3);

        }
        T1.setText(DATOS);
    }

    public void metodoeditar(View view) {
        DB.upDateData(E4.getText().toString(),E1.getText().toString(),E2.getText().toString(),E3.getText().toString());
    }

    public void metodoBorrar(View view) {
        DB.deleteDAta(E4.getText().toString());
    }
}


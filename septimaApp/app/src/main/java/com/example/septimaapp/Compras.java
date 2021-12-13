package com.example.septimaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Compras extends AppCompatActivity {
    Button B1, B2, B3, B4, B5,B6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);
        B1 = (Button) findViewById(R.id.b1);
        B2 = (Button) findViewById(R.id.b2);
        B3 = (Button) findViewById(R.id.b3);
        B4 = (Button) findViewById(R.id.b4);
        B5 = (Button) findViewById(R.id.b5);
        B6 = (Button) findViewById(R.id.b6);

    }

    private void onAdd_miel(View view) {
        onAdd_miel(findViewById(R.id.t2));

    }

    private void onAdd_arte(View view) {
        onAdd_arte(findViewById(R.id.t2));
    }

    private void onAdd_tecafe(View view) {
        onAdd_tecafe(findViewById(R.id.t2));
    }

    private void onAdd_dulcescafe(View view) {
        onAdd_dulcescafe(findViewById(R.id.t2));
    }

    private void onAdd_tortas(View view) {
        onAdd_tortas(findViewById(R.id.t2));
    }

    private void onAdd_comprarcafetostado(View view) {
        onAdd_comprarcafetostado(findViewById(R.id.t2));
    }
}
package com.example.appbdsqliteaguilar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListaProductos extends AppCompatActivity { //Inicia clase
    public TextView tvSalidaPrecio;
    public ListView lvProductos;

    //Arreglo para losta de productos
    public String productos[]={"Smar TV ", "Tablet", "PC", "Radio", "Smart Watch"};
    //Arreglo para imprimir precios
    public String precio[]= {"1000","900", "4000", "500", "300"};

    @Override
    protected void onCreate(Bundle savedInstanceState) { //Inicio OnCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);

        //Integracion elementos de XML  a JAVA
        tvSalidaPrecio= findViewById(R.id.tvSalidaPrecio);
        lvProductos= (ListView) findViewById(R.id.lvProductos);


        //Definicion de un  adapter  pra lista de productos
        ArrayAdapter <String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,productos);


            lvProductos.setAdapter(adapter);

        //Programa de evento click Para seleccionar el producto de la lista y se imprima precio
        lvProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                tvSalidaPrecio.setText("Precio de venta: "+precio[position]);
            }
        });



    }//Termina OnCreate
}
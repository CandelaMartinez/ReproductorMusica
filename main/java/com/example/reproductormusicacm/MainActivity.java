package com.example.reproductormusicacm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //declaro las variables para poder usar el listView y mi adaptador propio
    public ListView todasCancionesCM;
    public AdaptadorCM miAdaptadorCM;
    public static int miPosicionLV;
    public static String [] listaCancionesNombresCM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inicializo la variable ListView
        todasCancionesCM =(ListView) findViewById(R.id.lvTodasCancionesCM);

        //lleno el array de nombre con metodo
        listaCancionesNombresCM=LlenoArrayNombre(listaCancionesNombresCM);

        //inicializo mi adaptador
        ArrayList <Item>miArrayList= getArrayListItems();
        miAdaptadorCM= new AdaptadorCM(miArrayList, this);
        //le asigno ese adaptador a mi ListView
        todasCancionesCM.setAdapter(miAdaptadorCM);

        //metodo que reacciona al seleccionar un item del listView
        //lleva dentro una clase anonima
        //no hay que agregar este metodo en ningun componente de la parte grafica
        todasCancionesCM.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                miPosicionLV=posicion;
               // System.out.println("Cancion ELEGIDa*****"+adapterView.getItemAtPosition(posicion)+ " posicion: "+ miPosicionLV);
                Intent miIntent= new Intent(view.getContext(),Reproducir.class);
                startActivity(miIntent);
            }
        });
    }
    public String[] LlenoArrayNombre(String[] arrayNombres){
        arrayNombres= new String[]{"samba","Creative Minds","DownTown","Dreams","Dubstep","Funky Element",
                "Funky Suspense","Groovy Hip Hop","Hey","Hip Jazz","House","Human Among Us",
                "Inspire","Jazzy Frenchy","Just Breathe","Monster Stomp","Moose","Once Again",
                "Perception","Race","Sexy","Sound","Summer","Sweet","Tea","The elevator"};
        return arrayNombres;
    }

    //metodo que me crea el arrayList que llenara mi listView
    public ArrayList<Item> getArrayListItems(){
        ArrayList<Item> listaItemsCM= new ArrayList<>();
        int k=0;
        for(int i=0; i<listaCancionesNombresCM.length; i++){
            listaItemsCM.add(k, new Item(R.drawable.iconomusica, listaCancionesNombresCM[i]));
            k++;
        }
        return listaItemsCM;
    }
}
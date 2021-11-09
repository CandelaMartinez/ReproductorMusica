package com.example.reproductormusicacm;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Reproducir extends AppCompatActivity {

    Button btPlayPause;
    Button btRepetirCM;
    MediaPlayer mpCM;
    ImageView ivImageCM;
    boolean repetirCM= false;
    int posicionCM=0;
    int posicionTraida;
    public  MediaPlayer [] listaCancionesCM;
    TextView tvNombreCM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproducir);

        //inicializo los componentes de mi actividad
        btPlayPause= findViewById(R.id.btPlayCM);
        tvNombreCM=findViewById(R.id.textViewNombreCancionCm);
        btRepetirCM=findViewById(R.id.btRepetirCM);

        //uso el metodo llenoArrayCanciones para poner las canciones dentro del array de MediaPlayer
        listaCancionesCM= LLenoArrayCanciones(listaCancionesCM);

        //logre traer la posicion elegida el ListView desde la actividad principal
        posicionTraida= MainActivity.miPosicionLV;

        //tengo que usar esa posicion como parametro del indice del array que tiene las canciones
        if(!listaCancionesCM[posicionTraida].isPlaying()){
            listaCancionesCM[posicionTraida].start();
            //uso esa posicion para el array de nombres de canciones, lo pongo en un textView
            tvNombreCM.setText(MainActivity.listaCancionesNombresCM[posicionTraida]);
        }
    }

    public MediaPlayer[] LLenoArrayCanciones(MediaPlayer[]arrayCanciones){
        arrayCanciones= new MediaPlayer[26];
        arrayCanciones[0]= MediaPlayer.create(this,R.raw.brazilsamba);
        arrayCanciones[1]= MediaPlayer.create(this,R.raw.creativeminds);
        arrayCanciones[2]= MediaPlayer.create(this, R.raw.downtown);
        arrayCanciones[3]= MediaPlayer.create(this, R.raw.dreams);
        arrayCanciones[4]= MediaPlayer.create(this, R.raw.dubstep);
        arrayCanciones[5]= MediaPlayer.create(this, R.raw.funkyelement);
        arrayCanciones[6]= MediaPlayer.create(this, R.raw.funkysuspense);
        arrayCanciones[7]= MediaPlayer.create(this, R.raw.groovyhiphop);
        arrayCanciones[8]= MediaPlayer.create(this, R.raw.hey);
        arrayCanciones[9]= MediaPlayer.create(this, R.raw.hipjazz);
        arrayCanciones[10]= MediaPlayer.create(this, R.raw.house);
        arrayCanciones[11]= MediaPlayer.create(this, R.raw.humanamongus);
        arrayCanciones[12]= MediaPlayer.create(this, R.raw.inspire);
        arrayCanciones[13]= MediaPlayer.create(this, R.raw.jazzyfrenchy);
        arrayCanciones[14]= MediaPlayer.create(this, R.raw.justbreathe);
        arrayCanciones[15]= MediaPlayer.create(this, R.raw.monsterstomp);
        arrayCanciones[16]= MediaPlayer.create(this, R.raw.moose);
        arrayCanciones[17]= MediaPlayer.create(this, R.raw.onceagain);
        arrayCanciones[18]= MediaPlayer.create(this, R.raw.perception);
        arrayCanciones[19]= MediaPlayer.create(this, R.raw.race);
        arrayCanciones[20]= MediaPlayer.create(this, R.raw.sexy);
        arrayCanciones[21]= MediaPlayer.create(this, R.raw.sound);
        arrayCanciones[22]= MediaPlayer.create(this, R.raw.summer);
        arrayCanciones[23]= MediaPlayer.create(this, R.raw.sweet);
        arrayCanciones[24]= MediaPlayer.create(this, R.raw.tea);
        arrayCanciones[25]= MediaPlayer.create(this, R.raw.theelevatorbossanova);
        return arrayCanciones;

    }



    //metodo asociado desde vista diseña al boton playPause
    //usa la posicion que me traje desde la actividad principal para verificar si esta sonando
    //si esta sonando: pause, cambia el fondo del boton y saca un toast
    public void PlayPause(View view){
        if(listaCancionesCM[posicionTraida].isPlaying()){
            listaCancionesCM[posicionTraida].pause();
            btPlayPause.setBackgroundResource(R.drawable.reproducir);
            Toast.makeText(this, "Pause",Toast.LENGTH_SHORT).show();
            tvNombreCM.setText(MainActivity.listaCancionesNombresCM[posicionTraida]);
        }else {
            listaCancionesCM[posicionTraida].start();
           btPlayPause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Play",Toast.LENGTH_SHORT).show();
            tvNombreCM.setText(MainActivity.listaCancionesNombresCM[posicionTraida]);

        }
    }

    public void Stop(View view){
        if(listaCancionesCM[posicionTraida]!=null){
            listaCancionesCM[posicionTraida].stop();
            //vuelvo a instanciar las variables Media Payer
            listaCancionesCM= LLenoArrayCanciones(listaCancionesCM);
            //borro la eleccion de posicion traida
            posicionTraida=0;
            //cambio la apariencia del boton reproducir
            btPlayPause.setBackgroundResource(R.drawable.reproducir);
            //toast
            Toast.makeText(this,"Stop",Toast.LENGTH_SHORT).show();
            tvNombreCM.setText("");
        }
    }

    public void Repetir(View view){
        //si repetir is false
        if(!repetirCM){
            //cambio el fondo del boton a no repetir
            btRepetirCM.setBackgroundResource(R.drawable.repetir);
            //saco toast
            Toast.makeText(this,"No repetir",Toast.LENGTH_SHORT).show();
            //le digo que la cancion de la posicion traida no se loopee
            listaCancionesCM[posicionTraida].setLooping(false);
            //cambio el estado de repetir
            repetirCM= true;
            tvNombreCM.setText(MainActivity.listaCancionesNombresCM[posicionTraida]);
        }else{
            //cambio el fondo del boton a no repetir
            btRepetirCM.setBackgroundResource(R.drawable.no_repetir);
            //saco toast
            Toast.makeText(this,"Repetir",Toast.LENGTH_SHORT).show();
            //le digo que la cancion de la posicion traida no se loopee
            listaCancionesCM[posicionTraida].setLooping(true);
            //cambio el estado de repetir
            repetirCM= false;
            tvNombreCM.setText(MainActivity.listaCancionesNombresCM[posicionTraida]);
        }
    }

    public void Siguiente(View view){
        //veo si no estoy en la ultima posicion del array de canciones
        if(posicionTraida<listaCancionesCM.length-1){
            //veo si esa cancion se esta reproduciendo
            if(listaCancionesCM[posicionTraida].isPlaying()){
                //si es asi, la paro
                listaCancionesCM[posicionTraida].stop();
                //sumo una posicion
                posicionTraida++;
                //la prendo
                listaCancionesCM[posicionTraida].start();
                tvNombreCM.setText(MainActivity.listaCancionesNombresCM[posicionTraida]);

            }else {
                //si no se esta reproduciendo, solo le sumo una posicion
                posicionTraida++;
                tvNombreCM.setText(MainActivity.listaCancionesNombresCM[posicionTraida]);
            }
        }else{
            //si es la ultima posicion
            Toast.makeText(this, "No hay mas canciones",Toast.LENGTH_SHORT).show();
            tvNombreCM.setText("");
        }
    }

    public void Anterior(View view){
        if(posicionTraida>=1){
            if(listaCancionesCM[posicionTraida].isPlaying()){
                listaCancionesCM[posicionTraida].stop();
                listaCancionesCM=LLenoArrayCanciones(listaCancionesCM);
                posicionTraida--;
                listaCancionesCM[posicionTraida].start();
                tvNombreCM.setText(MainActivity.listaCancionesNombresCM[posicionTraida]);

            }else{
                posicionTraida--;
                tvNombreCM.setText(MainActivity.listaCancionesNombresCM[posicionTraida]);
            }

        }else{
            Toast.makeText(this,"No hay mas canciones",Toast.LENGTH_SHORT).show();
            tvNombreCM.setText("");
        }
    }


}
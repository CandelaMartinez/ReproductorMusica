package com.example.reproductormusicacm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorCM extends BaseAdapter {

    public ArrayList<Item> listaItemCM;
    public Context miContextoCM;

    public AdaptadorCM(ArrayList<Item> listaItemCM, Context miContextoCM) {
        this.listaItemCM = listaItemCM;
        this.miContextoCM = miContextoCM;
    }

    @Override
    public int getCount() {
        return listaItemCM.size();
    }

    @Override
    public Object getItem(int posicion) {
        return listaItemCM.get(posicion);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posicion, View view, ViewGroup viewGroup) {
        //creo el objeto de la clase item para poder darle valor a sus campos
        Item itemCM= (Item) getItem(posicion);

        view= LayoutInflater.from(miContextoCM).inflate(R.layout.item,null);
        //crear cada elemento del item
        ImageView imgMusicaCM= (ImageView) view.findViewById(R.id.ivIconoMusicaCM);
        TextView textoMusicaCM=(TextView) view.findViewById(R.id.tvNombreMusicaCM);

        //le doy valor a cada uno de los campos
        imgMusicaCM.setImageResource(itemCM.getImgFotoCM());
        textoMusicaCM.setText(itemCM.getTituloCancionCM());

        return view;
    }
}

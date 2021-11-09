package com.example.reproductormusicacm;

public class Item {
    public int imgFotoCM;
    public String tituloCancionCM;

    public Item (int imgFotoCM, String tituloCancionCM){
        this.imgFotoCM= imgFotoCM;
        this.tituloCancionCM=tituloCancionCM;
    }

    public int getImgFotoCM(){return imgFotoCM;}

    public String getTituloCancionCM(){return tituloCancionCM;}
}

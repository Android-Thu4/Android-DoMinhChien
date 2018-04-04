package com.example.silver.docsach;

/**
 * Created by SILVER on 4/4/2018.
 */

public class Sotap {
    private  int Sach;
    private String Tensach;
    private int Muiten;

    public Sotap(int sach, String tensach, int muiten) {
        Sach = sach;
        Tensach = tensach;
        Muiten = muiten;
    }

    public int getSach() {
        return Sach;
    }

    public void setSach(int sach) {
        Sach = sach;
    }

    public String getTensach() {
        return Tensach;
    }

    public void setTensach(String tensach) {
        Tensach = tensach;
    }

    public int getMuiten() {
        return Muiten;
    }

    public void setMuiten(int muiten) {
        Muiten = muiten;
    }
}

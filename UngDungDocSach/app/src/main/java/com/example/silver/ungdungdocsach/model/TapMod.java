package com.example.silver.ungdungdocsach.model;

/**
 * Created by SILVER on 14/05/2018.
 */

public class TapMod {
    private   int MaTap;
    private   String TenTap;

    public TapMod(int maTap, String tenTap) {
        MaTap = maTap;
        TenTap = tenTap;
    }
    public TapMod() {

    }

    public int getMaTap() {
        return MaTap;
    }

    public void setMaTap(int maTap) {
        MaTap = maTap;
    }

    public String getTenTap() {
        return TenTap;
    }

    public void setTenTap(String tenTap) {
        TenTap = tenTap;
    }
}

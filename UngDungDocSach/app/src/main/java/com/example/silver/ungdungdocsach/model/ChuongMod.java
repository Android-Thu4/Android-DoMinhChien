package com.example.silver.ungdungdocsach.model;

/**
 * Created by SILVER on 14/05/2018.
 */

public class ChuongMod {
    private int MaChuong;
    private String TenChuong;
    private int MaTap;

    public ChuongMod(int maChuong, String tenChuong, int maTap) {
        MaChuong = maChuong;
        TenChuong = tenChuong;
        MaTap = maTap;
    }
    public ChuongMod() {

    }

    public int getMaChuong() {
        return MaChuong;
    }

    public void setMaChuong(int maChuong) {
        MaChuong = maChuong;
    }

    public String getTenChuong() {
        return TenChuong;
    }

    public void setTenChuong(String tenChuong) {
        TenChuong = tenChuong;
    }

    public int getMaTap() {
        return MaTap;
    }

    public void setMaTap(int maTap) {
        MaTap = maTap;
    }
}

package com.example.silver.ungdungdocsach.model;

/**
 * Created by SILVER on 14/05/2018.
 */

public class TruyenMod {
    private int MaTruyen;
    private String TenTruyen;
    private String NoiDung;
    private int MaChuong;
    private int maTap;

    public int getMaTap() {
        return maTap;
    }

    public void setMaTap(int maTap) {
        this.maTap = maTap;
    }

    public TruyenMod(int maTruyen, String tenTruyen, String noiDung, int maChuong, int maTap) {
        MaTruyen = maTruyen;
        TenTruyen = tenTruyen;
        NoiDung = noiDung;
        MaChuong = maChuong;
        this.maTap = maTap;
    }

    public TruyenMod() {

    }

    public int getMaTruyen() {
        return MaTruyen;
    }

    public void setMaTruyen(int maTruyen) {
        MaTruyen = maTruyen;
    }

    public String getTenTruyen() {
        return TenTruyen;
    }

    public void setTenTruyen(String tenTruyen) {
        TenTruyen = tenTruyen;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public int getMaChuong() {
        return MaChuong;
    }

    public void setMaChuong(int maChuong) {
        MaChuong = maChuong;
    }
}

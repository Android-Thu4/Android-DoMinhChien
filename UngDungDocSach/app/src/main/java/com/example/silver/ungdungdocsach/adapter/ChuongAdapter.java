package com.example.silver.ungdungdocsach.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.silver.ungdungdocsach.R;
import com.example.silver.ungdungdocsach.activity.Chuong;
import com.example.silver.ungdungdocsach.activity.SoTap;
import com.example.silver.ungdungdocsach.model.ChuongMod;
import com.example.silver.ungdungdocsach.model.TapMod;

import java.util.List;

/**
 * Created by SILVER on 14/05/2018.
 */

public class ChuongAdapter extends BaseAdapter {
    private Chuong myContext ;
    private int myLayout;
    private List<ChuongMod> arrayChuongMod;

    public ChuongAdapter(Chuong myContext, int myLayout, List<ChuongMod> aarrayChuongMod) {
        this.myContext = myContext;
        this.myLayout = myLayout;
        this.arrayChuongMod = aarrayChuongMod;
    }

    @Override
    public int getCount() {
        return arrayChuongMod.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayChuongMod.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder {
        TextView txtTen;
        ImageView imgSach;
        ImageView imgMuiTen;
    }

        @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;


            if(view==null){
                holder = new ViewHolder();
                LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(myLayout,null);
                holder.txtTen       =(TextView) view.findViewById(R.id.textviewten);
                holder.imgSach      =(ImageView) view.findViewById(R.id.imageviewSach);
                holder.imgMuiTen    =(ImageView)view.findViewById(R.id.imageviewMuiten);

                view.setTag(holder);

            }else {
                holder = (ChuongAdapter.ViewHolder) view.getTag();
            }

            final ChuongMod chuongMod = arrayChuongMod.get(i);
            holder.txtTen.setText(chuongMod.getTenChuong());
        return view;
    }
}

package com.example.silver.ungdungdocsach.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.silver.ungdungdocsach.R;
import com.example.silver.ungdungdocsach.activity.Truyen;
import com.example.silver.ungdungdocsach.model.TapMod;
import com.example.silver.ungdungdocsach.model.TruyenMod;

import java.util.List;

/**
 * Created by SILVER on 14/05/2018.
 */

public class TruyenAdapter extends BaseAdapter {
    private Truyen myContext;
    private  int myLayout;
    private List<TruyenMod> arrayTruyenMod;

    public TruyenAdapter(Truyen myContext, int myLayout, List<TruyenMod> arrayTruyenMod) {
        this.myContext = myContext;
        this.myLayout = myLayout;
        this.arrayTruyenMod = arrayTruyenMod;
    }

    @Override
    public int getCount() {
        return arrayTruyenMod.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayTruyenMod.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder {
        TextView txtTen,txtNoiDung;
        ImageView imgNgoiSao;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TruyenAdapter.ViewHolder holder;


        if (view == null) {
            holder = new TruyenAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(myLayout, null);
            holder.txtTen = (TextView) view.findViewById(R.id.textviewten);
            holder.txtNoiDung=(TextView) view.findViewById(R.id.noi_dung);
            holder.imgNgoiSao = (ImageView) view.findViewById(R.id.imgNgoiSao);


            view.setTag(holder);

        } else {
            holder = (TruyenAdapter.ViewHolder) view.getTag();
        }

        final TruyenMod truyenMod = arrayTruyenMod.get(i);
        holder.txtTen.setText(truyenMod.getTenTruyen());
        holder.txtNoiDung.setText(truyenMod.getNoiDung());

        return view;
    }
}

package com.example.silver.ungdungdocsach.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.silver.ungdungdocsach.R;
import com.example.silver.ungdungdocsach.activity.SoTap;
import com.example.silver.ungdungdocsach.model.TapMod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SILVER on 11/05/2018.
 */

public class TapAdapter extends BaseAdapter {

    private SoTap myContext;
    private int myLayout;
    private List<TapMod> arrayTapMod;

    public TapAdapter(SoTap myContext, int myLayout, List<TapMod> arrayTapMod) {
        this.myContext = myContext;
        this.myLayout = myLayout;
        this.arrayTapMod = arrayTapMod;
    }

    @Override
    public int getCount() {
        return arrayTapMod.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayTapMod.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder {
        TextView txtTen;
        ImageView imgSach, imgDelete;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;


        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(myLayout, null);
            holder.txtTen = (TextView) view.findViewById(R.id.textviewten);
            holder.imgSach = (ImageView) view.findViewById(R.id.imageviewSach);
            holder.imgDelete = (ImageView) view.findViewById(R.id.imgDelete);

            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        final TapMod tapMod = arrayTapMod.get(i);
        holder.txtTen.setText(tapMod.getTenTap());


        //bắt sự kiện xóa và sửa
       /* holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myContext.DialogSuaTruyen(tapMod.getTenTap(), tapMod.getMaTap());
            }
        });

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myContext.DialogXoaTruyen(tapMod.getTenTap(), tapMod.getMaTap());
            }
        });

        return view;
    }*/
       return view;
    }
}

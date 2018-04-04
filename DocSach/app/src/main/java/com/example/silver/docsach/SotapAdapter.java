package com.example.silver.docsach;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SILVER on 4/4/2018.
 */

public class SotapAdapter extends BaseAdapter{
    private Context context;
    private int layout;
    private List<Sotap> sotapList;

    public SotapAdapter(Context context,int layout, List<Sotap> sotapList){
        this.context = context;
        this.layout=layout;
        this.sotapList=sotapList;
    }
    @Override
    public int getCount(){return sotapList.size();}
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 1;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        TextView txtTen=(TextView) view.findViewById(R.id.textviewten);
        ImageView imgSach=(ImageView) view.findViewById(R.id.imageviewSach);
        ImageView imgMuiTen=(ImageView) view.findViewById(R.id.imageviewMuiten);
        Sotap sotap=sotapList.get(i);
        txtTen.setText(sotap.getTensach());
        imgSach.setImageResource(sotap.getSach());
        imgMuiTen.setImageResource(sotap.getMuiten());
        return view;
    }
}

package com.example.silver.ungdungdocsach.activity;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.silver.ungdungdocsach.R;
import com.example.silver.ungdungdocsach.adapter.TruyenAdapter;
import com.example.silver.ungdungdocsach.model.ChuongMod;
import com.example.silver.ungdungdocsach.model.TapMod;
import com.example.silver.ungdungdocsach.model.TruyenMod;

import java.util.ArrayList;
import java.util.List;

public class Truyen extends AppCompatActivity {
    SQLite db;
    List<TruyenMod> arrayTruyen;
    TextView tieude;
    TextView noidung;
    Button nex , rev;
    int n = 0;
    int chuong;   int tap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truyen);

        db = new SQLite(this,"cuoiki1",null,1);
        chuong = getIntent().getIntExtra("chuong",0);
        tap = getIntent().getIntExtra("tap",0);

        String sql = "SELECT * FROM TruyenMod WHERE MaTap ="+tap+" and MaChuong = " + chuong;
        tieude = (TextView) findViewById(R.id.tieu_de);
        noidung = (TextView) findViewById(R.id.noi_dung);
        nex = (Button)findViewById(R.id.nex);
        rev = (Button)findViewById(R.id.rev);

        arrayTruyen = new ArrayList<>();
        Cursor cursorTap = db.GetData(sql);
        while(cursorTap.moveToNext()){
            String td = cursorTap.getString(1);
            String nd = cursorTap.getString(2);
            int id = cursorTap.getInt(0);
            int id_chuong = cursorTap.getInt(3);
            int id_tap = cursorTap.getInt(4);

            TruyenMod tr = new TruyenMod(id,td,nd,id_chuong,id_tap);
            arrayTruyen.add(tr);
        }
        if(arrayTruyen.size()>0) {
            setContentButton(chuong,tap);
        }
        else {
            Toast.makeText(Truyen.this,arrayTruyen.size() + "_*ERRO*>>sql_",Toast.LENGTH_SHORT).show();
        }

        nex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(chuong<11) {
                chuong++;
                setContentButton(chuong,tap);

            }
            else Toast.makeText(Truyen.this,"Đã tới cuối !",Toast.LENGTH_SHORT).show();
            }
        });
        rev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chuong>0) {
                    chuong--;
                    setContentButton(chuong,tap);


                }
                else Toast.makeText(Truyen.this,"Đã tới cuối !",Toast.LENGTH_SHORT).show();

            }
        });


    }
    private void setContentButton(int chuong, int tap){


            String sql = "SELECT * FROM TruyenMod WHERE MaTap ="+tap+" and MaChuong = " + chuong;
            arrayTruyen.clear();
            arrayTruyen = new ArrayList<>();
            Cursor cursorTap = db.GetData(sql);
            while(cursorTap.moveToNext()){
                String td = cursorTap.getString(1);
                String nd = cursorTap.getString(2);
                int id = cursorTap.getInt(0);
                int id_chuong = cursorTap.getInt(3);
                int id_tap = cursorTap.getInt(4);

                TruyenMod tr = new TruyenMod(id,td,nd,id_chuong,id_tap);
                arrayTruyen.add(tr);
            tieude.setText(arrayTruyen.get(n).getTenTruyen()+" ");
            noidung.setText(arrayTruyen.get(n).getNoiDung()+" ");
        }
        setTitle("Bạn đang đọc Tập " + tap + " - Chương " + chuong);
    }

}

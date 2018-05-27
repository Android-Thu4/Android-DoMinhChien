package com.example.silver.ungdungdocsach.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.silver.ungdungdocsach.R;
import com.example.silver.ungdungdocsach.adapter.TapAdapter;
import com.example.silver.ungdungdocsach.model.ChuongMod;
import com.example.silver.ungdungdocsach.model.TapMod;
import com.example.silver.ungdungdocsach.model.TruyenMod;

import java.util.ArrayList;
import java.util.List;

public class SoTap extends AppCompatActivity {

    ListView lvTap;
    SQLite db;
    TapAdapter adapter;
    ArrayList<TapMod> arrayTapMod;
    private String text[] = {"Bạn Đang Đọc Truyện: 1.Hạt Giống Tâm Hồn-Tập 1", "Bạn Đang Đọc Truyện: 2.Hạt Giống Tâm Hồn-Tập 2", "Bạn Đang Đọc Truyện: 3.Hạt Giống Tâm Hồn-Tập 3", "Bạn Đang Đọc Truyện: 4.Hạt Giống Tâm Hồn-Tập 4", "Bạn Đang Đọc Truyện: 5.Hạt Giống Tâm Hồn-Tập 5", "Bạn đang đọc: 6.Hạt Giống Tâm Hồn-Tập 6", "Bạn Đang Đọc Truyện: 7.Hạt Giống Tâm Hồn-Tập 7", "Bạn Đang Đọc Truyện: 8.Hạt Giống Tâm Hồn-Tập 8", "Bạn Đang Đọc Truyện: 9.Hạt Giống Tâm Hồn-Tập 9", "Bạn Đang Đọc Truyện: 10.Hạt Giống Tâm Hồn-Tập 10", "Bạn Đang Đọc Truyện: 11.Hạt Giống Tâm Hồn-Tập 11"};

    private ArrayList<ChuongMod> arrayChuongmod = new ArrayList<>();
    private ArrayList arrayListChuong = new ArrayList<>();
    private ArrayList arrayListTruyen = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_so_tap);
        lvTap = (ListView) findViewById(R.id.listviewTap);


        GetData();

        adapter = new TapAdapter(this, R.layout.dong_so_tap, arrayTapMod);
        lvTap.setAdapter(adapter);
        lvTap.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SoTap.this, text[position] + "", Toast.LENGTH_SHORT).show();
                Intent intentsotap = new Intent(SoTap.this, Chuong.class);

                int idsotap = arrayTapMod.get(position).getMaTap();
                intentsotap.putExtra("matap", idsotap);
                startActivity(intentsotap);
            }
        });


    }

    private void GetData() {
        db = new SQLite(this, "cuoiki1", null, 1);
        arrayTapMod = new ArrayList();
        Cursor cursorTap = db.GetData("SELECT * FROM TapMod");
        while (cursorTap.moveToNext()) {
            int id = cursorTap.getInt(0);
            String ten = cursorTap.getString(1);
            arrayTapMod.add(new TapMod(id, ten));
        }

        Cursor cursorChuong = db.GetData("SELECT * FROM ChuongMod ");
        if (cursorChuong.getCount() == 0) {
            for (int i = 0; i < arrayTapMod.size(); i++) {
                for (int j = 1; j <= 11; j++) {
                    db.QuerryData("INSERT INTO ChuongMod VALUES (null,'Chương " + j + "', " + arrayTapMod.get(i).getMaTap() + ")");
                }
            }
        }


    }


}
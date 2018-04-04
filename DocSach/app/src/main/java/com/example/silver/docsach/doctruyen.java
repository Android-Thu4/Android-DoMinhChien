package com.example.silver.docsach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class doctruyen extends AppCompatActivity {
    ListView lvsotap;
    ArrayList<Sotap> arraysotap;
    SotapAdapter adapter;
    private String text []={"1.Hạt Giống Tâm Hồn-Tập 1","2.Hạt Giống Tâm Hồn-Tập 2","3.Hạt Giống Tâm Hồn-Tập 3","4.Hạt Giống Tâm Hồn-Tập 4","5.Hạt Giống Tâm Hồn-Tập 5","6.Hạt Giống Tâm Hồn-Tập 6","7.Hạt Giống Tâm Hồn-Tập 7","8.Hạt Giống Tâm Hồn-Tập 8","9.Hạt Giống Tâm Hồn-Tập 9","10.Hạt Giống Tâm Hồn-Tập 10","11.Hạt Giống Tâm Hồn-Tập 11"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctruyen);
        Anhxa();
        adapter = new SotapAdapter(this, R.layout.so_tap, arraysotap);
        lvsotap.setAdapter(adapter);
        lvsotap.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentsotap= new Intent(doctruyen.this,sochuong.class);
                startActivity(intentsotap);
            }
        });

    }
    private void Anhxa(){
        lvsotap=(ListView) findViewById(R.id.lvsotap);
        arraysotap = new ArrayList<>();
        arraysotap.add(new Sotap(R.drawable.icon_sach,"1.Hạt Giống Tâm Hồn-Tập 1",R.drawable.icon));
        arraysotap.add(new Sotap(R.drawable.icon_sach,"2.Hạt Giống Tâm Hồn-Tập 2",R.drawable.icon));
        arraysotap.add(new Sotap(R.drawable.icon_sach,"3.Hạt Giống Tâm Hồn-Tập 3",R.drawable.icon));
        arraysotap.add(new Sotap(R.drawable.icon_sach,"4.Hạt Giống Tâm Hồn-Tập 4",R.drawable.icon));
        arraysotap.add(new Sotap(R.drawable.icon_sach,"5.Hạt Giống Tâm Hồn-Tập 5",R.drawable.icon));
        arraysotap.add(new Sotap(R.drawable.icon_sach,"6.Hạt Giống Tâm Hồn-Tập 6",R.drawable.icon));
        arraysotap.add(new Sotap(R.drawable.icon_sach,"7.Hạt Giống Tâm Hồn-Tập 7",R.drawable.icon));
        arraysotap.add(new Sotap(R.drawable.icon_sach,"8.Hạt Giống Tâm Hồn-Tập 8",R.drawable.icon));
        arraysotap.add(new Sotap(R.drawable.icon_sach,"9.Hạt Giống Tâm Hồn-Tập 9",R.drawable.icon));
        arraysotap.add(new Sotap(R.drawable.icon_sach,"10.Hạt Giống Tâm Hồn-Tập 10",R.drawable.icon));
        arraysotap.add(new Sotap(R.drawable.icon_sach,"11.Hạt Giống Tâm Hồn-Tập 11",R.drawable.icon));
    }

}

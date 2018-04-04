package com.example.silver.docsach;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class sochuong extends AppCompatActivity {
    ListView lvsotap;
    ArrayList<Sotap> arraysotap;
    SotapAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sochuong);
        Anhxa();
        adapter = new SotapAdapter(this, R.layout.so_tap, arraysotap);
        lvsotap.setAdapter(adapter);
        lvsotap.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }
    private void Anhxa(){
        lvsotap=(ListView) findViewById(R.id.lvchuong);
        arraysotap = new ArrayList<>();
        arraysotap.add(new Sotap(R.drawable.uti,"Chương 1",R.drawable.icon));
        arraysotap.add(new Sotap(R.drawable.uti,"Chương 2",R.drawable.icon));
        arraysotap.add(new Sotap(R.drawable.uti,"Chương 3",R.drawable.icon));
        arraysotap.add(new Sotap(R.drawable.uti,"Chương 4",R.drawable.icon));
        arraysotap.add(new Sotap(R.drawable.uti,"Chương 5",R.drawable.icon));
        arraysotap.add(new Sotap(R.drawable.uti,"Chương 6",R.drawable.icon));
        arraysotap.add(new Sotap(R.drawable.uti,"Chương 7",R.drawable.icon));
        arraysotap.add(new Sotap(R.drawable.uti,"Chương 8",R.drawable.icon));

    }

}

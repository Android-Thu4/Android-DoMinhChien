package com.example.silver.docsach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intentsotap= new Intent(MainActivity.this,doctruyen.class);
        startActivity(intentsotap);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0,0,0,"Thêm Sách");
        menu.add(0,1,0,"Sửa Sách");
        menu.add(0,2,0,"Xóa Sách");
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int index = item.getItemId();

        switch (index){
            case 0:

                break;
            case 1:

                break;
            case 2:

                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

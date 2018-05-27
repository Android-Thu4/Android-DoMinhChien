package com.example.silver.ungdungdocsach.activity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.silver.ungdungdocsach.R;
import com.example.silver.ungdungdocsach.adapter.TapAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button button1;
    private Dialog dialog;
    Button button2;
    Button button3;
    Button button4;
    SQLite db;

    TapAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SetData();

        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentsotap= new Intent(MainActivity.this,SoTap.class);
                startActivity(intentsotap);
            }
        });
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent emailIntent = new Intent(Intent.ACTION_SEND);

            /* Fill it with Data */
                emailIntent.setType("plain/text");
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"chiendo.15t4@email.com"});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Hạt giống tâm hồn");

            /* Send it off to the Activity-Chooser */
                startActivity(Intent.createChooser(emailIntent, "Góp Ý Ứng Dụng"));
            }
        });
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://play.google.com/store/search?q=pub:BookFunny&c=apps"));
                startActivity(i);
            }
        });
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    public void showDialog() {
        dialog = new Dialog(MainActivity.this);
        dialog.setCancelable(true);
        dialog.setTitle("BookFunny");
        dialog.setContentView(R.layout.dialog);
        Button btnDongy=(Button) dialog.findViewById(R.id.btn_dong_y);
        Button btnKhong=(Button) dialog.findViewById(R.id.btn_khong);
        btnDongy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://play.google.com/store/apps/details?id=bookfunny.hatgiongtamhon.full11"));
                startActivity(i);
            }
        });
        btnKhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Bạn đã đăng xuất thành công", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                finish();
            }
        });
        dialog.show();
    }

    private void SetData(){
        db = new SQLite(this,"cuoiki1",null,1);

        //tạo bảng
        db.QuerryData("Create Table IF NOT EXISTS TapMod(MaTap INTEGER PRIMARY KEY AUTOINCREMENT, TenTap VARCHAR )");
        db.QuerryData("Create Table IF NOT EXISTS ChuongMod(MaChuong  INTEGER PRIMARY KEY AUTOINCREMENT, TenChuong VARCHAR ,MaTap INTEGER)");
        db.QuerryData("Create Table IF NOT EXISTS TruyenMod(MaTruyen  INTEGER PRIMARY KEY AUTOINCREMENT, TenTruyen VARCHAR , TruyenMod VARCHAR, MaChuong INTEGER, MaTap INTEGER)");

        Cursor cursor = db.GetData("SELECT * FROM TapMod");
        if(cursor.getCount()==0) {
            //thêm dữ liệu
            db.QuerryData("INSERT INTO TapMod VALUES(null, 'Hạt Giống Tâm Hồn Tập 1')");
            db.QuerryData("INSERT INTO TapMod VALUES(null, 'Hạt Giống Tâm Hồn Tập 2')");
            db.QuerryData("INSERT INTO TapMod VALUES(null, 'Hạt Giống Tâm Hồn Tập 3')");
            db.QuerryData("INSERT INTO TapMod VALUES(null, 'Hạt Giống Tâm Hồn Tập 4')");
            db.QuerryData("INSERT INTO TapMod VALUES(null, 'Hạt Giống Tâm Hồn Tập 5')");
            db.QuerryData("INSERT INTO TapMod VALUES(null, 'Hạt Giống Tâm Hồn Tập 6')");
            db.QuerryData("INSERT INTO TapMod VALUES(null, 'Hạt Giống Tâm Hồn Tập 7')");
            db.QuerryData("INSERT INTO TapMod VALUES(null, 'Hạt Giống Tâm Hồn Tập 8')");
            db.QuerryData("INSERT INTO TapMod VALUES(null, 'Hạt Giống Tâm Hồn Tập 9')");
            db.QuerryData("INSERT INTO TapMod VALUES(null, 'Hạt Giống Tâm Hồn Tập 10')");
            db.QuerryData("INSERT INTO TapMod VALUES(null, 'Hạt Giống Tâm Hồn Tập 11')");

        }

    }
}

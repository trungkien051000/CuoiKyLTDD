package com.example.pinterest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Tuy_chon_khac_Activity extends AppCompatActivity {
    private TextView txtTaiAnh, txtBaoCaoGhim;
    private Button btnDong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuy_chon_khac);
        Intent intentGet = getIntent();
        String name = intentGet.getStringExtra("name");
        txtTaiAnh = (TextView) findViewById(R.id.txt_taianhxuong);
        txtBaoCaoGhim = (TextView) findViewById(R.id.txt_baocaoGhim);
        btnDong = (Button) findViewById(R.id.btnDong_Tuychonkhac);

        txtTaiAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tuy_chon_khac_Activity.this,Tai_Anh_Activity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        txtBaoCaoGhim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tuy_chon_khac_Activity.this,Bao_Cao_GhimActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tuy_chon_khac_Activity.this,AnhActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
    }
}
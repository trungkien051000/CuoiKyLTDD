package com.example.pinterest;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TinnhanActivity extends AppCompatActivity {
Button tk,tnmoi,capnhat;
String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinnhan);
        capnhat = findViewById(R.id.capnhat);
        tk=findViewById(R.id.btn_ten);
        tnmoi=findViewById(R.id.tinnhanmoi);
        Intent intentGet = getIntent();
        name = intentGet.getStringExtra("name");

        capnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TinnhanActivity.this, ThongbaoActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });

        tnmoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TinnhanActivity.this, TrangcanhanActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });

        BottomNavigationView botNav = findViewById(R.id.bottom_navigation6);
        botNav.getMenu().findItem(R.id.bottom_messenger).setChecked(true);
        botNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottom_home:
                        Toast.makeText(TinnhanActivity.this,"Trang chủ",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(TinnhanActivity.this,LayoutTrangchuActivity.class);
                        intent.putExtra("name",name);
                        startActivity(intent);
                        break;
                    case R.id.bottom_search:
                        Toast.makeText(TinnhanActivity.this,"Tìm kiếm",Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(TinnhanActivity.this,MainTimKiemActivity.class);
                        intent1.putExtra("name",name);
                        startActivity(intent1);
                        break;
                    case R.id.bottom_messenger:
                        Toast.makeText(TinnhanActivity.this,"Tin nhắn",Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(TinnhanActivity.this,ThongbaoActivity.class);
                        intent2.putExtra("name",name);
                        startActivity(intent2);
                        break;
                    case R.id.bottom_account:
                        Toast.makeText(TinnhanActivity.this,"Tài khoản",Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(TinnhanActivity.this,MainActivityAccount.class);
                        intent3.putExtra("name",name);
                        startActivity(intent3);
                        break;
                }
                return true;
            }
        });

        tk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToNoidungActivity();
            }
        });
    }
    private void goToNoidungActivity() {
        Intent intent = new Intent(this, NoidungTNActivity.class);
        startActivity(intent);
    }
}
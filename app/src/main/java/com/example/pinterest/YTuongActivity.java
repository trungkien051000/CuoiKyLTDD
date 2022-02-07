package com.example.pinterest;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class YTuongActivity extends AppCompatActivity {
    private ImageView imageViewAnh;
    private Button btnBack;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ytuong);
        Intent intentGet = getIntent();
        name = intentGet.getStringExtra("name");
        btnBack = (Button) findViewById(R.id.imgBt_back_Bonghoacodon);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(YTuongActivity.this, MainTimKiemActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        imageViewAnh = (ImageView) findViewById(R.id.img1);
        imageViewAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(YTuongActivity.this, AnhActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        BottomNavigationView botNav = findViewById(R.id.bottom_navigation4);
        botNav.getMenu().findItem(R.id.bottom_search).setChecked(true);
        botNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottom_home:
                        Toast.makeText(YTuongActivity.this,"Trang chủ",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(YTuongActivity.this,LayoutTrangchuActivity.class);
                        intent.putExtra("name",name);
                        startActivity(intent);
                        break;
                    case R.id.bottom_search:
                        Toast.makeText(YTuongActivity.this,"Tìm kiếm",Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(YTuongActivity.this,MainTimKiemActivity.class);
                        intent1.putExtra("name",name);
                        startActivity(intent1);
                        break;
                    case R.id.bottom_messenger:
                        Toast.makeText(YTuongActivity.this,"Nhắn tin",Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(YTuongActivity.this,ThongbaoActivity.class);
                        intent2.putExtra("name",name);
                        startActivity(intent2);
                        break;
                    case R.id.bottom_account:
                        Toast.makeText(YTuongActivity.this,"Tài khoản",Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(YTuongActivity.this,MainActivityAccount.class);
                        intent3.putExtra("name",name);
                        startActivity(intent3);
                        break;
                }
                return true;
            }
        });

    }
}
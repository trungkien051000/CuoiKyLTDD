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

public class ThongbaoActivity extends AppCompatActivity {

    Button tinnhan;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongbao);

        Intent intentGet = getIntent();
        name = intentGet.getStringExtra("name");

        tinnhan = findViewById(R.id.tinnhan);
        tinnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToTinnhanActivity();
            }
        });
        BottomNavigationView botNav = findViewById(R.id.bottom_navigation5);
        botNav.getMenu().findItem(R.id.bottom_messenger).setChecked(true);
        botNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottom_home:
                        Toast.makeText(ThongbaoActivity.this,"Trang chủ",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ThongbaoActivity.this,LayoutTrangchuActivity.class);
                        intent.putExtra("name",name);
                        startActivity(intent);
                        break;
                    case R.id.bottom_search:
                        Toast.makeText(ThongbaoActivity.this,"Tìm kiếm",Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(ThongbaoActivity.this,MainTimKiemActivity.class);
                        intent1.putExtra("name",name);
                        startActivity(intent1);
                        break;
                    case R.id.bottom_messenger:
                        Toast.makeText(ThongbaoActivity.this,"Tin nhắn",Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(ThongbaoActivity.this,ThongbaoActivity.class);
                        intent2.putExtra("name",name);
                        startActivity(intent2);
                        break;
                    case R.id.bottom_account:
                        Toast.makeText(ThongbaoActivity.this,"Tài khoản",Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(ThongbaoActivity.this,MainActivityAccount.class);
                        intent3.putExtra("name",name);
                        startActivity(intent3);
                        break;
                }
                return true;
            }
        });

    }

    private void goToTinnhanActivity() {
        Intent intent = new Intent(ThongbaoActivity.this, TinnhanActivity.class);
        intent.putExtra("name",name);
        startActivity(intent);
    }
}
package com.example.pinterest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainTimKiemActivity extends Activity {
    private TextView tvBHCD;
    private String name;
    private EditText timkiem;
    private Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_maintimkiem);

        Intent intentGet = getIntent();
        name = intentGet.getStringExtra("name");

        timkiem = findViewById(R.id.edt_timkiem);
        search = findViewById(R.id.btn_search);

        tvBHCD = (TextView) findViewById(R.id.tvBongHoaCoDon);
        tvBHCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainTimKiemActivity.this, YTuongActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainTimKiemActivity.this, ListSearchActivity.class);
                intent.putExtra("infosearch", timkiem.getText().toString());
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        timkiem.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    Intent intent = new Intent(MainTimKiemActivity.this, ListSearchActivity.class);
                    intent.putExtra("infosearch", timkiem.getText().toString());
                    intent.putExtra("name", name);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
        BottomNavigationView botNav = findViewById(R.id.bottom_navigation3);
        botNav.getMenu().findItem(R.id.bottom_search).setChecked(true);
        botNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_home:
                        Toast.makeText(MainTimKiemActivity.this, "Trang chủ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainTimKiemActivity.this, LayoutTrangchuActivity.class);
                        intent.putExtra("name", name);
                        startActivity(intent);
                        break;
                    case R.id.bottom_search:
                        Toast.makeText(MainTimKiemActivity.this, "Tìm kiếm", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(MainTimKiemActivity.this, MainTimKiemActivity.class);
                        intent1.putExtra("name", name);
                        startActivity(intent1);
                        break;
                    case R.id.bottom_messenger:
                        Toast.makeText(MainTimKiemActivity.this, "Tin nhắn", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(MainTimKiemActivity.this, ThongbaoActivity.class);
                        intent2.putExtra("name", name);
                        startActivity(intent2);
                        break;
                    case R.id.bottom_account:
                        Toast.makeText(MainTimKiemActivity.this, "Tài khoản", Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(MainTimKiemActivity.this, MainActivityAccount.class);
                        intent3.putExtra("name", name);
                        startActivity(intent3);
                        break;
                }
                return true;
            }
        });
    }


}
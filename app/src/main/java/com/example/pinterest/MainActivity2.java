    package com.example.pinterest;

    import android.content.Intent;
    import android.os.Bundle;
    import android.view.MenuItem;
    import android.view.View;
    import android.widget.ImageButton;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.annotation.NonNull;
    import androidx.appcompat.app.AppCompatActivity;

    import com.google.android.material.bottomnavigation.BottomNavigationView;

    import SignInSignUp.MainActivity;

    public class MainActivity2 extends AppCompatActivity {
    private TextView chinhSuaHoSoTv, caiDatTaiKhoanTv,dxuat;
    private ImageButton btnChinhSuaHoSo, btnCaiDatTaiKhoan, btnback;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        chinhSuaHoSoTv = (TextView) findViewById(R.id.chinhsuahoso);
        Intent intentGet = getIntent();
        name = intentGet.getStringExtra("name");
        chinhSuaHoSoTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        caiDatTaiKhoanTv = (TextView) findViewById(R.id.caidattaikhoan);
        caiDatTaiKhoanTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        btnChinhSuaHoSo = (ImageButton) findViewById(R.id.btnchinhsuahoso);
        btnChinhSuaHoSo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        btnCaiDatTaiKhoan = (ImageButton) findViewById(R.id.btncaidattaikhoan);
        btnCaiDatTaiKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        btnback = (ImageButton) findViewById(R.id.clear);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivityAccount.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        BottomNavigationView botNav = findViewById(R.id.bottom_navigation8);
        botNav.getMenu().findItem(R.id.bottom_account).setChecked(true);
        botNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottom_home:
                        Toast.makeText(MainActivity2.this,"Trang chủ",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity2.this,LayoutTrangchuActivity.class);
                        intent.putExtra("name",name);
                        startActivity(intent);
                        break;
                    case R.id.bottom_search:
                        Toast.makeText(MainActivity2.this,"Tìm kiếm",Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(MainActivity2.this,MainTimKiemActivity.class);
                        intent1.putExtra("name",name);
                        startActivity(intent1);
                        break;
                    case R.id.bottom_messenger:
                        Toast.makeText(MainActivity2.this,"Nhắn tin",Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(MainActivity2.this,ThongbaoActivity.class);
                        intent2.putExtra("name",name);
                        startActivity(intent2);
                        break;
                    case R.id.bottom_account:
                        Toast.makeText(MainActivity2.this,"Tài khoản",Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(MainActivity2.this,MainActivityAccount.class);
                        intent3.putExtra("name",name);
                        startActivity(intent3);
                        break;
                }
                return true;
            }
        });
        dxuat = findViewById(R.id.dangxuat);
        dxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
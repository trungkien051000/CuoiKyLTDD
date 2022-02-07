package com.example.pinterest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Tai_Anh_Activity extends AppCompatActivity {
    private Button btnDong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tai_anh);
        Intent intentGet = getIntent();
        String name = intentGet.getStringExtra("name");
        btnDong = (Button) findViewById(R.id.btnDong);
        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tai_Anh_Activity.this, AnhActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
    }
}
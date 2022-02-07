package com.example.pinterest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class cmt_Activity extends AppCompatActivity {
    private ImageButton imgBtClose, imgBtBaoCao;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmt);
        imgBtClose = (ImageButton) findViewById(R.id.imgBtn_Dong_cmt);
        imgBtBaoCao = (ImageButton)findViewById(R.id.imgBt_baocao_cmt);
        Intent intentGet = getIntent();
        name = intentGet.getStringExtra("name");
        imgBtClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cmt_Activity.this,AnhActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        imgBtBaoCao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cmt_Activity.this,Baocao_Nhanxet_Activity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
    }
}
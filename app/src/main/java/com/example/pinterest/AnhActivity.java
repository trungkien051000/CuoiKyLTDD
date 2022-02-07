package com.example.pinterest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class AnhActivity extends AppCompatActivity {
    private ImageButton imageButton_bacham,imageButton_cmt,imageButton_share, imageButton_back;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anh);
        imageButton_back = (ImageButton) findViewById(R.id.imgBt_back_anh);
        imageButton_cmt = (ImageButton) findViewById(R.id.imgBt_cmt_anh) ;
        imageButton_share = (ImageButton) findViewById(R.id.imgBt_share_anh);
        imageButton_bacham = (ImageButton) findViewById(R.id.imgBt_bacham_anh);

        Intent intentGet = getIntent();
        name = intentGet.getStringExtra("name");
        imageButton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnhActivity.this,YTuongActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        imageButton_bacham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnhActivity.this, Tuy_chon_khac_Activity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        imageButton_cmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnhActivity.this, cmt_Activity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        imageButton_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnhActivity.this,Share_Activity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
    }
}
package com.example.pinterest;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class LayoutTrangchu1Activity extends AppCompatActivity {
    TextView tieude, mota, ten;
    ImageView imagetrangchu1,back;
    CardView anhcanhan;
    BottomNavigationView botNav;
    Context mContext;
    String id, fileExtension, ImageURL;
    Button download;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_trangchu_1);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);

        ten = findViewById(R.id.txt_Name);
        anhcanhan = findViewById(R.id.avatar_canhan);
        tieude = findViewById(R.id.tv_tieude);
        mota = findViewById(R.id.tv_mota);
        imagetrangchu1 = findViewById(R.id.imageSelected);
        botNav = findViewById(R.id.bottom_navigation2);
        download = findViewById(R.id.btn_download_trangchu1);
        back = findViewById(R.id.button_back);



        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        ten.setText(intent.getStringExtra("name"));
        fileExtension = intent.getStringExtra("fileExtension");
        tieude.setText(intent.getStringExtra("tieude"));
        mota.setText(intent.getStringExtra("mota"));
        ImageURL = intent.getStringExtra("imageUrl");
        Picasso.with(mContext)
                .load(ImageURL)
                .into(imagetrangchu1);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LayoutTrangchu1Activity.this, LayoutTrangchuActivity.class);
                intent.putExtra("name",ten.getText().toString());
                startActivity(intent);
            }
        });
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadFile(tieude.getContext(), id, fileExtension,
                        ImageURL);
                Toast.makeText(mContext, "Đang tải xuống ...", Toast.LENGTH_SHORT).show();
            }
        });
        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentlayout = new Intent(LayoutTrangchu1Activity.this, TrangcanhanActivity.class);
                startActivity(intentlayout);
            }
        });
        anhcanhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentlayout = new Intent(LayoutTrangchu1Activity.this, TrangcanhanActivity.class);
                startActivity(intentlayout);
            }
        });

        botNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_home:
                        Toast.makeText(LayoutTrangchu1Activity.this,"Trang chủ",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LayoutTrangchu1Activity.this, LayoutTrangchuActivity.class);
                        intent.putExtra("name",ten.getText().toString());
                        startActivity(intent);
                        break;
                    case R.id.bottom_search:
                        Toast.makeText(LayoutTrangchu1Activity.this,"Tìm kiếm",Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(LayoutTrangchu1Activity.this, MainTimKiemActivity.class);
                        intent1.putExtra("name",ten.getText().toString());
                        startActivity(intent1);
                        break;
                    case R.id.bottom_messenger:
                        Toast.makeText(LayoutTrangchu1Activity.this,"Tin nhắn",Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(LayoutTrangchu1Activity.this, ThongbaoActivity.class);
                        intent2.putExtra("name",ten.getText().toString());
                        startActivity(intent2);
                        break;
                    case R.id.bottom_account:
                        Toast.makeText(LayoutTrangchu1Activity.this,"Tài khoản",Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(LayoutTrangchu1Activity.this, MainActivityAccount.class);
                        intent3.putExtra("name",ten.getText().toString());
                        startActivity(intent3);
                        break;
                }
                return true;
            }
        });

    }

    public void downloadFile(Context context, String fileName, String fileExtension, String url) {
        DownloadManager downloadmanager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setTitle("Download");
        request.setDescription("Download file ...");
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName + "." + fileExtension);

        if (downloadmanager != null) {
            downloadmanager.enqueue(request);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
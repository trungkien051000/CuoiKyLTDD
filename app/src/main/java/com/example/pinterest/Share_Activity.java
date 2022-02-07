package com.example.pinterest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Share_Activity extends AppCompatActivity {
    private ImageButton close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        Intent intentGet =getIntent();
        String name = intentGet.getStringExtra("name");
        close = (ImageButton) findViewById(R.id.imgBt_back_Share);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Share_Activity.this, AnhActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });

    }
}
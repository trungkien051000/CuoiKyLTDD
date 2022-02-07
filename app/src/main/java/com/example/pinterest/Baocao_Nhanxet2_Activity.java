package com.example.pinterest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Baocao_Nhanxet2_Activity extends AppCompatActivity {
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baocao_nhanxet2);
        Intent intentGet = getIntent();
        String name = intentGet.getStringExtra("name");
        relativeLayout= (RelativeLayout) findViewById(R.id.rllo_Baocao_Nhanxet2);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Baocao_Nhanxet2_Activity.this, Bao_Cao_Spam_Activity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
    }
}
package com.example.pinterest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    private TextView settingTv,tvName;
    private Button btndong;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        settingTv = (TextView) findViewById(R.id.caidat1);
        tvName=findViewById(R.id.tv_name2);

        Intent intentGet = getIntent();
        name = intentGet.getStringExtra("name");
        tvName.setText(name);
        settingTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity5.this, MainActivity2.class);
                intent.putExtra("name",name);
                startActivity(intent);

            }
        });
        btndong = (Button) findViewById(R.id.dong);
        btndong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity5.this, MainActivityAccount.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });

    }


}
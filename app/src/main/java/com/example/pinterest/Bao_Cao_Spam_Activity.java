package com.example.pinterest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Bao_Cao_Spam_Activity extends AppCompatActivity {
    private Button btnBaoCao;
    private ImageButton imageButton_Back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bao_cao_spam);
        Intent intentGet= getIntent();
        String name = intentGet.getStringExtra("name");
        btnBaoCao = (Button) findViewById(R.id.btn_baocao);
        imageButton_Back = (ImageButton) findViewById(R.id.btnBack);

        btnBaoCao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bao_Cao_Spam_Activity.this, AnhActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
                Toast.makeText(Bao_Cao_Spam_Activity.this,"Cảm ơn bạn! Phản hồi này sẽ giúp chúng tôi cải thiện Pinterfake",Toast.LENGTH_LONG).show();;
            }
        });
        imageButton_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Bao_Cao_Spam_Activity.this, Bao_Cao_GhimActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
    }
}
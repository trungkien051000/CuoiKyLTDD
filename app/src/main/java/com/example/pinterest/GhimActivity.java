package com.example.pinterest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class GhimActivity extends AppCompatActivity {
    private RecyclerView rcvghim;
    private GhimAdapter ghimAdapter;
    Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghim);
        close = findViewById(R.id.ic_close);
        Intent intentGet = getIntent();
        String name = intentGet.getStringExtra("name");
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GhimActivity.this, NoidungTNActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });

        rcvghim = findViewById(R.id.recyclerviewghim);
        ghimAdapter = new GhimAdapter();


        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rcvghim.setLayoutManager(staggeredGridLayoutManager);

        ghimAdapter.setData(getListGhim());
        rcvghim.setAdapter(ghimAdapter);


    }

    private List<Ghim> getListGhim() {
        List<Ghim> list = new ArrayList<>();
        list.add(new Ghim(R.drawable.aa, "Trang điểm kiểu tây "));
        list.add(new Ghim(R.drawable.a1, "Floral Overlay Print Sheet Set.Natural stone is always an endless source of inspiration for designers. Let’ be with Viet Home Stone to admire the great masterpieces close to you every day!"));
        list.add(new Ghim(R.drawable.a2, "Korean Beauty Product Reviews"));
        list.add(new Ghim(R.drawable.a3, "Floral Overlay Print Sheet Set"));
        list.add(new Ghim(R.drawable.a4, "Gợi ý những kiểu tóc vừa đẹp vừa sang chảnh dễ thực hiện"));
        list.add(new Ghim(R.drawable.a5, "a on Twitter"));
        list.add(new Ghim(R.drawable.a6, "UlzzangFabs shared a photo on Instagram: “Hi~, sorry for being inactive the past few days but I was adjusting to my new life in Gangnam"));
        list.add(new Ghim(R.drawable.a7, "Photo"));
        list.add(new Ghim(R.drawable.a8, "Floral Overlay Print Sheet Set"));
        list.add(new Ghim(R.drawable.a9, "Cool kitchen appliance, which fits an oven, frying pan"));
        list.add(new Ghim(R.drawable.a10, "The Dental"));
        list.add(new Ghim(R.drawable.a11, "Makeup"));
        return list;
    }
}
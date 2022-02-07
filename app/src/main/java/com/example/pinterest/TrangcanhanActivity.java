package com.example.pinterest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class TrangcanhanActivity extends AppCompatActivity {
    private RecyclerView rcvanh;
    private AnhTCNAdapter anhTCNAdapter;
    String name;

    Button theodoi, back;
    ImageButton btn_caidat, up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangcanhan);
        theodoi = findViewById(R.id.btn_theodoi);
        back = findViewById(R.id.back_tcn);
        Intent intentGet = getIntent();
        name = intentGet.getStringExtra("name");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TrangcanhanActivity.this, TinnhanActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        up = findViewById(R.id.img_btn_up);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickOpenBottomSheetUpDialog();
            }
        });

        btn_caidat = findViewById(R.id.img_btn_caidat);
        btn_caidat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickOpenBottomSheetDialog();
            }
        });

        rcvanh = findViewById(R.id.recyclerviewanhtcn);
        anhTCNAdapter = new AnhTCNAdapter();

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        rcvanh.setLayoutManager(staggeredGridLayoutManager);

        anhTCNAdapter.setData(getListAnhTCN());
        rcvanh.setAdapter(anhTCNAdapter);


    }

    private void clickOpenBottomSheetUpDialog() {
        View v = getLayoutInflater().inflate(R.layout.layout_bottom_sheet_up, null);
        final BottomSheetDialog btsdidlog = new BottomSheetDialog(this);
        btsdidlog.setContentView(v);
        btsdidlog.show();
        Button btn_dong = v.findViewById(R.id.thoat_bottom_sheet);
        btn_dong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btsdidlog.dismiss();
            }
        });
    }

    private void clickOpenBottomSheetDialog() {
        View viewDialog = getLayoutInflater().inflate(R.layout.layout_bottom_sheet, null);
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(viewDialog);
        bottomSheetDialog.show();

        Button btn_dong = viewDialog.findViewById(R.id.bottom_sheet_btn_dong);
        btn_dong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });

    }


    private List<Anhtrangcanhan> getListAnhTCN() {
        List<Anhtrangcanhan> list = new ArrayList<>();
        list.add(new Anhtrangcanhan(R.drawable.dog1, ""));
        list.add(new Anhtrangcanhan(R.drawable.dog2, ""));
        list.add(new Anhtrangcanhan(R.drawable.dog3, ""));
        list.add(new Anhtrangcanhan(R.drawable.dog4, ""));
        list.add(new Anhtrangcanhan(R.drawable.dog5, ""));
        list.add(new Anhtrangcanhan(R.drawable.anime, ""));
        list.add(new Anhtrangcanhan(R.drawable.hoa, ""));
        list.add(new Anhtrangcanhan(R.drawable.ha7, ""));
        list.add(new Anhtrangcanhan(R.drawable.a, ""));
        list.add(new Anhtrangcanhan(R.drawable.a6, ""));
        list.add(new Anhtrangcanhan(R.drawable.a2, ""));
        list.add(new Anhtrangcanhan(R.drawable.ha3, ""));
        list.add(new Anhtrangcanhan(R.drawable.ha4, ""));
        list.add(new Anhtrangcanhan(R.drawable.ha5, ""));


        return list;
    }
}
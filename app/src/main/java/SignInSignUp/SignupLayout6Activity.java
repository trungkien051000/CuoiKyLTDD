package SignInSignUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pinterest.LayoutTrangchuActivity;
import com.example.pinterest.R;

import java.util.ArrayList;

public class SignupLayout6Activity extends AppCompatActivity {
    GridView gridView;
    GridviewAdapter adapter;
    ArrayList<HinhAnh> arrayList;
    Button btn_Next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout6);
        gridView = (GridView) findViewById(R.id.gridView);
        arrayList = new ArrayList<>();
        DataArray();
        adapter = new GridviewAdapter(this, R.layout.custom_layout_gridview,arrayList);
        gridView.setAdapter(adapter);
        btn_Next = (Button) findViewById(R.id.btn_next6);
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupLayout6Activity.this, LayoutTrangchuActivity.class);
                startActivity(intent);
            }
        });
        ImageView backsignup5 =  findViewById(R.id.back_signup5);
        backsignup5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupLayout6Activity.this, SignupLayout5Activity.class);
                startActivity(intent);
            }
        });
    }
    public void DataArray(){
        arrayList.add(new HinhAnh("Hoa", R.drawable.hoa));
        arrayList.add(new HinhAnh("Nghệ thuật", R.drawable.nghethuat));
        arrayList.add(new HinhAnh("Móng tay", R.drawable.mongtay));
        arrayList.add(new HinhAnh("Giáo dục", R.drawable.giaoduc));
        arrayList.add(new HinhAnh("Anime", R.drawable.anime));
        arrayList.add(new HinhAnh("Nhiếp ảnh", R.drawable.nhiepanh));
        arrayList.add(new HinhAnh("Động vật", R.drawable.dog4));
        arrayList.add(new HinhAnh("Sức khỏe", R.drawable.suckhoe));
        arrayList.add(new HinhAnh("Thiết kế", R.drawable.thietke));
        arrayList.add(new HinhAnh("Mặt trăng", R.drawable.mattrang));
        arrayList.add(new HinhAnh("Trang sức", R.drawable.trangsuc));
        arrayList.add(new HinhAnh("Xe", R.drawable.xedep));
        arrayList.add(new HinhAnh("Bầu trời xanh", R.drawable.bautroixanh));
        arrayList.add(new HinhAnh("Koi", R.drawable.koi));
        arrayList.add(new HinhAnh("Hình xăm", R.drawable.hinhxam));   }
}
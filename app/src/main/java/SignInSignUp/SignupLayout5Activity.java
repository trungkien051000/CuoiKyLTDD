package SignInSignUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pinterest.LayoutTrangchuActivity;
import com.example.pinterest.R;

import java.util.ArrayList;
import java.util.List;

public class SignupLayout5Activity extends AppCompatActivity {
    private Spinner spnQuocGia;
    Button btn_Next;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout5);
        Intent intentGet = getIntent();
        String name = intentGet.getStringExtra("name");
        spnQuocGia = (Spinner) findViewById(R.id.spnQuocgia);
        List<String> list = new ArrayList<String>();
        list.add("Việt Nam");
        list.add("Mỹ");
        list.add("Anh");
        list.add("Hàn Quốc");
        list.add("Thái Lan");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spnQuocGia.setAdapter(adapter);
        spnQuocGia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SignupLayout5Activity.this, spnQuocGia.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn_Next = (Button) findViewById(R.id.btn_next5);
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignupLayout5Activity.this,"Đăng ký thành công",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignupLayout5Activity.this, LayoutTrangchuActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        ImageView backsignup4 =  findViewById(R.id.back_signup4);
        backsignup4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupLayout5Activity.this, SignupLayout4Activity.class);
                startActivity(intent);
            }
        });

    }
}
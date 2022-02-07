package SignInSignUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pinterest.R;

public class SignupLayout4Activity extends AppCompatActivity {

    private Button btn_Next,btn_nam,btn_nu,btn_khac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout4);
        Intent intentGet=getIntent();
        String name = intentGet.getStringExtra("name");
        btn_Next = (Button) findViewById(R.id.btn_hoantat);
        btn_nam = (Button) findViewById(R.id.btn_sex1);
        btn_nu = (Button) findViewById(R.id.btn_sex2);
        btn_khac = (Button) findViewById(R.id.btn_sex3);
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupLayout4Activity.this, SignupLayout5Activity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        btn_nam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupLayout4Activity.this, SignupLayout5Activity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        btn_nu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupLayout4Activity.this, SignupLayout5Activity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        btn_khac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupLayout4Activity.this, SignupLayout5Activity.class);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        ImageView backsignup3 =  findViewById(R.id.back_signup3);
        backsignup3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupLayout4Activity.this, SignupLayout1Activity.class);
                startActivity(intent);
            }
        });
    }
}
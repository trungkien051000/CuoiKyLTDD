package SignInSignUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pinterest.R;

public class MainActivity extends AppCompatActivity {
    private Button btn_Signin,btn_Signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Signin = (Button) findViewById(R.id.btn_signin);
        btn_Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity .this, SignupLayout1Activity.class);
                startActivity(intent);
            }
        });
        btn_Signup = (Button) findViewById(R.id.btn_signup);
        btn_Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,LoginLayout1Activity.class);
                startActivity(intent);
            }
        });
    }
}
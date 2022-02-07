package SignInSignUp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pinterest.R;

public class SignupLayout3Activity extends AppCompatActivity {

    private Button btn_Next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout3);
        btn_Next = (Button) findViewById(R.id.btn_next3);
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupLayout3Activity.this, SignupLayout4Activity.class);
                startActivity(intent);
            }
        });
        ImageView backsignup2 =  findViewById(R.id.back_signup2);
        backsignup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupLayout3Activity.this, SignupLayout2Activity.class);
                startActivity(intent);
            }
        });
    }
}
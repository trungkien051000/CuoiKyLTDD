package SignInSignUp;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pinterest.R;

public class SignupLayout2Activity extends AppCompatActivity {
    ImageView img_eye;
    EditText edt_pass;
    private Button btn_Next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_layout2);
        img_eye = (ImageView) findViewById(R.id.ic_eye_signin);
        btn_Next = (Button) findViewById(R.id.btn_next2);
        edt_pass = (EditText) findViewById(R.id.edt_Pass);
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupLayout2Activity.this, SignupLayout3Activity.class);
                startActivity(intent);

            }
        });
        img_eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_pass.getTransformationMethod() != null) {
                    edt_pass.setTransformationMethod(null);
                }
                else
                    edt_pass.setTransformationMethod(new PasswordTransformationMethod());
            }
        });
        ImageView   backsignup1 =  findViewById(R.id.back_signup1);
        backsignup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupLayout2Activity.this, SignupLayout1Activity.class);
                startActivity(intent);
            }
        });
    }
}
package SignInSignUp;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pinterest.LayoutTrangchuActivity;
import com.example.pinterest.MainActivityAccount;
import com.example.pinterest.R;

public class LoginLayout1Activity extends AppCompatActivity {
    TextView chinhsach,quenmatkhau;
    ImageView ic_X,ic_eye;
    EditText edt_email,edt_pass;
    Button btn_Login,btn_Fb,btn_Gg;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout1);
        anhXa();
        closeLogin();
        eyeLogin();
        Login();
        quenmatkhau();
    }
    void anhXa(){
        chinhsach = (TextView) findViewById(R.id.tv_chinhsach);
        chinhsach.setText(R.string.chinhsach);

        ic_X = (ImageView) findViewById(R.id.ic_X_Login);
        ic_eye = (ImageView) findViewById(R.id.ic_eye_Login);
        edt_email = (EditText) findViewById(R.id.edt_Email_login);
        edt_pass = (EditText) findViewById(R.id.edt_Pass_Login);
        btn_Login = (Button) findViewById(R.id.btn_login);
        btn_Fb = (Button) findViewById(R.id.btn_Facebook);
        btn_Gg = (Button) findViewById(R.id.btn_Google);
        quenmatkhau=(TextView) findViewById((R.id.tv_forgetPass));
        DB = new DBHelper(this);
    }
    void closeLogin(){
        ic_X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginLayout1Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    void eyeLogin(){
        ic_eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_pass.getTransformationMethod() != null) {
                    edt_pass.setTransformationMethod(null);
                }
                else
                    edt_pass.setTransformationMethod(new PasswordTransformationMethod());
            }
        });
    }
    void Login(){

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = edt_email.getText().toString();
                String pass = edt_pass.getText().toString();

                if(user.equals("")||pass.equals(""))
                {
                    Toast.makeText(LoginLayout1Activity.this,"Vui lòng nhập tên đăng nhập và mật khẩu",Toast.LENGTH_SHORT ).show();
                }
                else
                {
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(LoginLayout1Activity.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), LayoutTrangchuActivity.class);
                    intent.putExtra("name",user);
                    startActivity(intent);
                    }
                    else Toast.makeText(LoginLayout1Activity.this,"Sai tên đăng nhập hoặc mật khẩu",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_Fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(LoginLayout1Activity.this,LayoutTrangchuActivity.class);
                    startActivity(intent);
            }
        });
        btn_Gg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(LoginLayout1Activity.this,LayoutTrangchuActivity.class);
                    startActivity(intent);
            }
        });

    }
    void quenmatkhau(){
        quenmatkhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginLayout1Activity.this,LayoutQuenmatkhauActivity.class);
                startActivity(intent);
            }
        });
    }
}